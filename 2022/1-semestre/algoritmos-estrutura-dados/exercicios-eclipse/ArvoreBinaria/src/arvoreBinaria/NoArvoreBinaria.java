package arvoreBinaria;

public class NoArvoreBinaria<T>
{
	private T info;
	private NoArvoreBinaria<T> esq;
	private NoArvoreBinaria<T> dir;
	
	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoArvoreBinaria<T> getEsq() {
		return esq;
	}

	public void setEsq(NoArvoreBinaria<T> esq) {
		this.esq = esq;
	}

	public NoArvoreBinaria<T> getDir() {
		return dir;
	}

	public void setDir(NoArvoreBinaria<T> dir) {
		this.dir = dir;
	}

	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir)
	{
		this.info = info;
		this.esq = esq;
		this.dir = dir;
	}
	
	public NoArvoreBinaria(T info)
	{
		this.info = info;
	}
	
	public NoArvoreBinaria<T> pertence(T info)
	{
		// encontrou o nó que queria
		if (this.info.equals(info))
		{
			return this;
		}
		// se n encontrou, cria um novo objeto
		NoArvoreBinaria<T> retorno = null;
		if (this.esq != null) // pra nao dar null pointer exception
		{
			// se encontrar o valor no lado esquerdo da arvore
			retorno = this.esq.pertence(info);
		}
		// se o retorno for null signfica q n achou nada na esquerda
		// verifica se a direita nao esta vazia e entra no if
		if (retorno == null  && this.dir != null)
		{
			retorno = this.dir.pertence(info);
		}
		return retorno;
	}
	
	public String imprimePre() 
	{
		String msg = "<" + this.getInfo();
		// enquanto os nós da esquerda nao forem nulos, imprime eles
		if (this.getEsq() != null) 
		{
			// ao chamar imprimirPre de novo, gera recursividade e vai imprimindo todos os elementos da esq e direita
			msg += this.getEsq().imprimePre();
		} 
		else 
		{ // se for nulo, imprime nada
			msg += "<>";
		}
		if (this.getDir() != null) 
		{
			msg += this.getDir().imprimePre();
		} 
		else 
		{
			msg += "<>";
		}
		return msg + ">";
	}
}
