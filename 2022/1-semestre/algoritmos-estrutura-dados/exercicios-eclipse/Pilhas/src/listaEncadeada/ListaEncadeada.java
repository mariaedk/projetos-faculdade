package listaEncadeada;

public class ListaEncadeada<T> implements Lista<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElem;

	public NoLista<T> getUltimo() {
		return ultimo;
	}

	public void setUltimo(NoLista<T> ultimo) {
		this.ultimo = ultimo;
	}

	@Override
	public void inserir(T valor) {
		// inserção ao final da lista
		NoLista<T> novo = new NoLista();
		// seta o valor passado para esse objeto
		novo.setInfo(valor);
		
		// se a lista estiver vazia, preciso adicionar um primeiro objeto. logo, primeiro aponta para novo
		if (this.estaVazia())
		{
			primeiro = novo;
		} 
		// se não, o meu último objeto passa a apontar para este novo e o anterior é este último
		else 
		{
			ultimo.setProximo(novo);
			// alteração
			novo.setAnterior(ultimo);
		}
		// atualiza o valor da variável último para sabermos quem é o último objeto da lista
		ultimo = novo;
		qtdElem++;
	}

	@Override
	public String exibir() 
	{
		// este método exibe a lista encadeada na sua forma normal, do primeiro objeto inserido até o último
		NoLista<T> p = primeiro;
		String resultado = "[";

		while (p != null) 
		{
			resultado += p.getInfo() + ", ";
			p = p.getProximo();
		}

		return resultado + "]";
	}
	
	public String exibirContrario()
	{
		// este método exibe a lista encadeada ao contrário; segue o padrão da pilha
		// a pilha tem como primeiro elemento o último adicionado. logo, precisa imprimir de trás para frente
		NoLista<T> u = ultimo;
		String resultado = "-> topo [";
		
		// contador é = ao total de elementos
		int contador = this.getTamanho();
		// enquanto não chega ao fim da lista
		while (contador != 0)
		{
			// printa de trás pra frente
			resultado += u.getInfo() + ", ";
			u = u.getAnterior();
			// decrementa contador para ir ao anterior
			contador--;
		}
		return resultado + "] <- base";
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
		NoLista<T> a = null;
		NoLista<T> p = primeiro;

		while (p != null && !p.getInfo().equals(valor))
		{
			a = p;
			p = p.getProximo();
			// modificação -> guarda referência do anterior
			p.setAnterior(a);
		}

		if (p != null) 
		{ 
			// significa que encontrou o elemento a ser retirado
			if (a == null)
			{
				primeiro = p.getProximo();
			}
			else 
			{	
				a.setProximo(p.getProximo());
			}
			qtdElem--;
			if (ultimo == p) 
			{
				ultimo = a;
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
	public void concatenar(Lista<T> outra)
	{ 
		for (int i = 0; i < outra.getTamanho(); i++) 
		{
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return qtdElem;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	 public Lista<T> dividir()
	{  
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
	public T pegar(int pos)
	{ 
		if (pos < 0 || pos >= this.qtdElem) {
			throw new IndexOutOfBoundsException("Posicao=" + pos + "; Tamanho=" + qtdElem);
		}
		NoLista<T> no = primeiro;

		for (int i = 0; i < pos; i++) {
			no = no.getProximo();
		}

		return no.getInfo();
	}

}