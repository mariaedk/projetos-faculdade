// K = chave, T = valor
public class MapaDispersao<K, T>
{
	// vetor do tipo lista encadeada que recebe K como chave e T como valor
	// em cada posição do vetor terá uma lista encadeada
	private ListaEncadeada<K, T>[] tabela;
	
	public MapaDispersao(int quantidade)
	{
		int tamanho = quantidade * 2;
		tabela = new ListaEncadeada[tamanho];
	}
	
	// calcular o valor de hash da chave (índice)
	private int calcularHash(K chave)
	{
		// H(K) = K % M; K -> Chave, M -> Tamanho da tabela
		// valor de hash da chave dividido pelo tamanho da tabela
		return chave.hashCode() % this.tabela.length;
	}
	
	public boolean inserir(K chave, T info)
	{
		// mandar buscar o objeto
		// não pode inserir o objeto caso exista um objeto com a mesma chave
		// exemplo: inseri a chave 18000 e o objeto Maria
		// ai quero tentar inserir sob a chave 18000 dnv, o Paulo
		// nao pode.
		// tabela.inserir(18000, Maria)
		// indice = 18000 % 32 = 16
		// no vetor = posição 15. (16-1)
		int indice = this.calcularHash(chave) - 1;
		// Nao tem nada ali nessa posição
		if (tabela[indice] == null)
		{
			// então deve-se criar uma nova lista nesta posição
			this.tabela[indice] = new ListaEncadeada<K, T>();
		}
		
		int posicaoObjeto = this.tabela[indice].buscarPorChave(chave);
		// se retornar -1 significa que não foi adicionado ainda
		// logo, pode adicionar o objeto com a chave
		if (posicaoObjeto == -1)
		{
			this.tabela[indice].inserir(chave, info);
			return true;
		}
		// se retornar um valor diferente de -1 significa que ja tem um objeto sob a mesma chave, logo nao pode inserir
		return false;
	}
	
	// remover o objeto pela chave
	public NoLista<K, T> remover (K chave)
	{
		// buscar o objeto para garantir que ele realmente existe
		int indice = this.calcularHash(chave) - 1;
		int posicaoObjeto = this.tabela[indice].buscarPorChave(chave);
		// se retornar -1 significa que não existe na tabela
		if (posicaoObjeto == -1)
		{
			return null;
		}
		return this.tabela[indice].retirarPorChave(chave);
	}
	
	// procura no mapa o objeto por chave
	public NoLista<K, T> buscar (K chave)
	{
		int indice = this.calcularHash(chave) - 1;
		// se a posição não estiver vazia
		if (this.tabela[indice] != null)
		{
			return this.tabela[indice].pegarPorChave(chave);
		}
		// se estiver vazia, não tem o que buscar
		return null;
	}
	
	// REFAZER
	// retorna qtd atual de elementos inseridos no mapa
	public int quantosElementos()
	{
		int qtdElementosTabela = 0;
		// para cada posição do vetor, pegar a qtd de elementos da lista encadeada
		for (int i = 0; i < this.tabela.length; i++)
		{
			// se existe algum dado, verifica
			if (this.tabela[i] != null)
			{
				qtdElementosTabela += this.tabela[i].getTamanho();
			}
		}
		return qtdElementosTabela;
	}
	
}