import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author vostoc
 * @version 1.0
 * @since segunda-feira, 2023-03-27 18:03
 */
public class Main {

    public static void main(String[] args) {
        // wrappers são bons quando queremos criar listas de um tipo com tamanho não definido.
        //ex:
        List<Integer> inteiros = new ArrayList<>();

        System.out.println("Digite um número:");
        Scanner scanner = new Scanner(System.in);

        // colocando o input no tipo primitivo
        int numero = scanner.nextInt();
        System.out.println("Recebemos esse número e guardamos ele para o tipo primitivo INT");

        // transformando o tipo primitivo em Wrapper
        Integer numeroInteger = Integer.valueOf(numero);
        System.out.println("Agora transformamos ele no tipo Integer");

        // fazendo o casting e transformando em long
        long numeroLong = (long) numero;
        System.out.println("O casting do int para long é: " + numeroLong);

        // mas eu sou inspirado e quero transformar em byte e ainda do tipo wrapper
        byte numeroByte = (byte) numero;
        Byte numeroByteWrapper = Byte.valueOf(numeroByte);
        System.out.println("O numero do tipo Wrapper Byte é: "+ numeroByte);

        // fazendo o boxing -> converte tipo primitivo em Objeto Wrapper
        boolean status = Boolean.TRUE;
        Integer numeroInteger2 = 15;
        Character c = 'A';

        // fazendo o unboxing -> converte Objeto Wrapper em tipo primitivo
        int numeroInteger3 = Integer.valueOf(15);
        long cpf = Long.valueOf(70436227193l);




    }


}
