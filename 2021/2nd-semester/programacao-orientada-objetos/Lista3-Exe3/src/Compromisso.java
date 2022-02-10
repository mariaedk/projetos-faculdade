import java.time.LocalTime;

public class Compromisso {
	private LocalTime hora;
	private String descricao;
	private int tempo;
	private char prioridade;
	
	private Compromisso(LocalTime hora, String descricao, int tempo, char prioridade) {
		this.setHora(hora);
		this.setDescricao(descricao);
		this.setTempo(tempo);
		this.setPrioridade(prioridade);
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public char getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(char prioridade) {
		if(prioridade == 'B' || prioridade == 'N' || prioridade == 'A') {
			this.prioridade = prioridade;
		}
	}
	
}
