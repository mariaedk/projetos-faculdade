import java.util.Scanner;

public class Uni4Exe15 {
    public static void main(String[] args) throws Exception {
        // Scanner para input de usuário
        Scanner reader = new Scanner(System.in);

        System.out.print("Digite há quantos meses você esta admitido: ");
        int meses = reader.nextInt();

        double salario = 1000;

        if (meses < 12){
            salario = salario * 1.05;
            System.out.print("Seu salário após o reajuste será R$"+ salario);
        } else if (meses > 13 && meses < 48){
            salario = salario * 1.07;
            System.out.print("Seu salário após o reajuste será R$"+ salario);
        }
        reader.close();
    }
}
