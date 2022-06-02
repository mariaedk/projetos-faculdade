package arvoreBinariaABS;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T>
{

	public NoArvoreBST(T info) 
	{
		super(info);
	}

	public void inserir(T valor) 
	{
		if (valor.compareTo(this.getInfo()) < 0) 
		{
			if (this.getEsq() == null) 
			{
				this.setEsq(new NoArvoreBST<T>(valor));
			} 
			else
			{
				((NoArvoreBST<T>) this.getEsq()).inserir(valor);
			}
		} 
		else 
		{
			if (this.getDir() == null) 
			{
				this.setDir(new NoArvoreBST<T>(valor));
			}
			else 
			{
				((NoArvoreBST<T>) this.getDir()).inserir(valor);
			}
		}
	}

	public NoArvoreBST<T> buscar(T valor) 
	{
		if (valor.compareTo(this.getInfo()) == 0) 
		{
			return this;
		} 
		else 
		{
			if (valor.compareTo(this.getInfo()) < 0) 
			{
				if (this.getEsq() == null) 
				{
					return null;
				} 
				else 
				{
					return ((NoArvoreBST<T>) this.getEsq()).buscar(valor);
				}
			} 
			else 
			{
				if (this.getDir() == null)
				{
					return null;
				} 
				else 
				{
					return ((NoArvoreBST<T>) this.getDir()).buscar(valor);
				}
			}
		}
	}

	public boolean ehFolha()
	{
		return (this.getDir() == null && this.getEsq() == null);
	}

	// XOR = OR EXCLUSIVO = ^ -> ou um ou outro (v e f - TRUE / f e v - TRUE ------ v e v - FALSE / f e f - FALSE)
	public boolean temApenasUmFilho() 
	{
		return (this.getDir() == null ^ this.getEsq() == null);
	}

	public NoArvoreBST<T> localizarSucessor() 
	{
		NoArvoreBST<T> sucessor = (NoArvoreBST<T>) this.getDir();
		while (sucessor.getEsq() != null) 
		{
			sucessor = (NoArvoreBST<T>) sucessor.getEsq();
		}
		return sucessor;
	}
	
	public NoArvoreBST<T> localizarAntecessor()
	{
		NoArvoreBST<T> sucessor = (NoArvoreBST<T>) this.getEsq();
		while (sucessor.getDir() != null) 
		{
			sucessor = (NoArvoreBST<T>) sucessor.getDir();
		}
		return sucessor;
	}

	public String imprimeEmOrdem() 
	{
		String msg = "";
		
		// se tiver elementos à esquerda
		if (this.getEsq() != null) 
		{
			msg += ((NoArvoreBST<T>) this.getEsq()).imprimeEmOrdem();
		}
		
		msg += this.getInfo() + ", ";
		
		if (this.getDir() != null)
		{
			msg += ((NoArvoreBST<T>) this.getDir()).imprimeEmOrdem();
		} 
		return msg;
	}
}
