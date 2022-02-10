import java.util.Scanner;

/*
Faça um programa que leia N valores reais. Em seguida, dado um determinado valor, informe se o mesmo foi cadastrado no vetor.Faça um método para ler o vetor e outro, que retorne verdadeiro ou falso, para encontrar o valor.
*/

// feito.
public class Uni6Exe06 {
    Scanner teclado = new Scanner(System.in); // atributo

    private Uni6Exe06(){

        System.out.print("Quantos valores deseja escrever? ");
        final int n = teclado.nextInt();

        double valor = 0;
        double vetor[] = new double[n];

        vetorLer(vetor);
        if (vetorPesquisar(vetor, valor)){
            System.out.println("Encontrou o valor.");
        } else {
            System.out.println("Não encontrou o valor.");
        }
        
        teclado.close();
    }

    private void vetorLer(double vetor[]){

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Valor: ");
            vetor[i] = teclado.nextDouble();
        }
    }

    private boolean vetorPesquisar(double vetor[], double valor){

        System.out.print("Qual valor deseja verificar? ");
        valor = teclado.nextDouble();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Uni6Exe06();
    }
}
