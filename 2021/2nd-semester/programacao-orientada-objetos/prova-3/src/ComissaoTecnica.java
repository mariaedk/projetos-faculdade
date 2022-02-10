import java.time.LocalDate;
import java.util.Random;
import fifa.Condition;

// Maria Eduarda Krutzsch e Maria Eduarda de Sousa
public class ComissaoTecnica extends Membro
{
	private String funcao;

	public ComissaoTecnica(String n, String a, LocalDate d, String f) {
		super(n, a, d);
		this.setFuncao(f);
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public char getGrauHidratacao()
	{
		if (this.getTemperatura() < 37 && this.getHidratacao() > 90)
		{
			return 'H';
		}
		else if (this.getTemperatura() > 37.3 || this.getHidratacao() < 85)
		{
			return 'D';
		}
		else
		{
			return 'E';
		}
	}
	
	public void go(Condition c)
	{
		Random random = new Random();
		int valorAleatorio = random.nextInt(10);
		
		if (valorAleatorio == 10 || valorAleatorio == 9)
		{
			this.setTemperatura(this.getTemperatura() - 0.1);
			if (c == Condition.MATCH)
			{
				this.setHidratacao(this.getHidratacao() + 2);
			}
			else if (c == Condition.TRAINING)
			{
				this.setHidratacao(this.getHidratacao() + 1);
			}
		}
		else if (valorAleatorio == 7 || valorAleatorio == 8)
		{
			this.setTemperatura(this.getTemperatura() + 0.1);
			if (c == Condition.MATCH)
			{
				this.setHidratacao(this.getHidratacao() - 3);
			}
			else if (c == Condition.TRAINING)
			{
				this.setHidratacao(this.getHidratacao() - 1);
			}
		}
	}
}
