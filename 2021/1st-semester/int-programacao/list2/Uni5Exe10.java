public class Uni5Exe10 {
    public static void main(String[] args) {
        double initial, last, test;
        int number = 0; 

        for (int counter = number; counter <= 99999; counter++){ // Começa a contar números a partir do 0 até 99999.
            initial = (int) number / 100; // Pega os dois primeiros termos.
            last = (int) (number - initial * 100); // Pega os dois últimos termos do número.
            test = Math.pow((initial + last), 2); // faz o cálculo da potência (elevando ao quadrado) somando o dois primeiros termos com os dois últimos termos.
            if (test == number){ // Se a característica de somar dois números e ao elevar a soma ao quadrado for igual ao valor do N, o número possui a característica.
                System.out.println("First number: "+initial+" Second number: "+last);
                System.out.println("Found: "+ number);
                System.out.println("-----------------------------------------");
            }
            number++; // atualiza o valor do numero.
        }
    }
}
