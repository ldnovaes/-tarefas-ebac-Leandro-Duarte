package co.leandroduarte.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe do banco
 * @author vostoc
 */

public class Bank {

    private String ag;
    private List<Account> accounts;

    private int lastAccount = 1;
    private double balance;


    /**
     * Construtor da classe. Gera uma agencia
     * @param ag
     */
    public Bank(String ag) {
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }

    /**
     * Insere a conta dentro do ArrayList
     * @param account
     */
    public void inserAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Função que cria contas dentro do banco e adiciona a conta criada dentro do ArrayList
     * @param name
     * @return account
     */
    public Account generateAccount(String name) {
        Account account = new Account(ag, "000" + lastAccount, name);
        lastAccount++;
        accounts.add(account);
        return account;
    }

    /**
     * Obtém o total do banco. De acordo com saques/depósitos na classe Account
     * @return
     */
    public double getBalance() {

        for (Account account:accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    /**
     * Personaliza a impressão quando o sout for direto no objeto instanciado
     * @return String
     */
    @Override
    public String toString() {
        return "Esse banco tem um total de R$ " + getBalance() + "reais.";
    }
}
