package br.com.ldnovaes.calculadora;

/**
 *
 * @author ldnovaes
 */
public class Calculadora {
    
    /**
     *
     * Método que realiza a adição de dois números inteiros
     * @param a
     * @param b
     * @return
     */
    public int adicionar(int a, int b) {
        return a + b;
    }
    
    /**
     *
     * Método que realiza a subtração de dois inteiros
     * @param a
     * @param b
     * @return
     */
    public int subtrair(int a, int b) {
        return a - b;
    }
    
    /**
     * 
     * Método que realiza a multiplicação de dois inteiros
     * @param a
     * @param b
     * @return
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }
    
    /**
     * 
     * Método que realiza a divisão de dois números inteiros
     * @param a
     * @param b
     * @throws ArithmeticException se o divisor for zero
     * @return
     */
    public int dividir(int a, int b) {
        
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é possível");
        }
        
        return a / b;
    }
    
    
}
