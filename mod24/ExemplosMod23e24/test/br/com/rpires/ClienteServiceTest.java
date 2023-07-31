package br.com.rpires;

import br.com.rpires.dao.ClienteDao;
import br.com.rpires.dao.ClienteDaoMock;
import br.com.rpires.dao.IClienteDao;
import br.com.rpires.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

import java.lang.module.FindException;

/**
 * @author rodrigo.pires
 */
public class ClienteServiceTest {

    @Test
    public void salvarTest() {
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = FindException.class)
    public void buscar() {
        IClienteDao clienteDao = new ClienteDao();
        ClienteService service = new ClienteService(clienteDao);
        String retorno = service.buscar(15);
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = FindException.class)
    public void excluir() {
        IClienteDao clienteDao = new ClienteDao();
        ClienteService service = new ClienteService(clienteDao);
        String retorno = service.excluir(15);
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void salvar() {
        IClienteDao clienteDao = new ClienteDao();
        ClienteService service = new ClienteService(clienteDao);
        String retorno = service.atualizar(15);
        Assert.assertEquals("Sucesso", retorno);
    }
}
