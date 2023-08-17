package br.com.tech4me.agendamento.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.agendamento.shared.AgendamentoCompletoDto;
import br.com.tech4me.agendamento.shared.AgendamentoDto;

public interface AgendamentoService {
    List<AgendamentoDto> obterTodos();
    Optional<AgendamentoCompletoDto> obterPorId(String id);
    AgendamentoCompletoDto cadastrar(AgendamentoCompletoDto dto);
    AgendamentoCompletoDto atualizarPorId(String id, AgendamentoCompletoDto dto);
    void excluirPorId(String id);
}