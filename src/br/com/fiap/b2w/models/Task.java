package br.com.fiap.b2w.models;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;

public class
Task {
    private br.com.fiap.b2w.models.Gestor gestor;
    private br.com.fiap.b2w.models.Associado lideradoaFazer;
    private String status;
    private LocalDate dtCriacao;
    private LocalDate dtInicio;
    private LocalDate dtTermino;
    private String objetivo;

    public Task() {
    }

    public Task(br.com.fiap.b2w.models.Gestor gestor, br.com.fiap.b2w.models.Associado lideradoaFazer, String objetivo) {
        this.gestor = gestor;
        this.lideradoaFazer = lideradoaFazer;
        this.dtCriacao = LocalDate.now();
        this.dtInicio = null;
        this.dtTermino = null;
        this.objetivo = objetivo;
        this.status = "Não Iniciado";
    }

    public br.com.fiap.b2w.models.Gestor getGestor() {
        return gestor;
    }

    public br.com.fiap.b2w.models.Associado getLideradoaFazer() {
        return lideradoaFazer;
    }

    public void setLideradoaFazer(br.com.fiap.b2w.models.Associado lideradoaFazer) {
        this.lideradoaFazer = lideradoaFazer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        this.status = "Em Curso";
        this.dtInicio = LocalDate.now();
    }

    public void terminar(){
        this.status = "Concluída";
        this.dtTermino = LocalDate.now();
    }
    public long calculaTempoTermino(){
        long tempoTermino = ChronoUnit.HOURS.between(dtInicio, dtTermino);
        return tempoTermino;
    }

}
