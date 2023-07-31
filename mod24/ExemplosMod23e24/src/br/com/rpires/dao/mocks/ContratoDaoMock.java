package br.com.rpires.dao.mocks;

import br.com.rpires.dao.IContratoDao;

/**
 * @author rodrigo.pires
 */
public class ContratoDaoMock implements IContratoDao {

    @Override
    public void salvar() {

    }

    @Override
    public String buscar(String nome) {
        return "Sucesso";
    }

    @Override
    public String excluir(String nome) {
        return "Sucesso";
    }

    @Override
    public String atualizar(String nome) {
        return "Sucesso";
    }
}
