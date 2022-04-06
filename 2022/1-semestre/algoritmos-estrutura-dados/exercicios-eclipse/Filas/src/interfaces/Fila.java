package interfaces;

public interface Fila<T>
{
	void inserir(T valor);
	T retirar();
	T peek();
	boolean estaVazia();
	void liberar();
}
