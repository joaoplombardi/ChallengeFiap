package br.com.fiap.b2w;

import br.com.fiap.b2w.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void menu() {
        System.out.println(" -------------------------------------");
        System.out.println("|                SGP                  |");
        System.out.println("| 1-Dashboard do Gestor               |");
        System.out.println("| 2-Dashboard do RH                   |");
        System.out.println("| 3-Dashboard do Associado            |");
        System.out.println("| 0-Sair                              |");
        System.out.println(" -------------------------------------");
    }

    public static void menuGestor() {
        System.out.println(" -------------------------------------");
        System.out.println("|                SGP                  |");
        System.out.println("| 1-Criar Plano de Desenvolvimento    |");
        System.out.println("| 2-Consultar planos criados          |");
        System.out.println("| 0-Sair                              |");
        System.out.println(" -------------------------------------");
    }

    public static void menuRH() {
        System.out.println(" -------------------------------------");
        System.out.println("|                SGP                  |");
        System.out.println("| 1-Aprovar Plano de Desenvolvimento  |");
        System.out.println("| 0-Sair                              |");
        System.out.println(" -------------------------------------");
    }

    public static void menuAssociado() {
        System.out.println(" -------------------------------------");
        System.out.println("|                SGP                  |");
        System.out.println("| 1-Consultar Plano de Desenvolvimento|");
        System.out.println("| 2-Iniciar Task                      |");
        System.out.println("| 3-Encerrar Task                     |");
        System.out.println("| 0-Sair                              |");
        System.out.println(" -------------------------------------");
    }

    public static void main(String[] args) {
        menu();
        Integer opcao = null;
        Scanner scan = new Scanner(System.in);
        System.out.print("Qual Dashboard gostaria de acessar: ");
        opcao = scan.nextInt();
        scan.nextLine();
        do {
            switch (opcao) {
                case 1 -> dashboardGestor(scan);
                case 2 -> dashboardRH(scan);
                case 3 -> dashboardAssociado(scan);
            }
        } while (opcao != 0);
    }

    private static void dashboardAssociado(Scanner scan) {
        menuAssociado();
        Integer opcao = null;
        System.out.print("Qual ação será realizada: ");
        opcao = scan.nextInt();
        scan.nextLine();
        switch (opcao) {
            case 1 -> consultaPlanosAtribuidos();
            case 2 -> iniciarTask();
            case 3 -> encerrarTask();
        }
    }

    private static void iniciarTask() {
        Scanner scan = new Scanner(System.in);
        Integer opcao = null;
        System.out.println("Informe o código da task para iniciar: ");
        opcao = scan.nextInt();
        System.out.println("Task " + opcao + " iniciada!");
        menu();
    }

    private static void encerrarTask() {
        Scanner scan = new Scanner(System.in);
        Integer opcao = null;
        System.out.println("Informe o código da task para encerrar: ");
        opcao = scan.nextInt();
        System.out.println("Task " + opcao + " encerrar!");
        menu();
    }

    private static void consultaPlanosAtribuidos() {
        Gestor gestor = new Gestor();
        Associado associado = new Associado();

        gestor.setNomeCompleto("Marcos");

        Task task = new Task();
        task.setNome("Java");
        task.setStatus(Status.CRIADA);

        Task task2 = new Task();
        task2.setNome("Oracle");
        task2.setStatus(Status.CRIADA);

        List<Task> arrayTask = new ArrayList<>();
        arrayTask.add(task);
        arrayTask.add(task2);

        PlanodeDesenvolvimento planodeDesenvolvimento = new PlanodeDesenvolvimento();
        planodeDesenvolvimento.setAtivo(true);
        planodeDesenvolvimento.setCdPlanodeDesenvolvimento(123);
        planodeDesenvolvimento.setTasks(arrayTask);

        associado.setNomeCompleto("Sérgio");
        associado.setPlanodeDesenvolvimento(planodeDesenvolvimento);

        List<PlanodeDesenvolvimento> arrayPlanosCriados = new ArrayList<>();
        arrayPlanosCriados.add(planodeDesenvolvimento);
        gestor.setPlanosCriados(arrayPlanosCriados);

        RH rh = new RH();
        rh.setPlanosParaAprovacao(arrayPlanosCriados);

        associado.setPlanodeDesenvolvimento(planodeDesenvolvimento);

        System.out.println("Associado...............: " + associado.getNomeCompleto());
        System.out.println("Plano com Associado.....: " + associado.getPlanodeDesenvolvimento().getCdPlanodeDesenvolvimento());
        associado.getPlanodeDesenvolvimento().getTasks().forEach(task1 ->
                System.out.println("Task com Associado......: " + task1.getNome()));
    }

    private static void consultaPlanosGestor() {
        System.out.println("-------------------------------");
        Gestor gestor = new Gestor();
        Associado associado = new Associado();

        gestor.setNomeCompleto("Marcos");

        Task task = new Task();
        task.setNome("Java");
        task.setStatus(Status.CRIADA);

        Task task2 = new Task();
        task2.setNome("Oracle");
        task2.setStatus(Status.CRIADA);

        List<Task> arrayTask = new ArrayList<>();
        arrayTask.add(task);
        arrayTask.add(task2);

        PlanodeDesenvolvimento planodeDesenvolvimento = new PlanodeDesenvolvimento();
        planodeDesenvolvimento.setAtivo(true);
        planodeDesenvolvimento.setCdPlanodeDesenvolvimento(123);
        planodeDesenvolvimento.setTasks(arrayTask);

        associado.setNomeCompleto("Sérgio");
        associado.setPlanodeDesenvolvimento(planodeDesenvolvimento);

        List<PlanodeDesenvolvimento> arrayPlanosCriados = new ArrayList<>();
        arrayPlanosCriados.add(planodeDesenvolvimento);
        gestor.setPlanosCriados(arrayPlanosCriados);

        RH rh = new RH();
        rh.setPlanosParaAprovacao(arrayPlanosCriados);

        associado.setPlanodeDesenvolvimento(planodeDesenvolvimento);

        //System.out.println(planodeDesenvolvimento.getAssociado().getNomeCompleto()); não faz sentido
        System.out.println("Gestor..................: " + gestor.getNomeCompleto());
        System.out.println("Planos Criados..........: " + gestor.getPlanosCriados().size());
        gestor.getPlanosCriados().forEach(planoCriado ->
                System.out.println("Código do Plano.........: " + planoCriado.getCdPlanodeDesenvolvimento() + " - " +
                        "Ativo: " + planoCriado.getAtivo()));
        gestor.getPlanosCriados().forEach(planoCriado ->
                planoCriado.getTasks().forEach(task1 ->
                        System.out.println("Task do Plano...........: " + task1.getNome())));
        System.out.println("Associado...............: " + associado.getNomeCompleto());
        System.out.println("Plano com Associado.....: " + associado.getPlanodeDesenvolvimento().getCdPlanodeDesenvolvimento());
        associado.getPlanodeDesenvolvimento().getTasks().forEach(task1 ->
                System.out.println("Task com Associado......: " + task1.getNome()));

        System.out.println("-------------------------------");
    }

    private static void criarPlanoDesenv() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Qual o seu número de matricula: ");
            Gestor gestor = new Gestor();
            gestor.setNrCadastro(1);
            gestor.setNomeCompleto("Bruno");
            scan.nextLine();
            System.out.print("Qual o número da matricula do Associado: ");
            Associado associado = new Associado();
            associado.setNrCadastro(2);
            associado.setNomeCompleto("João");
            scan.nextLine();


            scan.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scan.close();

    }

    private static void dashboardRH(Scanner scan) {
        menuRH();
        Integer opcao = null;
        System.out.print("Qual ação será realizada: ");
        opcao = scan.nextInt();
        scan.nextLine();
        switch (opcao) {
            case 1 -> consultaPlanosParaAprovacao();
        }
    }

    private static void consultaPlanosParaAprovacao() {
        System.out.println("-------------------------------");
        Gestor gestor = new Gestor();
        gestor.setNomeCompleto("Bruno");

        Task task = new Task();
        task.setNome("Java");
        task.setStatus(Status.CRIADA);

        Task task2 = new Task();
        task2.setNome("Oracle");
        task2.setStatus(Status.CRIADA);

        List<Task> arrayTask = new ArrayList<>();
        arrayTask.add(task);
        arrayTask.add(task2);

        PlanodeDesenvolvimento planodeDesenvolvimento = new PlanodeDesenvolvimento();
        planodeDesenvolvimento.setAtivo(true);
        planodeDesenvolvimento.setCdPlanodeDesenvolvimento(123);
        planodeDesenvolvimento.setTasks(arrayTask);

        List<PlanodeDesenvolvimento> arrayPlanosCriados = new ArrayList<>();
        arrayPlanosCriados.add(planodeDesenvolvimento);
        gestor.setPlanosCriados(arrayPlanosCriados);

        RH rh = new RH();
        rh.setPlanosParaAprovacao(arrayPlanosCriados);

        rh.getPlanosParaAprovacao().forEach(plano ->
                System.out.println("ID Plano: " + plano.getCdPlanodeDesenvolvimento() + " - " +
                        "Quantidade de task: " + plano.getTasks().size() + " - " +
                        "Aprovado: " + plano.getAtivo())
        );

        System.out.println("-------------------------------");
    }

    private static void dashboardGestor(Scanner scan) {
        menuGestor();
        Integer opcao = null;
        System.out.print("Qual ação será realizada: ");
        opcao = scan.nextInt();
        scan.nextLine();
        switch (opcao) {
            case 1 -> criarPlanoDesenv();
            case 2 -> consultaPlanosGestor();
        }
    }

}
