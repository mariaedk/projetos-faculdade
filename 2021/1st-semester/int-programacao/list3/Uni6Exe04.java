/*
Faça um programa para ler dois vetores de inteiros, cada um contendo 10 elementos. Crie um terceiro vetor onde cada vetor é a soma dos valores contidos nas posições respectivas dos vetores originais. Exiba, ao final, os três vetores na tela. Faça três métodos: um método para ler os vetores, outro para somar e outro para escrever os vetores.
*/
// feito.
import java.util.Scanner;

public class Uni6Exe04 {

    private Uni6Exe04(){
        // determina vetores
        int vetor1[] = new int[10];
        int vetor2[] = new int[10];
        int vetor3[] = new int[10];

        // chamada de metodos
        lerVetores(vetor1, vetor2);
        somarVetores(vetor1, vetor2, vetor3);
        escreverVetor(vetor3);
    }

    private void lerVetores(int vetor1[], int vetor2[]){
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < vetor1.length; i++) {
            System.out.print("Valor "+i+" em vetor 1: ");
            vetor1[i] = teclado.nextInt();
            }
        System.out.println("--------------------------------");
        for (int j = 0; j < vetor2.length; j++) {
            System.out.print("Valor "+j+" em vetor 2: ");
            vetor2[j] = teclado.nextInt();
            }
        teclado.close();
    }

    private void somarVetores(int vetor1[], int vetor2[], int vetor3[]){
        for (int i = 0; i < vetor3.length; i++) {
            vetor3[i] = vetor1[i] + vetor2[i];
        }
    }

    private void escreverVetor(int vetor3[]){
        for (int i = 0; i < vetor3.length; i++) {
            System.out.println("Na posição ["+i+"] têm-se "+vetor3[i]);
        }
    }
    public static void main(String[] args) {
        new Uni6Exe04();
    }
}
