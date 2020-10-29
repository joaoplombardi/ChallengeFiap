package br.com.connectall.b2w.models;

import java.util.List;

public class Associado {

    private int id;
    private String nomeCompleto;
    private String email;
    private String senha;
    private Equipe equipe;
    private String cargo;
    private String cpf;
    private List<PlanoDeEstudo> planosDeEstudo;
    private PlanoDeDesenvolvimento planosDeDesenvolvimento;

    public Associado() {
    }

    public Associado(int id,
                     String nomeCompleto,
                     String email,
                     String senha,
                     Equipe equipe,
                     String cargo,
                     String cpf) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.equipe = equipe;
        this.cargo = cargo;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<PlanoDeEstudo> getPlanosDeEstudo() {
        return planosDeEstudo;
    }

    public void setPlanosDeEstudo(List<PlanoDeEstudo> planosDeEstudo) {
        this.planosDeEstudo = planosDeEstudo;
    }

    public PlanoDeDesenvolvimento getPlanodeDesenvolvimento() {
        return planosDeDesenvolvimento;
    }

    public void setPlanodeDesenvolvimento(PlanoDeDesenvolvimento planodeDesenvolvimento) {
        this.planosDeDesenvolvimento = planodeDesenvolvimento;
    }
}
