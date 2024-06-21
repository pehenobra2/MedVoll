package med.voll.api.Repository;

import med.voll.api.Model.Medico;
import med.voll.api.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findAllByOrderByNomeAsc();
    Optional<Paciente> findByCpf(String cpf);
}
