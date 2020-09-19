package br.com.fiap.b2w.models;

import java.util.List;

public class Gestor extends Associado {
    private List<PlanodeDesenvolvimento> planosCriados;

    public Gestor() {
    }

    public Gestor(int nrCadastro,
                  String nomeCompleto,
                  String email,
                  String senha,
                  Equipe equipe,
                  String cargo,
                  long cpf) {
        super(nrCadastro, nomeCompleto, email, senha, equipe, cargo, cpf);
    }

    public Gestor(int nrCadastro,
                  String nomeCompleto,
                  String email,
                  String senha,
                  String cargo,
                  long cpf,
                  Integer codigoSetorGerencia,
                  Equipe equipe,
                  List<Associado> liderados,
                  List<PlanodeDesenvolvimento> planosCriados) {
        super(nrCadastro, nomeCompleto, email, senha, equipe, cargo, cpf);
//        this.liderados = liderados;
        this.planosCriados = planosCriados;
    }

    public List<PlanodeDesenvolvimento> getPlanosCriados() {
        return planosCriados;
    }

    public void setPlanosCriados(List<PlanodeDesenvolvimento> planosCriados) {
        this.planosCriados = planosCriados;
    }

//    public List<Associado> getLiderados() {
//        return liderados;
//    }
//
//    public void setLiderados(List<Associado> liderados) {
//        this.liderados = liderados;
//    }
}
