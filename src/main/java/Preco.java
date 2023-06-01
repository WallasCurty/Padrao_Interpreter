public class Preco implements InterpretadorPreco {
    private double preco;

    public Preco(double preco) {
        this.preco = preco;
    }

    public double interpretar() {
        return preco;
    }

    public double getPreco() {
        return this.preco;
    }
}
