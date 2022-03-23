package listaEncadeada;

import interfaces.Lista;
import listaEstatica.ListaEstatica;

public class ListaEncadeada<T> implements Lista<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElem;

	public ListaEncadeada() 
	{
		primeiro = null;
	}

	@Override
	public int getTamanho() {
		return qtdElem;
	}

	public void setTamanho(int tamanho) {
		this.qtdElem = tamanho;
	}


	@Override
	public void inserir(T valor) {
		// cria um novo objeto de Nó
		NoLista<T> novoNo = new NoLista<T>();

		// se a lista está vazia, o primeiro elemento será adicionado
		if (this.estaVazia())
		{
			primeiro = novoNo;
		}
		// se não está vazia, faz o último objeto adicionado apontar para o novo objeto de nó
		else
		{
			ultimo.setProx(novoNo);
		}
		// faz com que o último adicionado seja o novo nó
		ultimo = novoNo;
		// aumenta qtd elementos
		qtdElem++;
	}

	@Override
	public String exibir() 
	{
		// cria objeto Nó "p" e iguala ele ao primeiro objeto da lista
		NoLista<T> p = primeiro;
		String exibeInformacao = "[ ";
		
		// enquanto a referência do próximo objeto não for nula, ou seja, não chegar ao fim da lista
		while (p != null)
		{
			exibeInformacao += p.getInfo().toString() + " ,";
			// pega o próximo objeto da lista
			p = p.getProx();
		}
		return exibeInformacao + " ]";
	}

	@Override
	public int buscar(T valor) {
		NoLista<T> p = primeiro;
		int posicao = 0;
		
		while (p != null)
		{
			if (p.getInfo().equals(valor))
			{
				return posicao;
			}
			p = p.getProx();
			posicao++;
		}
		return -1;
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;
		// enquanto não encontrar o valor a ser retirado
		while ((p != null) && (!(p.getInfo().equals(valor))))
		{
			// vai percorrendo a lista
			// o atual vai ser o anterior
			anterior = p;
			// o novo vai ser o próximo
			p = p.getProx();
		}
		// se achou o valor
		// garante que não chegou no fim da lista
		if (p != null)
		{
			// se for o primeiro elemento
			if (anterior == null)
			{
				// se o meu primeiro elemento for o que eu desejo retirar, faz com que agora o primeiro elemento
				// se torne o próximo da lista, já que tem que remover
				this.primeiro = p.getProx();
			}
			else
			{
				// faz com que o objeto anterior do deletado tenha como referência de próximo o próximo elemento do objeto deletado
				anterior.setProx(p.getProx());
			}
			qtdElem--;
			// atualizar a variável ultimo
			// se deletei o último objeto, o último passa a ser o anterior deste
			if (ultimo == p)
			{
				ultimo = anterior;
			}
		}
	}

	@Override
	public boolean estaVazia() {
		if (this.primeiro == null)
		{
			return true;
		}
		return false;
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
	public Lista<T> dividir()
	{
		// criando uma nova lista do tipo listaencadeada
		Lista<T> listaRetornada = new ListaEncadeada<T>();
		
		if (this.estaVazia())
		{
			return listaRetornada;
		}
		
		NoLista<T> p = primeiro;
		NoLista<T> novoUltimo = null;
		
		int metade = this.getTamanho()/2;
		int contador = 1;
		
		while (p != null)
		{
			// enquanto nao for menor do que a metade, vai caminhando pela lista
			if (contador > metade)
			{
				// chegou acima da metade, começa a inserir
				listaRetornada.inserir(p.getInfo());
			}
			else
			{
				// vai entrar aqui até que chegue na metade, assim mantendo a informação
				novoUltimo = p;
			}
			// caminha
			contador++;
			p = p.getProx();
		}
		// quebra a corrente setando o ultimo como o da metade
		ultimo = novoUltimo;
		ultimo.setProx(null);
		return listaRetornada;
	}

	@Override
	public Lista<T> copiar() {
		ListaEncadeada<T> novaLista = new ListaEncadeada<>();
		// cria um noLista e faz ele apontar para o primeiro
		NoLista<T> p = primeiro;
		// enquanto nao chegar no ultimo
		while (p != null)
		{
			// insere na novaLista a info do noLista
			novaLista.inserir(p.getInfo());
			// pula para o próximo nó
			p = p.getProx();
		}
		
		return novaLista;
		
	}

	@Override
	public T pegar(int posicao) 
	{
		// se a posição for negativa ou nao for valida
		if (posicao < 0 || posicao >= this.qtdElem)
		{
			throw new IndexOutOfBoundsException("Posição: " + posicao + "; Tamanho: " + qtdElem);
		}
		
		NoLista<T> p = primeiro;
		
		int contador = 0;
		
		
		while (p != null)
		{
			if (contador == posicao)
			{
				return p.getInfo();
			}
			// enquanto não encontrar o valor a ser pego
			p = p.getProx();
			contador++;
		}
		
		return null;  // nunca deveria chegar aqui
		
	}
}
