package br.com.connectall.b2w.models;

import java.util.List;

public class RH {

    private int id;
    private String nomeCompleto;
    private String email;
    private String senha;
    private Equipe equipe;
    private String cpf;
    private Integer cdSetorParaAprovar;
    private List<PlanoDeDesenvolvimento> planosParaAprovacao;

    public RH() {
    }

    public RH(int id,
              String nomeCompleto,
              String email,
              String senha,
              Equipe equipe,
              String cpf,
              Integer cdSetorParaAprovar,
              List<PlanoDeDesenvolvimento> planosParaAprovacao) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.equipe = equipe;
        this.cpf = cpf;
        this.cdSetorParaAprovar = cdSetorParaAprovar;
        this.planosParaAprovacao = planosParaAprovacao;
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

    public Integer getCdSetorParaAprovar() {
        return cdSetorParaAprovar;
    }

    public void setCdSetorParaAprovar(Integer cdSetorParaAprovar) {
        this.cdSetorParaAprovar = cdSetorParaAprovar;
    }

    public List<PlanoDeDesenvolvimento> getPlanosParaAprovacao() {
        return planosParaAprovacao;
    }

    public void setPlanosParaAprovacao(List<PlanoDeDesenvolvimento> planosParaAprovacao) {
        this.planosParaAprovacao = planosParaAprovacao;
    }
}
