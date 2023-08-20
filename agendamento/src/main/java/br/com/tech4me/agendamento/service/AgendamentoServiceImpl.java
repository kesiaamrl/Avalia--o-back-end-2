package br.com.tech4me.agendamento.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.agendamento.httpClient.MedicosClient;
import br.com.tech4me.agendamento.httpClient.PacientesClient;
import br.com.tech4me.agendamento.model.Agendamento;
import br.com.tech4me.agendamento.model.Pacientes;
import br.com.tech4me.agendamento.repository.AgendamentoRepository;
import br.com.tech4me.agendamento.shared.AgendamentoCompletoDto;
import br.com.tech4me.agendamento.shared.AgendamentoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {
    @Autowired
    private AgendamentoRepository repositorio;
    @Autowired
    private MedicosClient medicosClient;
    @Autowired
    private PacientesClient pacientesClient;


     @Override
    public List<AgendamentoCompletoDto> obterTodos(){
        return repositorio.findAll()
        .stream()
        .map(p-> new AgendamentoCompletoDto(p.getId(), p.getIdMedico(), p.getIdPaciente(), p.getData(), p.getValor()))
        .toList();

    }
    
    @CircuitBreaker(name="obterPacientes", fallbackMethod = "fallbackAgendamentoPorId")
    @Override
    public Optional<AgendamentoDto> obterAgendamentoPorId(String id) {
        Optional<Agendamento> agendamento = repositorio.findById(id);

        if (agendamento.isPresent()) {
            Pacientes pacientes = pacientesClient.obterPacientes(agendamento.get().getIdPaciente());
            AgendamentoDto agendamentoComPaciente = new AgendamentoDto(agendamento.get().getId(), agendamento.get().getData(), pacientes, agendamento.get().getValor());
            return Optional.of(agendamentoComPaciente);
        } else {
            return Optional.empty();
        }
    }

    public Optional<AgendamentoDto> fallbackAgendamentoPorId(String id, Exception e) {
        Optional<Agendamento> agendamento = repositorio.findById(id);

        if (agendamento.isPresent()) {
            AgendamentoDto agendamentoComPaciente = new AgendamentoDto(agendamento.get().getId(), agendamento.get().getData(), null, agendamento.get().getValor());
            return Optional.of(agendamentoComPaciente);
        } else {
            return Optional.empty();
        }
    }
    

    @Override
    public AgendamentoCompletoDto cadastrar(AgendamentoCompletoDto dto) {
      Agendamento agendamento = new Agendamento(dto);
      repositorio.save(agendamento);
      
      return new AgendamentoCompletoDto(agendamento.getId(), 
      agendamento.getIdMedico(),
      agendamento.getIdPaciente(),
      agendamento.getData(),
      agendamento.getValor());
      }
    

    @Override
    public AgendamentoCompletoDto atualizarPorId(String id, AgendamentoCompletoDto dto) {
       Agendamento agendamento = repositorio.findById(id).orElse(null);

       if(agendamento != null){
        Agendamento agendamentoAtualizar = new Agendamento(dto);
        agendamentoAtualizar.setId(id);
        repositorio.save(agendamentoAtualizar);
        return new AgendamentoCompletoDto(agendamentoAtualizar.getId(),
         agendamentoAtualizar.getIdMedico(),
      agendamentoAtualizar.getIdPaciente(),
      agendamentoAtualizar.getData(),
      agendamentoAtualizar.getValor());
       } else{
        return null;
       }
    }

    @Override
    public void excluirPorId(String id) {
       repositorio.deleteById(id);
    }

}
