package org.example;

import java.util.*;

public class Trabalho1 {

    public static void main(String[] args) {
       List<List<Ponto>> coordenadasPorGaleria = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);

       // Ler todas as coordenadas de todos os polígonos
       while (true) {
            int numeroPontosGaleria = scanner.nextInt();
            if (numeroPontosGaleria < 3 || numeroPontosGaleria > 50) {
                break;
            }
            List<Ponto> coordenadasPonto = new ArrayList<>();
            for (int i = 0; i < numeroPontosGaleria; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (x < 0 || y < 0 || x > 1000 || y > 1000) {
                    break;
                }
                coordenadasPonto.add(new Ponto(x, y));
            }
            if (!coordenadasPonto.isEmpty()) {
                coordenadasPorGaleria.add(new ArrayList<>(coordenadasPonto));
            }
       }
       List<String> respostas = new ArrayList<>();
       for (List<Ponto> coordenadas : coordenadasPorGaleria) {
            boolean resposta = isPoligonoConvexo(coordenadas);
            if (resposta) {
                respostas.add("No");
            } else {
                respostas.add("Yes");
            }
       }
       // imprimir as respostas do console
       for (String resposta : respostas) {
            System.out.println(resposta);
       }
       scanner.close();
    }

    private static boolean isPoligonoConvexo(List<Ponto> coordenadas) {
        Double sentido = null;
        if (coordenadas.isEmpty()) {
            return false;
        }
        if (coordenadas.size() == 3) { // triângulos são convexos
            return true;
        } else if (coordenadas.size() > 3) {
            // processar todos os 3 pontos consecutivos do polígono
            for (int i = 0; i < coordenadas.size(); i++) {
                double produtoVetorial = getProdutoVetorial(coordenadas, i);
                if (sentido == null) {
                    sentido = produtoVetorial;
                }
                // se estiver no sentido da esquerda e houver uma mudança para a direita
                if (sentido > 0 && produtoVetorial < 0) {
                    return false;
                }
                // se estiver no sentindo da direita e houver uma mudança para a direita
                if (sentido < 0 && produtoVetorial > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static double getProdutoVetorial(List<Ponto> coordenadas, int i) {
        Ponto ponto1 = coordenadas.get(i);
        // subtrai para garantir que esteja dentro do tamanho da lista
        Ponto ponto2 = coordenadas.get((i + 1 < coordenadas.size() ? i + 1 : i + 1 - coordenadas.size()));
        Ponto ponto3 = coordenadas.get((i + 2 < coordenadas.size() ? i + 2 : i + 2 - coordenadas.size()));

        return (ponto2.getX() - ponto1.getX()) * (ponto3.getY() - ponto1.getY()) - (ponto2.getY() - ponto1.getY()) * (ponto3.getX() - ponto1.getX());
    }

    public static class Ponto {
        private final int x;
        private final int y;

        public Ponto(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
}