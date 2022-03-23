package listaEstatica;

import interfaces.Lista;

/**
 * 
 * @author maria
 *
 */
public class ListaEstatica<T> implements Lista<T>
{
	private T[] info;
	private int tamanho;
	
	public ListaEstatica() 
	{
		// T é uma subclasse de Object, logo eu posso declarar ele como um vetor de objetos
		info = (T[]) new Object[10];
		tamanho = 0;
	}	
	
	// arrayList.size() -> equivalente
	@Override
	public int getTamanho() {
		return tamanho;
	}

	public T[] getInfo() {
		return info;
	}

	public void setInfo(T[] info) {
		this.info = info;
	}

	private void redimensionar()
	{
		// declara novo vetor
		T[] novo;
		// declara o novo tamanho
		int novoTamanho = info.length + 10;
		
		// determina o tamanho do novo vetor
		novo = (T[]) new Object[novoTamanho];
		
		// processo de cópia de um vetor para outro
		for (int i = 0; i < tamanho; i++) 
		{
			novo[i] = info[i];
		}
		
		info = novo;
	}
	
	@Override
	public void inserir(T valor)
	{
		if (tamanho == info.length)
		{
			this.redimensionar();
		}
		
		this.info[tamanho] = valor;
		tamanho++;
	}
	
	@Override
	public String exibir()
	{
		String retorno = "[";
		for (int i = 0; i < tamanho; i++)
		{
			retorno += info[i] + ", ";
		}
		return retorno + "]";
	}
	
	@Override
	public int buscar(T valor)
	{
		// percorrer somente as posições usadas
		for (int posicao = 0; posicao < tamanho; posicao++)
		{
			// comparar objetos pelo método equals
			if (info[posicao].equals(valor))
			{
				return posicao;
			}
		}
		return -1;
	}
	

	@Override
	public void retirar(T valor) {
		int posicao = buscar(valor);
		if (posicao != -1) {
			for (int i = posicao; i < tamanho - 1; i++) {
				info[i] = info[i + 1];
			}
			tamanho--;
		}
	}
	
	@Override
	public boolean estaVazia()
	{
		// para estar vazio, o array deve ter tamanho 0
		return (tamanho == 0);
	}
	
	@Override
	public void concatenar(Lista<T> outra)
	{	
		for (int i = 0; i < outra.getTamanho(); i++)
		{
			inserir(outra.pegar(i));
		}
	}
	
	@Override
	public Lista<T> dividir()
	{
		int metade = this.getTamanho()/2;

		Lista<T> listaRetornada = new ListaEstatica<>();
		
		for (int i = metade; i < this.getTamanho(); i++)
		{
			listaRetornada.inserir(this.info[i]);
		} 
		tamanho = metade;
		return listaRetornada;
	} 
	
	@Override
	public Lista<T> copiar()
	{
		ListaEstatica<T> listaCopiada = new ListaEstatica<>();
		
		for (int i = 0; i < info.length; i++)
		{
			listaCopiada.inserir(this.info[i]);
		}
		
		return listaCopiada;
	}

	@Override
	public T pegar(int posicao) {
		// maior beneficio do vetor: acesso direto ao valor
		return info[posicao];
	}
	
}
