import java.util.*;

public class PrincipalExerc1 {

	public static void main(String[] args) {
		List<Veiculo> veiculos = new LinkedList<Veiculo>();

		Veiculo v1 = new Veiculo("1234abc", "teste1", 2020, "Pedro");
		Veiculo v2 = new Veiculo("1345grn", "teste2", 1990, "Caio");
		Veiculo v3 = new Veiculo("6344nfe", "teste3", 2019, "Rose");
		Veiculo v4 = new Veiculo("3592knv", "teste4", 2021, "Raul");
		Veiculo v5 = new Veiculo("2353fsc", "teste5", 2010, "Rita");
		Veiculo v6 = new Veiculo("8253gnr", "teste6", 2015, "Artur");
		Veiculo v7 = new Veiculo("9181fss", "teste7", 3220, "Romeu");
		Veiculo v8 = new Veiculo("3522nvo", "teste8", 2321, "Rubens");
		Veiculo v9 = new Veiculo("1343adk", "teste9", 2020, "Angela");
		Veiculo v10 = new Veiculo("8351nfw", "teste10", 2020, "Priscila");

		veiculos.add(v1);
		veiculos.add(v2);
		veiculos.add(v3);
		veiculos.add(v4);
		veiculos.add(v5);
		veiculos.add(v6);
		veiculos.add(v7);
		veiculos.add(v8);
		veiculos.add(v9);
		veiculos.add(v10);

		System.out.println("Quantidade de elementos = "+veiculos.size());
		System.out.println(veiculos);
		// remover pelo objeto
		veiculos.remove(v4);

		// remover pela posição 7
		veiculos.remove(6);
		System.out.println("Apos remoção objeto e posição \nQuantidade de elementos = "+veiculos.size());
		System.out.println(veiculos);
		
		// remover pelo iterador
		ListIterator<Veiculo> li = veiculos.listIterator(veiculos.size());
		Veiculo v = li.previous();  // ultimo
		v = li.previous(); // penultimo
		v = li.previous(); //antepenultimo
		li.remove();
		System.out.println("Apos remoção pelo iterador \nQuantidade de elementos = "+veiculos.size());
		System.out.println(veiculos);
		
		Collections.sort(veiculos);
		System.out.println("Ordenados por placa \nQuantidade de elementos = "+veiculos.size());
		System.out.println(veiculos);
		
		Comparator<Veiculo> comparaAno = new Comparator<Veiculo>() {
			public int compare(Veiculo v1, Veiculo v2) {
				if (v1.getAno() < v2.getAno()) {
					return -1;
				}
				if (v1.getAno() > v2.getAno()) {
					return 1;
				}
				return v1.getPlaca().compareTo(v2.getPlaca());
			}
		};
		
		Collections.shuffle(veiculos); // para embaralhar tudo
		Collections.sort(veiculos,comparaAno);
		System.out.println("Ordenados por ano e placa \nQuantidade de elementos = "+veiculos.size());
		System.out.println(veiculos);
		
		Comparator<Veiculo> comparaModeloAno = new Comparator<Veiculo>() {
			public int compare(Veiculo v1, Veiculo v2) {
				int retorno = v1.getModelo().compareTo(v2.getModelo());
				if (retorno == 0) { 
					return comparaAno.compare(v1, v2);
				}
				else return retorno;
			}
		};
		
		Collections.shuffle(veiculos); // para embaralhar tudo
		veiculos.sort(comparaModeloAno);
		System.out.println("Ordenados por modelo, ano e placa \nQuantidade de elementos = "+veiculos.size());
		System.out.println(veiculos);
	}

}