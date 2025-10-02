
public class Terrorista {
// definindo os campos privados (encapsulamento)

    private String nome;
    private int energia;
    private int quantidadeGranadas;
    private int arma;

//contrutor - definindo os valores iniciais ao objeto criado. no caso, o terrorista.
    public Terrorista(String nome, int energia, int quantidadeGranadas, int armamento) {
        this.nome = nome;
        this.energia = energia;
        this.quantidadeGranadas = quantidadeGranadas;
        this.arma = armamento;
    }
//métodos - ações
    public int atacar(int energiaAdversario) {
        int dano = 0;
        if (arma == 1) dano = 1;
        else if (arma == 2) dano = 2;
        else if (arma == 3) dano = 3;
        
        energiaAdversario -= dano;
        energiaAdversario = Math.max(0, energiaAdversario); //limitando o minimo a 0
        System.out.println(nome + " atacou! Energia do adversário agora: " + energiaAdversario);
        return energiaAdversario;      
    }

    public int passarVez(int energiaAdversario) {
        int ganho = 1 + (int) (Math.random() * 2);
        energiaAdversario += ganho;
        energiaAdversario = Math.min(10, energiaAdversario); //limitando o max de energia a 10
        System.out.println(nome + " passou a vez. Adversario ganhou " + ganho + " de energia." );
        return energiaAdversario;
    }    

    public void plantarBomba() {
        System.out.println(nome + " plantou uma bomba");
    }

    public void lancarGranada() {
    if (quantidadeGranadas > 0) {
    quantidadeGranadas--;
    System.out.println(nome + " lançou uma granada");
    } else {
        System.out.println(nome + " tentou lançar uma graada mas não há nenhuma disponivel");
        }
    }    

        

//GETTERS
    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

//SETTERS
    public void setEnergia(int energia) {
        this.energia = energia;
    }
}
