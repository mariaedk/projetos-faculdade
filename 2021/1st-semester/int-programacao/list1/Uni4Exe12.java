import java.util.Scanner;

public class Uni4Exe12 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Inputs
        System.out.print("- Please inform the first size: ");
        double size1 = reader.nextDouble();
        System.out.println();

        System.out.print("- Please inform the second size: ");
        double size2 = reader.nextDouble();
        System.out.println();

        System.out.print("- Please inform the third size: ");
        double size3 = reader.nextDouble();
        System.out.println();

        // Process
        if ((size1 < size2 + size3) && (size2 < size1 + size3) && (size3 < size2 + size1)){
            if (size1 == size2 && size2 == size3 && size3 == size1){
                System.out.print("Equilateral triangle.");
            } else {
                if (size1 == size2 || size3 == size1 || size2 == size3){
                    System.out.print("Isosceles triangle.");
                } else {
                    if (size1 != size2 && size2 != size3 && size1 != size3){
                        System.out.print("Scalene triangle.");
                    }
                }
            }
        } else{
            System.out.print("Invalid sizes.");
        }
        reader.close();
    }
}
