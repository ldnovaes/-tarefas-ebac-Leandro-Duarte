import br.ldnovaes.clientesv1.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author ldnovaes
 */

public class ClienteTest {

    Cliente cliente = new Cliente();

    @BeforeEach
    void initi() {
        cliente = cliente.salvar("Leandro", 70422222293l, 2424444444l, "leandro@teste.com");
        cliente.addCliente(cliente);
    }

    @Test
    void testListCliente() {
        List<Cliente> clientesLista = Cliente.getClientes();
        Assertions.assertNotNull(clientesLista.get(0));
    }
}
