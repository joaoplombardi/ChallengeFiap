package br.com.connectall.b2w.models;

import java.util.List;

public class Associado {

    private int nrCadastro;
    private String nomeCompleto;
    private String email;
    private String senha;
    private Equipe equipe;
    private String cargo;
    private long cpf;
    private List<PlanodeEstudo> planodeEstudo;
    private PlanodeDesenvolvimento planodeDesenvolvimento;

    public Associado() {
    }

    public Associado(int nrCadastro,
                     String nomeCompleto,
                     String email,
                     String senha,
                     Equipe equipe,
                     String cargo,
                     long cpf) {
        this.nrCadastro = nrCadastro;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.equipe = equipe;
        this.cargo = cargo;
        this.cpf = cpf;
    }

    public int getNrCadastro() {
        return nrCadastro;
    }

    public void setNrCadastro(int nrCadastro) {
        this.nrCadastro = nrCadastro;
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public List<PlanodeEstudo> getPlanodeEstudo() {
        return planodeEstudo;
    }

    public void setPlanodeEstudo(List<PlanodeEstudo> planodeEstudo) {
        this.planodeEstudo = planodeEstudo;
    }

    public PlanodeDesenvolvimento getPlanodeDesenvolvimento() {
        return planodeDesenvolvimento;
    }

    public void setPlanodeDesenvolvimento(PlanodeDesenvolvimento planodeDesenvolvimento) {
        this.planodeDesenvolvimento = planodeDesenvolvimento;
    }
}
