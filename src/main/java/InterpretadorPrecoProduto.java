import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InterpretadorPrecoProduto implements InterpretadorPreco{
    private InterpretadorPreco interpretadorInicial;

    public InterpretadorPrecoProduto(String contexto) {

        Stack<InterpretadorPreco> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.matches("\\d+(\\.\\d*)?")) {
                pilhaInterpretadores.push(new Preco(Double.parseDouble(elemento)));
            } else if (elemento.equals("+")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Produto inválido");
                Preco elementoEsquerda = (Preco) pilhaInterpretadores.pop();
                Preco elementoDireita = new Preco(Double.parseDouble(iterator.next()));
                Reajuste interpretador = new Reajuste(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Preco(interpretador.interpretar()));
            } else if (elemento.equals("-")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Produto inválido");
                Preco elementoEsquerda = (Preco) pilhaInterpretadores.pop();
                Preco elementoDireita = new Preco(Double.parseDouble(iterator.next()));
                Desconto interpretador = new Desconto(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Preco(interpretador.interpretar()));
            } else {
                throw new IllegalArgumentException("Produto com elemento inválido");
            }
        }
        interpretadorInicial = pilhaInterpretadores.pop();
    }

    public double interpretar() {
        return interpretadorInicial.interpretar();
    }

}
