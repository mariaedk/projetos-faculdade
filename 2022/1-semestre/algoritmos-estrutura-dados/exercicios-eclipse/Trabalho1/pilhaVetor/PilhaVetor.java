package pilhaVetor;

import interfacesPilha.Pilha;

public class PilhaVetor <T> implements Pilha<T>
{
	private int limite;
	private int tamanho = 0;
	private T[] info;

	public T[] getInfo() {
		return info;
	}

	public void setInfo(T[] info) {
		this.info = info;
	}

	public int getTamanho() {
		return tamanho;
	}

	public PilhaVetor(int limite) 
	{
		this.info = (T[]) new Object[limite];
		this.limite = limite;
	}
	@Override
	public void push(T valor) 
	{
		if (this.tamanho == this.limite) {
			throw new RuntimeException("A pilha está cheia!");
		}
		this.info[tamanho] = valor;
		this.tamanho++;

	}
	@Override
	public T pop()
	{
		if (estaVazia()) 
		{
			throw new RuntimeException("A pilha vazia.");
		} 
		
		T elemento = this.info[tamanho - 1];
		this.info[tamanho - 1] = null;
		this.tamanho--;
		return elemento;
	}
	@Override
	public T peek() 
	{
		if (estaVazia()) 
		{
			throw new RuntimeException("A pilha vazia.");
		}
		return this.info[tamanho - 1];
	}
	@Override
	public boolean estaVazia()
	{
		return this.tamanho == 0;
	}
	@Override
	public void liberar() 
	{
		this.info = (T[]) new Object[this.limite];
		this.tamanho = 0;
	}
	@Override
	public String toString() 
	{
		String elementos = "";
		for (int i = this.tamanho - 1; i >= 0; i--)
		{
			elementos += this.info[i]+", ";
		}
		elementos = elementos.substring(0, Math.max(0,elementos.length()-2));
		return "topo -> [" + elementos + "] <- base";
	}
	
	public int comparaPilha(PilhaVetor<T> p2)
	{
		if (this.estaVazia()) 
		{
			throw new RuntimeException("A pilha vazia.");
		}	
		if (p2.estaVazia()) 
		{
			throw new RuntimeException("A pilha recebida está vazia.");
		}	
		
		boolean isValid = true;
		if (this.getTamanho() < p2.getTamanho())
		{
			return -1;
		}
		// se fosse genérico, usar .equals()
		else if (this.getTamanho() == p2.getTamanho())
		{
			for (int i = 0; i < this.getTamanho(); i++)
			{
				if (this.info[i] != p2.getInfo()[i])
				{
					isValid = false;
					break;
				}
			}
			if (isValid)
			{
				return 0;
			}
		}
		return 1;
	}
}
