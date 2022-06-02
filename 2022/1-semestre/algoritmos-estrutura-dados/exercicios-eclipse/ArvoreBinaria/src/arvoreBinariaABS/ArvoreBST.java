package arvoreBinariaABS;

public class ArvoreBST<T extends Comparable<T>> 
				extends ArvoreBinariaAbstract<T>
{

	public void inserir(T valor) 
	{
		if (this.vazia())
		{
			this.setRaiz(new NoArvoreBST<>(valor));
		}
		else 
		{
			((NoArvoreBST<T>)this.getRaiz()).inserir(valor);
		}
	}

	
	public NoArvoreBST<T> buscar(T valor)
	{
		if (this.vazia())
		{
			return null;
		}
		else 
		{
			// manda a raiz chamar o método de buscar
			return ((NoArvoreBST<T>)this.getRaiz()).buscar(valor);
		}
	}
	
	public void retirar(T valor)
	{
		NoArvoreBST<T> noARetirar = this.buscar(valor);
		if (noARetirar != null) {
			this.retirar(noARetirar);
		}
	}
	
	public void retirar(NoArvoreBST<T> noRetirar)
	{
		// manda encontrar o pai do nó a retirar
		NoArvoreBST<T> pai = this.buscarPai(noRetirar);
		
		// se for uma folha 
		if (noRetirar.ehFolha()) // caso 1
		{
			// se a folha for a própria raiz
			if (noRetirar == this.getRaiz())  // para saber se é a raiz da arvore
			{
				 // seta a raiz null
				this.setRaiz(null);
			}
			else
			{
				// se não for a raíz
				// se o que estiver a esquerda do pai for o numero a retira
				if (pai.getEsq() == noRetirar)
				{
					pai.setEsq(null);
				}
				else
				{
					// se o que estiver a direita do pai for o numero a retirar
					pai.setDir(null);
				}
			}
		}
		// se não for uma folha
		else
		{
			if (noRetirar.temApenasUmFilho()) // caso 2 
			{
				// se não tiver nada na direita
				if (noRetirar.getDir() == null)
				{
					// se for a raiz
					if (noRetirar == this.getRaiz())
					{
						// seta o que tava na esquerda pra ser a raiz
						this.setRaiz(noRetirar.getEsq());
					}
					// se não for a raiz
					else
					{
						// se o que tem que tirar ta na direita, seta o que tava na esquerda do nó
						// a retirar pra ser a nova ligação da direita (slide 20)
						if (pai.getDir() == noRetirar)
						{
							pai.setDir(noRetirar.getEsq());
						}
						// se não, seta o que tava na esquerda do nó para ser a nova ligação da
						// esquerda
						else 
						{
							pai.setEsq(noRetirar.getEsq());
						}
					}
				}
				else
				{
					if (noRetirar == this.getRaiz())
					{
						this.setRaiz(noRetirar.getDir());
					}
					else
					{
						if (pai.getDir() == noRetirar)
						{
							pai.setDir(noRetirar.getDir());
						}
						else
						{
							pai.setEsq(noRetirar.getDir());
						}
					}
				}
			}
			// se tiver 2 filhos
			else // slide 25
			{
				NoArvoreBST<T> noSucessor = noRetirar.localizarSucessor();
				// ja esta tudo pronto no noRetirar. é só trocar o info e depois excluir o sucessor
				T info = noSucessor.getInfo();
				this.retirar(noSucessor);
				noRetirar.setInfo(info);
			}
		}
	}
	

	private NoArvoreBST<T> buscarPai(NoArvoreBST<T> noRetirar) 
	{
		// se nó a retirar é a raíz
		if (this.getRaiz() == noRetirar)
		{
			// retorna null, pois raíz não tem pai
			return null;
		}
		
		// seta para ser a raiz pois deve começar da raiz a busca
		NoArvoreBinaria<T> pai = (NoArvoreBST<T>) this.getRaiz();
		
		// enquanto não encontrar o nó a retirar SEM Pular para o proximo
		while (pai.getEsq() != noRetirar && pai.getDir() != noRetirar)
		{
			// se o info do nó a retirar é menor que o info do pai, vai pra esquerda
			if (noRetirar.getInfo().compareTo(pai.getInfo()) < 0)
			{
				pai = pai.getEsq();
			}
			// se o info do nó a retirar é maior que o info do pai, vai pra direita
			else
			{
				pai = pai.getDir();
			}
		}
		
		return (NoArvoreBST<T>) pai;
	}
	
	public T buscaMenorElemento()
	{
		if (this.vazia())
		{
			return null;
		}

		NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
		
		// Enquanto houver elementos à esquerda
		while (no.getEsq() != null)
		{
			no = (NoArvoreBST<T>) no.getEsq();
		}
		return no.getInfo();
	}
	
	public T buscaMaiorElemento()
	{
		if (this.vazia())
		{
			return null;
		}

		NoArvoreBST<T> no = (NoArvoreBST<T>) this.getRaiz();
		
		// Enquanto houver elementos à direita
		while (no.getDir() != null)
		{
			no = (NoArvoreBST<T>) no.getDir();
		}
		return no.getInfo();
	}
	
	
	public T buscaSucessor(T info)
	{
		
		// ----------------- tratamentos
		// se a arvore ta vazia, n tem sucessor
		if (this.vazia())
		{
			return null;
		}
		// mando buscar o valor na arvore,  para garantir que ele existe na arvore
		NoArvoreBST<T> no = this.buscar(info);
		if (no == null)
		{
			return null;
		}
		// se o elemento a buscar o sucessor é o maior da arvore, n tem pq buscar sucessor pois n tem
		if (this.buscaMaiorElemento().equals(info))
		{
			return null; // o maior elemento nao tem sucessor
		}
		// procura à direita pois à direita sempre estao os elementos maiores (sucessor)
		
		// ----------------- tratamentos
		
		
		
		if (no.getDir() != null)
		{
			return no.localizarSucessor().getInfo();
		}
		else
		{
			NoArvoreBST<T> pai = this.buscarPai(no);
			while (pai.getInfo().compareTo(info) <= 0)
			{
				pai = this.buscarPai(pai);
			}
			return pai.getInfo();
		}
	}
	
	public T buscaAntecessor(T info)
	{
		
		// ----------------- tratamentos
		
		// se a arvore ta vazia, n tem sucessor
		if (this.vazia())
		{
			return null;
		}
		// mando buscar o valor na arvore,  para garantir que ele existe na arvore
		NoArvoreBST<T> no = this.buscar(info);
		
		if (no == null)
		{
			// se n existir na arvore, retorna null
			return null;
		}
		// se o elemento a buscar o sucessor é o maior da arvore, n tem pq buscar sucessor pois n tem
		if (this.buscaMaiorElemento().equals(info))
		{
			return null; // o maior elemento nao tem sucessor
		}
		
		// ----------------- tratamentos
		
		// anotacoes docx
		if (no.getEsq() != null)
		{
			return no.localizarAntecessor().getInfo();
		}
		else
		{
			NoArvoreBST<T> pai = this.buscarPai(no);
			while (pai.getInfo().compareTo(info) >= 0) // buscando pelo valor
			{
				pai = this.buscarPai(pai);
			}
			return pai.getInfo();
		}
	} 
	
	public String toStringOrdered() 
	{
		if (this.vazia()) 
		{
			return "";
		} 
		else
		{
			return ((NoArvoreBST<T>)this.getRaiz()).imprimeEmOrdem();
		}
	}
}