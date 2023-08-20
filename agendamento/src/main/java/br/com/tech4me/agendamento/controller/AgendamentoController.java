package br.com.tech4me.agendamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.agendamento.service.AgendamentoService;
import br.com.tech4me.agendamento.shared.AgendamentoCompletoDto;
import br.com.tech4me.agendamento.shared.AgendamentoDto;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoService servico;

    @GetMapping
    private ResponseEntity<List<AgendamentoDto>> obterAgendamentos(){
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<AgendamentoCompletoDto> obterAgendamentosPorId(@PathVariable String id){
        Optional<AgendamentoCompletoDto> agendamento = servico.obterPorId(id);

        if(agendamento.isPresent()){
            return new ResponseEntity<>(agendamento.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<AgendamentoCompletoDto> cadastrarAgendamento(@RequestBody AgendamentoCompletoDto agendamento){
        return new ResponseEntity<>(servico.cadastrar(agendamento), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirAgendamentoPorId(@PathVariable String id){
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<AgendamentoCompletoDto> atualizarAgendamento(@PathVariable String id, @RequestBody AgendamentoCompletoDto agendamento){
      AgendamentoCompletoDto agendamentoAtualizado = servico.atualizarPorId(id, agendamento);
      
      if(agendamentoAtualizado !=null){
        return new ResponseEntity<>(agendamentoAtualizado, HttpStatus.OK);
      } else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    

}

