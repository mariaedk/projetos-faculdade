
public class TesteLista {


	public static void main(String[] args) {
//		Lista<Integer> lista = new ListaEncadeada<>();
//		System.out.println("Lista original vazia. Tamanho = "+lista.getTamanho());
//		lista.inserir(50);
//		lista.inserir(-15);
//		lista.inserir(12);
//		lista.inserir(28);
//		lista.inserir(91);
//		System.out.println("Lista original = "+lista.exibir());
//		System.out.println("Lista original. Tamanho = "+lista.getTamanho());
//		System.out.println("Buscar 50 = "+lista.buscar(50));
//		System.out.println("Buscar 91 = "+lista.buscar(91));
//		System.out.println("Buscar 100 = "+lista.buscar(100));
//		System.out.println("Pegar pela posio 2 = "+lista.pegar(2));
//		lista.retirar(100);
//		lista.retirar(50);
//		System.out.println("Lista aps retiradas (100 e 50) = "+lista.exibir());
//		System.out.println("Tamanho = "+lista.getTamanho());
//		System.out.println("Buscar 50 = "+lista.buscar(50));
//		System.out.println("Buscar 91 = "+lista.buscar(91));
//		System.out.println("Pegar pela posio 2 = "+lista.pegar(2));
//		lista.retirar(91);
//		System.out.println("Buscar aps retirada 91 = "+lista.buscar(91));
//		lista.inserir(150);
//		System.out.println("Lista aps insero = "+lista.exibir());
//		System.out.println("Tamanho = "+lista.getTamanho());
//		System.out.println("Pegar pela posio 2 = "+lista.pegar(2));
//		//System.out.println("Pegar pela posio 20 = "+lista.pegar(20));
//		
//		Lista<Integer> lista1 = new ListaEncadeada<>();
//		lista1.inserir(50);
//		lista1.inserir(-15);
//		lista1.inserir(12);
//		lista1.inserir(28);
//		lista1.inserir(91);
//		lista1.inserir(57);
//		lista1.inserir(25);
//		System.out.println("=====\nOutras listas");
//		System.out.println("Lista 1 = "+lista1.exibir());
//		Lista<Integer> lista3 = lista1.copiar();
//		System.out.println("Lista copiada = "+lista3.exibir());
//		Lista<Integer> lista2 = lista1.dividir();
//		System.out.println("Lista 1 = "+lista1.exibir());
//		System.out.println("Lista 1 tam = "+lista1.getTamanho());
//		System.out.println("Lista 2 = "+lista2.exibir());
//		System.out.println("Lista 2 tam = "+lista2.getTamanho());
//		System.out.println("Lista copiada = "+lista3.exibir());
		
		ListaEncadeada<String> lista1 = new ListaEncadeada<String>();
//		lista1.inserir("A"); // 0
//		lista1.inserir("C"); // 1
//		lista1.inserir("E"); // 2
//		lista1.inserir("G"); // 3
		lista1.inserir("I");// 0
		lista1.inserir("J");// 1
		lista1.inserir("I");// 2
		lista1.inserir("J");// 3
		
		ListaEncadeada<String> lista2 = new ListaEncadeada<String>();
		lista2.inserir("B"); // 0
		lista2.inserir("D"); // 1
		lista2.inserir("D"); // 2
		lista2.inserir("D"); // 3
		lista2.inserir("D"); // 4
		
//		lista2.inserir("F"); // 2
//		lista2.inserir("H"); // 2
		
		System.out.println(" O último índice do número é : " + lista1.ultimoIndiceDe("J"));
		System.out.println(" O último índice do número é : " + lista2.ultimoIndiceDe("D"));
		System.out.println("Lista intercalada: "+ lista1.intercala(lista2).exibir());
	}
}
