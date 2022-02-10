import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni4Exe21 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat df_02 = new DecimalFormat("#.00");

        System.out.println("CÁLCULO IMC");
        System.out.print("- Informe sua altura em M: ");
        double altura = teclado.nextDouble();

        System.out.print("- Informe o valor de sua massa em KG: ");
        double massa = teclado.nextDouble();

        double imc = massa / (altura * altura);

        System.out.println("Seu IMC: " + df_02.format(imc));
        System.out.print("Sua classificação: ");

        if (imc < 18.5){
            System.out.print("Magreza.");
        } else if ((imc > 18.5) && (imc < 24.9)){
            System.out.print("Saudável.");
        } else if ((imc > 25) && (imc < 29.9)){
            System.out.print("Sobrepeso.");
        } else if ((imc > 30) && (imc < 34.9)){
            System.out.print("Obesidade Grau I.");
        } else if ((imc > 35) && (imc < 39.9)){
            System.out.print("Obesidade Grau II (severa).");
        } else if ((imc >= 40)){
            System.out.print("Obesidade Grau III (mórbida).");
        }
        teclado.close();
    }
}
