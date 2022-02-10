// Maria Eduarda de Sousa, Maria Eduarda Krutzsch, Victor do Amaral
import java.time.LocalDate;

public class TelefoneEspecializado {
	private String nomeUsuario;
	private String enderecoInstalacao;
	private LocalDate dataInstalacao;
	private String numero;
	private int qtdeOcorrencias;
	private double valorAPagar;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEnderecoInstalacao() {
		return enderecoInstalacao;
	}

	public void setEnderecoInstalacao(String enderecoInstalacao) {
		this.enderecoInstalacao = enderecoInstalacao;
	}

	public LocalDate getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(LocalDate dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public String getNumero() {

		return numero;
	}

	public void setNumero(String numero) {
		if (numero.length() == 13) {
			numero.replace("(", "");
			numero.replace(")", "");
			numero.replace(" ", "");
			numero.replace("-", "");
			this.numero = numero;
		}
	}

	public int getQtdeOcorrencias() {
		return qtdeOcorrencias;
	}

	public void setQtdeOcorrencias(int qtdeOcorrencias) {
		this.qtdeOcorrencias = qtdeOcorrencias;
	}

	public double getValorAPagar() {
		return valorAPagar;
	}
	
	public void setValorAPagar() {
		
		if (this.qtdeOcorrencias > 50000) {
			this.valorAPagar = 187.82;
		} else if (this.qtdeOcorrencias >= 10001) {
			this.valorAPagar = 123.90;
		} else if (this.qtdeOcorrencias >= 5001) {
			this.valorAPagar = 98.50;
		} else if (this.qtdeOcorrencias >= 1001) {
			this.valorAPagar = 67.80;
		} else if (this.qtdeOcorrencias >= 1) {
			this.valorAPagar = 50;
		}
	}
}
