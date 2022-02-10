import java.util.Scanner;

public class Uni5Exe31 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int divisor = 2;
        System.out.print("Digite um número: ");
        int numero = teclado.nextInt();
        while (numero > 1){
            if (numero % divisor == 0){
                System.out.println(numero + "           " + divisor);
                if (numero == divisor){
                    System.out.println("1");
                }
                numero = numero / divisor;
                } else {
                divisor = divisor + 1;
            }
        }
        teclado.close();
    }
}
