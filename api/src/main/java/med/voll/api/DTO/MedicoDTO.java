package med.voll.api.DTO;

import jakarta.persistence.Column;
import med.voll.api.Model.Endereco;
import med.voll.api.Model.Especialidade;

public record MedicoDTO(
        Long id,
        String nome,
        String email,
        Long telefone,
        String crm,
        Especialidade especialidade,
        EnderecoDTO endereco) {
}
