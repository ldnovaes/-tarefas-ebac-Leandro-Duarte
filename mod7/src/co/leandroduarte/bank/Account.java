package co.leandroduarte.bank;

/**
 * Classe da conta
 * <br>
 * Essa classe é responsável pela criação das contas. É usada pela classe Bank para criar contas sem números repetidos
 * @author vostoc
 */

public class Account {

    // define uma propriedade compartilhada (no caso é uma constante pelo "final")onde definiremos o maximo de caracteres de nomes
    private static final int MAX_LENGTH = 12;

    // propriedades privadas da classe (não é possível acessar as propriedades através de outra classe uma vez que estas estão privadas)
    private String ag;
    private String cc;
    private String name;

    private double balance;

    private Log logger;

    /**
     * Construtor da Classe
     * @param ag
     * @param cc
     * @param name
     */
    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    /**
     * Método que seta o nome
     * @param name
     */
    public void setName(String name) {

        if (name.length() > MAX_LENGTH) {
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }

    }

    /**
     * Retorna o nome da conta
     * @return noame
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna o total da conta
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Função utilizada para depositar dinheiro na conta
     * @param value
     */
    public void deposit(double value) {
        balance += value;
        logger.out("DEPOSITO - R$ " + value + " Sua conta agora é de R$ " + balance);
    }

    /**
     * Retorna um boleando. Só há saque quando o valor é do saque é menor que o que há na conta
     * @param value
     * @return boolean
     */
    public boolean withDraw(double value) {

        // se o valor para sacar for menor que o valor da conta ele retorna false
        if (balance < value) {
            System.out.println("SAQUE - R$ " + value + " Saque não disponível! O valor para saque ultrapassa o valor em sua conta!");
            return false;

        }

        // se nao der false, ele executa esse código que quer dizer que o saque foi liberado
        balance -= value;
        logger.out("SAQUE - R$ " + value + " Sua conta agora é de R$ " + balance);
        return true;

    }

    /**
     * quando der um sout na classe é modificado não para ver o hash e sim uma impressão personalizada
     * @return result
     */
    @Override
    public String toString() {
        String result = "A conta " + this.name + " Agencia " + this.ag + "/" + this.cc + " possui: R$ " + balance;
        return result;
    }
}
