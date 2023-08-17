package br.com.tech4me.agendamento.shared;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendamentoDto(String id, LocalDate data, LocalDateTime hora) {
    
}
