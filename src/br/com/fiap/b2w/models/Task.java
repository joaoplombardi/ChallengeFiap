package br.com.fiap.b2w.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class
Task {
    private Integer cdTask;
    private Status status;
    private LocalDate dtCriacao;
    private LocalDate dtInicio;
    private LocalDate dtTermino;
    private String objetivo;

    public Task() {
    }

    public Task(Integer cdTask,
                Status status,
                LocalDate dtCriacao,
                LocalDate dtInicio,
                LocalDate dtTermino,
                String objetivo) {
        this.cdTask = cdTask;
        this.status = status;
        this.dtCriacao = dtCriacao;
        this.dtInicio = dtInicio;
        this.dtTermino = dtTermino;
        this.objetivo = objetivo;
    }

    public Integer getCdTask() {
        return cdTask;
    }

    public void setCdTask(Integer cdTask) {
        this.cdTask = cdTask;
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

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtTermino() {
        return dtTermino;
    }

    public void setDtTermino(LocalDate dtTermino) {
        this.dtTermino = dtTermino;
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
