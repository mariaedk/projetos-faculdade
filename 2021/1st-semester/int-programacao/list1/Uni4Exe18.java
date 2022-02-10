import java.util.Scanner;

public class Uni4Exe18 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        System.out.print("- Dia do vencimento da parcela: ");
        int diaVencimento = reader.nextInt();

        System.out.print("- Dia do pagamento: ");
        int diaPagamento = reader.nextInt();

        System.out.print("- Valor do pagamento: ");
        double valorPagamento = reader.nextInt();

        if (diaVencimento <= 10){
            if (diaPagamento <= diaVencimento){
                System.out.print("Pagamento ocorre até o dia do vencimento. Você tem direito a 10% de desconto. ");
                valorPagamento = valorPagamento * 0.9;
            } else if ((diaPagamento < diaVencimento + 5) && (diaPagamento > diaVencimento)){
                System.out.print("Pagamento ocorre até 5 dias depois do vencimento. Você não terá direito a desconto. ");
            } else if (diaPagamento > 5 + diaVencimento){
                System.out.print("Pagamento ocorre mais de 5 dias após o vencimento. Você terá que pagar uma multa de 2% por cada dia de atraso. ");
                valorPagamento = valorPagamento * (1 + (0.02 * (diaPagamento - diaVencimento)));
            }
            System.out.print("O pagamento será de R$" + valorPagamento);
        } else {
            System.out.print("Data de vencimento inválida. Todo vencimento ocorre até o dia 10.");
        }
        reader.close();
    }
}
