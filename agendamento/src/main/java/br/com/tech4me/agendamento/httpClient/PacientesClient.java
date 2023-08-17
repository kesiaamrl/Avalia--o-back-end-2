package br.com.tech4me.agendamento.httpClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.agendamento.model.Pacientes;

@FeignClient("pacientes")
public interface PacientesClient {
    @RequestMapping(method = RequestMethod.GET, value = "/pacientes/{id}")
    Pacientes obterPacientes(@PathVariable String id);
}

