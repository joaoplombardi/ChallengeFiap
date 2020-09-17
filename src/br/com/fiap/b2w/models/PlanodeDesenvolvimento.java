package br.com.fiap.b2w.models;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanodeDesenvolvimento {

    private Associado associado;
    private Gestor gestor;
    private LocalDate dtCriacao;
    private List<Task> tasks;
    private Double percentualConcluidos;
    private Status status;

    public PlanodeDesenvolvimento(Associado associado, Gestor gestor) {
        this.associado = associado;
        this.gestor = gestor;
        this.tasks = new ArrayList<>();
        this.dtCriacao = LocalDate.now();
        this.percentualConcluidos = .0;
        this. status = Status.PARADA;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task consultaTaskPorPosicao(int posicao){
        return tasks.get(posicao);
    }

    public Double getPercentualConcluidos() {
        calculaPercentualConcluidos();
        return percentualConcluidos;
    }

    public void setPercentualConcluidos(Double percentualConcluidos) {
        this.percentualConcluidos = percentualConcluidos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void calculaPercentualConcluidos(){
        int concluidas = 0;
        for(int i = 0; i < this.tasks.size(); i++){
            if(this.tasks.get(i).getStatus() == Status.CONCLUIDA){
                concluidas = concluidas + 1;
            }
        }
        double percentual = (concluidas/this.tasks.size())*100;
        DecimalFormat dt = new DecimalFormat("##0.0");
        dt.format(percentual);
        this.percentualConcluidos = percentual;
    }
    public void defineStatus(){
        this.status = (this.percentualConcluidos < 100.0) ? Status.INICIALIZADA : Status.CONCLUIDA;
    }
}
