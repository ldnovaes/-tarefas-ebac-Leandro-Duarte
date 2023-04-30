package br.com.lduarte;

import java.util.Scanner;

/**
 * @author vostoc
 * @version 1.0
 * @since segunda-feira, 2023-03-27 14:43
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] notas = new double[4];
        double total = 0;

        // faz a pergunta das notas e adiciona na lista
        for (int i = 0; i < 4; i++) {

            System.out.println("Insira a nota");
            double nota = scanner.nextDouble();
            notas[i] = nota;
        }

        // soma as notas
        for (int j = 0; j < 4; j++) {
            total += notas[j];
        }

        // obtem a media
        double media = total / notas.length;

        System.out.println("A média do aluno é " + media);

        if (media >= 6 && total <= 100 || media >= 60 && total >= 100) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }

    }

}
