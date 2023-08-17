package br.com.tech4me.pacientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.pacientes.model.Pacientes;

public interface PacientesRepository extends MongoRepository<Pacientes, String> {
    
}
