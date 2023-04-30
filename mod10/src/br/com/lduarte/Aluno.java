package br.com.lduarte;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vostoc
 * @version 1.0
 * @since quarta-feira, 2023-03-29 10:25
 */
public class Aluno {

    List<Integer> notas = new ArrayList<>();

    private String name;
    private int age;
    private int lastAluno = 0;
    private int idAluno = 0;
    private String situacao;

    public Aluno (String name, int age) {
        this.name = name;
        this.age = age;
        this.idAluno = lastAluno;
        lastAluno++;
    }

    public void insertNota (int nota) {

        // boxing
        nota = Integer.valueOf(nota);
        notas.add(nota);
    }

    public void changeSituacao () {

        int total = 0;

        for (int nota: notas) {
            total += nota;
        }

        int media = total/4;
        System.out.println(media);

        if (media >= 7) {
            this.situacao =  "Aprovado";
        } else if (media >= 5 && media < 7) {
            this.situacao = "Recuperação";
        } else {
            this.situacao = "Reprovado";
        }
    }

    public int getIdAluno() {
        return idAluno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getSituacao() {
        return situacao;
    }
}
