// K = chave, T = valor
public class MapaDispersao<K, T>
{
	// vetor do tipo lista encadeada que recebe K como chave e T como valor
	// em cada posição do vetor terá uma lista encadeada
	private ListaEncadeada<K, T>[] tabela;
	
	public MapaDispersao(int quantidade)
	{
		this.tabela =  (ListaEncadeada<K, T>[]) new Object[quantidade * 2];
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
		int posicaoObjeto = this.tabela[indice].buscarPorChave(chave);
		// se retornar -1 significa que não foi adicionado ainda
		// logo, pode adicionar o objeto com a chave
		if (posicaoObjeto == -1)
		{
			this.tabela[indice].inserir(chave, info);
			return true;
		}
		return false;
	}
}
