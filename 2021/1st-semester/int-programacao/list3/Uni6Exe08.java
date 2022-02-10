import java.util.Scanner;


/*
Faça um programa que leia um valor N inteiro limitado a 20 posições. Com base neste valor, crie um vetor do tipo real. Faça o usuário informar valores para as posições deste vetor e coloque-as nas posições na sequência informada pelo usuário. Imprima uma tabela contendo cada valor diferente e o número de vezes que o valor aparece no vetor (veja exemplo a seguir).
*/

public class Uni6Exe08 {
    Scanner teclado = new Scanner(System.in);

    private Uni6Exe08(){
        System.out.print("Quantos valores deseja informar ? : ");
        int n = teclado.nextInt();

        while (n > 20){
            System.out.print("Você ultrapassou o limite! Digite um número menor que 20: ");
            n = teclado.nextInt();
        }
        double vetor[] = new double[n];

        lerVetor(vetor);
        escreverVetor(vetor);
        verificaVetor(vetor);
    }

    private void lerVetor(double vetor[]){
        for (int contador = 0; contador < vetor.length; contador++) {
            System.out.print("Valor: ");
            vetor[contador] = teclado.nextDouble();
        }
        teclado.close();
    }

    private void escreverVetor(double vetor[]){
        for (int contador = 0; contador < vetor.length; contador++){
            System.out.println(vetor[contador]);
        }
    }

    private void verificaVetor(double vetor[]){
        System.out.println("| VALOR | FREQÜÊNCIA | ");

        int quantidade;
        int elementoLista = 0;
        boolean pesquisar;
        
        
        while (elementoLista < vetor.length) {
            quantidade = 1;
            int pesAbaixo = 0;
            pesquisar = true;
            while (pesAbaixo < elementoLista) {
                if (vetor[pesAbaixo] == vetor[elementoLista]) {
                    pesquisar = false;
                }
                pesAbaixo++;
            }
            if (pesquisar) {
                System.out.print("| " + (vetor[elementoLista]) + "   | ");
                int indiceTeste = elementoLista + 1;
                while (indiceTeste < vetor.length) {
                    if (vetor[elementoLista] == vetor[indiceTeste]) {
                        quantidade++;
                    }
                    indiceTeste++;
                    }
                    System.out.println(quantidade + " |");
                    }
                    elementoLista++;
                    }
    }

    public static void main(String[] args) {
        new Uni6Exe08();
    }
}
