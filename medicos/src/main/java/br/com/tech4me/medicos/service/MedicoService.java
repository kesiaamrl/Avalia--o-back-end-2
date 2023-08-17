package br.com.tech4me.medicos.service;
import java.util.List;
import java.util.Optional;

import br.com.tech4me.medicos.shared.MedicoCompletoDto;
import br.com.tech4me.medicos.shared.MedicoDto;

public interface MedicoService {
    List<MedicoDto> obterTodos();
    Optional<MedicoCompletoDto> obterPorId(String id);
    MedicoCompletoDto cadastrar(MedicoCompletoDto dto);
    MedicoCompletoDto atualizarPorId(String id, MedicoCompletoDto dto);
    void excluirPorId(String id);
}
