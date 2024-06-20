package med.voll.api.DTO;

import jakarta.validation.constraints.*;

public record EnderecoDTO(
        @NotBlank @Size(max = 100) String logradouro,
        @NotBlank @Size(max = 10) String numero,
        String complemento,
        @NotBlank @Size(max = 50) String bairro,
        @NotBlank @Size(max = 50) String cidade,
        @NotBlank @Size(max = 2) String uf,
        @NotBlank @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos") String cep
) {}