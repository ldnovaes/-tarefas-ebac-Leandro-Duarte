/*
* @author: ldnovaes
* */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        //1 - Ler nomes - sexo: exemplo Leandro M, Dapheny F, João M, Renata F
        //2 - Separar em um map
        List<String> listaLeitura;
        Map<String, List<String>> mapPessoas = new HashMap<>();
        List<String> listaFeminina = new ArrayList<>();
        List<String> listaMasculina = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String leituraConsole = scanner.nextLine();
        listaLeitura = List.of(leituraConsole.split(", "));

        listaLeitura.stream()
                .map(s -> s.split(" "))
                .forEach(lista -> {
                    if(lista[1].equalsIgnoreCase("f")) {
                        listaFeminina.add(lista[0]);
                        mapPessoas.put(lista[1].toLowerCase(), listaFeminina);
                    } else {
                        listaMasculina.add(lista[0]);
                        mapPessoas.put(lista[1].toLowerCase(), listaMasculina);
                    }
                });

        // obtem as mulheres de duas maneiras:
        System.out.println(listaFeminina);
        System.out.println(mapPessoas.get("f"));

    }
}