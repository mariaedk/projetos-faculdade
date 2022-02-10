import java.time.LocalDate;
import java.util.ArrayList;

public class Transatlantico extends Embarcacao
{
	private String nome;
	private LocalDate dataInauguracao;
	private ArrayList<BoteSalvaVidas> botes = new ArrayList<>();
	
	public Transatlantico(String registroCapitania, int qtdePessoas, String nome, LocalDate dataInauguracao) 
	{
		super(registroCapitania, qtdePessoas);
		
		this.setNome(nome);
		this.setDataInauguracao(dataInauguracao);
	}

	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		if (nome != null && nome.length() != 0)
		{
			this.nome = nome;			
		}
	}
	public LocalDate getDataInauguracao() 
	{
		return dataInauguracao;
	}
	public void setDataInauguracao(LocalDate dataInauguracao) 
	{
		if (dataInauguracao != null)
		{
			this.dataInauguracao = dataInauguracao;
		}
	}

	
	public void addBote(BoteSalvaVidas bote)
	{
		if (bote != null)
		{
			this.botes.add(bote);			
		}
		else
		{
			throw new IllegalArgumentException("Não pode ser nulo!");
		}
	}
	
	public void addBote(String nroReg, int qtdPessoas, boolean inflavel, int qtdRemos, int qtdColetes)
	{
		BoteSalvaVidas bote = new BoteSalvaVidas(nroReg, qtdPessoas, inflavel, qtdRemos, qtdColetes);
		botes.add(bote);
	}
	
	@Override
	public String verificaSeguranca() {
		
		int soma = 0;
		for (BoteSalvaVidas bote : botes)
		{
			soma = soma + bote.getQtdePessoas();
		}
		
		if (soma >= this.getQtdePessoas())
		{
			return "Está em condições adequadas de segurança";
		}
		else
		{
			if (this.getDataInauguracao().isAfter(LocalDate.now()))
			{
				return "ALERTA! Navio necessitando de mais botes!";
			}
			else if (this.getDataInauguracao().isBefore(LocalDate.now()))
			{
				return "CUIDADO: navio em perigo!";
			}
		}
		
		return null;
	}
	
	
}
