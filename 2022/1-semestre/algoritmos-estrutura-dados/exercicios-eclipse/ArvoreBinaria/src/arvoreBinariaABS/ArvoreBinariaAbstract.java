package arvoreBinariaABS;

public abstract class ArvoreBinariaAbstract<T> { 
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinariaAbstract() {
		super();
	}

	public ArvoreBinariaAbstract(NoArvoreBinaria<T> no) {
		this.raiz = no;
	}

	protected void setRaiz(NoArvoreBinaria<T> no) {
		this.raiz = no;
	}

	protected NoArvoreBinaria<T> getRaiz(){
		return this.raiz;
	}
	
	public boolean vazia() {
		return this.raiz == null;
	}

	public NoArvoreBinaria<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		} else {
			return raiz.pertence(info);
		}
	}

	public String toString() {
		if (this.vazia()) {
			return "<>";
		} else {
			return this.raiz.imprimePre();
		}
	}
}