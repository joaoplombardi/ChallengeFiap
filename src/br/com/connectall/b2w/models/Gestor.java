package br.com.connectall.b2w.models;

import java.util.List;

public class Gestor {

    private int id;
    private String nomeCompleto;
    private String email;
    private String senha;
    private Equipe equipe;
    private String cpf;
    private List<PlanoDeDesenvolvimento> planosCriados;
    private List<Equipe> equipes;

    public Gestor() {
    }

    public Gestor(int id,
                  String nomeCompleto,
                  String email,
                  String senha,
                  Equipe equipe,
                  String cargo,
                  String cpf) {
    }

    public Gestor(int id,
                  String nomeCompleto,
                  String email,
                  String senha,
                  Equipe equipe,
                  String cpf,
                  List<PlanoDeDesenvolvimento> planosCriados,
                  List<Equipe> equipes) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.equipe = equipe;
        this.cpf = cpf;
        this.planosCriados = planosCriados;
        this.equipes = equipes;
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

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<PlanoDeDesenvolvimento> getPlanosCriados() {
        return planosCriados;
    }

    public void setPlanosCriados(List<PlanoDeDesenvolvimento> planosCriados) {
        this.planosCriados = planosCriados;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

}
