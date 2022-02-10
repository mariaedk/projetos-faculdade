import java.util.Scanner;

public class Uni5Exe21 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int year = 0;
        double chico = 1.5, ze = 1.1;
        while (ze < chico){
            chico = chico + 0.02;
            ze = ze + 0.03;
            year = year + 1;
        }
        System.out.println("Chico's current height: " + chico);
        System.out.println("Zé's current height: " + ze);
        System.out.println("Time taken: " + year + " years.");
        reader.close();
    }
}
