// Maria Eduarda Krutzsch e Victor do Amaral

public class Arquivo extends Dados{
	 private long tamanho;
	 
	public Arquivo(String nome, long tamanho)
	 {
		 super(nome);
		 this.setTamanho(tamanho);
	 }

	public long getTamanho() {
		return (tamanho + super.getTamanho());
	}
	
	public void setTamanho(long tamanho) {
		this.tamanho = tamanho;
	}
	
}
