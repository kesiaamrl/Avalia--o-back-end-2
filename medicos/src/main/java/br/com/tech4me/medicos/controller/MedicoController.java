package br.com.tech4me.medicos.controller;

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

import br.com.tech4me.medicos.service.MedicoService;
import br.com.tech4me.medicos.shared.MedicoCompletoDto;
import br.com.tech4me.medicos.shared.MedicoDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoService servico;

    @GetMapping
    private ResponseEntity<List<MedicoDto>> obterMedicos(){
        return new ResponseEntity<>(servico.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<MedicoCompletoDto> obterMedicosPorId(@PathVariable String id){
        Optional<MedicoCompletoDto> medico = servico.obterPorId(id);

        if(medico.isPresent()){
            return new ResponseEntity<>(medico.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<MedicoCompletoDto> cadastrarMedico(@RequestBody @Valid MedicoCompletoDto medico){
        return new ResponseEntity<>(servico.cadastrar(medico), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirMedicoPorId(@PathVariable String id){
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<MedicoCompletoDto> atualizarMedico(@PathVariable String id, @RequestBody @Valid MedicoCompletoDto medico){
      MedicoCompletoDto medicoAtualizado = servico.atualizarPorId(id, medico);
      
      if(medicoAtualizado !=null){
        return new ResponseEntity<>(medicoAtualizado, HttpStatus.OK);
      } else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    

}
