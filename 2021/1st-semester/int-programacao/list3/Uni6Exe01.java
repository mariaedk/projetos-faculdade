import java.util.Scanner;

/*
Uni6Exe01.java - Descreva um algoritmo que leia 10 números inteiros e os coloque em um vetor de 10 posições do tipo inteiro. Escreva na ordem inversa em que foram lidos. Faça um método para ler e outro para escrever.
*/

// feito.
public class Uni6Exe01 {
    private Uni6Exe01(){
        int vetor[] = new int[10];
        leitura(vetor);
        escrita(vetor);
    }

    private void leitura(int vetor[]) {
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = reader.nextInt();
        }
        reader.close();
    }
    private void escrita(int vetor[]) {
        for (int i = vetor.length - 1; i >= 0; i--) {
            System.out.println(vetor[i]);
        }
    }
    public static void main(String[] args) {
        new Uni6Exe01();
    }
}
