
public class Principal {
	public static void main(String[] args) {
		
		Veiculo v = new Veiculo();
		v.setPlaca("AAA-0123");
		v.setModelo("Hyundai Creta");
		v.setAno(2017);
		v.setProprietario("João da Silva");
		MapaDispersao<String,Veiculo> mp = new MapaDispersao<String, Veiculo>(2000);
		System.out.println("Deve retornar true: " + mp.inserir(v.getPlaca(), v));
		
		Veiculo v2 = new Veiculo();
		v2.setPlaca("AAA-0123");
		v2.setModelo("Hyundai Creta");
		v2.setAno(2017);
		v2.setProprietario("Mariazinha");
		System.out.println("Deve retornar false pq tem a chave repetida: " + mp.inserir(v2.getPlaca(), v2));
		
		Veiculo v3 = new Veiculo();
		v3.setPlaca("ABC-3456");
		v3.setModelo("CORSA");
		v3.setAno(2017);
		v3.setProprietario("ANA");
		System.out.println("Deve retornar true: " + mp.inserir(v3.getPlaca(), v3));
		
		Veiculo v4 = new Veiculo();
		v4.setPlaca("ABC-3456");
		v4.setModelo("CORSA");
		v4.setAno(2017);
		v4.setProprietario("ANA");
		System.out.println("Deve retornar false pq a chave ja existe na tabela: " + mp.inserir(v4.getPlaca(), v4));
		
		Veiculo v5 = new Veiculo();
		v5.setPlaca("BDW-3456");
		v5.setModelo("FUSCA");
		v5.setAno(2017);
		v5.setProprietario("GABRIEL");
		System.out.println("Deve retornar TRUE: " + mp.inserir(v5.getPlaca(), v5));
		
		System.out.println("quantos elementos: " + mp.quantosElementos());
		
		System.out.println("objeto: " + mp.remover(v5.getPlaca()));
		System.out.println("deve retornar null: (tentando remover objeto q n existe mais) " + mp.remover(v5.getPlaca()));

		System.out.println("Objeto buscado:"+mp.buscar("ABC-3456"));
		System.out.println("Objeto q n existe: "+ mp.buscar("AYU-1111"));
	
		System.out.println("quantos elementos: " + mp.quantosElementos());
	}
}
