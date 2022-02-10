public class Manutencao {
	private int numero;
	private float custo;
	private String descricao;
	private int tempo;

	public float getCustoDiario() {
		return this.custo / this.tempo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero > 0) {
			this.numero = numero;
		}
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		if (custo >= 0) {
			this.custo = custo;
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao != null && !descricao.isBlank()) {
			this.descricao = descricao;
		}
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		if (tempo > 0) {
			this.tempo = tempo;
		}
	}
}