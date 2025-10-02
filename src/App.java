import java.util.Random;

public class App {

    public static void main(String[] args) throws Exception {
        // criando os personagens
        Policial policial = new Policial("Cazé", 10, 3, 2); // começa com pistola (2)
        Terrorista terrorista = new Terrorista("Brino", 10, 3, 3); // começa com fuzil (3)

        Random gerador = new Random();

        System.out.println("=== INÍCIO DO JOGO ===");

        // loop do jogo
        while (true) {
            // sorteia quem começa a rodada. (0 = policial, 1 = terrorista)
            int primeiro = gerador.nextInt(2);

            if (primeiro == 0) {
                rodadaPolicial(policial, terrorista, gerador);
                if (terrorista.getEnergia() == 0) {
                    System.out.println("O policial " + policial.getNome() + " venceu!");
                    break;
                }

                rodadaTerrorista(terrorista, policial, gerador);
                if (policial.getEnergia() == 0) {
                    System.out.println("O terrorista " + terrorista.getNome() + " venceu!");
                    break;
                }
            } else {
                rodadaTerrorista(terrorista, policial, gerador);
                if (policial.getEnergia() == 0) {
                    System.out.println("O terrorista " + terrorista.getNome() + " venceu!");
                    break;
                }

                rodadaPolicial(policial, terrorista, gerador);
                if (terrorista.getEnergia() == 0) {
                    System.out.println("O policial " + policial.getNome() + " venceu!");
                    break;
                }
            }

            // mostrar as energias no fim da rodada
            System.out.println("Energias: " + policial.getNome() + " = " + policial.getEnergia()
                    + " | " + terrorista.getNome() + " = " + terrorista.getEnergia());
            System.out.println("-----------------------------");

            Thread.sleep(2000); // pausa para leitura
        }

        System.out.println("=== FIM ===");
    }

    // Ações do policial
    private static void rodadaPolicial(Policial p, Terrorista t, Random gerador) {
        // 0 = atacar, 1 = lançar granada, 2 = passar a vez, 3 = desarmar a bomba
        int acao = gerador.nextInt(4);

        switch (acao) {
            case 0:
                t.setEnergia(p.atacar(t.getEnergia()));
                break;
            case 1:
                p.lancarGranada(); // granada não altera energia
                break;
            case 2:
                t.setEnergia(p.passarVez(t.getEnergia()));
                break;
            case 3:
                p.desarmarBomba(); // sem efeito de energia
                break;
        }
    }

    // Ações do terrorista
    private static void rodadaTerrorista(Terrorista t, Policial p, Random gerador) {
        // 0 = atacar, 1 = lançar granada, 2 = passar a vez, 3 = plantar bomba
        int acao = gerador.nextInt(4);

        switch (acao) {
            case 0:
                p.setEnergia(t.atacar(p.getEnergia()));
                break;
            case 1:
                t.lancarGranada(); // sem efeito
                break;
            case 2:
                p.setEnergia(t.passarVez(p.getEnergia()));
                break;
            case 3:
                t.plantarBomba(); // sem efeito
                break;
        }
    }
}
