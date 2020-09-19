package br.com.fiap.b2w.models;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanodeDesenvolvimento {
    private Integer cdPlanodeDesenvolvimento;
    private Associado associado;
    private Gestor gestor;
    private Equipe equipe;
    private LocalDate dtTermino;
    private LocalDate dtInicio;
    private List<Task> tasks;
   // private Double percentualConcluidos;
   // private Status status;
    private Boolean ativo;

    public PlanodeDesenvolvimento() {
    }

    public PlanodeDesenvolvimento(Integer cdPlanodeDesenvolvimento,
                                  Associado associado,
                                  Gestor gestor,
                                  Equipe equipe,
                                  LocalDate dtInicio,
                                  List<Task> tasks,
                                  Boolean ativo) {
        this.cdPlanodeDesenvolvimento = cdPlanodeDesenvolvimento;
        this.associado = associado;
        this.gestor = gestor;
        this.equipe = equipe;
        this.dtInicio = dtInicio;
        this.tasks = tasks;
        this.ativo = ativo;
    }

    public PlanodeDesenvolvimento(Integer cdPlanodeDesenvolvimento,
                                  Associado associado,
                                  Gestor gestor,
                                  Equipe equipe,
                                  List<Task> tasks,
                                  Boolean ativo) {
        this.cdPlanodeDesenvolvimento = cdPlanodeDesenvolvimento;
        this.associado = associado;
        this.gestor = gestor;
        this.equipe = equipe;
        this.tasks = tasks;
        this.ativo = ativo;
    }

    public PlanodeDesenvolvimento(Associado associado, Equipe equipe) {
        this.associado = associado;
        this.equipe = equipe;
        this.tasks = new ArrayList<>();
        this.dtInicio = null;
        this.dtTermino = null;
       // this.percentualConcluidos = .0;
     //   this.status = Status.PARADA;
        this.ativo = false;
    }

    public Integer getCdPlanodeDesenvolvimento() {
        return cdPlanodeDesenvolvimento;
    }

    public void setCdPlanodeDesenvolvimento(Integer cdPlanodeDesenvolvimento) {
        this.cdPlanodeDesenvolvimento = cdPlanodeDesenvolvimento;
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


    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public LocalDate getDtTermino() {
        return dtTermino;
    }

    public void setDtTermino(LocalDate dtTermino) {
        this.dtTermino = dtTermino;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
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

//    public Double getPercentualConcluidos() {
//        calculaPercentualConcluidos();
//        return percentualConcluidos;
//    }

//    public void setPercentualConcluidos(Double percentualConcluidos) {
//        this.percentualConcluidos = percentualConcluidos;
//    }

//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

//    public void calculaPercentualConcluidos(){
//        int concluidas = 0;
//        for(int i = 0; i < this.tasks.size(); i++){
//            if(this.tasks.get(i).getStatus() == Status.CONCLUIDA){
//                concluidas = concluidas + 1;
//            }
//        }
//        double percentual = (concluidas/this.tasks.size())*100;
//        DecimalFormat dt = new DecimalFormat("##0.0");
//        dt.format(percentual);
//        this.percentualConcluidos = percentual;
//    }



}
