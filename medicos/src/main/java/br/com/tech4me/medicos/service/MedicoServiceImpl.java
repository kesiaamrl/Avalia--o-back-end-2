package br.com.tech4me.medicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tech4me.medicos.model.Medicos;
import br.com.tech4me.medicos.repository.MedicoRepository;
import br.com.tech4me.medicos.shared.MedicoCompletoDto;
import br.com.tech4me.medicos.shared.MedicoDto;

@Service
public class MedicoServiceImpl implements MedicoService {
   
    @Autowired
    private MedicoRepository repositorio;

    @Override
    public List<MedicoDto> obterTodos(){
        return repositorio.findAll()
        .stream()
        .map(p-> new MedicoDto(p.getNome(), p.getEspecialidade()))
        .toList();
    }
    
    @Override
    public Optional<MedicoCompletoDto> obterPorId(String id){
        Optional<Medicos> medicos = repositorio.findById(id);

        if(medicos.isPresent()){
            return Optional.of(new MedicoCompletoDto(medicos.get().getId(), medicos.get().getNome(), 
            medicos.get().getCrm(), medicos.get().getEndereco(), medicos.get().getEspecialidade()));
        } else{
            return Optional.empty();
        }
    }
    

    @Override
    public MedicoCompletoDto cadastrar(MedicoCompletoDto dto) {
      Medicos medicos = new Medicos(dto);
      repositorio.save(medicos);
      
      return new MedicoCompletoDto(medicos.getId(),
       medicos.getNome(), medicos.getCrm(),
    medicos.getEndereco(), medicos.getEspecialidade());
    }

    @Override
    public MedicoCompletoDto atualizarPorId(String id, MedicoCompletoDto dto) {
       Medicos medicos = repositorio.findById(id).orElse(null);

       if(medicos != null){
        Medicos medicosAtualizar = new Medicos(dto);
        medicosAtualizar.setId(id);
        repositorio.save(medicosAtualizar);
        return new MedicoCompletoDto(medicosAtualizar.getId(),
        medicosAtualizar.getNome(),
        medicosAtualizar.getCrm(), 
        medicosAtualizar.getEndereco(), 
        medicosAtualizar.getEspecialidade());
       } else{
        return null;
       }
    }

    @Override
    public void excluirPorId(String id) {
       repositorio.deleteById(id);
    }
}

