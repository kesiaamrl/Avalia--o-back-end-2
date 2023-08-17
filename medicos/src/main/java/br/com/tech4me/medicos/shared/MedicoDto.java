package br.com.tech4me.medicos.shared;

import br.com.tech4me.medicos.model.Especialidade;

public record MedicoDto(String nome, Especialidade especialidade) {
    
}
