import br.ldnovaes.clientesv1.model.Cliente;
import br.ldnovaes.clientesv1.service.ClienteService;
import org.junit.jupiter.api.*;

import java.util.stream.Stream;

/**
 * @author ldnovaes
 */

public class ClienteServiceTest {

    ClienteService clienteService;
    Cliente clienteInstancia;
    Cliente clienteObjeto;

    @BeforeEach
    void init() {
        clienteInstancia = new Cliente();
        clienteService = new ClienteService();
        clienteObjeto = clienteService.salvar("Leandro", "70456227193", "61998951731", "teste@teste.com");
        clienteInstancia.addCliente(clienteObjeto);
    }

    @Test
    void tratamentoCpfTest() {
        Long cpf = clienteService.tratamentoCpf("70436227193");
        Assertions.assertNotNull(cpf);
    }

    @Test
    void tratamentoTelefoneTest() {
        Long telefone = clienteService.tratamentoTelefone("61998051731");
        Assertions.assertNotNull(telefone);
    }

    @Test
    void pesquisarClienteTest() {
        Cliente clientePesquisado = clienteService.pesquisarCliente("70456227193").toList().get(0);
        Assertions.assertEquals(clienteObjeto, clientePesquisado);
    }

    @Test
    void updateTeste() {
        Cliente clienteEmailAtualizado = clienteService.update("Leandro", "70456227193", "61998951731", "email@gmail.com");
        Assertions.assertNotNull(clienteEmailAtualizado);
        Assertions.assertEquals("email@gmail.com", clienteEmailAtualizado.getEmail());
    }
}
