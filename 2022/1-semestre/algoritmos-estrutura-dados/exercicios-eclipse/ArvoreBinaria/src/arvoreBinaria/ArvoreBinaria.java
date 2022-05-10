package arvoreBinaria;

public class ArvoreBinaria <T>
{
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinaria() {
		super();
	}

	public ArvoreBinaria(NoArvoreBinaria<T> no) {
		this.raiz = no;
	}

	
	public void setRaiz(NoArvoreBinaria<T> no)
	{
		this.raiz = no;
	}
	
	public boolean vazia()
	{
		return this.raiz == null;
	}
	
	public NoArvoreBinaria<T> pertence(T info)
	{
		if (this.vazia())
		{
			return null;
		}
		else
		{
			// processo recursivo
			return raiz.pertence(info);
		}
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
	
	
}
