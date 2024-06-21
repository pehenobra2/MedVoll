package med.voll.api.Service;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.DTO.EnderecoDTO;
import med.voll.api.DTO.MedicoDTO;
import med.voll.api.DTO.MedicoDTOLista;
import med.voll.api.Mapper.Mapper;
import med.voll.api.Model.Endereco;
import med.voll.api.Model.Medico;
import med.voll.api.Repository.MedicoRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico cadastroMedico(MedicoDTO medicoDTO){
        Medico medico = Mapper.toMedicoEntity(medicoDTO);

        return repository.save(medico);
    }

    public List<MedicoDTOLista> pegaTodosMedicos(){
        List<Medico> medicos = repository.findAllByOrderByNomeAsc();
        return medicos.stream()
                .map(this::converteParaDTOLista)
                .collect(Collectors.toList());
    }

    public Optional<Medico> attMedico (MedicoDTO medicoDTO){
        Medico medicoConvertido = Mapper.toMedicoEntity(medicoDTO);
        Optional<Medico> medicoExiste = repository.findByCrm(medicoDTO.crm());
        if (medicoExiste.isPresent()) {
            Medico medico = medicoExiste.get();
            medico.setNome(medicoConvertido.getNome());
            medico.setTelefone(medicoConvertido.getTelefone());

            Endereco enderecoExistente = medico.getEndereco();
            Endereco enderecoNovo = medicoConvertido.getEndereco();
            enderecoExistente.setLogradouro(enderecoNovo.getLogradouro());
            enderecoExistente.setNumero(enderecoNovo.getNumero());
            enderecoExistente.setComplemento(enderecoNovo.getComplemento());
            enderecoExistente.setBairro(enderecoNovo.getBairro());
            enderecoExistente.setCidade(enderecoNovo.getCidade());
            enderecoExistente.setUf(enderecoNovo.getUf());
            enderecoExistente.setCep(enderecoNovo.getCep());

            repository.save(medico);
            return Optional.of(medico);
        }else {
            return Optional.empty();
        }

    }

    public void deleteMedico(MedicoDTO medicoDTO) {
        Optional<Medico> medicoExiste = repository.findByCrm(medicoDTO.crm());

        if (medicoExiste.isPresent()) {
            Medico medico = medicoExiste.get();
            repository.delete(medico);
        } else {
            throw new EntityNotFoundException("Médico não encontrado com o CRM: " + medicoDTO.crm());
        }
    }

    private MedicoDTOLista converteParaDTOLista(Medico medico){
        return new MedicoDTOLista(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade()
        );
    }

}