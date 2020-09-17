package br.com.fiap.b2w.models;

import java.util.ArrayList;
import java.util.List;

public class Gestor extends br.com.fiap.b2w.models.Associado {

    private String setorGerencia;
    private List<Associado> liderados;

    public Gestor(int nrCadastro, String nomeCompleto, String email,
                  String senha, String cargo, long cpf, String setorGerencia, List<Associado> liderados) {
        super(nrCadastro, nomeCompleto, email, senha, cargo, cpf);
        this.setorGerencia = setorGerencia;
        this.liderados = new ArrayList<>();
    }

    public String getSetorGerencia() {
        return setorGerencia;
    }

    public void setSetorGerencia(String setorGerencia) {
        this.setorGerencia = setorGerencia;
    }

    public List<Associado> getLiderados() {
        return liderados;
    }

    public void setLiderados(List<Associado> liderados) {
        this.liderados = liderados;
    }
}
