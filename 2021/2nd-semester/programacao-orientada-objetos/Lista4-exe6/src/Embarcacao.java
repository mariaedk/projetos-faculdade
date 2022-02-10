public abstract class Embarcacao implements AtivoEmRisco {
	private String registroCapitania;
	private int qtdePessoas;

	public Embarcacao(String registroCapitania, int qtdePessoas) {
		this.setRegistroCapitania(registroCapitania);
		this.setQtdePessoas(qtdePessoas);
	}

	public String getRegistroCapitania() {
		return registroCapitania;
	}

	public void setRegistroCapitania(String registroCapitania) {
		this.registroCapitania = registroCapitania;
	}

	public int getQtdePessoas() {
		return qtdePessoas;
	}

	public void setQtdePessoas(int qtdePessoas) {
		if (qtdePessoas > 0) {
			this.qtdePessoas = qtdePessoas;
		}
	}

}