import java.util.Scanner;



public class Uni5Exe26 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int trechoNegado = 0, trechos = 0, totalTrechos = 0;
        double distanciaTrecho = 0;
        System.out.print("Digite o valor máximo de pedágio que será aceito: ");
        double pedagioAceito = reader.nextDouble();
        System.out.print("Valor do pedágio: ");
        double valorPedagio = reader.nextInt();
        
        while (valorPedagio != 0){
            
            System.out.print("Distância: ");
            distanciaTrecho = reader.nextDouble();
            if (valorPedagio > pedagioAceito){
                trechoNegado++;
            }
            if (distanciaTrecho > 150 && valorPedagio < pedagioAceito){
                trechos++;
            }
            totalTrechos++;
            System.out.print("Valor do pedágio: ");
            valorPedagio = reader.nextInt();
        }
        System.out.println("-- Trechos da viagem que possuem um valor de pedágio acima do qual você se nega­ a pagar: " + trechoNegado);
        System.out.println("-- " + totalTrechos + " foram informados.");
        System.out.println("-- Trechos acima de 150 Km de distância que possuem um valor de pedágio que você concorda em pagar: " + trechos);
        reader.close();
    }
}
