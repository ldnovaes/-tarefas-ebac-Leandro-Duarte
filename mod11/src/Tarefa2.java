import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author vostoc
 * @since quinta-feira, 2023-03-30 16:44
 */
public class Tarefa2 {
    public static void main(String[] args) {
        List<String> nomesList = new ArrayList<>();
        List<String> masculinos = new ArrayList<>();
        List<String> femininos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome + o sexo. Ex: Leandro-M || Leandro - M");
        String nomes = scanner.nextLine();


        // ignorando os espaços
        if (nomes.contains(" - ")) {
            nomes = nomes.replace(" ", "");
        }

        // evitando falhas da digitação
        nomes = nomes.toLowerCase();
        nomesList = Arrays.asList(nomes.split(","));

        for (String nome:nomesList) {
            if(nome.contains("-f")) {
                femininos.add(nome.replace("-f", ""));
            } else if (nome.contains("-m")) {
                masculinos.add(nome.replace("-m", ""));
            } else{

                // confirma com o usuario qual o sexo do nome, caso o usuario tenha esquecido
                System.out.println("O nome " +  nome + " não tem genero definido. Defina agora digitando \n[ 1 ] Masculino\n[ 2 ] Feminino");
                String genero = scanner.nextLine();

                switch (genero) {
                    case "1":
                        masculinos.add(nome);
                        break;
                    case "2":
                        femininos.add(nome);
                        break;
                }
            }
        }

        System.out.println(masculinos);
        System.out.println(femininos);
    }

}
