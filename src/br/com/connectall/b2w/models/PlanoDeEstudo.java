package br.com.connectall.b2w.models;

import java.time.LocalDate;
import java.util.List;

public class PlanoDeEstudo {

    private Associado associado;
    private Gestor gestor;
    private LocalDate dtCriacao;
    private String areadeConhecimento;
    private List<Recomendacao> recomendacoes;
    private int duracao;

    public PlanoDeEstudo() {
    }

    public PlanoDeEstudo(Associado associado,
                         Gestor gestor,
                         String areadeConhecimento,
                         List<Recomendacao> recomendacoes) {
        this.associado = associado;
        this.gestor = gestor;
        this.dtCriacao = LocalDate.now();
        this.areadeConhecimento = areadeConhecimento;
        this.recomendacoes = recomendacoes;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
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
