package br.com.lduarte;

import java.util.Scanner;

/**
 * @author vostoc
 * @version 1.0
 * @since terça-feira, 2023-03-28 15:05
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Escola escola1 = new Escola("EBAC");


        escola1.inserAlunos("Leandro", 24);
        escola1.inserAlunos("Dapheny", 22);
        escola1.inserAlunos("João Pedro", 12);
        escola1.inserAlunos("Roberto", 64);


        while (true) {
            int contador = 0;

            System.out.println("Escolha o aluno para inserir as notas ou digite 9 para sair do programa");

            // percore os alunos
            for (Aluno i:escola1.getAlunos()) {
                System.out.println("[ " + contador + " ] - " +"Aluno: " + i);
                contador++;
            }

            // obtem o id do aluno
            int idAluno = scanner.nextInt();
            scanner.nextLine();

            // sai do programa
            if (idAluno == 9) {
                break;
            }

            System.out.println("Você escolheu o aluno: " + escola1.getAluno(idAluno).getName());

            System.out.println("Deseja qual opção? \n[ 1 ] - Inserir Notas \n[ 2 ] - Ver Situação do Aluno");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.println("******** INSIRA AS NOTAS *********");

                    // insere as notas de acordo com o id do aluno
                    escola1.insertNotaAluno(idAluno);
                case 2:
                    System.out.println("O aluno está " + escola1.getAluno(idAluno).getSituacao());
            }



        }


    }



}
