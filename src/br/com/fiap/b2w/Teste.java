package br.com.fiap.b2w;

import br.com.fiap.b2w.models.*;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        //criando o funcionario, gestor e liderados do gestor
        Associado func = new Associado(123, "naotemainda", "abc@123.com", "1234", "dev", 123456789);
        List<Associado> arrayLiderados = new ArrayList<>();
        arrayLiderados.add(func);

        Gestor gestor = new Gestor(321, "tbmntem", "cba@321.com", "4321", "gestor", 987654321,
                "devs", arrayLiderados);

        //criando as tasks
        Task task1 = new Task(gestor, func, "Terminar o teste");
        Task task2 = new Task(gestor, func, "Subir o projeto");
        List<Task> arrayTasks = new ArrayList<>();
        arrayTasks.add(task1);
        arrayTasks.add(task2);

        //criando recomendacoes
        Recomendacoes recom1 = new Recomendacoes("leitura", 15);
        Recomendacoes recom2 = new Recomendacoes("video", 30);
        Recomendacoes[] arrayRecomendacoes = {recom1, recom2};

        //criando plano de estudo
        PlanodeEstudo pe = new PlanodeEstudo(func, gestor, "Desenvolvimento", arrayRecomendacoes);
        func.setPlanodeEstudo(pe);

        //criando plano de ação
        PlanodeDesenvolvimento pa = new PlanodeDesenvolvimento(func, gestor);
        pa.setTasks(arrayTasks);
        func.setPlanodeDesenvolvimento(pa);

        //testes das funções plano de ação
        System.out.println("Status task1: " + func.getPlanodeDesenvolvimento().consultaTaskPorPosicao(0).getStatus());
        System.out.println("Status task2: " + func.getPlanodeDesenvolvimento().consultaTaskPorPosicao(1).getStatus());

        //teste das funções das tasks
        System.out.println("Iniciando Task1...");
        task1.iniciar();
        System.out.println("Data de criação: " + task1.getDtCriacao());
        System.out.println("Data de início: " + task1.getDtInicio());
        System.out.println("Status task1: " + func.getPlanodeDesenvolvimento().consultaTaskPorPosicao(0).getStatus());
        task1.terminar();
        System.out.println("Terminando Task1...");
        System.out.println("Status task1: " + func.getPlanodeDesenvolvimento().consultaTaskPorPosicao(0).getStatus());
        System.out.println(task1.getDtTermino());
        System.out.println("Foi concluída em "+task1.calculaTempoTermino()+" dias.");


    }

}
