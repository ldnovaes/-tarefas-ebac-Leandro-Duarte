import java.util.*;

/**
 * @author vostoc
 * @since quinta-feira, 2023-03-30 16:31
 */
public class Tarefa01 {
    public static void main(String[] args) {
        usandoArray();
        usandoArraList();
    }

    public static void usandoArraList() {
        List<String> nomesList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os nomes separados por vírgula: ");
        String nomes = scanner.nextLine();
        nomesList = Arrays.asList(nomes.replace(" ", "").split(","));
        System.out.println("Usando ArrayList: " + nomesList);
        System.out.println("O tipo é " + nomesList.getClass());
    }

    public static void usandoArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os nomes separados por vírgula: ");
        String nomes = scanner.nextLine();
        String[] nomesList = nomes.split(",");
        System.out.println("Usando Array: " + Arrays.toString(nomesList));
        System.out.println("O tipo é " + nomesList.getClass());

    }
}
