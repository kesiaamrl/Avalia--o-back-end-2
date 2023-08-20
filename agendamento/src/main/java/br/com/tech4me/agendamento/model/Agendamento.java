package br.com.tech4me.agendamento.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.agendamento.shared.AgendamentoCompletoDto;

import java.time.format.DateTimeFormatter;

@Document("agendamento")
public class Agendamento {
    @Id

private String id;
private String idMedico;
private String idPaciente;
private LocalDateTime data;


public Agendamento(){}

public Agendamento(AgendamentoCompletoDto dto){
    this.id=dto.id();
    this.idMedico=dto.idMedico();
    this.idPaciente=dto.idPaciente();
    this.data=dto.data();
}

public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getIdMedico() {
    return idMedico;
}
public void setIdMedico(String idMedico) {
    this.idMedico = idMedico;
}
public String getIdPaciente() {
    return idPaciente;
}
public void setIdPaciente(String idPaciente) {
    this.idPaciente = idPaciente;
}
public LocalDateTime getData() {
    return data;
}
public void setData(LocalDateTime data) {
    this.data = data;
}
}
