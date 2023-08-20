package br.com.tech4me.pacientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.pacientes.model.Pacientes;
import br.com.tech4me.pacientes.repository.PacientesRepository;
import br.com.tech4me.pacientes.shared.PacientesCompletoDto;
import br.com.tech4me.pacientes.shared.PacientesDto;


@Service
public class PacientesServiceImpl implements PacientesService {

    @Autowired
    private PacientesRepository repositorio;

    @Override
    public List<PacientesDto> obterTodos() {
        return repositorio.findAll()
            .stream()
            .map(p -> new PacientesDto(p.getNome(), p.getTelefone()))
            .toList();
    }

    @Override
    public Optional<PacientesCompletoDto> obterPorId(String id) {
        Optional<Pacientes> paciente = repositorio.findById(id);

        if (paciente.isPresent()) {
            return Optional.of(new PacientesCompletoDto(paciente.get().getId(),
                paciente.get().getNome(),
                paciente.get().getCpf(),
                paciente.get().getEndereco(),
                paciente.get().getTelefone()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public PacientesCompletoDto cadastrar(PacientesCompletoDto dto) {
        Pacientes paciente = new Pacientes(dto);
        repositorio.save(paciente);

        return new PacientesCompletoDto(paciente.getId(),
            paciente.getNome(),
            paciente.getCpf(),
            paciente.getEndereco(),
            paciente.getTelefone());
    }

    @Override
    public PacientesCompletoDto atualizarPorId(String id, PacientesCompletoDto dto) {
        Pacientes pacientes = repositorio.findById(id).orElse(null);

        if (pacientes != null) {
            Pacientes pacientesAtualizar = new Pacientes(dto);
            pacientesAtualizar.setId(id);
            repositorio.save(pacientesAtualizar);
            return new PacientesCompletoDto(pacientesAtualizar.getId(),
                pacientesAtualizar.getNome(),
                pacientesAtualizar.getCpf(),
                pacientesAtualizar.getEndereco(),
                pacientesAtualizar.getTelefone());
        } else {
            return null;
        }
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }
    
}
