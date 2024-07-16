package med.voll.api.Validations;

import med.voll.api.DTO.ConsultaDTO;
import med.voll.api.Infra.Exceptions.ValidacaoException;

import java.time.DayOfWeek;

public class ConsultaValidations {

        public void ValidarHorarioClinica(ConsultaDTO consultaDTO){
            var dataConsulta = consultaDTO.data();

            var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
            var antesDoHorarioClinica = dataConsulta.getHour() < 7;
            var depoisDoHorarioClinica = dataConsulta.getHour() > 18;

            if(domingo || antesDoHorarioClinica || depoisDoHorarioClinica){
                throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica!");
            }

        }



}
