// Maria Eduarda Krutzsch e Victor do Amaral

import java.util.ArrayList;

public class Pasta extends Dados{
	private ArrayList<Dados> dados = new ArrayList<>();
	
	public Pasta(String nome)
	{
		super(nome);
	}
	
	public void addDados(Dados dado)
	{
		if (this.isPermissaoGravacao())
			this.dados.add(dado);
	}
	
	public long getTamanho()
	{
		long tamanho = 8 + super.getTamanho();
		for (Dados d: this.dados)
		{
			tamanho+= d.getTamanho();
		}
		return tamanho;
	}

	public ArrayList<Dados> getDados() {
		return dados;			
	}
}
