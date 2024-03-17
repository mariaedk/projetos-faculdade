package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Trabalho1 {
    public static void main(String[] args) {

       List<List<Ponto>> coordenadasPorGaleria = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int numeroPontosGaleria = scanner.nextInt();
            if (numeroPontosGaleria == 0) {
                break;
            }
            List<Ponto> coordenadasPonto = new ArrayList<>();
            for (int i = 0; i < numeroPontosGaleria; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                coordenadasPonto.add(new Ponto(x, y));
            }
            if (!coordenadasPonto.isEmpty()) {
                coordenadasPorGaleria.add(new ArrayList<>(coordenadasPonto));
                coordenadasPonto.clear();
            }
        }
        List<String> respostas = new ArrayList<>();
        for (List<Ponto> coordenadas: coordenadasPorGaleria) {
            boolean resposta = isPoligonoConvexo(coordenadas);
            if (resposta) {
                respostas.add("No");
            } else {
                respostas.add("Yes");
            }
        }
        for (String resposta : respostas) {
            System.out.println(resposta);
        }
    }

    private static boolean isPoligonoConvexo(List<Ponto> coordenadas) {
        boolean curvaDireita = false;
        if (!coordenadas.isEmpty()) {
            if (coordenadas.size() == 3) { // triângulos sempre são convexos.
                return true;
            } else if (coordenadas.size() > 3) {
                // processar todos os 3 pontos consecutivos do polígono
                for (int i = 0; i < coordenadas.size(); i++) {
                    double produtoVetorial = getProdutoVetorial(coordenadas, i);

                    if (produtoVetorial < 0.000001) {
                        curvaDireita = true;
                    }
                    // se trocar de sentido
                    // se estiver no sentido da direita e houver uma inversão para a esquerda
                    // ou se estiver no sentido da esquerda e houver uma inversão para a direita
                    // significa que é não convexo.
                    if (curvaDireita && produtoVetorial > 0.000001 || !curvaDireita && produtoVetorial < 0.000001) {
                        return false;
                    }
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

        double produtoVetorial = (ponto2.getX() - ponto1.getX()) * (ponto3.getY() - ponto1.getY()) - (ponto2.getY() - ponto1.getY()) * (ponto3.getX() - ponto1.getX());
        return produtoVetorial;
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