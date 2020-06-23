package br.com.fiap.b2w.models;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class PlanodeAcao {

    private br.com.fiap.b2w.models.Associado associado;
    private br.com.fiap.b2w.models.Gestor gestor;
    private LocalDate dtCriacao;
    private Task[] tasks;
    private double percentualConcluidos;
    private String status;

    public PlanodeAcao(br.com.fiap.b2w.models.Associado associado, br.com.fiap.b2w.models.Gestor gestor, Task[] tasks) {
        this.associado = associado;
        this.gestor = gestor;
        this.tasks = tasks;
        this.dtCriacao = LocalDate.now();
        this.percentualConcluidos = .0;
        this. status = "Em andamento";
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

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public double getPercentualConcluidos() {
        calculaPercentualConcluidos();
        return percentualConcluidos;
    }

    public void setPercentualConcluidos(double percentualConcluidos) {
        this.percentualConcluidos = percentualConcluidos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void calculaPercentualConcluidos(){
        int concluidas = 0;
        for(int i = 0; i < this.tasks.length; i++){
            if(this.tasks[i].getStatus() == "Concluída"){
                concluidas = concluidas + 1;
            }
        }
        double percentual = (concluidas/this.tasks.length)*100;
        DecimalFormat dt = new DecimalFormat("##0.0");
        dt.format(percentual);
        this.percentualConcluidos = percentual;
    }
    public void defineStatus(){
        this.status = (this.percentualConcluidos < 100.0) ? "Em andamento" : "Finalizado";
    }
}
