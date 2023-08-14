package main.java.br.com.tech4me.medicos.shared;

import main.java.br.com.tech4me.medicos.model.Especialidade;

public record MedicoCompletoDto (String id, String nome, String crm, String endereco, Especialidade especialidade){
    
}
