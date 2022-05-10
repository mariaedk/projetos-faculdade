package arvoreBinariaABS;

public class ArvoreBST<T extends Comparable<T>> 
				extends ArvoreBinariaAbstract<T>
{

	public void inserir(T valor) 
	{
		if (this.vazia()) {
			this.setRaiz(new NoArvoreBST<>(valor));
		}
		else {
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
		NoArvoreBST<T> noRetirar = this.buscar(valor);
		// se o nó a retirar existir na arvore
		if (noRetirar != null)
		{
			NoArvoreBST<T> pai = this.buscarPai(noRetirar);
			// se for uma folha 
			if (noRetirar.ehFolha()) // caso 1
			{
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
					if (noRetirar.getDir() == null)
					{
						if (noRetirar == this.getRaiz())
						{
							this.setRaiz(noRetirar.getEsq());
						}
						else
						{
							if (pai.getDir() == noRetirar)
							{
								pai.setDir(noRetirar.getEsq());
							}
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
					// TODO PEGAR NO GITHUB
					NoArvoreBST<T> noSucessor = noRetirar.localizarSucessor();
					// ja esta tudo pronto no noRetirar. é só trocar o info e depois excluir o sucessor
					T info = noSucessor.getInfo();
					this.retirar(noSucessor);
					noRetirar.setInfo(info);
				}
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
		
		NoArvoreBinaria<T> pai = (NoArvoreBST<T>) this.getRaiz();
		
		// enquanto não encontrar o nó a retirar SEM Pular para o proximo
		while (pai.getEsq() != noRetirar && pai.getDir() != noRetirar)
		{
			// se o info do nó é menor que o info do pai, vai pra esquerda
			if (noRetirar.getInfo().compareTo(pai.getInfo()) < 0)
			{
				pai = pai.getEsq();
			}
			// se o info do nó é maior que o info do pai, vai pra direita
			else
			{
				pai = pai.getDir();
			}
		}
		
		return (NoArvoreBST<T>) pai;
	}
}