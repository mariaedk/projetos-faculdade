import java.util.Scanner;
/*
Considere um vetor de N elementos inteiros positivos e em ordem crescente. Faça um programa que insira novos valores no vetor de maneira que ele continue ordenado. O novo valor só deve ser inserido caso não exista no vetor. O vetor não pode ultrapassar 20 posições. Crie um método para ler o vetor, outro para inserir e outro para informar o vetor resultante.
*/
// feito.

public class Uni6Exe07 {
    Scanner teclado = new Scanner(System.in);  // atributo

    private Uni6Exe07(){

    // para qtd elementos do vetor
    System.out.print("Quantos elementos? ");
    int n = teclado.nextInt();
    while (n > 20){
        System.out.print("Não pode ultrapassar 20 posições.");
        n = teclado.nextInt();
    }

    // declaração do vetor
    int vetor[] = new int[n];
    int valorExistente = 0;

    lerValorVetor(vetor, valorExistente);
    inserirValorVetor(vetor, n);


    for (int i = 0; i < vetor.length; i++) {
        System.out.print("valor da posição ["+i+"] : ");
        System.out.print(vetor[i]);
        System.out.println();

    }
}

    private void lerValorVetor(int vetor[], int valorExistente){
        int valor;
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira o valor da posição ["+i+"] : ");
            valor = teclado.nextInt();
            for (int j = 0; j < vetor.length; j++) {
                if (vetor[j] == valor){
                    valorExistente = valorExistente + 1;
                    if (valorExistente != 0){
                        System.out.print("Insira somente valores que não foram adicionados ainda! : ");
                        valor = teclado.nextInt();
                        valorExistente = 0;
                    }
                }
            }
            if (valorExistente == 0){
                vetor[i] = valor;
            }
    }
}

    private void inserirValorVetor(int vetor[], int n){

        int cont1, cont2, aux;  
        for (cont1 = 0; cont1 < n; cont1++){  
            for (cont2 = 0; cont2 < n - 1; cont2++){  
               if (vetor[cont2]> vetor[cont2+1]){  
                    aux = vetor[cont2];  
                    vetor[cont2] = vetor[cont2+1];  
                    vetor[cont2+1] = aux;  
                }  
            }  
        }       
    } 
        public static void main(String[] args) {
            new Uni6Exe07();
        }

    }     

