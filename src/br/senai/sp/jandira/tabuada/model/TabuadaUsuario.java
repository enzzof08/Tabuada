package br.senai.sp.jandira.tabuada.model;

import java.util.Scanner;

public class TabuadaUsuario {
    public int multiplicando;
    public int multiplicadorInicial;
    public int multiplicadorFinal;
    public String[] tabuada;





    public void ColetarDados() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Qual o multiplicando ?");
        multiplicando = leitor.nextInt();

        System.out.println("Qual o multiplicador inicial ?");
        multiplicadorInicial = leitor.nextInt();

        System.out.println("Qual o multiplicador final ?");
        multiplicadorFinal = leitor.nextInt();

        CalcularTabuada();


    }

    public void CalcularTabuada() {
        int apoio = 0;

        if (multiplicadorFinal < multiplicadorInicial){
            apoio = multiplicadorFinal;
            multiplicadorFinal = multiplicadorInicial;
            multiplicadorInicial = apoio;
        }

        int tamanho = multiplicadorFinal - multiplicadorInicial + 1;
        tabuada = new String[tamanho];

        int i = 0;
        while (i < tamanho) {
            int produto = multiplicando * multiplicadorInicial;
            tabuada[i] = multiplicando + " X " + multiplicadorInicial + " = " + produto;
            multiplicadorInicial = multiplicadorInicial + 1;
            i = i + 1;

        }

        ExibirTabuada();

    }

    public void ExibirTabuada() {
        System.out.println("Resultado da sua tabuada:");
        int i = 0;
        while (i < tabuada.length) {
            System.out.println(tabuada[i]);
            i ++;             //i = i + 1

        }
    }




}


