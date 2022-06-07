public class ListaEncadeada<K, T>
{
	private NoLista<K, T> primeiro;
	private NoLista<K, T> ultimo;
	private int qtdElem;

	public void inserir(K chave, T valor) {
		// inserção ao final da lista
		NoLista<K, T> novo = new NoLista<K, T>();
		novo.setInfo(valor);
		novo.setChave(chave);

		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElem++;
	}

	public String exibir() {
		NoLista<K, T> p = primeiro;
		String resultado = "[";

		while (p != null) {
			resultado += p.getInfo() + ", " + p.getChave() + ", ";
			p = p.getProximo();
		}

		return resultado + "]";
	}

	public int buscar(T valor) {
		int posicao = 0;
		NoLista<K, T> p = primeiro;

		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return -1;
	}
	
	public int buscarPorChave(K chave) {
		int posicao = 0;
		NoLista<K, T> p = primeiro;

		while (p != null) {
			if (p.getChave().equals(chave)) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return -1;
	}
	
	public NoLista<K, T> pegarPorChave(K chave) 
	{
		NoLista<K, T> p = primeiro;
		// enquanto nao chegar no fim da lista
		while (p != null) {
			// se a chave do objeto atual é a chave que procuro
			if (p.getChave().equals(chave)) {
				// retorna o objeto
				return p;
			}
			// se n pega o proximo
			p = p.getProximo();
		}
		// se não achou nenhum objeto, retorna null
		return null;
	}

	public void retirar(T valor) {
		NoLista<K, T> anterior = null;
		NoLista<K, T> p = primeiro;

		while (p != null && !p.getInfo().equals(valor)) {
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) { // significa que encontrou o elemento a ser retirado
			if (anterior == null) {
				primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
			qtdElem--;
			if (ultimo == p) {
				ultimo = anterior;
			}
		}
	}
	
	public NoLista<K, T> retirarPorChave(K chave) 
	{
		NoLista<K, T> anterior = null;
		NoLista<K, T> p = primeiro;

		while (p != null && !p.getChave().equals(chave))
		{
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) 
		{ 
			if (anterior == null) 
			{
				primeiro = p.getProximo();
			} 
			else
			{
				anterior.setProximo(p.getProximo());
			}
			qtdElem--;
			if (ultimo == p) 
			{
				ultimo = anterior;
			}
		}
		// retorna objeto removido
		return p;
	}


	public int getTamanho() {
		return qtdElem;
	}

	public boolean estaVazia() {
		return (primeiro == null);
	}
	
	public T pegar(int pos)
	{
		if (pos < 0 || pos >= this.qtdElem) {
			throw new IndexOutOfBoundsException("Posicao=" + pos + "; Tamanho=" + qtdElem);
		}
		NoLista<K, T> no = primeiro;

		for (int i = 0; i < pos; i++) 
		{
			no = no.getProximo();
		}

		return no.getInfo();
	}

	public T pegar2(int posicao) { 
		if (posicao < 0 || posicao >= this.qtdElem) {
			throw new IndexOutOfBoundsException("Posicao=" + posicao + "; Tamanho=" + qtdElem);
		}

		NoLista<K, T> p = primeiro;
		int pos = 0;
		while (p != null) {
			if (pos == posicao) {
				return p.getInfo();
			}
			pos++;
			p = p.getProximo();
		}
		return null; // nunca deveria chegar aqui
	}

}