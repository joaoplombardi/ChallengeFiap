package br.com.fiap.b2w;

import br.com.fiap.b2w.models.*;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

        Associado bruno = new Associado();
        Associado jonas = new Associado();
        Equipe equipe = new Equipe();
        Gestor alice = new Gestor();
        PlanodeDesenvolvimento planodeDesenvolvimento1 = new PlanodeDesenvolvimento();
        PlanodeDesenvolvimento planodeDesenvolvimento2 = new PlanodeDesenvolvimento();
        PlanodeEstudo planodeEstudo = new PlanodeEstudo();
        RH rh = new RH();
        Task task1 = new Task();
        Task task2 = new Task();

        task1.setCdTask(15561651);
        task1.setObjetivo("ASDF");
        task1.setStatus(Status.CRIADA);

        task2.setCdTask(8794621);
        task2.setObjetivo("QWER");
        task2.setStatus(Status.CRIADA);

        List<Task> tasks1 = new ArrayList<>();
        List<Task> tasks2 = new ArrayList<>();
        tasks1.add(task1);
        tasks2.add(task2);

        planodeDesenvolvimento1.setCdPlanodeDesenvolvimento(123);
        planodeDesenvolvimento1.setAtivo(true);
        planodeDesenvolvimento1.setTasks(tasks1);
        planodeDesenvolvimento1.setAssociado(bruno);

        planodeDesenvolvimento2.setCdPlanodeDesenvolvimento(456);
        planodeDesenvolvimento2.setAtivo(true);
        planodeDesenvolvimento2.setTasks(tasks2);
        planodeDesenvolvimento2.setAssociado(jonas);

        List<PlanodeDesenvolvimento> planosdeDesenvolvimento = new ArrayList<>();
        planosdeDesenvolvimento.add(planodeDesenvolvimento1);
        planosdeDesenvolvimento.add(planodeDesenvolvimento2);

        bruno.setNomeCompleto("Bruno");
        bruno.setCargo("Dev back");
        bruno.setEquipe(equipe);

        jonas.setNomeCompleto("Jonas");
        jonas.setCargo("Dev front");
        jonas.setEquipe(equipe);

        List<Associado> associados = new ArrayList<>();
        associados.add(bruno);
        associados.add(jonas);

        equipe.setCdEquipe(123);
        equipe.setGerenteResponsavel(alice);
        equipe.setMembros(associados);


        alice.setNomeCompleto("Alice");
        alice.setEquipe(equipe);
       // alice.setLiderados(associados);
        alice.setPlanosCriados(planosdeDesenvolvimento);

        System.out.println("-----------------------");
        System.out.println("Gestor(a): " + alice.getNomeCompleto());
        System.out.println("-----------------------");
        System.out.println("Equipe do Gestor(a)");
        alice.getEquipe().getMembros().forEach(membro -> {
            System.out.println(membro.getNomeCompleto() + " - " + membro.getCargo());
        });
        System.out.println("-----------------------");
        System.out.println("Planos Criados pelo Gestor(a)");
        alice.getPlanosCriados().forEach(planodeDesenvolvimento ->
                System.out.println(planodeDesenvolvimento.getCdPlanodeDesenvolvimento())
        );
        System.out.println("-----------------------");
        System.out.println("Tasks dentro do Plano");
        alice.getPlanosCriados().forEach(planodeDesenvolvimento ->
                planodeDesenvolvimento.getTasks().forEach(task ->
                        System.out.println(
                                task.getCdTask() + " - " +
                                task.getObjetivo() + " - " +
                                task.getStatus()
                        )
                )
        );
        System.out.println("-----------------------");
        System.out.println("Plano atribuido");
        alice.getPlanosCriados().forEach(planodeDesenvolvimento ->
                System.out.println(
                        planodeDesenvolvimento.getCdPlanodeDesenvolvimento() + " - " +
                        planodeDesenvolvimento.getAssociado().getNomeCompleto()
                )
        );
        System.out.println("-----------------------");


    }
}
