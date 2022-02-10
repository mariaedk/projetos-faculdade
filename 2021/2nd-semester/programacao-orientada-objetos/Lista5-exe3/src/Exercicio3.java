import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;
import java.util.Vector;

public class Exercicio3 {

	private static final int QUANTIDADE_VALORES = 100_000;
	private static final int VALOR_FIXO = 10_000_001;
	private static StringBuffer resultado = new StringBuffer();

	public static void main(String[] args) {

		long ultimoNanoTime = System.nanoTime();
		int[] vetor = criarVetor();
		resultado.append("Tempo para criação do vetor: ")
				.append(String.format("%,16d%n", System.nanoTime() - ultimoNanoTime)).append("\n");
		Collection[] colecoes = { new ArrayDeque<>(), new ArrayList<>(), new HashSet<>(), new LinkedHashSet<>(),
				new LinkedList<>(), new PriorityQueue<>(), new TreeSet<>(), new Vector<>() };

		for (Collection colecao : colecoes) {
			resultado.append("------- Iniciando operações com ").append(colecao.getClass().getName())
					.append(" ---------\n");
			realizarOperacoes(vetor, colecao);
			resultado.append("------- Fim das operações com ").append(colecao.getClass().getName())
					.append(" ---------\n\n");
		}

		System.out.println(resultado);
	}

	private static void realizarOperacoes(int[] vetor, Collection<Integer> colecao) {
		long tempo, ultimoNanoTime = System.nanoTime();
		for (int i = 0; i < vetor.length; i++) {
			colecao.add(vetor[i]);
		}
		tempo = System.nanoTime() - ultimoNanoTime;

		resultado.append(" Tempo para inserção: ").append(String.format("%,16d%n", tempo));
		resultado.append("\n Quantidade inserida: ").append(colecao.size());

		resultado.append("\n Buscando objeto valor " + VALOR_FIXO + " - por iterator ...\n");
		Iterator<Integer> iterator = colecao.iterator();
		ultimoNanoTime = System.nanoTime();
		while (iterator.hasNext()) {
			if (iterator.next().equals(VALOR_FIXO)) {
				break;
			}
		}
		tempo = System.nanoTime() - ultimoNanoTime;
		resultado.append(" Tempo para busca do objeto valor " + VALOR_FIXO + " - por iterator: ")
				.append(String.format("%,16d%n", tempo));

		resultado.append("\n Buscando objeto valor 99.000.000 - por contains ...\n");
		ultimoNanoTime = System.nanoTime();
		colecao.contains(99000000);
		tempo = System.nanoTime() - ultimoNanoTime;
		resultado.append(" Tempo para busca do objeto valor 99.000.000 - por contains: ")
				.append(String.format("%,16d%n", tempo));

		resultado.append("\n Removendo objetos...");
		ultimoNanoTime = System.nanoTime();
		boolean isRemover = true;
		iterator = colecao.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			if (isRemover) {
				iterator.remove();
			}
			isRemover = !isRemover;
		}
		tempo = System.nanoTime() - ultimoNanoTime;
		resultado.append("\n Tempo para remo��o dos objetos...").append(String.format("%,16d%n", tempo));
		resultado.append("\n Quantidade que sobrou: ").append(colecao.size()).append("\n");

	}

	private static int[] criarVetor() {
		int[] vetor = new int[QUANTIDADE_VALORES];
		Random random = new Random();
		for (int i = 0; i < QUANTIDADE_VALORES - 1; i++) {
			vetor[i] = random.nextInt(VALOR_FIXO);
		}
		vetor[QUANTIDADE_VALORES - 1] = VALOR_FIXO;
		return vetor;
	}

}