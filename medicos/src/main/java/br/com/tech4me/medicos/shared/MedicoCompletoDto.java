package br.com.tech4me.medicos.shared;

import br.com.tech4me.medicos.model.Especialidade;

public record MedicoCompletoDto(String id, String nome, String crm, String endereco, Especialidade especialidade) {
    
}
