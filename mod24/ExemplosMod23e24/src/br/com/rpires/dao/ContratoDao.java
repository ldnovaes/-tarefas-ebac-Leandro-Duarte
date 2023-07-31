package br.com.rpires.dao;

/**
 * @author rodrigo.pires
 */
public class ContratoDao implements IContratoDao {


    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }

    @Override
    public String buscar(String nome) {
        return null;
    }

    @Override
    public String excluir(String nome) {
        return null;
    }

    @Override
    public String atualizar(String nome) {
        return  null;
    }
}
