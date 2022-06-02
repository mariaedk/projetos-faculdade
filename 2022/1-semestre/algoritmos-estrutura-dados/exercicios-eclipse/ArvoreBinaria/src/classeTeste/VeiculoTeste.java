package classeTeste;

import arvoreBinariaABS.ArvoreBST;

public class VeiculoTeste 
{

	public static void main(String[] args) 
	{
		ArvoreBST<Veiculo> arvore = new ArvoreBST<>();
		Veiculo a = new Veiculo("MJT-7432", "Fusca", 1912, "Pedro");
		Veiculo b = new Veiculo("MIT-8008", "Celta", 1999, "Douglas");
		Veiculo c = new Veiculo("MEI-4665", "Gol", 2002, "Carlos");
		Veiculo d = new Veiculo("MIO-6668", "Fusca", 1915, "Aline");
		Veiculo e = new Veiculo("DIO-3333", "Celta", 1999, "Fausto");
		Veiculo f = new Veiculo("PAO-6472", "C3", 2007, "Carolina");
		Veiculo g = new Veiculo("CAO-2890", "C4", 2012, "Kelvin");
		Veiculo h = new Veiculo("UVA-3939", "BMW", 2015, "Zé");
		Veiculo i = new Veiculo("OVO-0000", "Gol", 2000, "Joshua");
		Veiculo j = new Veiculo("ABC-1234", "Ferrari", 2015, "Marta");

		arvore.inserir(a);
		arvore.inserir(b);
		arvore.inserir(c);
		arvore.inserir(d);
		arvore.inserir(e);
		arvore.inserir(f);
		arvore.inserir(g);
		arvore.inserir(h);
		arvore.inserir(i);
		arvore.inserir(j);

		System.out.println(arvore.toString());
		System.out.println(arvore.toStringOrdered());
	}

}
