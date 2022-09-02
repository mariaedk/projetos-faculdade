// Maria Eduarda Krutzsch
import java.util.ArrayList;
import java.util.Collections;

public class Grafo 
{

    public static String tipoDoGrafo(int matrizAdjacencia[][]) 
    {

        return "Dirigido, simples, não é regular, não é completo, não é nulo, e não é bipartido";
    }

    public static String arestasDoGrafo(int matrizAdjacencia[][]) 
    {
        ArrayList<String> arestas = new ArrayList<>();
        int qtdArestas = 0;
        for (int i = 0; i < matrizAdjacencia.length; i++) 
        {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) 
            {
               if (matrizAdjacencia[i][j] == 1)
               {
                    arestas.add(String.valueOf((char)(i + 'A')) + String.valueOf((char)(j + 'A')));
                    qtdArestas++;
               }
            }
        }
        return "Quantidade de arestas: " + String.valueOf(qtdArestas) + ". Conjunto de arestas: " + arestas.toString();
    }

    public static String grausDoVertice(int matrizAdjacencia[][]) 
    {
        ArrayList<Integer> grausVertices = new ArrayList<Integer>();
        int grauPorVertice[] = new int[5];
        int grau = 0;
        String resp = "Grau de cade vértice:\n";
        // para cada vértice da matriz
        for (int i = 0; i < matrizAdjacencia.length; i++)
        {
            // para cada coluna da matriz
            for (int j = 0; j < matrizAdjacencia.length; j++) 
            {
                grau += matrizAdjacencia[j][i];
            }
            // para cada linha da matriz
            for (int j = 0; j < matrizAdjacencia.length; j++) 
            {
                grau += matrizAdjacencia[i][j];
            }
            grausVertices.add(grau);
            grauPorVertice[i] = grau;
            grau = 0;
        }
        Collections.sort(grausVertices);
        for (int i = 0; i < grauPorVertice.length; i++)
        {
            resp += String.valueOf((char)(i + 'A')) + ": " + grauPorVertice[i] + "\n";
        }
        return resp + "Sequência de graus: " + grausVertices.toString();
    }

    public static void main(String[] args) 
    {
        int matrizAdjacencia[][] = { {0, 1, 0, 0, 1},
                                     {0, 0, 0, 1, 0},
                                     {0, 1, 0, 1, 0},
                                     {1, 0, 0, 0, 1},
                                     {0, 1, 0, 0, 0} };   
        
        System.out.println("a. "+tipoDoGrafo(matrizAdjacencia));
        System.out.println();
        System.out.println("b. "+arestasDoGrafo(matrizAdjacencia));
        System.out.println();
        System.out.println("c. "+grausDoVertice(matrizAdjacencia));
    }
    
}
