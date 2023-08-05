package br.ldnovaes.clientesv1.dao;

import br.ldnovaes.clientesv1.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

/**
 * @author ldnovaes
 */

public class ClienteDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
    private EntityManager entityManager;
    public ClienteDAO() {
        this.entityManager = emf.createEntityManager();
    }

    public void abreConexao() {
        this.entityManager.getTransaction().begin();
    }

    public void fechaConexao() {
        this.entityManager.close();
    }

    public Cliente salvarCliente(Cliente cliente) {
        this.entityManager.persist(cliente);
        this.entityManager.getTransaction().commit();
        return cliente;
    }

    public Cliente atualizarCliente(Cliente cliente) {
        this.entityManager.merge(cliente);
        this.entityManager.getTransaction().commit();
        return cliente;
    }

    public void removerCliente(Cliente cliente) {
        this.entityManager.remove(cliente);
        this.entityManager.getTransaction().commit();
    }

    public Cliente buscarCliente(Cliente cliente) {
        Cliente cliente_procurado = this.entityManager.find(Cliente.class, cliente.getId());
        return cliente_procurado;
    }
    public List<Cliente> obterClientes() {
        List<Cliente> clientes = this.entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        return clientes;
    }
}
