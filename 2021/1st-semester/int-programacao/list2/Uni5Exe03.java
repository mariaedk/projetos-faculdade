public class Uni5Exe03 {
    public static void main(String[] args) throws Exception {
        double sum = 0;
        final double numerador = 1;
        for (int counter = 1; counter <= 100; counter++) {
            sum = sum + (numerador / counter);
        }
        System.out.println("Sum: " + sum);
    }
}
