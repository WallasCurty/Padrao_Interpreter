import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {
    @Test
    void deveCalcularPrecoProdutoComFormula() {
        Produto produto = new Produto();
        produto.setPrecoCusto(5.0);
        produto.setPrecoCompra(7.0);

        assertEquals(14.0, produto.calcularPrecoProduto());
    }
}
