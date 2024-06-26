package med.voll.api.Repository;

import med.voll.api.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findAllByOrderByNomeAsc();

    Optional<Medico> findByCrm(String crm);

}
