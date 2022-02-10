
import java.util.Scanner;


public class Uni5Exe34 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int hospedesDeixaram = 0, numeroDiarias = 0;
        String nomeHospede = "";
        double totalPago = 0;
        System.out.println("----------- Controle de Hóspedes -----------");
        System.out.println("1. encerrar a conta de um hóspede");
        System.out.println("2. verificar número de contas encerradas");
        System.out.println("3. sair");
        System.out.print("opção: ");
        int opcao = teclado.nextInt();
        do {
            switch(opcao){
                case 1:
                System.out.print("Nome hóspede: ");
                nomeHospede = teclado.next();
                System.out.print("Número diárias: ");
                numeroDiarias = teclado.nextInt();
                System.out.println();
                if (numeroDiarias < 20){ 
                    totalPago = 9.50 + (numeroDiarias * 45);
                    }
                if (numeroDiarias == 20){
                    totalPago = 8.50 + (numeroDiarias * 45); 
                    }
                if (numeroDiarias > 20){
                    totalPago = 7 + (numeroDiarias * 45);
                    }
                System.out.println("--------");
                System.out.println();
                System.out.println("Nome: " + nomeHospede );
                System.out.println("Total: " + totalPago);
                System.out.println();
                hospedesDeixaram+=1;
                System.out.println("----------- Controle de Hóspedes -----------");
                System.out.println("1. encerrar a conta de um hóspede");
                System.out.println("2. verificar número de contas encerradas");
                System.out.println("3. sair");
                System.out.print("opção: ");
                opcao = teclado.nextInt();
                break;
                
                case 2: System.out.println("Número de contas encerradas: "+ hospedesDeixaram);
                System.out.println("----------- Controle de Hóspedes -----------");
                System.out.println("1. encerrar a conta de um hóspede");
                System.out.println("2. verificar número de contas encerradas");
                System.out.println("3. sair");
                System.out.print("opção: ");
                opcao = teclado.nextInt();
                break;

                case 3: break;

                default: System.out.println("Opção errada.");
                System.out.println("----------- Controle de Hóspedes -----------");
                System.out.println("1. encerrar a conta de um hóspede");
                System.out.println("2. verificar número de contas encerradas");
                System.out.println("3. sair");
                System.out.print("opção: ");
                opcao = teclado.nextInt();
                break;
            }   
        } while (opcao != 3);
        teclado.close();
    }
}