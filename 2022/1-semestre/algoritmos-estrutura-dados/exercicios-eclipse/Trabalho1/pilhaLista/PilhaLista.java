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
		int posicao = this.lista.buscar(valor);
		// tem que passar a posicao pra ele nao tirar a primeira ocorrencia do numero
		this.lista.retirarPilha(posicao);
		
		return valor;
	}
	
	@Override
	public T peek() 
	{

		if (this.estaVazia())
		{
			throw new RuntimeException("Pilha vazia.");
		}
		// o último da lista é o primeiro da pilha 
		return this.lista.getUltimo().getInfo();
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
		this.lista.inserir(valor);
	}
	
	@Override
	public String toString() 
	{
		return this.lista.exibirContrario();
	}
	
	public String toString2() 
	{
		return this.lista.exibir();
	}
}
