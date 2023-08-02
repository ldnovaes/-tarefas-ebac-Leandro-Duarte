import br.ldnovaes.clientesv1.enums.LogEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author ldnovaes
 */

public class LogEnumTest {

    LogEnum voltar;
    LogEnum main;
    LogEnum cadastro;
    LogEnum buscar;


    @BeforeEach
    void init() {
        voltar = LogEnum.VOLTAR;
        main = LogEnum.MAIN;
        cadastro = LogEnum.CADASTRO;
        buscar = LogEnum.BUSCAR;
    }

    @Test
    void getLogTest() {
        String voltarString = voltar.getLog();
        String mainString = main.getLog();
        String cadastroString = cadastro.getLog();
        String buscarString = buscar.getLog();

        Assertions.assertEquals("[LOG] - DETAILCONTROLLER - CLICADO EM VOLTAR", voltarString);
        Assertions.assertEquals("[LOG] - MAINCONTROLLER - CLICADO EM NOVO CADASTRO", mainString);
        Assertions.assertEquals("[LOG] - CADADRO REALIZADO", cadastroString);
        Assertions.assertEquals("[LOG] - REALIZADO BUSCA NO SISTEMA", buscarString);
    }
}
