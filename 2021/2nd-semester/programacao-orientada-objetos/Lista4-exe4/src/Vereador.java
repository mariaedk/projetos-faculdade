import java.util.ArrayList;

public class Vereador {
	private String nome;
	private Partido partido;
	
	private ArrayList<ProjetoDeLei> projetosDeLei = new ArrayList<ProjetoDeLei>(); 

	public Vereador(String nome, Partido partido) {
		this.setNome(nome);
		this.setPartido(partido);
	}
	
	@Override
	public String toString() {
		return getNome();
	}
	
	public ArrayList<ProjetoDeLei> getProjetosDeLei() {
		return (ArrayList<ProjetoDeLei>) this.projetosDeLei.clone();
	}
	
	public double getIndiceTrabalho() {
		if (this.getQtdProjetosApresentados() == 0)
			return 0.0;
		else if (this.getQtdProjetosApresentados() <= 5)
			return 0.8;
		else if (this.getQtdProjetosApresentados() <= 10)
			return 1.0;
		else if (this.getQtdProjetosApresentados() <= 17)
			return 1.08;
		else
			return 1.22;
	}

	public double getDesempenho() {
		if (this.getQtdProjetosApresentados() == 0)
			return 0;
		
		return (this.getQtdProjetosAprovados() / (double) this.getQtdProjetosApresentados()) * getIndiceTrabalho();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public int getQtdProjetosApresentados() {
		return projetosDeLei.size();
	}

	public int getQtdProjetosAprovados() {
		int projetosAprovados = 0;
		for (ProjetoDeLei p: projetosDeLei) {
			if (p.estaAprovado()) {
				projetosAprovados++;
			}
		}
		return projetosAprovados;
	}
	
	public void addProjetoDeLei(ProjetoDeLei projetoDeLei) {
		if (projetoDeLei != null)
		{
			this.projetosDeLei.add(projetoDeLei);
		}
		else
			throw new IllegalArgumentException("Projeto deve ser informado.");
	}
}