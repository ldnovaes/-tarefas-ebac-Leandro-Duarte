package br.com.ldnovaes.controller;

import br.com.ldnovaes.view.Menu;
import br.com.ldnovaes.view.MenuPrincipal;

import java.util.Scanner;

/**
 * @author ldnovaes
 */

public class ControllerMenuPrincipal implements ControllerMenu<String, String>{

    private Scanner scanner;
    private Menu menuPrincipal;
    private String opcao;

    public ControllerMenuPrincipal(Scanner scanner, MenuPrincipal menuPrincipal) {
        this.scanner = scanner;
        this.menuPrincipal = menuPrincipal;
    }
    @Override
    public String escolheOpcao() {
        return this.inputDado();
    }

    @Override
    public String inputDado() {
        this.menuPrincipal.exibeMenu();
        this.opcao = this.scanner.nextLine();
        return this.opcao;
    }
}
