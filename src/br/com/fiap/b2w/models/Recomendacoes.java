package br.com.fiap.b2w.models;

public class Recomendacoes {
    //tipo = leitura, documentação etc.
    private String tipo;
    private double duracao;

    public Recomendacoes(String tipo, double duracao) {
        this.tipo = tipo;
        this.duracao = duracao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Recomendacoes() {
        super();
    }
}
