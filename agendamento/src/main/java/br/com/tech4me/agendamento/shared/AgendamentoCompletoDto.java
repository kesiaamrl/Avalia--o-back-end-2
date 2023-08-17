package br.com.tech4me.agendamento.shared;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendamentoCompletoDto(String id, String idMedico, String idPaciente, LocalDate data, LocalDateTime hora) {
    
}
