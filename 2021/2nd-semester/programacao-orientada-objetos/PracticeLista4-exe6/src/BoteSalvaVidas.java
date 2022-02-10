
public class BoteSalvaVidas extends Embarcacao
{
	private boolean inflavel;
	private int qtdeRemos;
	private int qtdeColetes;

	public BoteSalvaVidas(String registroCapitania, int qtdePessoas, boolean inflavel, int qtdeRemos, int qtdeColetes) 
	{
		super(registroCapitania, qtdePessoas);
		this.setInflavel(inflavel);
		this.setQtdeColetes(qtdeColetes);
		this.setQtdeRemos(qtdeRemos);
	}

	public boolean isInflavel() 
	{
		return inflavel;
	}

	public void setInflavel(boolean inflavel) 
	{
		this.inflavel = inflavel;
	}

	public int getQtdeRemos() 
	{
		return qtdeRemos;
	}

	public void setQtdeRemos(int qtdeRemos) 
	{
		if (qtdeRemos >= 1)
		{
			this.qtdeRemos = qtdeRemos;			
		}
		else
		{
			throw new IllegalArgumentException("Número de remos deve ser maior que 1.");
		}
	}

	public int getQtdeColetes() 
	{
		return qtdeColetes;
	}

	public void setQtdeColetes(int qtdeColetes) {
		if (qtdeColetes > 0)
		{
			this.qtdeColetes = qtdeColetes;			
		}
		else
		{
			throw new IllegalArgumentException("Número de coletes deve ser maior que 0.");
		}
	}

	@Override
	public String verificaSeguranca() 
	{
		if (this.getQtdeColetes() >= this.getQtdePessoas())
		{
			return "Bote OK!";
		}
		else
		{
			return "Insuficiência de " + (this.getQtdePessoas() - this.getQtdeColetes()) + " coletes salva-vidas";
		}
	}
}
