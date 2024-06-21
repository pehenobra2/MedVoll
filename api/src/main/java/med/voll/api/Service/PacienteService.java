package med.voll.api.Service;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.DTO.MedicoDTO;
import med.voll.api.DTO.PacienteDTO;
import med.voll.api.DTO.PacienteDTOList;
import med.voll.api.Mapper.Mapper;
import med.voll.api.Model.Endereco;
import med.voll.api.Model.Medico;
import med.voll.api.Model.Paciente;
import med.voll.api.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional<Paciente> attPaciente (PacienteDTO pacienteDTO){
        Paciente pacienteConvertido = Mapper.toPacienteEntity(pacienteDTO);
        Optional<Paciente> pacienteExiste = repository.findByCpf(pacienteDTO.cpf());
        if (pacienteExiste.isPresent()) {
            Paciente paciente = pacienteExiste.get();
            paciente.setNome(pacienteConvertido.getNome());
            paciente.setTelefone(pacienteConvertido.getTelefone());

            Endereco enderecoExistente = paciente.getEndereco();
            Endereco enderecoNovo = pacienteConvertido.getEndereco();
            enderecoExistente.setLogradouro(enderecoNovo.getLogradouro());
            enderecoExistente.setNumero(enderecoNovo.getNumero());
            enderecoExistente.setComplemento(enderecoNovo.getComplemento());
            enderecoExistente.setBairro(enderecoNovo.getBairro());
            enderecoExistente.setCidade(enderecoNovo.getCidade());
            enderecoExistente.setUf(enderecoNovo.getUf());
            enderecoExistente.setCep(enderecoNovo.getCep());

            repository.save(paciente);
            return Optional.of(paciente);
        }else {
            return Optional.empty();
        }



    }

    public void deletePaciente(PacienteDTO pacienteDTO) {
        Optional<Paciente> pacienteExiste = repository.findByCpf(pacienteDTO.cpf());

        if (pacienteExiste.isPresent()) {
            Paciente paciente = pacienteExiste.get();
            repository.delete(paciente);
        } else {
            throw new EntityNotFoundException("Paciente não encontrado com o cpf: " + pacienteDTO.cpf());
        }
    }



}
