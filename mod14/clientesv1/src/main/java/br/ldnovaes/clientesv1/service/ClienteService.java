package br.ldnovaes.clientesv1.service;

import br.ldnovaes.clientesv1.model.Cliente;

import javax.swing.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ldnovaes
 */

public class ClienteService {
    
    public Cliente salvar(String nome, String cpfString, String telefoneString, String email) {
        Long cpf = this.tratamentoCpf(cpfString);
        Long telefone = this.tratamentoTelefone(telefoneString);

        if (cpf != null && telefone != null) {
            Cliente cliente = new Cliente().salvar(nome, cpf, telefone, email);
            return cliente;
        }
        return null;

    }

    public Long tratamentoCpf(String cpf) {
        try {
            return Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF inválido! Para continuarmos, não insira nenhum caractere de símbolo nesse campo.");
        }
        return null;
    }

    public Long tratamentoTelefone(String telefone) {
        try {
            return Long.parseLong(telefone);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Telefone inválido! Para continuarmos, não insira nenhum caractere de símbolo nesse campo");
        }
        return null;
    }

    public Stream<Cliente> pesquisarCliente(String dado) {
        Stream<Cliente> stream = Cliente.getClientes().stream().filter(s -> s.getNome().equalsIgnoreCase(dado) || String.valueOf(s.getCpf()).equalsIgnoreCase(dado));
        return stream;
    }

    public Cliente update(String nome, String cpfString, String telefoneString, String email) {
        Long cpf = this.tratamentoCpf(cpfString);
        Long telefone = this.tratamentoTelefone(telefoneString);
        if (cpf != null && telefone != null) {
            Cliente cliente = this.pesquisarCliente(String.valueOf(cpf)).toList().get(0).update(nome, cpf, telefone, email);
            System.out.println(cliente);
            return null;
        }
        return null;

    }

}
