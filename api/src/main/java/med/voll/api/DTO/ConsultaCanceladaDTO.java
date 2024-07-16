package med.voll.api.DTO;

import jakarta.validation.constraints.NotNull;

public record ConsultaCanceladaDTO (
        @NotNull
        Long idConsulta){ }
