package br.com.tech4me.pacientes.controller;

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

import br.com.tech4me.pacientes.service.PacientesService;
import br.com.tech4me.pacientes.shared.PacientesCompletoDto;
import br.com.tech4me.pacientes.shared.PacientesDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
    
    @Autowired
    private PacientesService servico;

    @GetMapping
    private ResponseEntity<List<PacientesDto>> obterPacientes(){
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PacientesCompletoDto> obterPacientesPorId(@PathVariable String id){
        Optional<PacientesCompletoDto> paciente = servico.obterPorId(id);

        if(paciente.isPresent()){
            return new ResponseEntity<>(paciente.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<PacientesCompletoDto> cadastrarPaciente(@RequestBody @Valid PacientesCompletoDto paciente){
        return new ResponseEntity<>(servico.cadastrar(paciente), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirPacientePorId(@PathVariable String id){
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<PacientesCompletoDto> atualizarPaciente(@PathVariable String id, @RequestBody @Valid PacientesCompletoDto paciente){
      PacientesCompletoDto pacienteAtualizado = servico.atualizarPorId(id, paciente);
      
      if(pacienteAtualizado !=null){
        return new ResponseEntity<>(pacienteAtualizado, HttpStatus.OK);
      } else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    

}
