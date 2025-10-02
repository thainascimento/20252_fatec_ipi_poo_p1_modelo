
public class Policial {

// variaveis de encapsuladas (priv)
    private String nome;
    private int energia;
    private int quantidadeGranadas;
    private int arma;

// construtor criando o obj policial e ele receberá os valores iniciais
    public Policial(String nome, int energia, int quantidadeGranadas, int arma) {
        this.nome = nome; // o operador THIS permite diferenciar a variável de instancia (definida la em cima) da var. de parâmetro, chamada de var. local.    
        this.energia = energia;
        this.quantidadeGranadas = quantidadeGranadas;
        this.arma = arma;
    }
//metodo-ação: atacar
    public int atacar(int energiaAdversario) { //método: descreve o comportamento dos objetos implementado na classe
        int dano = 0;
        if (arma == 1) dano = 1;
        else if (arma == 2) dano = 2;
        else if (arma == 3) dano = 3;

        energiaAdversario -= dano;
        energiaAdversario = Math.max(0, energiaAdversario); //aqui, ta limitando o minimo da energia a 0
        System.out.println(nome + " atacou. Energia do Adversario: " + energiaAdversario);
        return energiaAdversario;

    }
//metodo
    public int passarVez(int energiaAdversario) {
        int ganho = 1 + (int) (Math.random() * 2);
        energiaAdversario += ganho;
        energiaAdversario = Math.min(10, energiaAdversario); //aqui, limita o maximo de energia a 10
        System.out.println(nome + " passou a vez. Adversario ganhou " + ganho + " de energia");
        return energiaAdversario; 
        } 
//metodo
    public void lancarGranada() {
        if (quantidadeGranadas > 0) {
            quantidadeGranadas--;
            System.out.println(nome + " lançou uma granada!");
        } else {
            System.out.println(nome + " tentou lançar uma granada mas não há nenhuma disponivel");
        }
    }
//metodo
    public void desarmarBomba() {
        System.out.println(nome + " desarmou a bomba");
    }
// GETTERS (leitura dos atributos privados) usados por outras classes se necessário

    public int getEnergia() {
        return energia;
    }

    public String getNome() {
        return nome;
    }
//SETTERS (permitem alterar atributos de forma controlada)
    public void setEnergia(int energia) {
        this.energia = energia;
    }
}
