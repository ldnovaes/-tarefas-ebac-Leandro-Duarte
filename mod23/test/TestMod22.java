import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author ldnovaes
 */

public class TestMod22 {
    @Test
    void name() {
        String input = "leandro m, dapheny f, joao m, rodrigo pires m, marcelo m, karina f, ketlyn f, hadassa f, fabricia f, mona f, padre m";
        ByteArrayInputStream biteCodeInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(biteCodeInput);

        String outputExpected = "dapheny, karina, ketlyn, hadassa, fabricia, mona, ";
        ByteArrayOutputStream biteCodeOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(biteCodeOutput);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String lines = biteCodeOutput.toString();

        Assertions.assertEquals(outputExpected, lines);
    }

}
