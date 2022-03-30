package principal;

import pilhaVetor.PilhaVetor;


public class TestePilhaVetor 
{
	public static void main(String[] args) {
		PilhaVetor<Integer> pilhaVetor = new PilhaVetor<Integer>(4);
		pilhaVetor.push(2);
		pilhaVetor.push(3);
		pilhaVetor.push(1);
		try {
			pilhaVetor.push(1);
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		System.out.println("ToString: "+ pilhaVetor.toString());

		System.out.println("Deletou: "+pilhaVetor.pop());
		System.out.println("último atual: "+pilhaVetor.peek());
		System.out.println("Deletou: "+pilhaVetor.pop());
		System.out.println("último atual: "+pilhaVetor.peek());
		System.out.println("Deletou: "+pilhaVetor.pop());
		try {
			System.out.println("último atual: "+pilhaVetor.peek());
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		try {
			System.out.println("Deletou: "+pilhaVetor.pop());
		} catch (Exception e) {
			System.out.println("Deu certo!!!!");
		}
		
		try {
			System.out.println("último atual: "+pilhaVetor.peek());
		} 
		catch (Exception e) 
		{
			System.out.println("Não há mais o que espiar (vazio)");
		}
		pilhaVetor.push(20);
		pilhaVetor.push(30);
		pilhaVetor.push(10);
		System.out.println("Inseriu:"+pilhaVetor.toString());
		pilhaVetor.liberar();
		System.out.println("Removeu:"+pilhaVetor.toString());
	}

}
