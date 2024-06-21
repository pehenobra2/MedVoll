package med.voll.api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Pessoa{

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(unique = true)
    private String cpf;

}
