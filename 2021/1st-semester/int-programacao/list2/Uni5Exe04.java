public class Uni5Exe04 {
    public static void main(String[] args) throws Exception {
        double numerador = 3;
        double denominador = 2;
        double somador = 2;
        double s = 1.5;

        for (int counter = 1; counter < 20; counter++){
            somador = somador + 2;
            denominador+=somador;
            numerador = numerador + 2;
            s = s + (numerador / (denominador));
        } 
        System.out.print(s);
    }
}
