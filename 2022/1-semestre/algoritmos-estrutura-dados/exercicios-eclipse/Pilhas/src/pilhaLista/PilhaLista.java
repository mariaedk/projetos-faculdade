package pilhaLista;
import interfacesPilha.Pilha;
import listaEncadeada.ListaEncadeada;

// o atributo "último" da ListaEncadeada tem o papel de "topo" da Pilha
// a implementação é igual pois o PilhaVetor também trata como uma "lista"
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
		// OK

		// busca o primeiro elemento da pilha
		T valor = this.peek();
		
		// usa o método retirar da classe ListaEncadeada
		this.lista.retirar(valor);
		
		return valor;
	}

	@Override
	public T peek() 
	{
		// OK
		
		// método peek retorna o primeiro elemento da pilha.
		if (this.estaVazia())
		{
			// garante que a pilha não está vazia e consequentemente lança uma exceção
			throw new RuntimeException("Pilha vazia.");
		}
		// o primeiro elemento em uma pilha é o último adicionado. logo, o último elemento de uma lista é o primeiro da pilha.
		return this.lista.getUltimo().getInfo();
	}

	@Override
	public boolean estaVazia()
	{
		// OK
		return lista.estaVazia();
	}

	@Override
	public void liberar() 
	{
		// OK
		// cria uma nova lista e joga a anterior fora
		this.lista = new ListaEncadeada<T>();
	}

	@Override
	public void push(T valor) 
	{
		// OK
		// inserir um elemento na pilha
		// possui modificações
		this.lista.inserir(valor);
	}
	@Override
	public String toString() 
	{
		// OK
		return this.lista.exibirContrario();
	}
	
	public String toString2() 
	{
		// OK
		return this.lista.exibir();
	}
}
