package listaEncadeada;

public class NoLista<T> {
	private T info;
	private NoLista<T> proximo;
	// novo atributo criado: anterior (saber qual que é o objeto anterior ao próximo)
	private NoLista<T> anterior;
	
	public NoLista<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(NoLista<T> anterior) {
		this.anterior = anterior;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NoLista<T> getProximo() {
		return proximo;
	}
	public void setProximo(NoLista<T> proximo) {
		this.proximo = proximo;
	}
	
}