package med.voll.api.Service;

import jakarta.validation.ValidationException;
import med.voll.api.DTO.ConsultaCanceladaDTO;
import med.voll.api.DTO.ConsultaDTO;
import med.voll.api.Infra.Exceptions.ValidacaoException;
import med.voll.api.Model.Consulta;
import med.voll.api.Model.Medico;
import med.voll.api.Repository.ConsultaRepository;
import med.voll.api.Repository.MedicoRepository;
import med.voll.api.Repository.PacienteRepository;
import org.apache.el.ValueExpressionLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.DesktopPaneUI;
import java.util.NoSuchElementException;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    MedicoRepository medicoRepository;

    public void agendar(ConsultaDTO consultaDTO){

        var paciente = pacienteRepository.findByCpf(consultaDTO.cpfPaciente()).get();
        if(paciente == null){
            throw new ValidacaoException("Paciente não existe!!");
        }

        var medico = escolheMedico(consultaDTO);
        if(consultaDTO.crmMedico() != null && medico == null){
            throw new ValidacaoException("Médico não existe");
        }
        Consulta consulta = new Consulta(null, medico, paciente, consultaDTO.data());

        consultaRepository.save(consulta);


    }

    public void cancelar(ConsultaCanceladaDTO consulta){
        if(!consultaRepository.existsById(consulta.idConsulta())){
            throw new ValidacaoException("Id da consulta informado não existe!!");
        }
        var consultaCancelada = consultaRepository.getReferenceById(consulta.idConsulta());
        consultaRepository.delete(consultaCancelada);
    }


    private Medico escolheMedico(ConsultaDTO consultaDTO){
        if(consultaDTO.crmMedico() != null){
            return medicoRepository.findByCrm(consultaDTO.crmMedico()).orElseThrow(() -> new NoSuchElementException("Médico não encontrado com o CRM fornecido"));
        }

        if(consultaDTO.especialidade() == null){
            throw new ValidacaoException("Especialidade precisa ser expecificada!");
        }

        return medicoRepository.escolheMedico(consultaDTO.especialidade(), consultaDTO.data());
    }



}
