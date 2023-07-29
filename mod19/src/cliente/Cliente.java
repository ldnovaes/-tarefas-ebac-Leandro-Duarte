package cliente;

import annotations.Collumn;
import annotations.Tabela;

import java.math.BigInteger;

/**
 * @author ldnovaes
 */

@Tabela(nome = "clientes")
public class Cliente {

    @Collumn(nameCollumn = "id")
    BigInteger id;

    @Collumn(nameCollumn = "nome_cliente")
    String nomeCliente;
}
