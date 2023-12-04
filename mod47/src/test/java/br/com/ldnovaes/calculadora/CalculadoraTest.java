package br.com.ldnovaes.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ldnovaes
 */
public class CalculadoraTest {
    
    @Test
    public void testAdicionarHappyPath() {
        Calculadora calculadora = new Calculadora();
        
        int resultado = calculadora.adicionar(10, 10);
        
        Assertions.assertEquals(20, resultado);
        
    }
    
    @Test
    public void testSubtrairHappyPath() {
        Calculadora calculadora = new Calculadora();
        
        int resultado = calculadora.subtrair(15, 10);
        
        Assertions.assertEquals(5, resultado);
        
    }
    
    @Test
    public void testMultiplicarHappyPath() {
        Calculadora calculadora = new Calculadora();
        
        int resultado = calculadora.multiplicar(10, 10);
        
        Assertions.assertEquals(100, resultado);
        
    }
    
    @Test
    public void testDividirHappyPath() {
        Calculadora calculadora = new Calculadora();
        
        int resultado = calculadora.dividir(100, 10);
        
        Assertions.assertEquals(10, resultado);
        
    }
    
    @Test
    public void testDividirDivisaoPorZero() {
        Calculadora calculadora = new Calculadora();

        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(10, 0);
        });
        
    }
}
