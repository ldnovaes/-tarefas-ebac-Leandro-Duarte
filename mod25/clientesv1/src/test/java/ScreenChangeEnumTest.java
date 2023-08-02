import br.ldnovaes.clientesv1.enums.ScreenChangeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author ldnovaes
 */

public class ScreenChangeEnumTest {

    ScreenChangeEnum main;
    ScreenChangeEnum detail;
    ScreenChangeEnum cadastro;

    @BeforeEach
    void init() {
        main = ScreenChangeEnum.MAIN;
        detail = ScreenChangeEnum.DETAIL;
        cadastro = ScreenChangeEnum.CADASTRO;
    }

    @Test
    public void getAcao() {
        String mainString = main.getAcao();
        String detailString = detail.getAcao();
        String cadastroString = cadastro.getAcao();

        Assertions.assertEquals("Tela Inicial", mainString);
        Assertions.assertEquals("Tela de Editar", detailString);
        Assertions.assertEquals("Tela de Cadastrar", cadastroString);
    }
}
