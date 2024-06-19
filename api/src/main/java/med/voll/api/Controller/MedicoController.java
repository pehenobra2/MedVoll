package med.voll.api.Controller;

import med.voll.api.Model.Medico;
import med.voll.api.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}