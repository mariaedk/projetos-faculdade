import java.util.Scanner;
/*
Descreva um algoritmo que leia 12 valores reais e os coloque em um vetor de 12 posições do tipo real. Em seguida, modifique o vetor de modo que os valores das posições ímpares sejam aumentados em 5% e os das posições pares sejam aumentados em 2%. Imprima o vetor resultante. Faça um método para ler os valores, outro para ajustar os valores dentro do vetor e outro para escrever os valores atualizados do vetor.
*/
// feito.
public class Uni6Exe03 {

    private Uni6Exe03(){
        double vetor[] = new double[12];
        leitura(vetor);
        ajuste(vetor);
        escrita(vetor);
    }

    private void leitura(double vetor[]){
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite o número: ");
            vetor[i] = teclado.nextDouble();
            System.out.println();
        }
        teclado.close();
    }
    private void ajuste(double vetor[]){
        for (int j = 0; j < vetor.length; j++) {
            if (vetor[j] % 2 == 0){
                vetor[j] = vetor[j] * 1.02;
            } else {
                vetor[j] = vetor[j] * 1.05;
            }
        }
    }

    private void escrita(double vetor[]){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
    }
}

    public static void main(String[] args) {
        new Uni6Exe03();
    }
}
