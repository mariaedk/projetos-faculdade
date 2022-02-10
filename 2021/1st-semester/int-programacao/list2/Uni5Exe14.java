import java.util.Scanner;

public class Uni5Exe14 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double percentualLucro = 0, lucro10 = 0, lucro1020 = 0, lucro20 = 0, valorCompra = 0, valorVenda = 0, valorTotal = 0;

        for (int counter = 0; counter < 5; counter++) {
            System.out.print("Preço compra: ");
            double PC = teclado.nextDouble();
            System.out.print("Preço venda: ");
            double PV = teclado.nextDouble();

            valorCompra = valorCompra + PC;
            valorVenda = valorVenda + PV;
            percentualLucro = (PV - PC) / PC * 100;
            valorTotal = valorTotal + percentualLucro;

            if (percentualLucro < 10){
                lucro10++;
            } else if (percentualLucro >= 10 || percentualLucro <= 20){
                lucro1020++;
            } else if (percentualLucro > 20){
                lucro20++;
            }
        }
        System.out.println("Mercadorias que têm percentual de lucro > 10: " + lucro10);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Mercadorias que têm percentual de lucro => 10 e <= 20: " + lucro1020);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Mercadorias que têm percentual de lucro > 20: " + lucro20);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Valor total de compra: " + valorCompra + "  ----  Valor total de venda: " + valorVenda);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Percentual de lucro: " + valorTotal);
        teclado.close();
    }
}
