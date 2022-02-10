import java.time.LocalDate;
import java.util.ArrayList;

public class Transatlantico extends Embarcacao {
	private String nome;
	private LocalDate dataInauguracao;
	private ArrayList<BoteSalvaVidas> botes = new ArrayList<BoteSalvaVidas>();

	public Transatlantico(String registroCapitania, int qtdePessoas, String nome, LocalDate dataInauguracao) {
		super(registroCapitania, qtdePessoas);
		this.setNome(nome);
		this.setDataInauguracao(dataInauguracao);
	}

	public void addBote(BoteSalvaVidas b) {
		if (b == null) {
			throw new IllegalArgumentException("Não pode ser nulo!");
		}
		this.botes.add(b);
	}

	public void addBote(String registroCapitania, int qtdePessoas, boolean inflavel, int qtdeRemos, int qtdeColetes) {
		BoteSalvaVidas bote = new BoteSalvaVidas(registroCapitania, qtdePessoas, inflavel, qtdeRemos, qtdeColetes);
		this.botes.add(bote);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome!= null && nome.length() > 5) {
			this.nome = nome;
		} else {
			throw new IllegalArgumentException("O nome precisa ter pelo menos seis caracteres!");
		}
	}

	public LocalDate getDataInauguracao() {
		return dataInauguracao;
	}

	public void setDataInauguracao(LocalDate dataInauguracao) {
		if (dataInauguracao == null) {
			throw new IllegalArgumentException("Data de inauguração não pode ser nula!");
		}
		this.dataInauguracao = dataInauguracao;
	}

	@Override
	public String verificaSeguranca() {
		if (getSomaCapacidadeBotes() >= this.getQtdePessoas()) {
			return "Está em condições adequadas de segurança";
		} else if (dataInauguracao.isBefore(LocalDate.now())) {
			return "CUIDADO: navio em perigo";
		} else {
			return "ALERTA: navio necessitando de mais botes!";
		}
	}

	public int getSomaCapacidadeBotes() {
		int soma = 0;
		for (BoteSalvaVidas bote : botes) {
			soma += bote.getQtdePessoas();
		}
		return soma;
	}

}