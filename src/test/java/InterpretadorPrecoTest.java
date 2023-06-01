import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InterpretadorPrecoTest {
    @Test
    void deveCalcularReajuste() {
        InterpretadorPreco interpretador = new InterpretadorPrecoProduto("6 + 2");
        assertEquals(8.0, interpretador.interpretar());
    }

    @Test
    void deveCalcularDesconto() {
        InterpretadorPreco interpretador = new InterpretadorPrecoProduto("6 - 2");
        assertEquals(4.0, interpretador.interpretar());
    }

    @Test
    void deveRetonarExcecaoElementoInvalido() {
        try {
            InterpretadorPreco interpretador = new InterpretadorPrecoProduto("2 ^ 2");
            assertEquals(4.0, interpretador.interpretar());
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Produto com elemento inválido", e.getMessage());
        }
    }

    @Test
    void deveRetonarExcecaoInvalida() {
        try {
            InterpretadorPreco interpretador = new InterpretadorPrecoProduto("2 - ");
            assertEquals(4.0, interpretador.interpretar());
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Produto inválido", e.getMessage());
        }
    }

}
