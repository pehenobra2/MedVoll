package med.voll.api.DTO;

import jakarta.persistence.Column;

public record EnderecoDTO(
        Long id,
        String logradouro,
        Integer numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        Long cep) {
}
