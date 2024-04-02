package org.example;

import java.util.Scanner;
/**
 * @author maria eduarda krutzsch
 * @author luan lavandoski guarnieri
 */
public class CifraCercaFerroviaria {
    // a coluna sempre contínua até o fim
    // as linhas do 0 até o limite (qtd de linhas) e depois do qtd de linhas até 0 (inverte)

    public CifraCercaFerroviaria() {
        String texto = new Scanner(System.in).nextLine();
        int trilhos =  new Scanner(System.in).nextInt();

        String criptografada = this.criptografarMsg(texto.toUpperCase(), trilhos);
        System.out.printf("Mensagem criptogradafa: %s \n", criptografada);
        System.out.printf("Mensagem descriptografada: %s", this.descripMsg(criptografada, trilhos));
    }

    // Função para criptografar uma mensagem
    private String criptografarMsg(String texto, int trilhos) {
        texto = texto.replaceAll(" ", "");
        boolean descer = false;
        int linha = 0, coluna = 0;

        // Criar a matriz para cifrar o texto plano
        char[][] trilho = new char[trilhos][texto.length()];

        // Preencher a matriz para distinguir espaços preenchidos de espaços em branco
        for (int i = 0; i < trilhos; i++) {
            for (int j = 0; j < texto.length(); j++) {
                trilho[i][j] = '\n';
            }
        }

        for (int i = 0; i < texto.length(); i++) {
            //faz o controle
            if (linha == 0 || linha == trilhos - 1) {
                descer = !descer;
            }

            trilho[linha][coluna++] = texto.charAt(i);

            //validar a prox linha
            linha += descer ? 1 : -1;
        }

        //Criptografa
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < trilhos; i++) {
            for (int j = 0; j < texto.length(); j++) {
                if (trilho[i][j] != '\n') {
                    resultado.append(trilho[i][j]);
                }
            }
        }

        return resultado.toString();
    }

    // Função para descriptografar uma mensagem
    private String descripMsg(String cifra, int trilhos) {
        cifra = cifra.replaceAll(" ", "");
        boolean descer = false;
        int linha = 0, coluna = 0;

        // Criar a matriz para cifrar o texto plano
        char[][] trilho = new char[trilhos][cifra.length()];

        // Preencher a matriz trilho para distinguir espaços preenchidos
        // de espaços em branco
        for (int i = 0; i < trilhos; i++) {
            for (int j = 0; j < cifra.length(); j++) {
                trilho[i][j] = '\n';
            }
        }

        // Marcar os lugares com '*'
        for (int i = 0; i < cifra.length(); i++) {
            // Verificar a direção do fluxo
            if (linha == 0) {
                descer = true;
            }
            if (linha == trilhos - 1) {
                descer = false;
            }

            // Colocar o marcador
            trilho[linha][coluna++] = '*';

            // Encontrar a próxima linha usando a sinalização de direção
            linha += descer ? 1 : -1;
        }

        //Preenche a matriz com os valores
        int indice = 0;
        for (int i = 0; i < trilhos; i++) {
            for (int j = 0; j < cifra.length(); j++) {
                if (trilho[i][j] == '*' && indice < cifra.length()) {
                    trilho[i][j] = cifra.charAt(indice++);
                }
            }
        }

        StringBuilder resultado = new StringBuilder();

        linha = 0;
        coluna = 0;
        for (int i = 0; i < cifra.length(); i++) {
            // Verificar a direção do fluxo
            if (linha == 0) {
                descer = true;
            }
            if (linha == trilhos - 1) {
                descer = false;
            }

            // Colocar o marcador
            if (trilho[linha][coluna] != '*') {
                resultado.append(trilho[linha][coluna++]);
            }

            // Encontrar a próxima linha usando a sinalização de direção
            linha += descer ? 1 : -1;
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        new CifraCercaFerroviaria();
    }
}
