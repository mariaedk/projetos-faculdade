import java.time.LocalDate;
import java.time.Period;

public abstract class Aluno{
	private String nome;
	private LocalDate dataNascimento;

	// construtor
	public Aluno(String nome, LocalDate dataNascimento) {
		super(); // fazendo a chamada ao construtor da superclasse (Object)
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
	}

	// destrutor
	protected void finalize() throws Throwable {
		System.out.println("Passando pelo destrutor de ALUNO:" + this.nome);
	}

	// métodos
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.length() < 5) {
			throw new IllegalArgumentException("Nome do aluno deve ter ao menos 5 caracteres.");
		} else {
			this.nome = nome;
		}
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate datanascimento) {
		this.dataNascimento = datanascimento;
	}

	public abstract String mostra();

	public int getIdade() {
		Period p = Period.between(this.getDataNascimento(), LocalDate.now());
		return p.getYears();
	}
}