package br.com.connectall.b2w.models;

import java.time.LocalDate;

public class Task {
    private int id;
    private String nome;
    private String descricao;
    private Integer planoPertencente;
    private Status status;
    private LocalDate dtCriacao;
    private LocalDate dtTermino;

    public Task() {
    }

    public Task(int id,
                String nome,
                String descricao,
                Integer planoPertencente,
                Status status,
                LocalDate dtCriacao,
                LocalDate dtTermino) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.planoPertencente = planoPertencente;
        this.status = status;
        this.dtCriacao = dtCriacao;
        this.dtTermino = dtTermino;
    }

    public Task(String nome, Integer codigo, Status status, String objetivo, Integer plano) {
        this.nome = nome;
        this.id = codigo;
        this.status = status;
        this.descricao = objetivo;
        this.planoPertencente = plano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPlanoPertencente() {
        return planoPertencente;
    }

    public void setPlanoPertencente(Integer planoPertencente) {
        this.planoPertencente = planoPertencente;
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

    public LocalDate getDtTermino() {
        return dtTermino;
    }

    public void setDtTermino(LocalDate dtTermino) {
        this.dtTermino = dtTermino;
    }

    //
//    public void iniciar(){
//        this.status = Status.INICIALIZADA;
//        this.dtInicio = LocalDate.now();
//    }
//
//    public void terminar(){
//        this.status = Status.CONCLUIDA;
//        this.dtTermino = LocalDate.now();
//    }
//    public long calculaTempoTermino(){
//        long tempoTermino = ChronoUnit.DAYS.between(dtInicio, dtTermino);
//        return tempoTermino;
//    }

}
