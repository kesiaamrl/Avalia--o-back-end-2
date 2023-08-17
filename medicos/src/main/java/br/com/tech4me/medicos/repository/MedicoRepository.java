package br.com.tech4me.medicos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.medicos.model.Medicos;

public interface MedicoRepository extends MongoRepository<Medicos, String> {
    
}
