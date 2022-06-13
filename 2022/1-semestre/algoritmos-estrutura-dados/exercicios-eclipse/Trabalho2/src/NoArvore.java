import java.util.ArrayList;

public class NoArvore<T> 
{
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;
	private int nivel;

	public int getNivel() {
		return nivel;
	}

	public void setFilho(NoArvore<T> filho) {
		this.filho = filho;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public NoArvore(T info)
	{
		this.info = info;
	}

	public String imprimePre() 
	{
		String result = "<" + this.info.toString();

		if (this.getFilho() != null) 
		{
			result += filho.imprimePre();
		}

		result += ">";

		if (this.getIrmao() != null) 
		{
			result += irmao.imprimePre();
		}

		return result;
	}

	public void inserirFilho(NoArvore<T> sa) 
	{
		sa.setIrmao(this.filho);

		this.filho = sa;
		
		filho.setNivel(this.getNivel() + 1);

		// teste depois apagar
		System.out.println("pai : " + this.getInfo() + " filho: " + this.filho.getInfo() + " recebendo nivel : "
				+ filho.getNivel());
	}

	public NoArvore<T> pertence(T info) 
	{
		if (this.info.equals(info)) 
		{
			return this;
		}
		else 
		{
			NoArvore<T> no = null;
			if (this.getFilho() != null) 
			{
				no = this.getFilho().pertence(info);
			}
			if (no == null && this.getIrmao() != null) 
			{
				no = this.getIrmao().pertence(info);
			}
			return no;
		}
	}

	protected NoArvore<T> getFilho() {
		return filho;
	}

	protected NoArvore<T> getIrmao() {
		return irmao;
	}

	private void setIrmao(NoArvore<T> irmao) {
		this.irmao = irmao;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	private boolean ehFolha()
	{
		return (this.getFilho() == null);
	}

	protected int getPosicaoPrimeiroNoFolha()
	{
		int subArvore = 0;
		int minimo = 0;
		if (!this.ehFolha())
		{
			NoArvore<T> no = this.getFilho();
			NoArvore<T> irmaos = this.getFilho();
			NoArvore<T> filhos = this.getFilho();
			ArrayList<Integer> listaSubarvores = new ArrayList<Integer>();
			for (irmaos = no; irmaos != null; irmaos = irmaos.getIrmao())
			{
				if (irmaos.getFilho() != null)
				{
					for (filhos = irmaos.getFilho(); filhos != null; filhos = filhos.getFilho())
					{
						subArvore++;
					}
					listaSubarvores.add(subArvore);
					subArvore = 0;
				}
			}
		       int numeroSubarvores = listaSubarvores.size();
		       minimo = listaSubarvores.get(0);
		       for (int i = 1; i < numeroSubarvores; i++) 
		       {
		            if (listaSubarvores.get(i) < minimo)
		            {
		            	minimo = listaSubarvores.get(i);
		            }
		       }
		}
		return minimo;
	}
}
