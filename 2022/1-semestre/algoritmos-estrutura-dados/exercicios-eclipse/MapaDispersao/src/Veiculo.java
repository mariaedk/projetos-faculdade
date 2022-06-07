public class Veiculo implements Comparable<Veiculo> 
{
	private String placa;
	private String modelo;
	private int ano;
	private String proprietario;

	public Veiculo() {}
	
	public Veiculo(String placa, String modelo, int ano, String proprietario) {
		this.setPlaca(placa);
		this.setModelo(modelo);
		this.setAno(ano);
		this.setProprietario(proprietario);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		if (placa == null || placa.isEmpty()  || placa.length() != 8) {
			throw new IllegalArgumentException("Placa inválida invalido");
		}
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo.isEmpty() || modelo == null) {
			throw new IllegalArgumentException("Modelo inválido");
		}
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		if (ano < 0) {
			throw new IllegalArgumentException("Ano inválido");
		}
		this.ano = ano;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		if (proprietario.isEmpty() || proprietario == null) {
			throw new IllegalArgumentException("Nome do proprietário inválido");
		}
		this.proprietario = proprietario;
	}

	public @Override String toString() {
		return "Placa " + placa + " Modelo: " + modelo + " Ano: " + ano + " Proprietário: " + proprietario;
	}

	@Override
	public int compareTo(Veiculo o) {
		// return this.getPlaca().compareTo(o.getPlaca());
		if (this.getPlaca().compareTo(o.getPlaca()) > 0) {
			return 1;
		} else if (this.getPlaca().compareTo(o.getPlaca()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

}