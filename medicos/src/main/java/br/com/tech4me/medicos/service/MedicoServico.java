package main.java.br.com.tech4me.medicos.service;

import java.util.List;
import java.util.Optional;

import main.java.br.com.tech4me.medicos.shared.MedicoCompletoDto;
import main.java.br.com.tech4me.medicos.shared.MedicoDto;

public interface MedicoServico {
    List<MedicoDto> obterTodas();
    Optional<MedicoCompletoDto> obterPorId(String id);
    MedicoCompletoDto cadastrar(MedicoCompletoDto dto);
    MedicoCompletoDto atualizarPorId(String id, MedicoCompletoDto dto);
    void excluirPorId(String id);
}
