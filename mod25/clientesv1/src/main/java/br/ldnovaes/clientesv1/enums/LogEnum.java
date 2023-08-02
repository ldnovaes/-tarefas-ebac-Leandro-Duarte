package br.ldnovaes.clientesv1.enums;

/**
 * @author ldnovaes
 */

public enum LogEnum {
    VOLTAR("[LOG] - DETAILCONTROLLER - CLICADO EM VOLTAR"),
    MAIN("[LOG] - MAINCONTROLLER - CLICADO EM NOVO CADASTRO"),
    CADASTRO("[LOG] - CADADRO REALIZADO"),
    BUSCAR("[LOG] - REALIZADO BUSCA NO SISTEMA");

    private String log;
    LogEnum(String log) {
        this.log = log;
    }

    public String getLog() {
        return this.log;
    }
}
