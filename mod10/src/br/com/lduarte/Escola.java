package br.com.lduarte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author vostoc
 * @version 1.0
 * @since quarta-feira, 2023-03-29 10:34
 */
public class Escola {

    private List<Aluno> alunos;

    private String nomeEscola;

    public Escola (String nomeEscola) {
        this.nomeEscola = nomeEscola;
        this.alunos = new ArrayList<>();

    }

    public void inserAlunos (String name, int age) {

        Aluno aluno = new Aluno(name, age);

        alunos.add(aluno);
    }

    public void insertNotaAluno (int idAluno) {

        // obtém o aluno
        Aluno aluno = alunos.get(idAluno);

        Scanner scanner = new Scanner(System.in);

        // insere as notas
        for (int i = 0; i < 4; i++) {
            System.out.println("Insira a nota " + i);
            int nota = scanner.nextInt();

            // tratar a nota antes de inserí-la pensando que o usuário pode digitar entre 0 - 10 ou entre 0 - 100
            if (nota >= 10 && nota <= 100 ) {
                nota /= 10;
            }

            aluno.insertNota(nota);
        }

        // apos inserir nota, retorna o método que muda a situação do aluno de acordo com a média
        aluno.changeSituacao();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Aluno getAluno (int idAluno) {
        return alunos.get(idAluno);
    }
}
