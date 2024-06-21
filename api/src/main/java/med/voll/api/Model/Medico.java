package med.voll.api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Pessoa{

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(unique = true)
    private String crm;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Especialidade especialidade;

}
