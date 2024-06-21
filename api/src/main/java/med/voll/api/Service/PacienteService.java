package med.voll.api.Service;

import med.voll.api.DTO.PacienteDTO;
import med.voll.api.DTO.PacienteDTOList;
import med.voll.api.Mapper.Mapper;
import med.voll.api.Model.Paciente;
import med.voll.api.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente cadastroPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = Mapper.toPacienteEntity(pacienteDTO);
        return repository.save(paciente);
    }

    public List<PacienteDTOList> pegaTodosPacientes(){
        List<Paciente> pacientes = repository.findAllByOrderByNomeAsc();
        return pacientes.stream()
                .map(this::converteToPacienteDTOList)
                .collect(Collectors.toList());
    }

    private PacienteDTOList converteToPacienteDTOList(Paciente paciente){
        PacienteDTOList pacienteDTOList = new PacienteDTOList(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
        return pacienteDTOList;
    }



}
