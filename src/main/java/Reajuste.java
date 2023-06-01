public class Reajuste implements InterpretadorPreco{
    private double valor1;
    private double valor2;

    public Reajuste (Preco elementoEsquerda, Preco elementoDireita) {
        valor1 = elementoEsquerda.getPreco();
        valor2 = elementoDireita.getPreco();
    }

    public double interpretar() {
        return valor1 + valor2;
    }
}
