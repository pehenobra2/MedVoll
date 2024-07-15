package med.voll.api.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.Model.Especialidade;

import java.time.LocalDateTime;

public record ConsultaDTO(

        String crmMedico,
        @NotBlank
        String cpfPaciente,
        @NotNull
        @Future
        LocalDateTime data,

        Especialidade especialidade
        ) {
}
