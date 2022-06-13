
// MARIA EDUARDA KRUTZSCH

public class Arvore<T> {

	private NoArvore<T> raiz;

	public void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}

	private NoArvore<T> getRaiz() {
		return raiz;
	}

	public NoArvore<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		}
		return raiz.pertence(info);
	}

	public boolean vazia() {
		return (this.raiz == null);
	}

	@Override
	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return raiz.imprimePre();
	}
	
	public String caminho (T procurado)
	{
		String caminho = "";
		
		// colocar isso na árvore
		NoArvore<T> noProcurado = this.pertence(procurado);
		
		if (noProcurado == null)
		{
			caminho = "";
		}
		
		else
		{
			caminho = this.getRaiz().caminhoAteNo(procurado);
		}
		return caminho;		
	}
	
	public int getGrau()
	{
		if (this.vazia())
		{
			return -1;
		}
		return this.getRaiz().grauArvore();
	}
}