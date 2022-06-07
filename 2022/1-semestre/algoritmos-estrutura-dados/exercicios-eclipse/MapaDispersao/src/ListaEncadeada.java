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
			resultado += p.getInfo() + ", ";
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

	public Lista<T> copiar() {
		ListaEncadeada<K, T> novaLista = new ListaEncadeada<>();
		NoLista<K, T> no = primeiro;

		while (no != null) {
			novaLista.inserir(no.getInfo());
			no = no.getProximo();
		}

		return novaLista;
	}

	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	public int getTamanho() {
		return qtdElem;
	}

	public boolean estaVazia() {
		return (primeiro == null);
	}

	 public Lista<T> dividir() {  
		NoLista<K, T> no = primeiro;
        ListaEncadeada<K, T> listaNova = new ListaEncadeada<>();
        int metade = this.getTamanho() / 2;
        int contador = 1;
        NoLista<K, T> novoUltimo = null;
       
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
	
	public T pegar(int pos) {
		if (pos < 0 || pos >= this.qtdElem) {
			throw new IndexOutOfBoundsException("Posicao=" + pos + "; Tamanho=" + qtdElem);
		}
		NoLista<K, T> no = primeiro;

		for (int i = 0; i < pos; i++) {
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