package med.voll.api.Repository;

import med.voll.api.Model.Especialidade;
import med.voll.api.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findAllByOrderByNomeAsc();

    Optional<Medico> findByCrm(String crm);

    @Query("""
                select m from Medico m
                where
                m.especialidade = :especialidade
                and
                m.crm not in(
                        select c.medico.crm from Consulta c
                        where
                        c.data = :data
                )
                order by rand()
                limit 1
                """)
    Medico escolheMedico(Especialidade especialidade, LocalDateTime data);
}
