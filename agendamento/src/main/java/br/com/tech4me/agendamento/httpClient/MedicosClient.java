package br.com.tech4me.agendamento.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.agendamento.model.Medicos;

@FeignClient("medicos")
public interface MedicosClient {
    @RequestMapping(method = RequestMethod.GET, value = "/medicos/{id}")
    Medicos obterMedicos(@PathVariable String id);
}
