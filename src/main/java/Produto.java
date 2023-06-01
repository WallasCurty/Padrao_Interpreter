public class Produto {
    private double precoCusto;
    private double precoCompra;

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double calcularPrecoProduto() {
        return Loja.calcularPrecoProduto(this.precoCusto, this.precoCompra);
    }
}
