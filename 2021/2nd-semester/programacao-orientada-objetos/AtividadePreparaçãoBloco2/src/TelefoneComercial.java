// Maria Eduarda de Sousa, Maria Eduarda Krutzsch, Victor do Amaral
import java.time.LocalDate;

public class TelefoneComercial {
	private String nomeUsuario;
	private String enderecoInstalacao;
	private LocalDate dataInstalacao;
	private String numero;
	private String ramoAtividade;
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
		numero.replace("(", "");
		numero.replace(")", "");
		numero.replace(" ", "");
		numero.replace("-", "");
		this.numero = numero;
	}

	public String getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public double getValorAPagar() {
		return valorAPagar;
	}
	
	public void setValorAPagar() {
		if (this.dataInstalacao.isBefore(LocalDate.of(2019, 01, 01))) {
			this.valorAPagar = 25;
		} else {
			this.valorAPagar = 37.50;
		}
	}

}
