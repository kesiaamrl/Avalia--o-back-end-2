package main.java.br.com.tech4me.medicos.model;

import main.java.br.com.tech4me.medicos.shared.MedicoCompletoDto;

@Document("medicos")
public class Medicos {
    
    private String id;
    private String nome;
    private String crm;
    private String endereco;
    private Especialidade especialidade;

    public Medicos(){}

    public Medicos (MedicoCompletoDto dto){
        this.id=dto.id();
        this.crm=dto.crm();
        this.nome=dto.crm();
        this.especialidade=dto.especialidade();
        this.endereco=dto.endereco();
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
