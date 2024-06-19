package med.voll.api.Service;

import med.voll.api.Model.Medico;
import med.voll.api.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico cadastroMedico(Medico medico){
        return repository.save(medico);
    }
}
