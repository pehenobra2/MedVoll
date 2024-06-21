package med.voll.api.Mapper;

import med.voll.api.DTO.*;
import med.voll.api.Model.*;

public class Mapper {

    public static MedicoDTO toMedicoDTO(Medico medico) {
        return new MedicoDTO(
                medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm(),
                medico.getEspecialidade(),
                toEnderecoDTO(medico.getEndereco())
        );
    }

    public static PacienteDTO toPacienteDTO(Paciente paciente) {
        return new PacienteDTO(
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf(),
                toEnderecoDTO(paciente.getEndereco())
        );
    }

    public static EnderecoDTO toEnderecoDTO(Endereco endereco) {
        return new EnderecoDTO(
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getCep()
        );
    }

    public static Medico toMedicoEntity(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setNome(medicoDTO.nome());
        medico.setEmail(medicoDTO.email());
        medico.setTelefone(medicoDTO.telefone());
        medico.setCrm(medicoDTO.crm());
        medico.setEspecialidade(medicoDTO.especialidade());

        Endereco endereco = toEnderecoEntity(medicoDTO.endereco());
        medico.setEndereco(endereco);

        return medico;
    }

    public static Paciente toPacienteEntity(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.nome());
        paciente.setEmail(pacienteDTO.email());
        paciente.setTelefone(pacienteDTO.telefone());
        paciente.setCpf(pacienteDTO.cpf());
        paciente.setEndereco(toEnderecoEntity(pacienteDTO.endereco()));
        return paciente;
    }

    public static Endereco toEnderecoEntity(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.logradouro());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setComplemento(enderecoDTO.complemento());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setUf(enderecoDTO.uf());
        endereco.setCep(enderecoDTO.cep());
        return endereco;
    }
}