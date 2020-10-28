package br.com.connectall.b2w.models;

public class Recomendacao {
    //tipo = leitura, documentação etc.
    private String tipo;
    private double duracao;

    public Recomendacao(String tipo, double duracao) {
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

    public Recomendacao() {
        super();
    }
}
