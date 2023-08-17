package br.com.tech4me.agendamento.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.agendamento.shared.AgendamentoCompletoDto;

@Document("agendamento")
public class Agendamento {
    @Id

private String id;
private String idMedico;
private String idPaciente;
private LocalDate data;
private LocalDateTime hora;

public Agendamento(){}

public Agendamento(AgendamentoCompletoDto dto){
    this.id=dto.id();
    this.idMedico=dto.idMedico();
    this.idPaciente=dto.idPaciente();
    this.data=dto.data();
    this.hora=dto.hora();
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
public LocalDate getData() {
    return data;
}
public void setData(LocalDate data) {
    this.data = data;
}
public LocalDateTime getHora() {
    return hora;
}
public void setHora(LocalDateTime hora) {
    this.hora = hora;
}
}
