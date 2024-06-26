package med.voll.api.DTO;

import jakarta.validation.constraints.*;
import med.voll.api.DTO.EnderecoDTO;
import med.voll.api.Model.Especialidade;

public record MedicoDTO(
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) @Email String email,
        @NotBlank @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos") String telefone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull Especialidade especialidade,
        @NotNull EnderecoDTO endereco
) {}