import java.util.Random;

public class App {

    // flags de controle. se o terrorista plantou a bomba na rodada, true
    private static boolean bombaPlantada;
    // se bomba plantada, e bombaDesarmada tb for true, vitoria do policial. se false, vitoria do terrorista
    private static boolean bombaDesarmada;

    public static void main(String[] args) throws Exception {
        // criando os personagens
        Policial policial = new Policial("Cazé", 10, 3, 2); // começa com pistola (2)
        Terrorista terrorista = new Terrorista("Brino", 10, 3, 3); // começa com fuzil (3)

        Random gerador = new Random();

        System.out.println("=== INÍCIO DO JOGO ===");

        // loop do jogo
        while (true) {

            // reset das flags no inicio de cada rodada. iniciam em "false"
            bombaPlantada = false;
            bombaDesarmada = false;

            // sorteia quem começa a rodada. (0 = policial, 1 = terrorista)
            int primeiro = gerador.nextInt(2);

            if (primeiro == 0) {
                rodadaPolicial(policial, terrorista, gerador);
                // se o ataque zerou energia do terrorista, termina imediatamente
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

            if (bombaPlantada) {
                if (bombaDesarmada) {
                    System.out.println("A bomba foi plantada e desarmada nesta rodada. Vitória do Policia!");
                    break;
                } else {
                    System.out.println("A bomba foi plantada e NÃO foi desarmada nessa rodada. Vitória do Terrorista!");
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

    // Ações do policial (seleciona aleatoriamente -gerador- e executa)
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
                // desarmar a bomba: marca true para desarme da bomba nesta rodada
                p.desarmarBomba();
                bombaDesarmada = true;
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
                // plantar a bomba: a flag para bombaPlantada é true nessa rodada
                t.plantarBomba();
                bombaPlantada = true;
                break;
        }
    }
}
