import java.util.Scanner;

/*
Uni5Exe28.java - Uma emissora de rádio decidiu promover uma eleição para determinar o melhor conjunto do ano segundo a opinião dos ouvintes. Entraram na disputa apenas os quatro conjuntos mais solicitados durante o ano. Os votos são informados através de códigos:

código	conjunto
1	    Nenhum de Nós
2	    CPM22
3	    Skank
3	    Jota Quest
Descreva um algoritmo que:

informe o total de votos para cada grupo;
informe o percentual dos votos para cada grupo;
informe o grupo vencedor.
O algoritmo deve apresentar ao usuário a seguinte mensagem: mais um voto: s (SIM) / n (NÃO)? antes de prosseguir com a entrada de dados.
*/

public class Uni5Exe28 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int voto = 0, votos1 = 0, votos2 = 0, votos3 = 0, votos4 = 0, totalVotos = 0;
        String vencedor = "";
        double percentual1 = 0, percentual2 = 0, percentual3 = 0, percentual4 = 0;
        char msg = 'S';
        msg = Character.toUpperCase(msg);

        while (msg == 'S'){
            System.out.println(" - 1 para NENHUM DE NÓS;");
            System.out.println(" - 2 CMP22;");
            System.out.println(" - 3 Skank;");
            System.out.println(" - 4 Jota Quest;");
            System.out.print("Sua resposta: ");
            voto = teclado.nextInt();
            totalVotos++;
            switch(voto){
                case 1: votos1++; break;
                case 2: votos2++; break;
                case 3: votos3++; break;
                case 4: votos4++; break;
            }
            System.out.print("Mais um voto? s ou n: ");
            msg = teclado.next().charAt(0);
            msg = Character.toUpperCase(msg);
        }

        if (votos1 > votos2 && votos1 > votos3 && votos1 > votos4) {
            vencedor = "NENHUM DE NÓS";
        } else if (votos2 > votos1 && votos2 > votos3 && votos2 > votos4){
            vencedor = "CMP22";
        } else if (votos3 > votos2 && votos3 > votos1 && votos3 > votos4){
            vencedor = "SKANK";
        } else if (votos4 > votos2 && votos4 > votos3 && votos4 > votos1){
            vencedor = "JOTA QUEST";
        }
        percentual1 = (votos1 * 100) / totalVotos;
        percentual2 = (votos2 * 100) / totalVotos;
        percentual3 = (votos3 * 100) / totalVotos;
        percentual4 = (votos4 * 100) / totalVotos;

        System.out.println("Total votos para o 1: " + votos1 + " - Percentual: " + percentual1);
        System.out.println("Total votos para o 2: " + votos2 + " - Percentual: " + percentual2);
        System.out.println("Total votos para o 3: " + votos3 + " - Percentual: " + percentual3);
        System.out.println("Total votos para o 4: " + votos4 + " - Percentual: " + percentual4);
        System.out.println("O VENCEDOR É ------- " + vencedor);
        teclado.close();
    }
}
