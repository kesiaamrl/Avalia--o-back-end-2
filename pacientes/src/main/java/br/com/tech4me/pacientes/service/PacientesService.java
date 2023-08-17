package br.com.tech4me.pacientes.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.pacientes.shared.PacientesCompletoDto;
import br.com.tech4me.pacientes.shared.PacientesDto;

public interface PacientesService {
    List<PacientesDto> obterTodos();
    Optional<PacientesCompletoDto> obterPorId(String id);
    PacientesCompletoDto cadastrar(PacientesCompletoDto dto);
    PacientesCompletoDto atualizarPorId(String id, PacientesCompletoDto dto);
    void excluirPorId(String id);
}
