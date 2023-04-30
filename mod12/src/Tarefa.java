import java.util.*;

/**
 * @author ldnovaes
 * @since 11/04/2023 - 09:58
 */


public class Tarefa {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os nomes separado por vírgula. Ex: Leandro, Dapheny, João");

        // cria um input
        String input = scanner.nextLine();

        // cria uma lista atraves do input
        String[] nomes = input.split(",");

        // dicionario e lista para fins de organização
        Map<String, List> dados = new HashMap<>();
        List<String> masculinos = new ArrayList<>();
        List<String> femininos = new ArrayList<>();

        for (String nome: nomes){

            // obtem o nome atual e pede o sexo
            System.out.println("Você digitou o nome: " + nome + ", Por favor insira o sexo desta pessoa [ M / F ]");
            input = scanner.nextLine();

            // verifica o sexo
            if (input.equalsIgnoreCase("F")) {
                femininos.add(nome);
            } else {
                masculinos.add(nome);
            }
        }

        // insere no Map os dados. No caso dentro do HashMap teremos uma chave String e os valores do tipo List
        dados.put("masculinos", masculinos);
        dados.put("femininos", femininos);

        // imprime os dois separados, quanto masculinos, quanto femininos
        dados.entrySet().forEach(e -> {
            if (e.getKey().equals("masculinos")) {
                System.out.println("Os masculinos são: " + e.getValue());
            } else {
                System.out.println("Os femininos são " + e.getValue());
            }
        });
    }
}
