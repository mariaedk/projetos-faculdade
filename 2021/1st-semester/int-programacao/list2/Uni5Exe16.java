import java.util.Scanner;

public class Uni5Exe16 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Height: ");
        double totalMHeight = 0, totalFHeight = 0;
        double height = reader.nextDouble();
        System.out.print("Gender: ");
        char gender = reader.next().charAt(0);
        gender = Character.toUpperCase(gender);
        int women = 0, total = 0;

        while (height != 0){
            if (gender == 'F'){
                totalFHeight = totalFHeight + height;
                women = women + 1;
                total = total + 1;
            } else if (gender == 'M'){
                totalMHeight = totalMHeight + height;
                total = total + 1;
            }
            System.out.print("Height: ");
            height = reader.nextDouble();
            if (height == 0){
                break;
            }
            System.out.print("Gender: ");
            gender = reader.next().charAt(0);
            gender = Character.toUpperCase(gender);
        }
        System.out.println("Female average height: " + totalFHeight / women);
        System.out.print("Total average height: " + (totalMHeight + totalFHeight) / total);
        reader.close();
    }
}
