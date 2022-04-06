package filaLista;

import interfaces.Fila;
import listaEncadeada.ListaEncadeada;

public class FilaLista<T> implements Fila<T>
{
	private ListaEncadeada<T> listaEncadeada;

	public FilaLista() 
	{
		this.listaEncadeada = new ListaEncadeada<T>();
	}

	@Override
	public void inserir(T valor) 
	{
		this.listaEncadeada.inserir(valor);
	}

	@Override
	public T retirar() 
	{
		T valor = this.peek();
		this.listaEncadeada.retirar(valor);
		return valor;
	}

	@Override
	public T peek() 
	{
		if (this.estaVazia())
		{
			throw new RuntimeException("Fila está vazia!");
		}
		return this.listaEncadeada.pegar(0);
	}

	@Override
	public boolean estaVazia() 
	{
		return this.listaEncadeada.estaVazia();
	}

	@Override
	public void liberar() 
	{
		this.listaEncadeada = new ListaEncadeada<T>();
	}

	public String toString()
	{
		return this.listaEncadeada.exibir();
	}
}
