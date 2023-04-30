import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ldnovaes
 * @since 30/04/2023 - 14:08
 */

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "leandro");
        stringMap.put(2, "duarte");
        stringMap.put(3, "novaes");
        stringMap.put(4, "dapheny");

        System.out.println(stringMap);

        // maneira de demonstrar fazer um for obtendo a chave e o value
        Set<Map.Entry<Integer, String>> entry = stringMap.entrySet(); // possível imprimir, retorna algo como [key1=value1, key2=value2]
        for (Map.Entry<Integer, String> item : entry) {
            System.out.println("Value é " + item.getValue());
            System.out.println("Key é " + item.getKey());
        }

        // foreach
        stringMap.entrySet().forEach(e -> {
            System.out.println("Value é " + e.getValue());
            System.out.println("Key é " + e.getKey());
        });
    }
}