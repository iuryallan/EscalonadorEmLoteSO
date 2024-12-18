package com.mycompany.escalonadorEmlote;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Main {
	
    public static void main(String[] args) {
        int quantidade = 100000;

        Escalonador escalonador = new Escalonador();

        
      // Medição do tempo de CPU
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long cpuTimeAntes = threadMXBean.getCurrentThreadCpuTime(); 
        
        
      // Medição do uso de memória
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Solicita Garbage Collection para medir memória de forma mais precisa
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        
     // Medição do tempo total de execução
        long inicioTempo = System.currentTimeMillis();
        
     // Geração e execução do escalonamento
        escalonador.gerarProcessosAleatorios(quantidade);
        escalonador.escalonar();
        
        long fimTempo = System.currentTimeMillis();
        long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
        long cpuTimeDepois = threadMXBean.getCurrentThreadCpuTime(); 

        escalonador.exibirResultados();
        System.out.println("Tempo de execução: " + (fimTempo - inicioTempo) + " ms");
        System.out.println("Uso de memória: " + (memoriaDepois - memoriaAntes) / 1024 + " KB");
        System.out.println("Tempo de CPU: " + (cpuTimeDepois - cpuTimeAntes) / 1_000_000 + " ms");
        
    }
}
