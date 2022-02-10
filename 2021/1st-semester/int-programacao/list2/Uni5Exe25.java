import java.util.Scanner;

/*
Uni5Exe25.java - Em uma disputa de pingue-pongue os pontos são anotados como D, ponto para o jogador do lado direito, e E, ponto para o jogador do lado esquerdo da mesa. Descreva um algoritmo que leia o código do ponto de cada jogada e determine o vencedor. A partida encerra quando:

um dos jogadores chegar a 21 pontos e a diferença de pontos entre os jogadores for maior ou igual a dois;
o jogador com mais de 21 pontos conseguir uma diferença de dois pontos sobre o adversário, caso a primeira condição não seja atendida.
*/

public class Uni5Exe25 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Which player did score a point? D or E? ");
        char player = reader.nextLine().charAt(0);
        player = Character.toUpperCase(player);
        int pointsD = 0, pointsE = 0;
        

        while ( player == 'D' || player =='E' ) {
            switch(player){
                case 'D': pointsD++; break;
                case 'E': pointsE++; break;
            }
            if (pointsD == 21  && (pointsD - pointsE >= 2) || pointsD > 21 && (pointsD - pointsE == 2)){
                System.out.println("The winner is the player D."); break;
            } else if (pointsE == 21 && (pointsE - pointsD >= 2) || pointsE > 21 && (pointsE - pointsD == 2)){
                System.out.println("The winner is the player E."); break;
            }
            System.out.print("Which player did score a point? D or E? ");
            player = reader.nextLine().charAt(0);
            player = Character.toUpperCase(player);
        }
        reader.close();
    }
}
