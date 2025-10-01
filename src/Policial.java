
public class Policial {

    // variaveis de instância
    private String nome;
    private int energia;
    private int quantidadeGranadas;
    private String armamento;

// contrutor criando o obj policial e ele receberá os valores iniciais
    public Policial(String nome, int energia, int quantidadeGranadas, String armamento) {
        this.nome = nome; // o operador THIS permite diferenciar a variável de instancia (definida la em cima) da var. de parâmetro, chamada de var. local.    
        this.energia = energia;
        this.quantidadeGranadas = quantidadeGranadas;
        this.armamento = armamento;
    }

    public void desarmarBomba() { //método: descreve o comportamento dos objetos implementado na classe
        System.out.println(nome + " está desarmando a bomba");

    }

    public void lancarGranada() {
        if (quantidadeGranadas > 0) {
            quantidadeGranadas--;
            System.out.println(nome + " lançou uma granada!!");
        } else {
            System.out.println(nome + " tentou lançar uma granada mas não está sem!!!");
        }
    }

    public void atacar() {
        System.out.println(nome + " atacou com " + armamento);

    }

    public void passarVez() {
        System.out.println(nome + " passou a vez");
    }
// GETTERS (leitura dos atributos privados) usados por outras classes se necessário

    public int getEnergia() {
        return energia;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeGranadas() {
        return quantidadeGranadas;
    }

    public String getArmamento() {
        return armamento;
    }

//SETTERS (permitem alterar atributos de forma controlada)
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setQuantidadeGranadas(int quantidadeGranadas) {
        this.quantidadeGranadas = quantidadeGranadas;
    }

}
