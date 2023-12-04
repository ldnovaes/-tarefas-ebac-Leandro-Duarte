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
     * Tome cuidado com a posição dos números passados em parâmetro. O @param a é referente ao primeiro número de uma subtração, enquanto que o @param b é o segundo
     * @param a primeiro parâmetro
     * @param b segundo parâmetro
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
     * Tome cuidado com a posição dos números passados em parâmetro. O @param a é referente ao dividendo, enquanto que o @param b é o divisor
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
