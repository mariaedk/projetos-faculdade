
public abstract class Embarcacao implements AtivoEmRisco {
	private String registroCapitania;
	private int qtdePessoas;
	
	public Embarcacao(String registroCapitania, int qtdePessoas) 
	{
		this.setQtdePessoas(qtdePessoas);
		this.setRegistroCapitania(registroCapitania);
	}
	
	public String getRegistroCapitania() 
	{
		return registroCapitania;
	}

	public void setRegistroCapitania(String registroCapitania) 
	{
		if (registroCapitania != null && registroCapitania.length() > 0)
		{
			this.registroCapitania = registroCapitania;
		}
	}

	public int getQtdePessoas() 
	{
		return qtdePessoas;
	}

	public void setQtdePessoas(int qtdePessoas) 
	{
		if (qtdePessoas > 0)
		{
			this.qtdePessoas = qtdePessoas;			
		}
	}
	
	public abstract String verificaSeguranca();
}
