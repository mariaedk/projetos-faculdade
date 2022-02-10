import java.util.ArrayList;

public class Partido {
	private String nome;
	private int numero;
	private ArrayList<Vereador> vereadores = new ArrayList<Vereador>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero >= 10 && numero < 100) {
			this.numero = numero;
		}
	}

	public ArrayList<Vereador> getVereadores() {
		return (ArrayList<Vereador>) this.vereadores.clone();
	}

	public void addVereador(Vereador vereador) {
		this.vereadores.add(vereador);
		vereador.setPartido(this);
	}

	public double getMediaDesempenho() {
		double soma = 0;
		for (int i = 0; i < this.vereadores.size(); i++)
			soma += this.vereadores.get(i).getDesempenho();
		return soma / this.vereadores.size();
	}

	public int getTotalProjetosApresentados() {
		int total = 0;
		for (int i = 0; i < this.vereadores.size(); i++) {
			total += this.vereadores.get(i).getProjetos();
		}
		return total;
	}

	public int getTotalProjetosAprovados() {
		int total = 0;
		for (Vereador v: this.vereadores) {
			total += v.getProjetosAprovados();
		}
		return total;
	}

	public int getQtdVereadores() {
		return this.vereadores.size();
	}
}