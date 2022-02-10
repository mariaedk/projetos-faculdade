import java.time.LocalDate;

public class Evento {
	private String titulo;
	private double valor;
	private LocalDate data;
	private Avaliacao avaliacao;
	
	public Evento(String titulo, double valor, LocalDate data)
	{
		this.setData(data);
		this.setTitulo(titulo);
		this.setValor(valor);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if (titulo != null && titulo.length() > 0)
		{
			this.titulo = titulo;			
		}
		else
		{
			throw new IllegalArgumentException("Título inválido.");
		}

	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		if (valor > 0) 
		{
			this.valor = valor;			
		}
		else
		{
			throw new IllegalArgumentException("Valor inválido.");
		}
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Avaliacao getAvaliacao() {
		return this.avaliacao;
	}
	
	public String exibir() {
		String msg = "Evento: " + this.getTitulo() + ", no dia " + this.getData() + ", ingressos a R$ " + this.getValor();
		if (avaliacao == null)
		{
			msg += ". Ainda não avaliado.";
		}
		else
		{
			msg += ", teve " + avaliacao.getOpiniaoGeral() + " pagantes que acharam o evento " 
					 + avaliacao.getOpiniaoGeral() + ".";
		}
		return msg;
		
	}
}
