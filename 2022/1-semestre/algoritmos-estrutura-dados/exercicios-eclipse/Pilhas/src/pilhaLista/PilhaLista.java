package pilhaLista;
import interfacesPilha.Pilha;
import listaEncadeada.ListaEncadeada;


public class PilhaLista<T> implements Pilha<T>
{
	private ListaEncadeada<T> lista;

	public PilhaLista() 
	{
		this.lista = new ListaEncadeada<T>();
	}

	@Override
	public T pop() 
	{
		T valor = this.peek();
		this.lista.retirar(valor);
		
		return valor;
	}

	@Override
	public T peek() 
	{
		if (this.estaVazia())
		{
			throw new RuntimeException("Pilha vazia.");
		}
		return lista.getPrimeiro().getInfo();
	}

	@Override
	public boolean estaVazia()
	{
		return lista.estaVazia();
	}

	@Override
	public void liberar() 
	{
		this.lista = new ListaEncadeada<T>();
	}

	@Override
	public void push(T valor) 
	{
		// inserir um elemento na pilha
		this.lista.inserir(valor);
	}
	@Override
	public String toString() 
	{
		return this.lista.exibir();
	}

}
