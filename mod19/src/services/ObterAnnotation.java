package services;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ldnovaes
 */

public class ObterAnnotation {

    private Class classe;
    private List<Annotation> annotationsCollumn = new ArrayList<>();

    public ObterAnnotation(Class classe) {
        this.classe = classe;
    }

    public Annotation[] getAnnotationsClass() {
        return classe.getDeclaredAnnotations();
    }

    public List<Annotation> getAnnotationField(Class AnnotationClasse) {

        for (Field field : classe.getDeclaredFields()) {
            annotationsCollumn.add(field.getAnnotation(AnnotationClasse));
        }

        return this.annotationsCollumn;
    }

}
