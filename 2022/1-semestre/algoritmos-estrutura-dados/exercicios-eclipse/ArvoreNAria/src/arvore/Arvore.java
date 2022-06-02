package arvore;

public class Arvore<T> 
{
	private NoArvore<T> raiz;
	
	public Arvore()
	{
		this.raiz = null;
	}
	

	public NoArvore<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}
	
	public NoArvore<T> pertence(T info)
	{
		if (this.vazia())
		{
			return null;
		}
		else 
		{
			// manda a raiz chamar o método de buscar
			return this.getRaiz().pertence(info);
		}
	}
	
	public boolean vazia()
	{
		return (this.getRaiz() == null);
	}
	
	public String toString()
	{
		if (this.vazia())
		{
			return "<>";
		} 
		else 
		{
			return this.raiz.imprimePre();
		}
	}
	
	

    
    public NoArvore<T> getPrimeiroNoFolha()
    {
    	return this.getRaiz().getPrimeiroNoFolha();
    	   
    }
 }