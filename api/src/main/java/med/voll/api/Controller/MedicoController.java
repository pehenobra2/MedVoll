package med.voll.api.Controller;

import jakarta.persistence.EntityNotFoundException;
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
import java.util.Optional;

@RestController
@RequestMapping("/medico")
@Validated
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroMedico(@RequestBody @Valid MedicoDTO medicoDTO) {
        Medico medico = service.cadastroMedico(medicoDTO);
        return new ResponseEntity<>("Médico cadastrado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTOLista>> pegaTodosMedicos(){
        List<MedicoDTOLista> medicos = service.pegaTodosMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizaMedico(@RequestBody MedicoDTO medicoDTO){
        Optional<Medico> medico = service.attMedico(medicoDTO);
        if (medico.isPresent()) {
            return new ResponseEntity<>("Médico atualizado com sucesso", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Médico não encontrado", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> deleteMedico(@RequestBody MedicoDTO medicoDTO) {
        try {
            service.deleteMedico(medicoDTO);
            return new ResponseEntity<>("Médico deletado com sucesso", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}