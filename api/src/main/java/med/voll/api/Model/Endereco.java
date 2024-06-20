package med.voll.api.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String uf;

    private String cep;

    @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pessoa> pessoas;

}
