package med.voll.api.Controller;

import jakarta.validation.Valid;
import med.voll.api.DTO.MedicoDTO;
import med.voll.api.DTO.MedicoDTOLista;
import med.voll.api.Model.Medico;
import med.voll.api.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
@Validated
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Medico> cadastroMedico(@RequestBody @Valid MedicoDTO medicoDTO) {
        Medico medico = service.cadastroMedico(medicoDTO);
        return new ResponseEntity<>(medico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTOLista>> pegaTodosMedicos(){
        List<MedicoDTOLista> medicos = service.pegaTodosMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }
}