package com.mycompany.escalonadorEmlote;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Escalonador {

    private List<Processo> processos;
    private Random random;

    public Escalonador() {
        this.processos = new ArrayList<>();
        this.random = new Random();
    }

    public void adicionarProcesso(Processo p) {
        processos.add(p);
    }

    public void gerarProcessosAleatorios(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            int tempoChegada = random.nextInt(100);
            int tempoExecucao = random.nextInt(100);
            Processo p = new Processo(i + 1, tempoChegada, tempoExecucao);
            adicionarProcesso(p);
        }
    }

    public void escalonar() {
        processos.sort(Comparator.comparingInt(p -> p.tempoExecucao));
        int tempoAtual = 0;
        
        for (Processo p : processos) {
        	int randomInterrupcao = random.nextInt(10);
        	 if (tempoAtual < p.tempoChegada) {
        		 if (tempoAtual == 0) {
        			 p.tempoEspera = tempoAtual + p.tempoChegada;
        		 }else {
        			 p.tempoEspera = p.tempoChegada - tempoAtual;
        		 }
                 tempoAtual = p.tempoChegada;
             }
        	 
        	 if(randomInterrupcao <8) {
        		 p.interrupcao = randomInterrupcao;
        		 p.tempoConclusao = p.interrupcao;
        	 }
            p.tempoInicio =  p.tempoChegada;
            p.tempoConclusao += p.tempoInicio + p.tempoExecucao;
            

            tempoAtual = p.tempoConclusao;

            p.tempoTurnAround = p.tempoEspera  + p.tempoExecucao;
        }
    }

    public void exibirResultados() {
        System.out.println("ID\tChegada\tExecução\tInício\tConclusão\tEspera\tTurnAround\tInterrupção");
        for (Processo p : processos) {
            System.out.println(p.id + "\t" + p.tempoChegada + "\t" + p.tempoExecucao + "\t" + p.tempoInicio + "\t" + p.tempoConclusao + "\t" + p.tempoEspera + "\t" + p.tempoTurnAround + "\t" + p.interrupcao);
        }
    }
}
