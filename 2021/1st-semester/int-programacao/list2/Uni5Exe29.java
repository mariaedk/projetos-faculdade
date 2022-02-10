import java.util.Scanner;

/*
var
saque: inteiro
inicio
escreva ("Entre com o valor do saque: ")
leia (saque)
escreval ("Número de cédulas de R$ 100: ",saque\100)
saque <- saque - saque\100*100
escreval ("Número de cédulas de R$ 50: ",saque\50)
saque <- saque%50
74
escreval ("Número de cédulas de R$ 20: ",saque\20)
saque <- saque%20
escreval ("Número de cédulas de R$ 10: ",saque\10)
saque <- saque%10
escreval ("Número de cédulas de R$ 5: ",saque\5)
saque <- saque%5
escreval ("Número de cédulas de R$ 2: ",saque\2)
saque <- saque%2
escreval ("Número de cédulas de R$ 1: ",saque)
fimalgoritmo
*/


public class Uni5Exe29 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Quantity: ");
        int quantity = reader.nextInt();
        while (quantity != 0){
            System.out.println("R$ 20 banknotes: " + quantity/20);
            quantity = quantity % 20;
            System.out.println("R$ 10 banknotes: " + quantity/10);
            quantity = quantity % 10;
            System.out.println("R$ 5 banknotes: " + quantity/5);
            quantity = quantity % 5;
            System.out.println("R$ 2 banknotes: " + quantity/2);
            quantity = quantity % 2;
            System.out.println("R$ 1 banknotes: " + quantity/1);
            quantity = quantity - quantity/1;
        }
        reader.close();
    }
}
