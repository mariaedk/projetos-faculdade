import java.util.Scanner;

public class Uni4Exe13 {
    public static void main(String[] args) throws Exception {
        // Scanner para inputs do usuario
        Scanner reader = new Scanner(System.in);
        
        // Programa que determina o que o usuário deve pedir no jogo TRUCO com base nas cartas que ele possui.

        // Apresentação do programa
        System.out.print("*-------TRUCO-------*");
        System.out.println();
        System.out.print("Cartas disponíveis: 1 (AS), 2, 3, 7, 11 (VALETE), 12(DAMA), 13 (REI).");
        System.out.println();
        System.out.print("Informe as cartas que você tem: ");
        System.out.println();

        // Inputs
        System.out.print("Carta 1: ");
        int carta1 = reader.nextInt();
        System.out.println();

        System.out.print("Carta 2: ");
        int carta2 = reader.nextInt();
        System.out.println();

        System.out.print("Carta 3: ");
        int carta3 = reader.nextInt();
        System.out.println();

        // Processo

        // Se o usuário não tiver nenhuma carta que seja 1,2 ou 3, ele imprime uma saída vazia.
        if ((carta1 != 1 && carta1 != 2 && carta1 != 3) && (carta2 != 1 && carta2 != 2 && carta2 != 3) && (carta3 != 1 && carta3 != 2 && carta3 != 3)){
            System.out.println();
        }

        // Se o usuário tiver 3 cartas que sejam 1,2 e 3, ele pede nove.
        if (((carta1 == 1 || carta1 == 2 || carta1 == 3) && (carta2 == 1 || carta2 == 2 || carta2 == 3) && (carta3 == 1 || carta3 == 2 || carta3 == 3))){
            System.out.print("---> NOVE! ");

        // Caso contrário: 
        } else {
            // Se o usuário tiver 3 cartas das quais ao menos 2 sejam 1,2 ou 3, ele pede seis.
            if (((carta1 == 1 || carta1 == 2 || carta1 == 3) && (carta2 == 1 || carta2 == 2 || carta2 == 3)) || ((carta2 == 1 || carta2 == 2 || carta2 == 3) && (carta3 == 1 || carta3 == 2 || carta3 == 3)) || ((carta1 == 1 || carta1 == 2 || carta1 == 3) && (carta3 == 1 || carta3 == 2 || carta3 == 3))){
                System.out.print("---> SEIS! ");

            // Caso contrário:
            } else {
                // Se o usuário tiver 3 cartas das quais ao menos 1 é 1,2 ou 3, ele pede truco.
                if ((carta1 == 1 || carta1 == 2 || carta1 == 3) || (carta2 == 1 || carta2 == 2 || carta2 == 3) || (carta3 == 1 || carta3 == 2 || carta3 == 3)){
                    System.out.print("---> TRUCO! ");

                }
            }
        }
        reader.close();
    }
}
