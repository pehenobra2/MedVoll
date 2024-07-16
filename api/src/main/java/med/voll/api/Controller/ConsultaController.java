package med.voll.api.Controller;

import jakarta.validation.Valid;
import med.voll.api.DTO.ConsultaCanceladaDTO;
import med.voll.api.DTO.ConsultaDTO;
import med.voll.api.Service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid ConsultaDTO consultaDTO){
        System.out.println(consultaDTO);
        consultaService.agendar(consultaDTO);
        return new ResponseEntity("Consulta cadastrada com sucesso!!", HttpStatus.CREATED);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid ConsultaCanceladaDTO consulta){
        consultaService.cancelar(consulta);
        return new ResponseEntity("Consulta cancelada", HttpStatus.OK);
    }

}
