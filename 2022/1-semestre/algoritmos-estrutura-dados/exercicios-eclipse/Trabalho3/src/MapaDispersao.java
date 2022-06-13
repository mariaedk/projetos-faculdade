/**
 * @authors: Maria Eduarda Krutzsch e Luan Lavandoski Guarnieri
 */
public class MapaDispersao<K, T>
{
	private ListaEncadeada<K, T>[] tabela;
	private int tamanhoMapa;
	
	public MapaDispersao(int quantidade)
	{
		tabela = new ListaEncadeada[quantidade * 2];
	}
	
	private int getTamanhoMapa()
	{
		return tamanhoMapa;
	}

	private int calcularHash(K chave)
	{
		return chave.hashCode() % this.tabela.length;
	}
	
	public boolean inserir(K chave, T info)
	{
		int indice = this.calcularHash(chave) - 1;

		if (tabela[indice] == null)
		{
			this.tabela[indice] = new ListaEncadeada<K, T>();
		}
		
		int posicaoObjeto = this.tabela[indice].buscarPorChave(chave);

		if (posicaoObjeto == -1)
		{
			this.tabela[indice].inserir(chave, info);
			this.tamanhoMapa++;
			
			return true;
		}
		
		return false;
	}
	
	public NoLista<K, T> remover (K chave)
	{
		int indice = this.calcularHash(chave) - 1;
		
		int posicaoObjeto = this.tabela[indice].buscarPorChave(chave);
		
		if (posicaoObjeto == -1)
		{
			return null;
		}
		
		this.tamanhoMapa--;
		
		return this.tabela[indice].retirarPorChave(chave);
	}
	
	public NoLista<K, T> buscar (K chave)
	{
		int indice = this.calcularHash(chave) - 1;
		
		if (this.tabela[indice] != null)
		{
			return this.tabela[indice].pegarPorChave(chave);
		}
		
		return null;
	}

	public int quantosElementos()
	{
		return this.getTamanhoMapa();
	}
}