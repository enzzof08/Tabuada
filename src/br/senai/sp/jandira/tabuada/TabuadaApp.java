package br.senai.sp.jandira.tabuada;

import br.senai.sp.jandira.tabuada.model.TabuadaUsuario;

public class TabuadaApp {
    public static void main(String[] args) {
        System.out.println("Iniciando Tabuada...");
        TabuadaUsuario tabuada = new TabuadaUsuario();
        tabuada.ColetarDados();

    }
}
