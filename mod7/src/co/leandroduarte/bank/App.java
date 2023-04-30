package co.leandroduarte.bank;

import java.util.Scanner;

/**
 * classe do app
 * created 22/03/2023
 * project projeto-curso-tiago
 * @author vostoc
 */

public class App {

    public static void main(String[] args) {

        // cria instancia do banco
        Bank santander = new Bank("001");

        // cria uma conta dentro do banco a
        Account leandro = santander.generateAccount("Leandro");
        Account dapheny = santander.generateAccount("Dapheny");
        dapheny.deposit(50);
        leandro.deposit(150);

        System.out.println(santander);


    }

}

