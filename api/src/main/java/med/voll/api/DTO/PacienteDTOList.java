package med.voll.api.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PacienteDTOList(
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) @Email String email,
        @NotBlank @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos") String cpf
) { }
