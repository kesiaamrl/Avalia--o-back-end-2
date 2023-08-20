package br.com.tech4me.agendamento.shared;

import java.time.LocalDateTime;

import br.com.tech4me.agendamento.model.Medicos;
import br.com.tech4me.agendamento.model.Pacientes;

public record AgendamentoDto(String id, LocalDateTime data, Pacientes dadosPacientes, double valor) {
    
}
