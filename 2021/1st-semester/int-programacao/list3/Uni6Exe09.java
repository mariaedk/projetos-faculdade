import java.util.Scanner;

/*
Um cinema pretende fazer uma pesquisa para avaliar o grau de satisfação de seus clientes. Trinta deles foram ouvidos e para cada um perguntou-se o sexo (1=feminino 2=masculino), uma nota para o cinema (zero até dez) e a idade.

Baseado nisto faça um programa que informe:

qual a nota média recebida pelo cinema; V
qual a nota média atribuída pelos homens; V
qual a nota atribuída pela mulher mais jovem; V (?)
quantas das mulheres com mais de 50 anos deram nota superior a média. V (?)
*/

public class Uni6Exe09 {
    Scanner teclado = new Scanner(System.in); 

    private Uni6Exe09(){
        int sexo[] = new int[30];
        double nota[] = new double[30];
        int idade[] = new int[30];

        double somaNotasTotal = 0, somaNotasHomens = 0, mediaNotasHomens = 0, idadeMulherJovem = 0, notaMulherJovem = 0;
        int qtdHomens = 0, mulheres50anos = 0;

        lerSexo(sexo);
        somaNotasTotal = lerNotas(sexo, nota, somaNotasHomens, somaNotasTotal, qtdHomens);
        lerIdade(idade, sexo, nota, somaNotasTotal, idadeMulherJovem, notaMulherJovem, mulheres50anos);
        mediaNotasHomens = calcMediaNotasHomens(sexo, nota, qtdHomens, somaNotasHomens, mediaNotasHomens);
        notaMulherJovem = calcMulherJovem(sexo, idade, nota, idadeMulherJovem, notaMulherJovem);
        mulheres50anos = calcMulherMaisVelha(sexo, idade, nota, somaNotasTotal, mulheres50anos);

        escreverDados(somaNotasHomens, somaNotasTotal, notaMulherJovem, mulheres50anos, qtdHomens, mediaNotasHomens);
    }

    private void lerSexo(int sexo[]){
        for (int contador1 = 0; contador1 < sexo.length; contador1++) {
            System.out.print("Sexo pessoa "+ (contador1 + 1) + " (1-feminino, 2-masculino): ");
            sexo[contador1] = teclado.nextInt();
        }
        
        System.out.println("----------------------------------------");
    }

    private double lerNotas(int sexo[], double nota[], double somaNotasHomens, double somaNotasTotal, double qtdHomens){
        for (int contador2 = 0; contador2 < nota.length; contador2++) {
            System.out.print("Nota pessoa "+ (contador2 + 1) + " (0 à 10): ");
            nota[contador2] = teclado.nextInt();
            somaNotasTotal = somaNotasTotal + nota[contador2];
        }
        System.out.println("----------------------------------------");
        return somaNotasTotal;
    }

    private double calcMediaNotasHomens(int sexo[], double nota[], int qtdHomens, double somaNotasHomens, double mediaNotasHomens){
        for (int i = 0; i < sexo.length; i++) {
            if (sexo[i] == 2){
                somaNotasHomens = somaNotasHomens + nota[i];
                qtdHomens = qtdHomens + 1;
            }
        }
        mediaNotasHomens = somaNotasHomens/qtdHomens;
        return mediaNotasHomens;
    }

    private void lerIdade(int idade[], int sexo[], double nota[], double somaNotasTotal, double idadeMulherJovem, double notaMulherJovem, double mulheres50anos){
        for (int contador3 = 0; contador3 < idade.length; contador3++) {
            System.out.print("Idade pessoa "+ (contador3 + 1) + ": ");
            idade[contador3] = teclado.nextInt();
        }

        System.out.println("----------------------------------------");
    }

    private double calcMulherJovem(int sexo[], int idade[], double nota[], double idadeMulherJovem, double notaMulherJovem){
        for (int contador3 = 0; contador3 < idade.length; contador3++) {
            if (idadeMulherJovem == 0 && sexo[contador3] == 1){
                idadeMulherJovem = idade[contador3];
            }
            if (sexo[contador3] == 1 && idade[contador3] <= idadeMulherJovem){
                idadeMulherJovem = idade[contador3];
                notaMulherJovem = nota[contador3];
            }
        }
        return notaMulherJovem;
    }

    private int calcMulherMaisVelha(int sexo[], int idade[], double nota[], double somaNotasTotal, int mulheres50anos){
        for (int contador3 = 0; contador3 < idade.length; contador3++) {
            if (idade[contador3] > 50 && sexo[contador3] == 1 && (somaNotasTotal / 30) < nota[contador3]){
                mulheres50anos = mulheres50anos + 1;
            }
        }
        return mulheres50anos;
    }

    private void escreverDados(double somaNotasHomens, double somaNotasTotal, double notaMulherJovem, int mulheres50anos, double qtdHomens, double mediaNotasHomens){
        System.out.print("- nota média recebida pelo cinema: ");
        System.out.println(somaNotasTotal/30);
        System.out.print("- nota média atribuída pelos homens: ");
        System.out.println(mediaNotasHomens);
        System.out.print("- nota atribuída pela mulher mais jovem: ");
        System.out.println(notaMulherJovem);
        System.out.print("- mulheres com mais de 50 anos deram nota superior a média: ");
        System.out.println(mulheres50anos);
    }

    public static void main(String[] args) {
        new Uni6Exe09();        
    }
}
