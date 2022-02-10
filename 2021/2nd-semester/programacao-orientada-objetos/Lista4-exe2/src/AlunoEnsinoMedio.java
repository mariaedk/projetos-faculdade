import java.time.LocalDate;

public class AlunoEnsinoMedio extends Aluno {
	private int ano;

	// construtor
	public AlunoEnsinoMedio(String nome, LocalDate date, int ano) {
		super(nome, date);  // fazendo a chamada ao construtor da superclasse (Aluno)
		this.setAno(ano);
	}

	// destrutor
	@Override
	protected void finalize() throws Throwable {
		System.out.println("destrutor de AlunoEnsinoMedio em ação - "+this.getNome());
		super.finalize();
	}	
	
	// métodos
	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		if (ano >0 && ano < 4) {
			this.ano = ano;
		}
		else {
			throw new IllegalArgumentException("Ano inválido. Deve estar entre 1 e 3.");
		}
	}

	@Override
	public String mostra() {
		// Carlos Pinheiro está cursando o 1o ano do ensino médio e tem 14 anos.
		return this.getNome()+" está cursando o "+this.ano
				+"o ano do ensino médio e tem "+this.getIdade()+" anos.";
	}

}