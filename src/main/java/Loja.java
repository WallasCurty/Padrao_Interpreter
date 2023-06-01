public class Loja {
    public static String formula = "precoCusto + 2 + precoCompra";

    public static double calcularPrecoProduto(double precoCusto, double precoCompra) {
        String expressao;
        expressao = formula.replace("precoCusto", Double.toString(precoCusto));
        expressao = expressao.replace("precoCompra", Double.toString(precoCompra));
        InterpretadorPreco interpretador = new InterpretadorPrecoProduto(expressao);
        return interpretador.interpretar();
    }
}
