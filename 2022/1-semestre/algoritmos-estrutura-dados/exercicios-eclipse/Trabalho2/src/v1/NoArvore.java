package v1;

import java.util.ArrayList;

public class NoArvore<T> {
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;
	private int nivel;

	public NoArvore(T info) {
		this.info = info;

	}

	public String imprimePre() {
		String result = "<" + this.info.toString();

		if (this.getFilho() != null) {
			result += filho.imprimePre();
		}

		result += ">";

		if (this.getIrmao() != null) {
			result += "" + irmao.imprimePre();
		}

		return result;
	}

	public int returnAltura() {
		int altura = 0;

		if (ehFolha()) {
			altura = getNivel();
		}

		if (this.getFilho() != null) {
			int i = filho.returnAltura();

			if (i > altura) {
				altura = i;
			}
		}

		if (this.getIrmao() != null) {
			int i = irmao.returnAltura();
			if (i > altura) {
				altura = i;
			}
		}

		return altura;
	}

	public void inserirFilho(NoArvore<T> filho) {
		filho.setIrmao(this.getFilho());
		this.filho = filho;
		filho.setNivel(this.getNivel() + 1);

		// teste depois apagar
		System.out.println("pai : " + this.getInfo() + " filho: " + this.filho.getInfo() + " recebendo nivel : "
				+ filho.getNivel());
	}

	public NoArvore<T> pertence(T info) {
		if (this.info.equals(info)) {
			return this;
		} else {
			NoArvore<T> no = null;
			if (this.getFilho() != null) {
				no = this.getFilho().pertence(info);
			}
			if (no == null && this.getIrmao() != null) {
				no = this.getIrmao().pertence(info);
			}
			return no;
		}
	}

	public NoArvore<T> getFilho() {
		return filho;
	}

	public NoArvore<T> getIrmao() {
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

	public void setNivel(int i) { // recebendo o nivel
		this.nivel = i;
	}

	public int getNivel() { // retornando o nivel
		return this.nivel;
	}
	
	private boolean ehFolha()
	{
		return (this.getFilho() == null);
	}

	protected int getPosicaoPrimeiroNoFolha()
	{
		int subArvore = 1;
		int minimo = 0;
		if (!this.ehFolha())
		{
			NoArvore<T> irmaos = this.getFilho();
			NoArvore<T> filhos = this.getFilho();
			ArrayList<Integer> listaSubarvores = new ArrayList<Integer>();
			for (irmaos = this.getFilho(); irmaos != null; irmaos = irmaos.getIrmao())
			{
				if (irmaos.getFilho() != null)
				{
					for (filhos = irmaos.getFilho(); filhos != null; filhos = filhos.getFilho())
					{
						subArvore++;
					}
				}
				listaSubarvores.add(subArvore);
				subArvore = 1;
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