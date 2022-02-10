import java.util.Scanner;

public class Uni5Exe19 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double valorCompra = 0, valorTotalDia = 0, valorDesconto = 0;
        System.out.print("Valor da compra: ");
        valorCompra = reader.nextDouble();

        while (valorCompra != 0){
            if (valorCompra > 500){
                valorDesconto = valorCompra * 0.8;
                System.out.println("Valor com desconto: " + valorDesconto);
            } else if (valorCompra <= 500){
                valorDesconto = valorCompra * 0.85;
                System.out.println("Valor com desconto: " + valorDesconto);
            }
            valorTotalDia = valorDesconto + valorTotalDia;

            System.out.print("Valor da compra: ");
            valorCompra = reader.nextDouble();
            if (valorCompra == 0){
                break;
            }
        }
        System.out.print("Valor total no dia: " + valorTotalDia);
        reader.close();
    }
}
