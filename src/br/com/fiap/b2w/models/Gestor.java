package br.com.fiap.b2w.models;

public class Gestor extends br.com.fiap.b2w.models.Associado {

    private String setorGerencia;
    private br.com.fiap.b2w.models.Associado[] liderados;

    public Gestor(int nrCadastro, String nomeCompleto, String email,
                  String senha, String cargo, long cpf, String setorGerencia, br.com.fiap.b2w.models.Associado[] liderados) {
        super(nrCadastro, nomeCompleto, email, senha, cargo, cpf);
        this.setorGerencia = setorGerencia;
        this.liderados = liderados;
    }

    public String getSetorGerencia() {
        return setorGerencia;
    }

    public void setSetorGerencia(String setorGerencia) {
        this.setorGerencia = setorGerencia;
    }

    public br.com.fiap.b2w.models.Associado[] getLiderados() {
        return liderados;
    }

    public void setLiderados(br.com.fiap.b2w.models.Associado[] liderados) {
        this.liderados = liderados;
    }
}
