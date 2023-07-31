package br.com.rpires.service;

import br.com.rpires.dao.ClienteDao;
import br.com.rpires.dao.ClienteDaoMock;
import br.com.rpires.dao.IClienteDao;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author rodrigo.pires
 */
public class ClienteService {

    private IClienteDao clienteDao;
    private List<Integer> codigosClientes = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16));

    public ClienteService(IClienteDao clienteDao) {
        //clienteDao = new ClienteDao();
        //clienteDao = new ClienteDaoMock();
        this.clienteDao = clienteDao;
    }

    public String salvar() {
        clienteDao.salvar();
        return "Sucesso";
    }

    public String buscar(Integer codigo) {

        if (this.codigosClientes.contains(codigo)) {
            return "Sucesso";
        }

        throw new FindException("Codigo do cliente não encontrado");

    }

    public String excluir(Integer codigo) {
        if (this.codigosClientes.contains(codigo)) {
            this.codigosClientes.remove(codigo);
            return "Sucesso";
        }
        throw new FindException("Cliente já cadastrado!");
    }


    public String atualizar(Integer codigo) {

        if (!this.codigosClientes.contains(codigo)) {
            this.codigosClientes.add(codigo);
            return "Sucesso";
        }
        throw new UnsupportedOperationException("Você excedeu a quantidade de clientes possíveis para cadastrar! Faça um upgrade no seu plano!");
    }
}
