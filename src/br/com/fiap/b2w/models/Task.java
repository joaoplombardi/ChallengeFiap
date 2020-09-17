package br.com.fiap.b2w.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class
Task {
    private Gestor gestor;
    private Associado lideradoaFazer;
    private Status status;
    private LocalDate dtCriacao;
    private LocalDate dtInicio;
    private LocalDate dtTermino;
    private String objetivo;

    public Task() {
    }

    public Task(Gestor gestor, Associado lideradoaFazer, String objetivo) {
        this.gestor = gestor;
        this.lideradoaFazer = lideradoaFazer;
        this.dtCriacao = LocalDate.now();
        this.dtInicio = null;
        this.dtTermino = null;
        this.objetivo = objetivo;
        this.status = Status.PARADA;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public Associado getLideradoaFazer() {
        return lideradoaFazer;
    }

    public void setLideradoaFazer(Associado lideradoaFazer) {
        this.lideradoaFazer = lideradoaFazer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public LocalDate getDtTermino() {
        return dtTermino;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void iniciar(){
        this.status = Status.INICIALIZADA;
        this.dtInicio = LocalDate.now();
    }

    public void terminar(){
        this.status = Status.CONCLUIDA;
        this.dtTermino = LocalDate.now();
    }
    public long calculaTempoTermino(){
        long tempoTermino = ChronoUnit.DAYS.between(dtInicio, dtTermino);
        return tempoTermino;
    }

}
