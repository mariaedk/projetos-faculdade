import java.time.LocalDate;
import fifa.Condition;

// Maria Eduarda Krutzsch e Maria Eduarda de Sousa
public abstract class Membro 
{
	private String nome;
	private String apelido;
	private LocalDate dataNascimento;
	private int hidratacao;
	private double temperatura;
	
	public Membro(String n, String a, LocalDate d)
	{
		this.setApelido(a);
		this.setDataNascimento(d);
		this.setNome(n);
		this.setHidratacao(95);
		this.setTemperatura(36.5);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getHidratacao() {
		return hidratacao;
	}
	public void setHidratacao(int hidratacao) {
		this.hidratacao = hidratacao;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	public abstract char getGrauHidratacao();
	
	public abstract void go(Condition c);
}
