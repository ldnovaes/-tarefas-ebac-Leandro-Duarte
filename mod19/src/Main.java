import annotations.Collumn;
import cliente.Cliente;
import services.ObterAnnotation;

import java.lang.annotation.Annotation;

/**
 * @author ldnovaes
 */

public class Main {
    public static void main(String[] args) {

        // obtendo anotacoes de classe (qualquer classe)
        ObterAnnotation annotation = new ObterAnnotation(Cliente.class);
        Annotation[] annotations = annotation.getAnnotationsClass();

        for (Annotation anot : annotations) {
            System.out.println(anot);
        }


        // obtendo anotacoes de fields (necessário passar a classe da annotation)
        System.out.println(annotation.getAnnotationField(Collumn.class));

    }
}
