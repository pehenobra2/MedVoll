package med.voll.api.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Pessoa{

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}
