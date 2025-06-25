package pckg;

public class Main {

    public static void main(String[] args) {
        int quantidadeGrilos = 2 + (int)(Math.random() * 9);

        Grilo[] grilos = new Grilo[quantidadeGrilos];

        System.out.println("Iniciando corrida com " + quantidadeGrilos + " grilos!\n");

        
        for (int i = 0; i < grilos.length; i++) {
            grilos[i] = new Grilo(i + 1);
            grilos[i].start();
        }

        
        for (Grilo grilo : grilos) {
            try {
                grilo.join();
            } catch (InterruptedException e) {
                System.out.println("Erro");
            }
        }

        //FINAL!
        System.out.println("\nResultados:");
        for (Grilo grilo : grilos) {
            System.out.printf("Grilo %d deu %d pulos\n", grilo.getNameGrilo(), grilo.getPulos());
        }
        
        System.out.println("\nOrdem de chegada:");
        int ordem = 1;
        for (int id : Grilo.getOrdemDeChegada()) {
            System.out.printf("%dº lugar: Grilo %d\n", ordem++, id);
        }
    }
}
