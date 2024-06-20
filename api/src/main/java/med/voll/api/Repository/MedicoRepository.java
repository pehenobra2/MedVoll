package med.voll.api.Repository;

import med.voll.api.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findAllByOrderByNomeAsc();

}
