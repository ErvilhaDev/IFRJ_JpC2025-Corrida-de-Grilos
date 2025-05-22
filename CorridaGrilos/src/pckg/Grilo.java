package pckg;

public class Grilo extends Thread {
    private int nome;
    private int deslocamento = 0;
    private int pulos = 0;
    private int linhadechegada = 100;

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
                
                Thread.sleep(500);
            }
            
            System.out.printf("Grilo %d chegou à linha de chegada em %d pulos\n", nome, pulos);
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
}
