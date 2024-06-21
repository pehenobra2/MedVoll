package med.voll.api.Controller;

import jakarta.validation.Valid;
import med.voll.api.DTO.PacienteDTO;
import med.voll.api.DTO.PacienteDTOList;
import med.voll.api.Model.Paciente;
import med.voll.api.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<Paciente> cadastroPaciente(@RequestBody @Valid PacienteDTO pacienteDTO){
        Paciente paciente = pacienteService.cadastroPaciente(pacienteDTO);
        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTOList>> pegaTodosPacientes(){
        List<PacienteDTOList> pacienteDTOLists = pacienteService.pegaTodosPacientes();
        return new ResponseEntity<>(pacienteDTOLists, HttpStatus.OK);
    }

}
