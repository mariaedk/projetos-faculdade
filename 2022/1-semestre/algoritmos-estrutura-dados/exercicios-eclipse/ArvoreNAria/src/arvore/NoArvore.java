package arvore;

public class NoArvore<T>
{
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;
	private int nivel;
	
	public NoArvore(T info)
	{
		this.info = info;
	}
	
	public String imprimePre()
	{
		String msg = "<" + this.getInfo().toString();
		
		if (this.getFilho() != null)
		{
			msg += this.getFilho().imprimePre();
		}
		
		msg += ">";
		
		if (this.getIrmao() != null)
		{
			msg += this.getIrmao().imprimePre();
		}
		
		return msg;
	}
	
	public void inserirFilho(NoArvore<T> sa)
	{
		sa.setIrmao(this.filho);

		this.filho = sa;
		
		filho.setNivel(this.getNivel() + 1);

		// teste depois apagar
		System.out.println("pai : " + this.getInfo() + " filho: " + this.filho.getInfo() + " recebendo nivel : "
				+ filho.getNivel());
	}
	
	public NoArvore<T> pertence(T valor)
	{
		if (this.info.equals(valor))
		{
			return this;
		}
		
		else
		{
			NoArvore<T> no = null;
			// vai procurar nos filhos
			if (this.getFilho() != null)
			{
				no = this.getFilho().pertence(valor);
			}
			// se estiver nulo significa que nao encontrou nada nos filhos, entao vai procurar nos irmaos.
			if (no == null  && this.getIrmao() != null)
			{
				no = this.getIrmao().pertence(valor);
			}

			return no;
		}
	}
	
	public boolean ehFolha()
	{
		return (this.getFilho() == null);
	}
	
	public T getInfo() {
		return info;
	}
	public NoArvore<T> getFilho() {
		return filho;
	}
	public NoArvore<T> getIrmao() {
		return irmao;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public void setFilho(NoArvore<T> filho) {
		this.filho = filho;
	}
	public void setIrmao(NoArvore<T> irmao) {
		this.irmao = irmao;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
    public NoArvore<T> getPrimeiroNoFolha()
    {
    	NoArvore<T> aux = this.getFilho();
    	NoArvore<T> folha = null;
    	
		// pergunta se ele é folha
    	if (aux.ehFolha())
    	{
    		folha = aux;
    	}
    	// se não for folha
    	else
    	{
    		// vê se o filho desse nó é folha
    		if (aux.getFilho().ehFolha())
    		{
    			folha = aux.getFilho();
    		}
    		// vê se o filho desse nó tem irmãos pra procurar
    		if (aux.getFilho().getIrmao() != null)
    		{
    			while (this.getFilho().getIrmao() != null)
    			{
    				if (aux.getFilho().getIrmao().ehFolha())
    				{
    					folha = aux.getFilho().getIrmao();
    					break;
    				}
    				aux = aux.getFilho().getIrmao();
    			}
    		}
    	}	
       
        return folha;
    }
	
}
