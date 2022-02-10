/*
        Uni5Exe32.java - Escreva um programa que imprime um calendário para um determinado mês. O calendário deve conter cada dia do mês e o dia da semana correspondente. A entrada consiste de um inteiro especificando em que dia da semana cai o primeiro dia do mês (1=Domingo, 2=Segunda,...,7=Sábado) e um inteiro especificando o número de dias que o mês possui.
*/

import java.util.Scanner;

public class Uni5Exe32 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Em qual dia da semana começa o mes? (considere domingo = 1 e sábado = 7)");
        int dia = scan.nextInt();
        System.out.println("Quantos dias tem o mes?");
        int dias = scan.nextInt();
        System.out.println("  D  S  T  Q  Q  S  S");
        System.out.println("---------------------");
        int contador = 1;

        for (int c = 1; c < dia; c++) {
            System.out.print("   ");
        }
        while (contador <= dias){
            if (contador < 10) {
                System.out.print("  " + contador);
            } else {
                System.out.print(" " + contador);
            }
            if (dia == 7) {
                dia = 1; // Reseta a variável para recomeçar a semana
                System.out.println();
            } else {
                dia++;
            }
            contador++;
        }
        scan.close();
    }
}