
public class App {

    public static void main(String[] args) throws Exception {
        //criando os personagens
        Terrorista terrorista = new Terrorista("Francisco", 10, 3, "Fuzil");
        Policial policial = new Policial("Cazé", 10, 2, "Pistola");
        //loop do jogo
        while (true) {
            int acaoT = (int) (Math.random() * 4);
            if (acaoT == 0) {
                terrorista.plantarBomba();
            } else if (acaoT == 1) {
                terrorista.lancarGranada();
            } else if (acaoT == 2) {
                terrorista.atacar();
            } else {
                terrorista.passarVez();
            }

            int acaoP = (int) (Math.random() * 4);
            if (acaoP == 0) {
                policial.desarmarBomba();
            } else if (acaoP == 1) {
                policial.lancarGranada();
            } else if (acaoP == 2) {
                policial.atacar();
            } else {
                policial.passarVez();
            }

            System.out.println("+++++++++++++++++++++++++++++++++++++++");

            Thread.sleep(2000);

        }
    }
}
