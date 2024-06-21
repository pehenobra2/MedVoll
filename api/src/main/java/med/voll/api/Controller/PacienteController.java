package med.voll.api.Controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import med.voll.api.DTO.MedicoDTO;
import med.voll.api.DTO.PacienteDTO;
import med.voll.api.DTO.PacienteDTOList;
import med.voll.api.Model.Medico;
import med.voll.api.Model.Paciente;
import med.voll.api.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroPaciente(@RequestBody @Valid PacienteDTO pacienteDTO){
        Paciente paciente = pacienteService.cadastroPaciente(pacienteDTO);
        return new ResponseEntity<>("Paciente cadastrado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTOList>> pegaTodosPacientes(){
        List<PacienteDTOList> pacienteDTOLists = pacienteService.pegaTodosPacientes();
        return new ResponseEntity<>(pacienteDTOLists, HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizaPaciente(@RequestBody PacienteDTO pacienteDTO){
        Optional<Paciente> paciente = pacienteService.attPaciente(pacienteDTO);
        return new ResponseEntity<>("Paciente atualizado com sucesso", HttpStatus.OK);

    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> deletePaciente(@RequestBody PacienteDTO pacienteDTO) {
        try {
            pacienteService.deletePaciente(pacienteDTO);
            return new ResponseEntity<>("Paciente deletado com sucesso", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
