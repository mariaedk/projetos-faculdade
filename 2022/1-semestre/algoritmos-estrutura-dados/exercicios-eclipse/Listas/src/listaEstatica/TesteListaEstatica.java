package listaEstatica;

import java.util.ArrayList;

import interfaces.Lista;

public class TesteListaEstatica {
	public static void main(String[] args) {
		ListaEstatica<Integer> lista = new ListaEstatica<>();
		ArrayList<Integer> listaParalela = new ArrayList<>();
		
		listaParalela.add(50);
		listaParalela.add(-15);
		listaParalela.add(12);
		listaParalela.add(28);
		listaParalela.add(91);
		System.out.println("Lista paralela = "+listaParalela);
		
		lista.inserir(50);
		lista.inserir(-15);
		lista.inserir(12);
		lista.inserir(28);
		lista.inserir(91);
		System.out.println("Lista original = "+lista.exibir());
		
		Lista<Integer> novaLista;
		novaLista = lista.dividir();
		System.out.println("Primeira lista (original pela metade) = "+lista.exibir());
		System.out.println("Lista criada pela divis�o = "+novaLista.exibir());

		novaLista.inserir(100);
		System.out.println("Lista A = "+novaLista.exibir());
		lista.inserir(200);
		System.out.println("Lista B = "+lista.exibir());
		novaLista.concatenar(lista);
		System.out.println("Lista concatenada (A+B) = "+novaLista.exibir());
		
		ListaEstatica<Integer> terceira = (ListaEstatica<Integer>) novaLista.copiar();
		System.out.println("Lista copiada = "+terceira.exibir());
		novaLista.retirar(100);
		terceira.retirar(200);
		System.out.println("Lista original (sem 100) = "+novaLista.exibir());
		System.out.println("Lista copiada (sem 200) = "+terceira.exibir());
		
	}
}