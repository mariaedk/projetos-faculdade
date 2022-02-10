import java.time.LocalDate;

public class ProjetoDeLeiComplementar extends ProjetoDeLei {
	private int artigoLO;
	private int qtdVotosFavoraveis;
	
	public ProjetoDeLeiComplementar(String titulo, LocalDate dataApresentacao, String dataAprovacao, int numeroProjeto, int artigoLO, int qtdVotosFavoraveis) {
		super(titulo, dataApresentacao, dataAprovacao, numeroProjeto);
		this.setArtigoLO(artigoLO);
		this.setQtdVotosFavoraveis(qtdVotosFavoraveis);
	}
	
	public int getArtigoLO() {
		return artigoLO;
	}
	
	public void setArtigoLO(int artigoLO) {
		if (artigoLO > 0)
			this.artigoLO = artigoLO;
		else
			throw new IllegalArgumentException("Número do artigo deve ser maior que zero.");
	}
	
	public int getQtdVotosFavoraveis() {
		return qtdVotosFavoraveis;
	}

	public void setQtdVotosFavoraveis(int qtdVotosFavoraveis) {
		if (qtdVotosFavoraveis >= 0)
		{
			if (this.getDataAprovacao() == null)
				throw new IllegalArgumentException("É necessário ter uma data de aprovação para que se possa ser informado a quantidade de votos favoráveis.");
			else
				this.qtdVotosFavoraveis = qtdVotosFavoraveis;
		}
		else
			throw new IllegalArgumentException("Quantidade de votos favoráveis não pode ser negativa.");
	}
	
	public String mostrar() {
		String informacao = super.mostrar();
		
		informacao += "\nArtigo LO: " + this.getArtigoLO();
		informacao += "\nQtd Votos Favoráveis: " + this.getQtdVotosFavoraveis();
		
		return informacao;
	}
}