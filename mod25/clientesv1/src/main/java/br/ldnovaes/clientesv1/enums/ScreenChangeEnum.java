package br.ldnovaes.clientesv1.enums;

import java.util.Map;

/**
 * @author ldnovaes
 */

public enum ScreenChangeEnum {
    MAIN("Tela Inicial"),
    DETAIL("Tela de Editar"),
    CADASTRO("Tela de Cadastrar");

    private String acao;

    ScreenChangeEnum(String screen) {
        this.acao = screen;
    }

    public String getAcao() {
        return this.acao;
    }
}
