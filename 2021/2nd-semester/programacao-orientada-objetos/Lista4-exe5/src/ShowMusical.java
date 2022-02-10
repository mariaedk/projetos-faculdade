import java.time.LocalDate;

public class ShowMusical extends Evento {
	private String nomeBanda;
	private String estiloMusical;

	public ShowMusical(String nomeBanda, String estiloMusical, String titulo, double valor, LocalDate data) {
		super(titulo, valor, data);
		setNomeBanda(nomeBanda);
		setEstiloMusical(estiloMusical);
	}

	public String getNomeBanda() {
		return nomeBanda;
	}

	public void setNomeBanda(String nomeBanda) {
		if (nomeBanda != null && nomeBanda.length() > 0)
			this.nomeBanda = nomeBanda;
		else {
			throw new IllegalArgumentException("Nome da banda inválido.");
		}
	}

	public String getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(String estiloMusical) {
		if (estiloMusical != null && estiloMusical.length() > 0)
			this.estiloMusical = estiloMusical;
		else {
			throw new IllegalArgumentException("Estilo musical inválido.");
		}
	}

	@Override
	public String exibir() {
		String mensagem = "Show Musical " + getTitulo() + " de " + getEstiloMusical() + " de " + getNomeBanda()
				+ " com ingressos a R$" + getValor()
				+ " no dia " + getData() + ".";
		if (getAvaliacao() == null)
			return mensagem + " Ainda não avaliado.";
		else 
			return mensagem + " Contou com " + getAvaliacao().getQtdPagantes()+" pagantes. Opinião: " + getAvaliacao().getOpiniaoGeral();
	}
}