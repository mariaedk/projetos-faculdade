import java.util.ArrayList;
import java.util.HashMap;

public class Camara {
	private HashMap<Integer, Partido> partidos = new HashMap<Integer, Partido>();

	public boolean addPartido(Partido partido) {
		if (this.partidos.containsKey(partido.getNumero())) {
			return false;
		}
		this.partidos.put(partido.getNumero(), partido);
		return true;
	}

	public Partido getPartido(int numero) {
		return this.partidos.get(numero);
	}

	public int getTotalProjetosAprovados() {
		int total = 0;
		for (Partido p : this.partidos.values()) {
			total += p.getTotalProjetosAprovados();
		}
		return total;
	}

	public int getTotalProjetosApresentados() {
		int total = 0;
		for (Partido p : this.partidos.values()) {
			total += p.getTotalProjetosApresentados();
		}
		return total;
	}

	public Vereador getVereadorMaisProjetosAprovados() {
		int maiorQtdProjetosAprovados = Integer.MIN_VALUE;
		Vereador vereadorMaisProjetosAprovados = null;
		for (Partido partido : this.partidos.values()) {
			for (Vereador v : partido.getVereadores()) {
				if (maiorQtdProjetosAprovados < v.getProjetosAprovados()) {
					maiorQtdProjetosAprovados = v.getProjetosAprovados();
					vereadorMaisProjetosAprovados = v;
				}
			}
		}
		return vereadorMaisProjetosAprovados;
	}

	public Vereador getVereadorMenorDesempenho() {
		double menorDesempenho = Double.MAX_VALUE;
		Vereador vereadorMenorDesempenho = null;
		for (Partido partido : this.partidos.values()) {
			for (Vereador v : partido.getVereadores()) {
				if (menorDesempenho > v.getDesempenho()) {
					menorDesempenho = v.getDesempenho();
					vereadorMenorDesempenho = v;
				}
			}
		}
		return vereadorMenorDesempenho;
	}

	public ArrayList<Vereador> getVereadoresAcimaMedia() {
		ArrayList<Vereador> vereadoresAcimaMedia = new ArrayList<>();
		double media = this.getDesempenhoMedio();
		for (Partido partido: this.partidos.values()) {
			for (Vereador vereador : partido.getVereadores()) {
				if (vereador.getDesempenho() > media)
					vereadoresAcimaMedia.add(vereador);
			}
		}
		return vereadoresAcimaMedia;
	}

	public double getDesempenhoMedio() {
		double soma = 0;
		int qtd = 0;

		for (Partido p : this.partidos.values()) {
			soma += (p.getMediaDesempenho() * p.getQtdVereadores());
			qtd += p.getQtdVereadores();
		}

		return soma / qtd;
	}
}