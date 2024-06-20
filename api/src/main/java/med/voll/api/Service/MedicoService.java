package med.voll.api.Service;

import med.voll.api.DTO.EnderecoDTO;
import med.voll.api.DTO.MedicoDTO;
import med.voll.api.Model.Medico;
import med.voll.api.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico cadastroMedico(Medico medico){
        return repository.save(medico);
    }

    public List<MedicoDTO> pegaTodosMedicos(){

        List<Medico> medicos = repository.findAll();

        return medicos.stream()
                .map(this::converteDados)
                .collect(Collectors.toList());
    }

    private MedicoDTO converteDados(Medico medico){
        EnderecoDTO enderecoDTO = new EnderecoDTO(
                medico.getEndereco().getId(),
                medico.getEndereco().getLogradouro(),
                medico.getEndereco().getNumero(),
                medico.getEndereco().getComplemento(),
                medico.getEndereco().getBairro(),
                medico.getEndereco().getCidade(),
                medico.getEndereco().getUf(),
                medico.getEndereco().getCep()
        );
        return new MedicoDTO(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm(),
                medico.getEspecialidade(),
                enderecoDTO
        );
    }

}
