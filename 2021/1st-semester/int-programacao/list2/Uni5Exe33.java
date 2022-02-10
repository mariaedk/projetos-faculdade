import java.util.Scanner;

public class Uni5Exe33 {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    int votos1Cand = 0;
    int votos2Cand = 0;
    int votos3Cand = 0;
    int votos4Cand = 0;
    int votos5Nulos = 0;
    int votos6Branco = 0;
    double votos5NulosPerc = 0;
    double votos6BrancoPerc = 0;
    int totalVotos = 0;

    int voto = 0;
    do {
      System.out.println("Digite o voto: ");
      voto = teclado.nextInt();
      
      switch (voto) {
        case 1: votos1Cand++; break;
        case 2: votos2Cand++; break;
        case 3: votos3Cand++; break;
        case 4: votos4Cand++; break;
        case 5: votos5Nulos++; break;
        case 6: votos6Branco++; break;
        case 0: break;
        default: System.out.println("Opção incorreta"); break;
      }
    } while (voto != 0);
    
    totalVotos = votos1Cand+votos2Cand+votos3Cand+votos4Cand+votos5Nulos+votos6Branco;
    votos5NulosPerc = (votos5Nulos / (double) totalVotos) * 100;
    votos6BrancoPerc = (votos6Branco / (double) totalVotos) * 100;

    System.out.println("Tot. cand1:        " + votos1Cand);
    System.out.println("Tot. cand2:        " + votos2Cand);
    System.out.println("Tot. cand3:        " + votos3Cand);
    System.out.println("Tot. cand4:        " + votos4Cand);
    System.out.println("Tot. nulo:         " + votos5Nulos);
    System.out.println("Tot. branco:       " + votos6Branco);
    System.out.println("Tot. perc. branco: " + votos5NulosPerc);
    System.out.println("Tot. perc. nulo:   " + votos6BrancoPerc);    

    teclado.close();
  }
}