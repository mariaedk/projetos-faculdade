/**
 * @authors: Maria Eduarda Krutzsch e Luan Lavandoski Guarnieri
 */
public class Principal 
{
	public static void main(String[] args) 
	{
		
		Veiculo v1 = new Veiculo();
		Pessoa p1 = new Pessoa();
		
		p1.setNome("João da Silva");
		p1.setEndereço("Rua azeitona");
		p1.setSexo("Outros");
		p1.setAnoNascimento(1995);
		
		v1.setPlaca("AAA-0123");
		v1.setModelo("Hyundai Creta");
		v1.setAno(2017);
		v1.setProprietario(p1.getNome());
		
		// Chave = classe pessoa
		// Objeto = classe veiculo
		MapaDispersao<Pessoa,Veiculo> mp = new MapaDispersao<Pessoa, Veiculo>(2000);
		
		System.out.println("Inserir p1 e v1: " + mp.inserir(p1, v1));
		
		
		Veiculo v2 = new Veiculo();
		Pessoa p2 = new Pessoa();
		
		p2.setNome("Mariazinha K");
		p2.setEndereço("Rua Ary Taborda Ribas");
		p2.setSexo("Feminino");
		p2.setAnoNascimento(2002);
		
		v2.setPlaca("DQD-7853");
		v2.setModelo("HB20");
		v2.setAno(2016);
		v2.setProprietario(p2.getNome());
		
		System.out.println("Inserir p2 e v2: " + mp.inserir(p2, v2));
		
		Veiculo v3 = new Veiculo();
		
		v3.setPlaca("ABC-3456");
		v3.setModelo("CORSA");
		v3.setAno(2008);
		v3.setProprietario(p2.getNome());
		
		System.out.println("Inserir p2 e v3 (p2 ja foi inserido = retornar false): " + mp.inserir(p2, v3));
		
		Veiculo v4 = new Veiculo();
		Pessoa p3 = new Pessoa();
		
		p3.setNome("Carolina Souza");
		p3.setEndereço("Rua Pão");
		p3.setSexo("Feminino");
		p3.setAnoNascimento(1999);
		
		v4.setPlaca("UIO-3291");
		v4.setModelo("Ranger");
		v4.setAno(2020);
		v4.setProprietario(p3.getNome());
		System.out.println("Inserir p3 e v4: " + mp.inserir(p3, v4));
		
		Veiculo v5 = new Veiculo();
		Pessoa p4 = new Pessoa();
		
		p4.setNome("Carlos Silveira");
		p4.setEndereço("Rua Pizza");
		p4.setSexo("Masculino");
		p4.setAnoNascimento(1987);
		
		v5.setPlaca("KLS-3921");
		v5.setModelo("Fox");
		v5.setAno(2020);
		v5.setProprietario(p4.getNome());
		
		// sem uso
		Pessoa p5 = new Pessoa();
		p5.setNome("Ana Joaquina");
		p5.setEndereço("Rua Garrafa");
		p5.setSexo("Feminino");
		p5.setAnoNascimento(1965);
		
		System.out.println("Inserir p4 e v5: " + mp.inserir(p4, v5));
		
		System.out.println("Quantos elementos no mapa agora: " + mp.quantosElementos());
		
		System.out.println("Objeto a remover: " + mp.remover(p4));
		System.out.println("Deve retornar null: (tentando remover objeto q n existe mais) " + mp.remover(p4));
		
		System.out.println("Objeto buscado: "+ mp.buscar(p2));
		System.out.println("Objeto q não existe no mapa: "+ mp.buscar(p5));
				
		System.out.println("Quantos elementos no mapa agora: " + mp.quantosElementos());
	}
}
