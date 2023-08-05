package br.ldnovaes.clientesv1.service;

import br.ldnovaes.clientesv1.dao.ClienteDAO;
import br.ldnovaes.clientesv1.model.Cliente;

import javax.swing.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ldnovaes
 */

public class ClienteService {

    ClienteDAO clienteDao = new ClienteDAO();

    public Cliente salvar(String nome, String cpf, String telefone, String email) {

        if (cpf != null && telefone != null && nome != null && email != null) {
            Cliente cliente = new Cliente().salvar(nome, cpf, telefone, email);
            return cliente;
        }
        return null;

    }

    public Stream<Cliente> pesquisarCliente(String dado) {
        ClienteDAO clienteDao = new ClienteDAO();
        Stream<Cliente> stream = clienteDao.obterClientes().stream().filter(s -> s.getNome().equalsIgnoreCase(dado) || String.valueOf(s.getCpf()).equalsIgnoreCase(dado));
        return stream;
    }

    public Cliente update(String nome, String cpf, String telefone, String email) {
        if (cpf != null && telefone != null && nome != null && email != null) {
            Cliente cliente = this.clienteDao.buscarCliente(this.pesquisarCliente(cpf).toList().get(0)).update(nome, cpf, telefone, email);
            return cliente;
        }
        return null;

    }

}
