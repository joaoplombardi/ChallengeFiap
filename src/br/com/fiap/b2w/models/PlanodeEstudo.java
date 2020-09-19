package br.com.fiap.b2w.models;

import java.time.LocalDate;
import java.util.List;

public class PlanodeEstudo {

    private Associado associado;
    private Gestor gestor;
    private LocalDate dtCriacao;
    private String areadeConhecimento;
    private List<Recomendacao> recomendacoes;
    private int duracao;

    public PlanodeEstudo(Associado associado,
                         Gestor gestor,
                         String areadeConhecimento,
                         List<Recomendacao> recomendacoes) {
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

    public List<Recomendacao> getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(List<Recomendacao> recomendacoes) {
        this.recomendacoes = recomendacoes;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
