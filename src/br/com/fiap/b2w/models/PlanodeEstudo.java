package br.com.fiap.b2w.models;
import java.time.LocalDate;

public class PlanodeEstudo {

    private br.com.fiap.b2w.models.Associado associado;
    private br.com.fiap.b2w.models.Gestor gestor;
    private LocalDate dtCriacao;
    private String areadeConhecimento;
    private Recomendacoes[] recomendacoes;
    private int duracao;

    public PlanodeEstudo(br.com.fiap.b2w.models.Associado associado, br.com.fiap.b2w.models.Gestor gestor, String areadeConhecimento, Recomendacoes[] recomendacoes) {
        this.associado = associado;
        this.gestor = gestor;
        this.dtCriacao = LocalDate.now();
        this.areadeConhecimento = areadeConhecimento;
        this.recomendacoes = recomendacoes;
    }

    public br.com.fiap.b2w.models.Associado getAssociado() {
        return associado;
    }

    public void setAssociado(br.com.fiap.b2w.models.Associado associado) {
        this.associado = associado;
    }

    public br.com.fiap.b2w.models.Gestor getGestor() {
        return gestor;
    }

    public void setGestor(br.com.fiap.b2w.models.Gestor gestor) {
        this.gestor = gestor;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public String getAreadeConhecimento() {
        return areadeConhecimento;
    }

    public void setAreadeConhecimento(String areadeConhecimento) {
        this.areadeConhecimento = areadeConhecimento;
    }

    public Recomendacoes[] getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(Recomendacoes[] recomendacoes) {
        this.recomendacoes = recomendacoes;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
