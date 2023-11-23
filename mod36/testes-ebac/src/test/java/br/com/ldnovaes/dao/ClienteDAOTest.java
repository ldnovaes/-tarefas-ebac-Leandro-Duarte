package br.com.ldnovaes.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.ldnovaes.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ClienteDAOTest {

	private static EntityManager em;
	private EntityTransaction transaction;
	private IClienteDAO dao;

	@BeforeAll
	public static void setUpEntityManager() {
		em = Mockito.mock(EntityManager.class);
	}

	@BeforeEach
	public void setUp() {
		transaction = Mockito.mock(EntityTransaction.class);
		dao = new ClienteDAO(em);

		Mockito.when(em.getTransaction()).thenReturn(transaction);
	}

	@Test
	public void testPersistir() {
		Cliente cliente = Cliente.builder().cpf("70432157853").nome("Leandro").build();

		dao.persistir(cliente);

		verify(transaction).begin();
		verify(em).persist(cliente);
		verify(transaction).commit();
	}

	@Test
	public void testDeletar() {
		Cliente cliente = Cliente.builder()
				.cpf("70432157853")
				.nome("Leandro")
				.build();

		dao.deletar(cliente);

		verify(transaction).begin();
		verify(em).remove(cliente);
		verify(transaction).commit();
	}
	
	@Test
    public void testBuscarPorId() {
        Long id = 1L;
        Cliente cliente = Cliente.builder()
        		.cpf("70428334678")
        		.nome("Leandro")
        		.build(); 
        when(em.find(Cliente.class, id)).thenReturn(cliente);

        Cliente resultado = dao.buscarPorId(id);

        verify(transaction).begin();
        verify(em).find(Cliente.class, id);
        verify(transaction).commit();
        assertEquals(cliente, resultado);
    }

	@AfterAll
	public static void closeEntityManager() {
		em.close();
	}
}