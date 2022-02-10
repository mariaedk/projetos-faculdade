import java.util.Scanner;

public class Uni4Exe17 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        // Inputs
        System.out.print("--------CÁLCULO DA RENDA LÍQUIDA--------");
        System.out.println();
        System.out.print("Por favor, informe sua renda anual, em reais: ");
        double rendaAnual = reader.nextDouble();

        System.out.print("Agora informe o número de dependentes: ");
        int dependentes = reader.nextInt();

        // Processo
        double rendaLiquida = rendaAnual * (1 - (0.02 * dependentes));

        if (rendaLiquida <= 2000){
            System.out.print("De acordo com a sua renda líquida, você NÃO PAGARÁ IMPOSTO.");
        } else if (rendaLiquida > 2000 && rendaLiquida <= 5000){
            rendaLiquida = rendaLiquida * 0.95;
            System.out.print("De acordo com a sua renda líquida, você terá IMPOSTO DE 5%, resultando em R$" + rendaLiquida);
        } else if (rendaLiquida > 5000 && rendaLiquida <= 10000){
            rendaLiquida = rendaLiquida * 0.9;
            System.out.print("De acordo com a sua renda líquida, você terá IMPOSTO DE 10%, resultando em R$" + rendaLiquida);
        } else if (rendaLiquida > 10000){
            rendaLiquida = rendaLiquida * 0.85;
            System.out.print("De acordo com a sua renda líquida, você terá IMPOSTO DE 15%, resultando em R$" + rendaLiquida);
        }
        reader.close();
    }
}
