
public class Avaliacao {
	private int qtdPagantes;
	private String opiniaoGeral;
	
	public Avaliacao(int qtdPagantes, String opiniaoGeral)
	{
		this.setQtdPagantes(qtdPagantes);
		this.setOpiniaoGeral(opiniaoGeral);
	}
	
	public int getQtdPagantes() {
		return qtdPagantes;
	}
	public void setQtdPagantes(int qtdPagantes) {
		if (qtdPagantes > 0) {
			this.qtdPagantes = qtdPagantes;
		}
		else
		{
			throw new IllegalArgumentException("Quantidade de pagantes inválida.");
		}
	}
	public String getOpiniaoGeral() {
		return opiniaoGeral;
	}
	public void setOpiniaoGeral(String opiniaoGeral) {
		if (opiniaoGeral != null) {
			this.opiniaoGeral = opiniaoGeral;		
		}
	}
}
