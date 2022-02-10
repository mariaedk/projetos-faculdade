
public class Contribuinte {
	private String nome;
	private String cpf;
	private String uf;
	private double rendaAnual;
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		if(uf.equals("SC")|| uf.equals("PR") || uf.equals("RS")) {
			this.uf = uf;
		}
	}

	public double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(double rendaAnual) {
		if (rendaAnual >= 0) {
			this.rendaAnual = rendaAnual;
		}
	}
	public double calcularImposto() {
		// descobrir alíquota
		double aliquota = 0;
		if (this.rendaAnual > 35000) {
			aliquota = 0.30;
		}
		else if (this.rendaAnual > 25000) {
			aliquota = 0.275;
		}
		else if (this.rendaAnual > 9000) {
			aliquota = 0.15;
		}
		else if (this.rendaAnual > 4000) {
			aliquota = 0.058;
		}
		return (this.rendaAnual * aliquota);
	}
}
