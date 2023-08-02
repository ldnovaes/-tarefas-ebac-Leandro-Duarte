import br.ldnovaes.clientesv1.enums.ScreenEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author ldnovaes
 */

public class ScreenEnumTest {

    ScreenEnum detail;
    ScreenEnum main;

    @BeforeEach
    void init() {
        detail = ScreenEnum.DETAIL;
        main = ScreenEnum.MAIN;
    }

    @Test
    void getWidthTest() {
        Assertions.assertEquals(600, main.getWidth());
        Assertions.assertEquals(600, detail.getWidth());
    }

    @Test
    void getHeighTest() {
        Assertions.assertEquals(400, main.getHeight());
        Assertions.assertEquals(400, detail.getHeight());
    }

    @Test
    void getFxmlFileTest() {
        Assertions.assertEquals("detail-view.fxml", detail.getFxmlFile());
        Assertions.assertEquals("main-view.fxml", main.getFxmlFile());
    }
}
