import java.time.LocalDate;
import java.util.Random;

import fifa.Condition;

// Maria Eduarda Krutzsch e Maria Eduarda de Sousa
public class Jogador extends Membro{
	private int numero;
	private String posicao;
	private int altura;
	private double peso;
	
	public Jogador(String n, String a, LocalDate d, String posicao, int numero, int altura, double peso) {
		super(n, a, d);
		this.setAltura(altura);
		this.setPeso(peso);
		this.setPosicao(posicao);
		this.setNumero(numero);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero >= 1 && numero <= 23)
		{
			this.numero = numero;		
		}
		else
		{
			throw new IllegalArgumentException("Número deve estar entre 1 e 23.");
		}
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void go(Condition c)
	{
		Random random = new Random();
		int valorAleatorio = random.nextInt(10);
		
		if (valorAleatorio >= 8)
		{
			this.setTemperatura(this.getTemperatura() - 0.1);
			if (c == Condition.MATCH)
			{
				this.setHidratacao(this.getHidratacao() + 3);
			}
			else if (c == Condition.TRAINING)
			{
				this.setHidratacao(this.getHidratacao() + 2);
			}
		}
		else if (valorAleatorio >= 5)
		{
			this.setTemperatura(this.getTemperatura() + 0.1);
			if (c == Condition.MATCH)
			{
				this.setHidratacao(this.getHidratacao() - 5);
			}
			else if (c == Condition.TRAINING)
			{
				this.setHidratacao(this.getHidratacao() - 3);
			}
		}
	}
	
	public char getGrauHidratacao()
	{
		if (this.getTemperatura() < 37 && this.getHidratacao() > 87)
		{
			return 'H';
		}
		else if (this.getTemperatura() > 37.6 || this.getHidratacao() < 80)
		{
			return 'D';
		}
		else
		{
			return 'E';
		}
	}
	
}
