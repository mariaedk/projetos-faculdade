import java.util.Scanner;

public class Expressao {
	private String exp;
	
	private Expressao() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Expressão: ");
        String expressao = teclado.next();
        
        setExpressao(expressao);
        System.out.print("Está correta? ");
        estaCorretaSintaticamente();
	}
	
	public void setExpressao(String exp) {
		this.exp = exp;
	}
	
	public String getExpressao(String exp) {
		return exp;
	}
	
	public boolean estaCorretaSintaticamente() {
		
		int contador1 = 0, contador2 = 0;
		for (int posicao = 0; posicao < exp.length(); posicao++) { 
			if (getExpressao(this.exp).charAt(posicao) == '(') {
				contador1+=1;
			} else if (getExpressao(this.exp).charAt(posicao) == ')') {
				contador2+=1;
			}
		}
		if (contador1 == contador2) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getQtdeDivisores() {
		int contador = 0;
		for (int posicao = 0; posicao < exp.length(); posicao++) {
			if (getExpressao(this.exp).charAt(posicao) == '/') {
				contador+=1;
			}
		}
		return contador;
	}
	public int getPosicaoOperador() {
		for (int posicao = 0; posicao < exp.length(); posicao++) {
			if (getExpressao(this.exp).charAt(posicao) == '/' || 
				getExpressao(this.exp).charAt(posicao) == '+' ||
				getExpressao(this.exp).charAt(posicao) == '-' ||
				getExpressao(this.exp).charAt(posicao) == '*') {
				
				return getExpressao(this.exp).charAt(posicao);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		new Expressao();
    }
	
	
}
