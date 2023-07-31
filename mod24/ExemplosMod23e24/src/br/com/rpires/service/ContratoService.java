package br.com.rpires.service;

import br.com.rpires.dao.IContratoDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rodrigo.pires
 */
public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;
    private List<String> clientesNomes = new ArrayList<>();


    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar(String nome) {

        if (this.clientesNomes.contains(nome)) {
            contratoDao.buscar(nome);
            return "Sucesso";
        }
        return "Cliente não encontrado. É necessário voltar e realizar o cadastro";
    }

    @Override
    public boolean excluir(String nome) {
        this.clientesNomes.add("Leandro"); // adição para fins de teste, para não tornar os testes todos repetitivos

        if (this.clientesNomes.contains(nome)) {
            this.clientesNomes.remove(nome);
        }
        // vou retornar um booleano e verificar se a exclusão foi feita atraves de um boolean apenas para fins didáticos
        // isso obivamente retornará false, mas é justamente para aproveitar esse modelo no teste
        return this.clientesNomes.contains(nome);
    }

    @Override
    public String atualizar(Integer nome) {

        contratoDao.atualizar(String.valueOf(nome));
        throw new NumberFormatException("Não pode ser inserido número! Chame um administrador do sistema para realizar a manutenção na atualização de contrato");

    }
}
