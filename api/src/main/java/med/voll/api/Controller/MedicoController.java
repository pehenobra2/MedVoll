package med.voll.api.Controller;

import med.voll.api.DTO.MedicoDTO;
import med.voll.api.Model.Medico;
import med.voll.api.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    public ResponseEntity<Medico> cadastroMedico(@RequestBody Medico medico) {

        Medico medicoCadastrado = service.cadastroMedico(medico);
        return new ResponseEntity<>(medicoCadastrado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> pegaTodosMedicos(){
        List<MedicoDTO> medicos = service.pegaTodosMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

}