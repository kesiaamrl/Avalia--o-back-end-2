package main.java.br.com.tech4me.medicos.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4me.agendamento.model.Medicos;

public interface MedicoRepository extends MongoRepository<Medicos, String> {
    
}
