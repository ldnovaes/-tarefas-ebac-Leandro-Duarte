package br.com.ldnovaes.controller;

import br.com.ldnovaes.view.Menu;
import br.com.ldnovaes.view.MenuPrincipal;
import br.com.ldnovaes.view.MenuVenda;

import java.util.Scanner;

/**
 * @author ldnovaes
 */

public class ControllerMenuVenda implements ControllerMenu {
    private Scanner scanner;
    private Menu menuVenda;
    private String opcao;

    public ControllerMenuVenda(Scanner scanner, MenuVenda menuVenda) {
        this.scanner = scanner;
        this.menuVenda = menuVenda;
    }
    @Override
    public String escolheOpcao() {
        return this.inputDado();
    }

    @Override
    public String inputDado() {
        this.menuVenda.exibeMenu();
        this.opcao = this.scanner.nextLine();
        return this.opcao;
    }
}
