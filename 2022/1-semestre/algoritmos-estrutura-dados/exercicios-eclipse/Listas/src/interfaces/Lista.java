package interfaces;

public interface Lista<T>
{

	// arrayList.size() -> equivalente
	int getTamanho();

	void inserir(T valor);

	String exibir();

	int buscar(T valor);

	void retirar(T valor);

	boolean estaVazia();

	void concatenar(Lista<T> outra);

	Lista<T> dividir();

	Lista<T> copiar();
	
	T pegar(int posicao);
}