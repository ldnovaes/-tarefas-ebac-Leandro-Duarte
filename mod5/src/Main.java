import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author vostoc
 * @version 1.0
 * @since $DAY_NAME_FULL, ${YEAR}-${MONTH}-${DAY} $TIME
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        int age;

        List<User> users = new ArrayList<>();

        while (true) {
            System.out.println("Você tem as opções:\nC - Criar Usuário\nS - Sair");
            String op = scanner.nextLine();

            if (op.equals("C") || op.equals("c")) {
                System.out.print("Diga o seu nome: ");
                firstName = scanner.nextLine();

                System.out.print("Agora diga o seu sobrenome: ");
                lastName = scanner.nextLine();

                System.out.println("Sua idade em anos é: ");
                age = scanner.nextInt();
                scanner.nextLine();

                User user = new User(firstName, lastName, age);
                users.add(user);

            } else if (op.equals("S") || op.equals("s")) {
                System.out.println("Você optou por sair do sistema!");
                break;
            }

        }

        System.out.println(users.toString());
    }
}