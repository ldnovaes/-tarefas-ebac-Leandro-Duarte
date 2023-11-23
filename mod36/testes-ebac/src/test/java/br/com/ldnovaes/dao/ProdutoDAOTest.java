package br.com.ldnovaes.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.ldnovaes.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class ProdutoDAOTest {

    private static EntityManager em;
    private EntityTransaction transaction;
    private IProdutoDAO dao;

    @BeforeAll
    public static void setUpEntityManager() {
        em = Mockito.mock(EntityManager.class);
    }

    @BeforeEach
    public void setUp() {
        transaction = Mockito.mock(EntityTransaction.class);
        dao = new ProdutoDAO(em);

        Mockito.when(em.getTransaction()).thenReturn(transaction);
    }

    @Test
    public void testPersistir() {
        Produto produto = Produto.builder()
                .nome("Caixa de Papelão")
                .build();

        dao.persistir(produto);

        Mockito.verify(transaction).begin();
        Mockito.verify(em).persist(produto);
        Mockito.verify(transaction).commit();
    }

    @Test
    public void testDeletar() {
        Produto produto = Produto.builder()
                .nome("Caixa de Papelão")
                .build();

        dao.deletar(produto);

        Mockito.verify(transaction).begin();
        Mockito.verify(em).remove(produto);
        Mockito.verify(transaction).commit();
    }
    
    @Test
    public void testBuscarPorId() {
        Long id = 1L;
        Produto produto = Produto.builder()
        		.nome("caixa")
        		.build(); 
        when(em.find(Produto.class, id)).thenReturn(produto);

        Produto resultado = dao.buscarPorId(id);

        verify(transaction).begin();
        verify(em).find(Produto.class, id);
        verify(transaction).commit();
        assertEquals(produto, resultado);
    }

    @AfterAll
    public static void closeEntityManager() {
        em.close();
    }
}
