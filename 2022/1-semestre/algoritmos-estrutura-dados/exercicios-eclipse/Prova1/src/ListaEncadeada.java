public class ListaEncadeada<T> implements Lista<T>
{
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElem;


	private NoLista<T> getPrimeiro() {
		return primeiro;
	}


	@Override
	public void inserir(T valor) {
		// inserção ao final da lista
		NoLista<T> novo = new NoLista();
		novo.setInfo(valor);

		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElem++;
	}

	@Override
	public String exibir() {
		NoLista<T> p = primeiro;
		String resultado = "[";

		while (p != null) {
			resultado += p.getInfo() + ", ";
			p = p.getProximo();
		}

		return resultado + "]";
	}

	@Override
	public int buscar(T valor) {
		int posicao = 0;
		NoLista<T> p = primeiro;

		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return posicao;
			}
			posicao++;
			p = p.getProximo();
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;

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

	@Override
	public Lista<T> copiar() {
		ListaEncadeada<T> novaLista = new ListaEncadeada<>();
		NoLista<T> no = primeiro;

		while (no != null) {
			novaLista.inserir(no.getInfo());
			no = no.getProximo();
		}

		return novaLista;
	}

	@Override
	public void concatenar(Lista<T> outra) { // contribuição do Adrian
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return qtdElem;
	}
	
	private void setTamanho(int qtdElem) {
		this.qtdElem = qtdElem;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	 public Lista<T> dividir() {  // Contribuição do Vinícius
        NoLista<T> no = primeiro;
        ListaEncadeada<T> listaNova = new ListaEncadeada<>();
        int metade = this.getTamanho() / 2;
        int contador = 1;
        NoLista<T> novoUltimo = null;
       
        while(no != null) {
            if(contador > metade) {
                listaNova.inserir(no.getInfo());
            }
            else {
            	novoUltimo = no;
            }
            contador++;
            no = no.getProximo();
        }
        ultimo = novoUltimo;
        ultimo.setProximo(null);
        qtdElem = metade;
        return listaNova;
    }
	
	@Override
	public T pegar(int pos) { // Contribuição do Vinícius
		if (pos < 0 || pos >= this.qtdElem) {
			throw new IndexOutOfBoundsException("Posicao=" + pos + "; Tamanho=" + qtdElem);
		}
		NoLista<T> no = primeiro;

		for (int i = 0; i < pos; i++) {
			no = no.getProximo();
		}

		return no.getInfo();
	}

	public T pegar2(int posicao) { // contribuição do Rodrigo
		if (posicao < 0 || posicao >= this.qtdElem) {
			throw new IndexOutOfBoundsException("Posicao=" + posicao + "; Tamanho=" + qtdElem);
		}

		NoLista<T> p = primeiro;
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
	
	public int ultimoIndiceDe(T x)
	{
		// retornar indice do ultimo no que armazena um valor igual x 
		// ou seja, ao encontrar um valor igual, assume que aquele é o último nó, e guarda a posicao em uma variável
		// garantir que ele percorra tudo (while p!= null)
		// primeiro nó = 0
		// se não encontrar = -1
		NoLista<T> no = this.primeiro;
		
		int posicaoNoLista = 0;
		int indice = -1; // ja começa com -1 pois se n achar nada não é alterado então permananece "Não encontrado"
		
		while (no != null)
		{
			if (no.getInfo().equals(x)) // se um objeto for igual ao outro
			{
				// atualiza a variável indíce para a posição que está contando agora
				indice = posicaoNoLista;
			}
			posicaoNoLista++;
			no = no.getProximo();
		}
		// se saiu do loop, é pq chegou ao fim da lista
		return indice;
	}
	
	public ListaEncadeada<T> intercala(ListaEncadeada<T> outra)
	{
		// criar uma nova lista encadeada intercalando duas outras
		
		ListaEncadeada<T> novaLista = new ListaEncadeada<T>();
		
		int tamanho = Math.max(this.getTamanho(), outra.getTamanho());
		
		NoLista<T> noListaClasse = this.primeiro;
		NoLista<T> noListaOutra = outra.getPrimeiro();
		
		for (int i = 0; i < tamanho; i++)
		{
			if (noListaClasse != null)
			{
				novaLista.inserir(noListaClasse.getInfo());
				noListaClasse = noListaClasse.getProximo();
			}
			if (noListaOutra != null)
			{
				novaLista.inserir(noListaOutra.getInfo());
				noListaOutra = noListaOutra.getProximo();
			}
		}
		return novaLista;
		
	}
	
	// ou
	// diminui o tempo de execução -> menos Ifs
	public ListaEncadeada<T> intercalaProf(ListaEncadeada<T> outra)
	{
		// criar uma nova lista encadeada intercalando duas outras
		ListaEncadeada<T> novaLista = new ListaEncadeada<T>();

		NoLista<T> noListaClasse = this.primeiro;
		NoLista<T> noListaOutra = outra.getPrimeiro();
		
		while (noListaClasse != null && noListaOutra != null)
		{
			novaLista.inserir(noListaClasse.getInfo());
			noListaClasse = noListaClasse.getProximo();

			novaLista.inserir(noListaOutra.getInfo());
			noListaOutra = noListaOutra.getProximo();
		}
		
		while (noListaClasse != null)
		{
			novaLista.inserir(noListaClasse.getInfo());
			noListaClasse = noListaClasse.getProximo();
		}
		
		while (noListaOutra != null)
		{
			novaLista.inserir(noListaOutra.getInfo());
			noListaOutra = noListaOutra.getProximo();
		}
		return novaLista;
	}
}

