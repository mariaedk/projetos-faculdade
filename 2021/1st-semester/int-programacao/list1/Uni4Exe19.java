import java.util.Scanner;

public class Uni4Exe19 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        System.out.print("- Informe a coordenada de X: ");
        double X = reader.nextDouble();

        System.out.print("- Informe a coordenada de Y: ");
        double Y = reader.nextDouble();

        if ((X == 0) && (Y == 0)){
            System.out.print("Não está em nenhum quadrante, por tanto, 0.");
        } else if ((X > 0) && (Y > 0)){
            System.out.print("Está no quadrante 1.");
        } else if ((X > 0) && (Y < 0)){
            System.out.print("Está no quadrante 2.");
        } else if ((X < 0) && (Y < 0)){
            System.out.print("Está no quadrante 3.");
        } else if ((X < 0) && (Y > 0)){
            System.out.print("Está no quadrante 4.");
        }
        reader.close(); 
    }
}
