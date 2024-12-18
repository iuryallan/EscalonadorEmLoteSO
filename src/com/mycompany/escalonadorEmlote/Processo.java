package com.mycompany.escalonadorEmlote;

public class Processo {
    int id;
    int tempoChegada;
    int tempoExecucao;
    int tempoInicio;
    int tempoConclusao;
    int tempoEspera;
    int tempoTurnAround;
    int interrupcao;
    
    public Processo(int id, int tempoChegada, int tempoExecucao) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExecucao = tempoExecucao;
    }
}