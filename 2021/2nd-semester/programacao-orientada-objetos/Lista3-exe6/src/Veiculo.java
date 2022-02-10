import java.time.LocalDate;
import java.util.HashMap;

public class Veiculo {
	private String placa;
	private String modelo;
	private LocalDate dataAquisicao;
	private HashMap<Integer, Manutencao> manutencoes;

	public void addManutencao(Manutencao m) {
		manutencoes.put(m.getNumero(), m);
	}

	public int getNumeroManutencoesRepetidas(String descricao) {
		int count = 0;
		for (Manutencao m : manutencoes.values()) {
			if (m.getDescricao().equals(descricao)) {
				count++;
			}
		}
		return count;
	}

	public float getIndiceSucateamento() {
		int diasParado = 0;
		for (Manutencao m : manutencoes.values()) {
			diasParado += m.getTempo();
		}
		if (diasParado > 120) {
			return 2f;
		} else if (diasParado >= 81) {
			return 1.5f;
		} else if (diasParado >= 51) {
			return 1f;
		} else if (diasParado >= 21) {
			return 0.5f;
		} else {
			return 0f;
		}
	}

	public float getCustoMedioManutencoes() {
		float soma = 0f;
		for (Manutencao m : manutencoes.values()) {
			soma += m.getCusto();
		}
		return soma / manutencoes.size();
	}

	public int comparaIndiceVeiculos(Veiculo p) {
		if (this.getIndiceSucateamento() > p.getIndiceSucateamento()) {
			return 1;
		} else if (getIndiceSucateamento() == p.getIndiceSucateamento()) {
			return 0;
		} else {
			return -1;
		}
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		if (placa.length() == 7) {
			this.placa = placa;
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo!= null && !modelo.isEmpty()) {
			this.modelo = modelo;
		}
	}

	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
}