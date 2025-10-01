
public class Terrorista {
    // definindo os campos privados (encapsulamento)

    private String nome;
    private int energia;
    private int quantidadeGranadas;
    private String armamento;
//contrutor - definindo os valores iniciais ao objeto criado

    public Terrorista(String nome, int energia, int quantidadeGranadas, String armamento) {
        this.nome = nome;
        this.energia = energia;
        this.quantidadeGranadas = quantidadeGranadas;
        this.armamento = armamento;
    }
//método: 

    public void plantarBomba() {
        System.out.println(nome  +  " plantou a bomba...");
    }

    public void lancarGranada() {
        if (quantidadeGranadas > 0) {
            quantidadeGranadas--;
            System.out.println(nome + " lançou uma Granada!!");
        } else {
            System.out.println(nome + " tentou lançar uma granada mas está sem");
        }
    }

    public void atacar() {
        System.out.println(nome + " atacou com " + armamento);
    }

    public void passarVez() {
        System.out.println(nome + " passou a vez");
    }

//GETTERS
    public String getnome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public int getQuantidadeGranadas() {
        return quantidadeGranadas;
    }

    public String getArmamento() {
        return armamento;
    }

//SETTERS
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setQuantidadeGranadas(int quantidadeGranadas) {
        this.quantidadeGranadas = quantidadeGranadas;
    }
}
