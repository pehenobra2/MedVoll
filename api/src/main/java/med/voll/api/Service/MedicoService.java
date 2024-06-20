package med.voll.api.Service;

import med.voll.api.DTO.EnderecoDTO;
import med.voll.api.DTO.MedicoDTO;
import med.voll.api.DTO.MedicoDTOLista;
import med.voll.api.Mapper.Mapper;
import med.voll.api.Model.Endereco;
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


    private MedicoDTOLista converteParaDTOLista(Medico medico){
        return new MedicoDTOLista(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade()
        );
    }
}