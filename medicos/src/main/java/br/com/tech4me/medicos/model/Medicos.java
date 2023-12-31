package br.com.tech4me.medicos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.medicos.shared.MedicoCompletoDto;

@Document("medicos")
public class Medicos {
    @Id
    
    private String id;
    private String nome;
    private String crm;
    private String endereco;
    private Especialidade especialidade;

    public Medicos(){}

    public Medicos(MedicoCompletoDto dto){
        this.id=dto.id();
        this.nome=dto.nome();
        this.crm=dto.crm();
        this.endereco=dto.endereco();
        this.especialidade=dto.especialidade();

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Especialidade getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
