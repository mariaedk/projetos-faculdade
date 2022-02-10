import java.util.Scanner;

public class Uni4Exe22 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite 1 para Ciência da Computação, 2 para Licenciatura da Computação e 3 para Sistemas de Informação: ");
        int opcao = teclado.nextInt();

        switch(opcao){
            case 1: System.out.print("Bacharel em Ciência da Computação."); break;
            case 2: System.out.print("Licenciado em Computação"); break;
            case 3: System.out.print("Bacharel em Sistemas de Informação"); break;
            default: System.out.print("Número inválido.");
        }
        teclado.close();
    }
}
