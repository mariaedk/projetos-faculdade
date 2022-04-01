package listaEncadeada;
public interface Lista<T> {

	void inserir(T valor);
	String exibir();
	int buscar(T valor);
	void retirar(T valor);
	Lista<T> copiar();
	void concatenar(Lista<T> outra);
	int getTamanho();
	boolean estaVazia();
	Lista<T> dividir();
	T pegar(int posicao);
}