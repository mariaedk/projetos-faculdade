/**
 * @authors: Maria Eduarda Krutzsch e Luan Lavandoski Guarnieri
 */
public class NoLista<K, T> 
{
	private K chave;
	private T info;
	private NoLista<K, T> proximo;
	
	public T getInfo() 
	{
		return info;
	}
	public void setInfo(T info) 
	{
		this.info = info;
	}
	public NoLista<K, T> getProximo()
	{
		return proximo;
	}
	public void setProximo(NoLista<K, T> proximo) 
	{
		this.proximo = proximo;
	}
	public K getChave() 
	{
		return chave;
	}
	public void setChave(K chave) 
	{
		this.chave = chave;
	}
}