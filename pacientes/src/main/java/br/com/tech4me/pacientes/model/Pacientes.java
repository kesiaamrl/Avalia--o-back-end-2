package br.com.tech4me.pacientes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.pacientes.shared.PacientesCompletoDto;

@Document("pacientes")
public class Pacientes {
    @Id
    
    private String id;
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;

    public Pacientes (){}

    public Pacientes (PacientesCompletoDto dto){
        this.id=dto.id();
        this.nome=dto.nome();
        this.cpf=dto.cpf();
        this.endereco=dto.endereco();
        this.idade=dto.idade();
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
