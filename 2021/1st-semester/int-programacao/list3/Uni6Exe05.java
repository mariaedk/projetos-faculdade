import java.util.Scanner;
/*
Com o objetivo de determinar o índice de afinidade entre um rapaz e uma moça cada um respondeu um questionário com 5 perguntas, como por exemplo:

Gosta de música sertaneja?
Gosta de futebol?
Gosta de seriados?
Gosta de redes sociais?
Gosta da Oktoberfest?
A resposta a cada pergunta pode ser: SIM, NÃO ou IND (indiferente). O índice de afinidade é medido da seguinte maneira:

se ambos deram a mesma resposta soma-se 3 pontos ao índice;
se um respondeu IND e o outro SIM ou NÃO soma-se 1;
se um respondeu SIM e o outro NÃO soma-se -2 ao índice.
Crie um vetor para armazenar as respostas do rapaz e outro para armazenar as respostas da moça. Crie um método para ler as respostas e outro para calcular e retornar a afinidade. Por fim, escreva a afinidade considerando os seguintes intervalos:

Afinidade	Mensagem
15	        “Casem!
10 a 14	    “Vocês têm muita coisa em comum!”
5 a 9	    “Talvez não dê certo :(”
0 a 4	    “Vale um encontro.”
-1 a -9	    “Melhor não perder tempo”
-10	        “Vocês se odeiam!”
*/

// FEITO.

public class Uni6Exe05 {
    private Uni6Exe05(){
        String vetorH[] = new String[5];
        String vetorM[] = new String[5];
        int indice = 0;
        lerRespostas(vetorH, vetorM);
        System.out.println("CALCULANDO...............");
        System.out.println("Resposta: " + calcularAfinidade(vetorH, vetorM, indice));
        
    }
    private void lerRespostas(String vetorH[], String vetorM[]){
        Scanner teclado = new Scanner(System.in);

        // Rapaz
        System.out.println("Para o rapaz: ");
        System.out.print("Gosta de música sertaneja?");
        vetorH[0] = teclado.next().toUpperCase();
        System.out.print("Gosta de futebol?");
        vetorH[1] = teclado.next().toUpperCase();
        System.out.print("Gosta de seriados?");
        vetorH[2] = teclado.next().toUpperCase();
        System.out.print("Gosta de redes sociais?");
        vetorH[3] = teclado.next().toUpperCase();
        System.out.print("Gosta da Oktoberfest?");
        vetorH[4] = teclado.next().toUpperCase();
        // Moça
        System.out.println("-----------------------------");
        System.out.println("Para a moça: ");
        System.out.print("Gosta de música sertaneja?");
        vetorM[0] = teclado.next().toUpperCase();
        System.out.print("Gosta de futebol?");
        vetorM[1] = teclado.next().toUpperCase();
        System.out.print("Gosta de seriados?");
        vetorM[2] = teclado.next().toUpperCase();
        System.out.print("Gosta de redes sociais?");
        vetorM[3] = teclado.next().toUpperCase();
        System.out.print("Gosta da Oktoberfest?");
        vetorM[4] = teclado.next().toUpperCase();

        teclado.close();
    }

    private String calcularAfinidade(String vetorH[], String vetorM[], int indice) {
        String resposta = "";
        for (int i = 0; i < 5; i++) {
            if ((vetorH[i].equals("SIM") && vetorM[i].equals("SIM")) || (vetorH[i].equals("NAO") && vetorM[i].equals("NAO"))){
                indice = indice + 3;
            } else if (((vetorH[i].equals("IND") && ((vetorM[i].equals("SIM")) || vetorM[i].equals("NAO")))) || ((vetorM[i].equals("IND")) && (vetorH[i].equals("SIM") || vetorH[i].equals("NAO")))){
                indice= indice + 1;
            } else if ((vetorH[i].equals("SIM") && vetorM[i].equals("NAO")) || (vetorM[i].equals("SIM") && (vetorH[i].equals("NAO")))){
                indice= indice - 2;
            }
        }
        if (indice == 15){
            resposta = "Casem!";
        } else if (indice >= 10 && indice <= 14){
            resposta = "Vocês tem muita coisa em comum!";
        } else if (indice >= 5 && indice <=9){
            resposta = "Talvez não dê certo :(";
        } else if (indice >= 0 && indice <=4){
            resposta = "Vale um encontro.";
        } else if (indice >= -1 && indice <= -9){
            resposta = "Melhor não perder tempo";
        } else if (indice == -10){
            resposta = "Vocês se odeiam!";
        }
        return resposta;
    }
    public static void main(String[] args) {
        new Uni6Exe05();
    }
}