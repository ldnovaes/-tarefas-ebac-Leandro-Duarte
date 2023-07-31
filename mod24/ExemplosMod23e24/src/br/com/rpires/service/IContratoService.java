package br.com.rpires.service;

/**
 * @author rodrigo.pires
 */
public interface IContratoService {
    String salvar();

    String buscar(String nome);

    boolean excluir(String nome);

    String atualizar(Integer nome);
    //TODO
    //Fazer métodos de buscar, excluir e atualizar
}
