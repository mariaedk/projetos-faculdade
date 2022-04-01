package principal;

import pilhaLista.PilhaLista;



// métodos push e toString funcionando.
// 01.04 -> método retirar funcionando (pop)
public class TestePilhaLista 
{
	public static void main(String[] args) 
	{
		PilhaLista<Integer> pilhaLista = new PilhaLista<Integer>();
		System.out.println("Adicionando número 5");
		pilhaLista.push(5);
		System.out.println("Adicionando número 2");
		pilhaLista.push(2);
		System.out.println("Adicionando número 4");
		pilhaLista.push(4);
		System.out.println("Adicionando número 6");
		pilhaLista.push(6);
		System.out.println("Adicionando número 8");
		pilhaLista.push(8);
		System.out.println("Lista atual: " + pilhaLista.toString());
		
		System.out.println("RETIRADO: " + pilhaLista.pop());
		System.out.println("Lista atual: " + pilhaLista.toString());
		System.out.println("RETIRADO: " + pilhaLista.pop());
		System.out.println("Lista atual: " + pilhaLista.toString());
		System.out.println("RETIRADO: " + pilhaLista.pop());
		System.out.println("Lista atual: " + pilhaLista.toString());
		System.out.println("RETIRADO: " + pilhaLista.pop());
		System.out.println("Lista atual: " + pilhaLista.toString());
		System.out.println("RETIRADO: " + pilhaLista.pop());
		System.out.println("Lista atual: " + pilhaLista.toString());
		
		System.out.println("Adicionando número 6");
		pilhaLista.push(6);
		System.out.println("Adicionando número 8");
		pilhaLista.push(8);
		System.out.println("Lista atual: " + pilhaLista.toString());
		
		System.out.println("Está vazia? " + pilhaLista.estaVazia());
		
		System.out.println("Limpando toda a pilha!");
		pilhaLista.liberar();
		System.out.println("Lista atual: " + pilhaLista.toString());
		
		System.out.println("Está vazia? " + pilhaLista.estaVazia());
		
		System.out.println("Adicionando número 0");
		pilhaLista.push(0);
		System.out.println("Adicionando número 6");
		pilhaLista.push(6);
		System.out.println("Adicionando número 34");
		pilhaLista.push(34);
		System.out.println("Adicionando número 2");
		pilhaLista.push(2);
		
		System.out.println("Lista atual: " + pilhaLista.toString());
		
		System.out.println("Está vazia? " + pilhaLista.estaVazia());
		
		System.out.println("Quem é o primeiro elemento da pilha: " + pilhaLista.peek());
	}
}
