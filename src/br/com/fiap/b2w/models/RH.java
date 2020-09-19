package br.com.fiap.b2w.models;

import java.util.List;

public class RH extends Associado{

    private List<PlanodeDesenvolvimento> planosParaAprovacao;

    public RH() {
    }

    public RH(int nrCadastro,
              String nomeCompleto,
              String email,
              String senha,
              Equipe equipe,
              String cargo,
              long cpf,
              Integer cdSetorParaAprovar,
              List<PlanodeDesenvolvimento> planosParaAprovacao) {
        super(nrCadastro, nomeCompleto, email, senha, equipe,cargo, cpf);

        this.planosParaAprovacao = planosParaAprovacao;
    }

    public List<PlanodeDesenvolvimento> getPlanosParaAprovacao() {
        return planosParaAprovacao;
    }

    public void setPlanosParaAprovacao(List<PlanodeDesenvolvimento> planosParaAprovacao) {
        this.planosParaAprovacao = planosParaAprovacao;
    }
}
