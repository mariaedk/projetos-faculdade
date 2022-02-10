import java.util.Scanner;

public class Uni5Exe15 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Name: ");
        String name = reader.next();
        float test1, test2;
        while (!"fim".equals(name)){
            System.out.print("First grade: ");
            test1 = reader.nextFloat();
            System.out.print("Second grade: ");
            test2 = reader.nextFloat();
            System.out.println("Name: " + name + " ------ Final grade: " + (test1 + test2) / 2);
            name = reader.next();
        }
        reader.close();
    }
}
