package med.voll.api.DTO;

import med.voll.api.Model.Especialidade;

public record MedicoDTOLista (
        String nome,
        String email,
        String crm,
        Especialidade especialidade) { }
