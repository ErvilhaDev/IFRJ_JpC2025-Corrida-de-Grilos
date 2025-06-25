package pckg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Grilo extends Thread {
    private int nome;
    private int deslocamento = 0;
    private int pulos = 0;
    private int linhadechegada = 100;
    
    private static Semaphore semaforo = new Semaphore(1);
    private static List<Integer> ordemDeChegada = new ArrayList<>();

    public Grilo(int nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (deslocamento < linhadechegada) {
                int pulo = 1 + (int)(Math.random() * 10);
                deslocamento += pulo;
                pulos++;
                System.out.printf("Grilo %d pulou %d centímetros (total: %d centímetros)\n", nome, pulo, deslocamento);
                
                Thread.sleep(300);
            }
            
            System.out.printf("Grilo %d chegou à linha de chegada em %d pulos\n", nome, pulos);
            
            semaforo.acquire();
            ordemDeChegada.add(nome);
            semaforo.release();
            
        } catch (InterruptedException e) {
            System.out.println("Erro");
        }
        
    }

	public int getNameGrilo() {
		return nome;
	}
	
	public int getPulos() {
		return pulos;
	}
	
	public static List<Integer> getOrdemDeChegada() {
        return ordemDeChegada;
    }
}
