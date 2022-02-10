import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjetoDeLei {
	private String titulo;
	private LocalDate dataApresentacao;
	private LocalDate dataAprovacao;
	private int numeroProjeto;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public ProjetoDeLei (String titulo, LocalDate dataApresentacao, String dataAprovacao, int numeroProjeto) {
		this.setTitulo(titulo);
		this.setDataApresentacao(dataApresentacao);
		this.setDataAprovacao(dataAprovacao);
		this.setNumeroProjeto(numeroProjeto);
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		if (titulo != null && titulo.length() > 0)
			this.titulo = titulo;
		else
			throw new IllegalArgumentException("Título deve ser informado.");
	}
	
	public LocalDate getDataApresentacao() {
		return dataApresentacao;
	}
	
	public void setDataApresentacao(LocalDate dataApresentacao) {
		if (dataApresentacao != null)
			this.dataApresentacao = dataApresentacao;
		else
			throw new IllegalArgumentException("Data de Apresentação deve ser informada.");
	}

	public LocalDate getDataAprovacao() {
		return dataAprovacao;
	}
	
	public void setDataAprovacao(String dataAprovacao) {
		if (dataAprovacao.isBlank() == false)
			this.dataAprovacao = LocalDate.parse(dataAprovacao, formatter);
		else
			this.dataAprovacao = null;
	}

	public int getNumeroProjeto() {
		return numeroProjeto;
	}
	
	public void setNumeroProjeto(int numeroProjeto) {
		if (numeroProjeto > 0)
			this.numeroProjeto = numeroProjeto;
		else
			throw new IllegalArgumentException("Número do projeto deve ser maior que zero.");
	}
	
	public String mostrar() {
		String informacao = "Título: " + this.getTitulo();
		
		informacao += "\nData Apresentação: " + this.getDataApresentacao();
		
		if (!this.estaAprovado())
			informacao += "\nProjeto ainda não aprovado.";
		else 
			informacao += "\nData Aprovação: " + this.getDataAprovacao();
		
		informacao += "\nNúmero Projeto: " + this.getNumeroProjeto();
		
		return informacao;
	}

	public boolean estaAprovado() {
		return (this.dataAprovacao != null);
	}
}