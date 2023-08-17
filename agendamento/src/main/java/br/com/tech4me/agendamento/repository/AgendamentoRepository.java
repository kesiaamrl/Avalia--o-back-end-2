package br.com.tech4me.agendamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.agendamento.model.Agendamento;

public interface AgendamentoRepository extends MongoRepository<Agendamento, String> {
    
}
