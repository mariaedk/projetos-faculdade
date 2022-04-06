package filaVetor;

import interfaces.Fila;

public class FilaVetor<T> implements Fila<T> 
{
	private T info[];
	private int limite;
	private int tamanhoAtual;
	private int inicio;

	public FilaVetor(int limite)
	{
		this.info = (T[]) new Object[limite];
		this.setLimite(limite);
		this.setTamanhoAtual(0);
		this.setInicio(0);
	}

	public T[] getInfo() {
		return info;
	}
	public void setInfo(T[] info) {
		this.info = info;
	}
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public int getTamanhoAtual() {
		return tamanhoAtual;
	}
	public void setTamanhoAtual(int tamanhoAtual) {
		this.tamanhoAtual = tamanhoAtual;
	}
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	
	@Override
	public void inserir(T valor)
	{
		if (this.getTamanhoAtual() == this.getLimite())
		{
			throw new RuntimeException("A fila está cheia.");
		}
		
		int posicaoInserir = (this.getInicio() + this.getTamanhoAtual()) % this.getLimite();
		
		info[posicaoInserir] = valor;
		
		this.setTamanhoAtual(this.getTamanhoAtual() + 1);	
	}
	
	@Override
	public T retirar()
	{
		T valor = this.peek();
		
		this.info[this.getInicio()] = null; // na posição atual que aponta para o início, setar para nulo
		
		this.setInicio((this.inicio + 1) % this.limite); // seta um novo início
		
		this.tamanhoAtual--;
		
		return valor;
	}
	
	@Override
	public T peek() 
	{
		if (this.estaVazia())
		{
			throw new RuntimeException("Fila está vazia!");
		}
		return this.info[this.getInicio()];
	}
	
	@Override
	public boolean estaVazia() 
	{
		return (this.getTamanhoAtual() == 0);
	}
	
	@Override
	public void liberar()
	{
		this.setTamanhoAtual(0);
		this.setInicio(0);
		this.info = (T[]) new Object[this.limite];
	}
	
	public FilaVetor<T> concatenar(FilaVetor<T> f2)
	{
		FilaVetor<T> novaFila = new FilaVetor<T>(this.getLimite() + f2.getLimite());
		for (int i = 0; i < this.getTamanhoAtual(); i++)
		{
			novaFila.inserir(this.pegar(i));
		}
		for (int i = 0; i < this.getTamanhoAtual(); i++)
		{
			novaFila.inserir(f2.pegar(i));
		}
		return novaFila;
	}
	
	public String toString()
	{
		String elementos = "";
		int posicao;
		
		for (int i = 0; i < this.getTamanhoAtual(); i++)
		{
			posicao = (this.getInicio() + 1) % this.getLimite();
			elementos += info[posicao] + ", ";
		}
		elementos = elementos.substring(0, Math.max(0, elementos.length() - 2));
		return "(" + elementos + ")";
	}
	
	private T pegar (int indice)
	{
		return this.info[(indice + this.inicio) % limite];
	}
}
