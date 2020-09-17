package br.com.fiap.b2w.models;

public class Associado {

    private int nrCadastro;
    private String nomeCompleto;
    private String email;
    private String senha;
    private String cargo;
    private long cpf;
    private PlanodeEstudo planodeEstudo;
    private PlanodeDesenvolvimento planodeDesenvolvimento;

    public Associado(int nrCadastro, String nomeCompleto, String email, String senha, String cargo, long cpf) {
        this.nrCadastro = nrCadastro;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.cpf = cpf;
    }

    public int getNrCadastro() {
        return nrCadastro;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getCpf() {
        return cpf;
    }

    public PlanodeEstudo getPlanodeEstudo() {
        return planodeEstudo;
    }

    public void setPlanodeEstudo(PlanodeEstudo planodeEstudo) {
        this.planodeEstudo = planodeEstudo;
    }

    public PlanodeDesenvolvimento getPlanodeDesenvolvimento() {
        return planodeDesenvolvimento;
    }

    public void setPlanodeDesenvolvimento(PlanodeDesenvolvimento planodeDesenvolvimento) {
        this.planodeDesenvolvimento = planodeDesenvolvimento;
    }
}
