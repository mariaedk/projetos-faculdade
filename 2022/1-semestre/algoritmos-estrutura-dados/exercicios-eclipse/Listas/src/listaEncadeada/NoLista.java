package listaEncadeada;

import interfaces.NoListaInterface;

public class NoLista<T> implements NoListaInterface<T>{
	private T info;
	private NoLista<T> prox;
	@Override
	public T getInfo() {
		return info;
	}
	@Override
	public void setInfo(T info) {
		this.info = info;
	}
	@Override
	public NoLista<T> getProx() {
		return prox;
	}
	@Override
	public void setProx(NoLista<T> prox) {
		this.prox = prox;
	}
	
}
