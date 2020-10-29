package br.com.connectall.b2w.models;

import java.time.LocalDate;
import java.util.List;

public class Equipe {

    private int id;
    private LocalDate dtInicio;
    private LocalDate dtEncerramento;
    private Gestor gerenteResponsavel;
    private RH rhResponsavel;
    private List<Associado> membros;
    private List<PlanoDeDesenvolvimento> planosEquipe;

    public Equipe() {

    }

    public Equipe(Integer id,
                  LocalDate dtInicio,
                  LocalDate dtEncerramento,
                  Gestor gerenteResponsavel,
                  RH rhResponsavel,
                  List<Associado> membros,
                  List<PlanoDeDesenvolvimento> planosEquipe) {
        this.id = id;
        this.dtInicio = dtInicio;
        this.dtEncerramento = dtEncerramento;
        this.gerenteResponsavel = gerenteResponsavel;
        this.rhResponsavel = rhResponsavel;
        this.membros = membros;
        this.planosEquipe = planosEquipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtEncerramento() {
        return dtEncerramento;
    }

    public void setDtEncerramento(LocalDate dtEncerramento) {
        this.dtEncerramento = dtEncerramento;
    }

    public Gestor getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    public void setGerenteResponsavel(Gestor gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }

    public RH getRhResponsavel() {
        return rhResponsavel;
    }

    public void setRhResponsavel(RH rhResponsavel) {
        this.rhResponsavel = rhResponsavel;
    }

    public List<Associado> getMembros() {
        return membros;
    }

    public void setMembros(List<Associado> membros) {
        this.membros = membros;
    }

    public List<PlanoDeDesenvolvimento> getPlanosEquipe() {
        return planosEquipe;
    }

    public void setPlanosEquipe(List<PlanoDeDesenvolvimento> planosEquipe) {
        this.planosEquipe = planosEquipe;
    }
}
