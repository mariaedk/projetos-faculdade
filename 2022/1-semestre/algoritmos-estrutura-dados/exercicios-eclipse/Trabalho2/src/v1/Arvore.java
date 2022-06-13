package v1;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
        raiz.setNivel(0);
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

    // OK
    private NoArvore<T> getRaiz() {
        return this.raiz;
    }

    // OK
    public int getAltura() {
        if (vazia()) {
            return -1;

        } else {
            return altura(getRaiz());
        }
    }

    // OK
    private int altura(NoArvore<T> no) {
        int alturaArvore = -1; // criando variavel local

        NoArvore<T> aux; // criando nó auxiliar

        for (aux = no.getFilho(); aux != null; aux = aux.getIrmao()) { // enquanto aux não for nulo

            int recebAltura = altura(aux);
            if (recebAltura > alturaArvore) {

                alturaArvore = recebAltura;
            }
        }
        return alturaArvore + 1;
    }

    // OK
    public int getNivel(T valor) {
        NoArvore<T> aux = pertence(valor);
        int nivelArvore = 0;

        if (aux == null) {
            nivelArvore = -1;
        } else {
            nivelArvore = aux.getNivel();
        }
        return nivelArvore;
    }

    // OK
    public boolean isBalanceada()
    {
    	if ((this.getAltura() - this.posicaoPrimeiroNoFolha()) <= 1)
    	{
        	return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    // OK
    private int posicaoPrimeiroNoFolha()
    {
    	return this.getRaiz().getPosicaoPrimeiroNoFolha();
    }

}