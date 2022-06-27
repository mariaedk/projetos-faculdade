package interfacesPilha;

public interface Pilha<T> 
{
	T pop ();
	T peek();
	boolean estaVazia();
	void liberar();
	void push(T info);
}
