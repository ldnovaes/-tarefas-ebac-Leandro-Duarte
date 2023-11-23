package br.com.ldnovaes.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.ldnovaes.model.Cliente;
import br.com.ldnovaes.model.Produto;
import br.com.ldnovaes.model.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VendaDAOTest {
	private static EntityManager em;
	private EntityTransaction transaction;
	private IVendaDAO dao;
	private static Cliente cliente;
	private static List<Produto> produtos;

	@BeforeAll
	public static void setUpEntityManager() {
		em = Mockito.mock(EntityManager.class);
		produtos = new ArrayList<>();

		cliente = Cliente.builder().cpf("70432157853").nome("Leandro").build();

		for (int i = 0; i <= 10; i++) {

			Produto produto = Produto.builder().nome("Caixa de Papelão " + i).build();

			produtos.add(produto);
		}
	}

	@BeforeEach
	public void setUp() {
		transaction = Mockito.mock(EntityTransaction.class);
		dao = new VendaDAO(em);

		Mockito.when(em.getTransaction()).thenReturn(transaction);
	}

	@Test
	public void testPersistir() {
		Venda venda = Venda.builder().codigo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9))
				.cliente(cliente).build();

		venda.setProdutos(produtos);

		dao.persistir(venda);

		Mockito.verify(transaction).begin();
		Mockito.verify(em).persist(venda);
		Mockito.verify(transaction).commit();
	}

	@Test
	public void testDeletar() {

		Venda venda = Venda.builder().codigo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9))
				.cliente(cliente).build();

		venda.setProdutos(produtos);

		dao.deletar(venda);

		Mockito.verify(transaction).begin();
		Mockito.verify(em).remove(venda);
		Mockito.verify(transaction).commit();
	}

	@Test
	public void testBuscarPorId() {
		Long id = 1L;

		Venda venda = Venda.builder().codigo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9))
				.cliente(cliente).build();

		venda.setProdutos(produtos);

		when(em.find(Venda.class, id)).thenReturn(venda);

		Venda resultado = dao.buscarPorId(id);

		verify(transaction).begin();
		verify(em).find(Venda.class, id);
		verify(transaction).commit();
		assertEquals(venda, resultado);
	}

	@AfterAll
	public static void closeEntityManager() {
		em.close();
	}
}
