package med.voll.api.dto;

import jakarta.validation.constraints.*;
import med.voll.api.DTO.EnderecoDTO;

public record PessoaDTO(
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) @Email String email,
        @NotBlank @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos") String telefone,
        @NotNull EnderecoDTO endereco
) {}