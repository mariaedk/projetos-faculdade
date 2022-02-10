public class BoteSalvaVidas extends Embarcacao {
	private boolean inflavel;
	private int qtdeRemos;
	private int qtdeColetes;

	public BoteSalvaVidas(String registroCapitania, int qtdePessoas, boolean inflavel, int qtdeRemos, int qtdeColetes) {
		super(registroCapitania, qtdePessoas);
		this.setInflavel(inflavel);
		this.setQtdeRemos(qtdeRemos);
		this.setQtdeColetes(qtdeColetes);
	}

	public boolean isInflavel() {
		return inflavel;
	}

	public void setInflavel(boolean inflavel) {
		this.inflavel = inflavel;
	}

	public int getQtdeRemos() {
		return qtdeRemos;
	}

	public void setQtdeRemos(int qtdeRemos) {
		if (qtdeRemos >= 1) {
			this.qtdeRemos = qtdeRemos;
		} else {
			throw new IllegalArgumentException("O bote salva vidas deve ter 1 ou mais remos");
		}
	}

	public int getQtdeColetes() {
		return qtdeColetes;
	}

	public void setQtdeColetes(int qtdeColetes) {
		if (qtdeColetes > 0) {
			this.qtdeColetes = qtdeColetes;
		} else {
			throw new IllegalArgumentException("O bote salva vidas deve ter 1 ou mais remos");
		}
	}

	public String verificaSeguranca() {
		if (this.qtdeColetes >= this.getQtdePessoas()) {
			return "Bote OK!";
		} else {
			return "Insuficiência de " + (getQtdePessoas() - this.qtdeColetes) + " coletes salva-vidas";
		}
	}
}