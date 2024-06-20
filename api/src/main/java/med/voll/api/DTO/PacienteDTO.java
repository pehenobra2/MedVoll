package med.voll.api.DTO;

import jakarta.validation.constraints.*;

public record PacienteDTO(
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) @Email String email,
        @NotBlank @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos") String telefone,
        @NotBlank @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos") String cpf,
        @NotNull EnderecoDTO endereco
) {}