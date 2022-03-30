package listaEncadeada;

public interface NoListaInterface<T> {
		
	public T getInfo();
	public void setInfo(T info);
	public NoLista<T> getProx();
	public void setProx(NoLista<T> prox);

}
