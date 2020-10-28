package br.com.connectall.b2w.validation;

import br.com.connectall.b2w.exceptions.AtivoSemDataException;
import br.com.connectall.b2w.exceptions.PlanoSemAssociadoException;
import br.com.connectall.b2w.exceptions.PlanoSemGestorException;
import br.com.connectall.b2w.exceptions.PlanoSemTaskException;
import br.com.connectall.b2w.models.PlanodeDesenvolvimento;

public class PlanoDesenvValidator {

    public static void verificaAtivoSemDataInicio(PlanodeDesenvolvimento plano) throws AtivoSemDataException {
        if (plano.getAtivo() && plano.getDtInicio() == null) {
            throw new AtivoSemDataException("Você não pode ter um plano ativo sem data de início!");
        }
    }

    public static void verificaPlanoSemGestor(PlanodeDesenvolvimento plano) throws PlanoSemGestorException {
        if (plano.getGestor() == null) {
            throw new PlanoSemGestorException("Um Plano de Desenvolvimento não pode existir sem um Gestor!");
        }
    }

    public static void verificaPlanoSemAssociado(PlanodeDesenvolvimento plano) throws PlanoSemAssociadoException {
        if (plano.getAssociado() == null) {
            throw new PlanoSemAssociadoException("Um Plano de Desenvolvimento não pode existir sem um Associado!");
        }
    }

    public static void verificaPlanoSemTask(PlanodeDesenvolvimento plano) throws PlanoSemTaskException {
        if (plano.getTasks().size() == 0) {
            throw new PlanoSemTaskException("Um Plano de Desenvolvimento não pode existir sem nenhuma Task!");
        }
    }

}
