import java.util.Scanner;

public class Uni4Exe27 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        
        // Entrada
        System.out.print("Horas / Minutos de entrada: ");
        int horasEntrada = teclado.nextInt();
        int minutosEntrada = teclado.nextInt();

        System.out.print("Horas / Minutos de saída: ");
        int horasSaida = teclado.nextInt();
        int minutosSaida = teclado.nextInt();

        // Para descobrir horas:
        int horasEstacionamento = horasSaida - horasEntrada;

        int minutosEstacionamento;
        double valorPagar = 0;
        

        if ( minutosEntrada > minutosSaida ) {
            
            // Para descobrir minutos:
            minutosEstacionamento = (minutosSaida + 60) - minutosEntrada;

            if ( horasEstacionamento <= 24 && horasEstacionamento <= -24 ) {
                if ( horasEntrada > horasSaida ) {
                    // A pessoa saiu no dia seguinte.
                    horasEstacionamento = (horasSaida + 23) - horasEntrada;
                    if ( minutosEstacionamento <= 29 && horasEstacionamento > 0 ) {
                        switch ( horasEstacionamento ) {

                        case 1: valorPagar = 5; break;
                        case 2: valorPagar = 10; break;
                        case 3: valorPagar = 17.50; break;
                        case 4: valorPagar = 25; break;
                        case 5: valorPagar = 35; break;
                        default: valorPagar = 35 + ( horasEstacionamento - 5) * 10;
                        }
                    } else if ( minutosEstacionamento <= 30 && horasEstacionamento == 0 || minutosEstacionamento > 30 && horasEstacionamento == 0 ) {
                        valorPagar = 5;

                    } else if ( minutosEstacionamento > 30 && horasEstacionamento > 0 ) {
                        horasEstacionamento++;
                        switch ( horasEstacionamento ) {

                            case 1: valorPagar = 5; break;
                            case 2: valorPagar = 10; break;
                            case 3: valorPagar = 17.50; break;
                            case 4: valorPagar = 25; break;
                            case 5: valorPagar = 35; break;
                            default: valorPagar = 35 + (horasEstacionamento - 5) * 10;
                        }
                    } 
                } else if ( horasSaida > horasEntrada ) {

                    if ( minutosEstacionamento <= 29 && horasEstacionamento > 0  ) {
                        switch ( horasEstacionamento ) {

                            case 1: valorPagar = 5; break;
                            case 2: valorPagar = 10; break;
                            case 3: valorPagar = 17.50; break;
                            case 4: valorPagar = 25; break;
                            case 5: valorPagar = 35; break;
                            default: valorPagar = 35 + ( horasEstacionamento - 5) * 10;
                            }
                    } else if ( minutosEstacionamento <= 30 && horasEstacionamento == 0 || minutosEstacionamento > 30 && horasEstacionamento == 0 ) {
                        valorPagar = 5;
                        
                    } else if ( minutosEstacionamento > 30 && horasEstacionamento > 0 ) {
                        switch ( horasEstacionamento ) {

                            case 1: valorPagar = 5; break;
                            case 2: valorPagar = 10; break;
                            case 3: valorPagar = 17.50; break;
                            case 4: valorPagar = 25; break;
                            case 5: valorPagar = 35; break;
                            default: valorPagar = 35 + (horasEstacionamento - 5) * 10;
                        }
                    } 
            } else if ( horasEstacionamento > 24 || horasEstacionamento >= -24 ) {
                System.out.print("Entradas inválidas.");
            } else {
                System.out.print(valorPagar);
            }
        }

        } else if ( minutosSaida >= minutosEntrada ) {
            if ( horasEstacionamento <= 24 && horasEstacionamento <= -24 ) {
                // Para descobrir minutos:
                minutosEstacionamento = minutosSaida - minutosEntrada;

                if ( horasEntrada > horasSaida ) {
                    // A pessoa saiu no dia seguinte.
                    horasSaida = horasSaida + 24;
                    horasEstacionamento = horasSaida - horasEntrada;

                    if ( horasSaida == horasEntrada){
                        valorPagar = 0;
                    } else if ( minutosEstacionamento <= 29 && horasEstacionamento > 0 ) {
                        switch ( horasEstacionamento ) {

                            case 1: valorPagar = 5; break;
                            case 2: valorPagar = 10; break;
                            case 3: valorPagar = 17.50; break;
                            case 4: valorPagar = 25; break;
                            case 5: valorPagar = 35; break; 
                            default: valorPagar = 35 + (horasEstacionamento - 5) * 10;
                        }
                    
                    } else if ( minutosEstacionamento <= 30 && horasEstacionamento == 0 || minutosEstacionamento > 30 && horasEstacionamento == 0 ) {
                        valorPagar = 5;

                    } else if ( minutosEstacionamento >= 30 && horasEstacionamento > 0 ) {
                        horasEstacionamento++;
                        switch ( horasEstacionamento ) {

                            case 1: valorPagar = 5; break;
                            case 2: valorPagar = 10; break;
                            case 3: valorPagar = 17.50; break;
                            case 4: valorPagar = 25; break;
                            case 5: valorPagar = 35;  break; 
                            default: valorPagar = 35 + (horasEstacionamento - 5) * 10;
                        } 
                    } 
                } else if ( horasSaida >= horasEntrada ) {

                    if ( horasEntrada + 24 == horasSaida || horasEntrada == horasSaida){
                        valorPagar = 0;

                    } else if ( minutosEstacionamento <= 29 && horasEstacionamento > 0 ) {
                        switch ( horasEstacionamento ) {
                            
                            case 1: valorPagar = 5; break;
                            case 2: valorPagar = 10; break;
                            case 3: valorPagar = 17.50; break;
                            case 4: valorPagar = 25; break;
                            case 5: valorPagar = 35; break;
                            default: valorPagar = 35 + (horasEstacionamento - 5) * 10;
                        }
                    } else if ( minutosEstacionamento <= 30 && horasEstacionamento == 0 || minutosEstacionamento > 30 && horasEstacionamento == 0) {
                        valorPagar = 5;

                    } else if ( minutosEstacionamento > 30 && horasEstacionamento > 0 ) {
                        horasEstacionamento++;
                        switch ( horasEstacionamento ) {

                            case 1: valorPagar = 5; break;
                            case 2: valorPagar = 10; break;
                            case 3: valorPagar = 17.50; break;
                            case 4: valorPagar = 25; break;
                            case 5: valorPagar = 35; break;
                            default: valorPagar = 35 + (horasEstacionamento - 5) * 10;
                        }
                    }
                }
            } else if ( horasEstacionamento > 24 || horasEstacionamento >= -24 ) {
                System.out.print("Entrada de dados inválida. ");
            } else {
                System.out.print(valorPagar);
            }
        }
        teclado.close();
    }    
}