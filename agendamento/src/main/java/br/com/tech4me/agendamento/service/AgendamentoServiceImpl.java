package br.com.tech4me.agendamento.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.agendamento.httpClient.MedicosClient;
import br.com.tech4me.agendamento.httpClient.PacientesClient;
import br.com.tech4me.agendamento.model.Agendamento;
import br.com.tech4me.agendamento.repository.AgendamentoRepository;
import br.com.tech4me.agendamento.shared.AgendamentoCompletoDto;
import br.com.tech4me.agendamento.shared.AgendamentoDto;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {
    @Autowired
    private AgendamentoRepository repositorio;
    @Autowired
    private MedicosClient medicosClient;
    @Autowired
    private PacientesClient pacientesClient;


     @Override
    public List<AgendamentoDto> obterTodos(){
        return repositorio.findAll()
        .stream()
        .map(p-> new AgendamentoDto(p.getId(), p.getData()))
        .toList();
    }
    
    @Override
    public Optional<AgendamentoCompletoDto> obterPorId(String id){
        Optional<Agendamento> agendamento = repositorio.findById(id);

        if(agendamento.isPresent()){
            return Optional.of(new AgendamentoCompletoDto(agendamento.get().getId(), agendamento.get().getIdMedico(),
        agendamento.get().getIdPaciente(),
        agendamento.get().getData()));
        } else{
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
      agendamento.getData());
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
      agendamentoAtualizar.getData());
       } else{
        return null;
       }
    }

    @Override
    public void excluirPorId(String id) {
       repositorio.deleteById(id);
    }

}
