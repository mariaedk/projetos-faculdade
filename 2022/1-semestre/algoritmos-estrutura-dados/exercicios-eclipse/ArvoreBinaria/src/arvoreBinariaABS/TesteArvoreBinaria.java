package arvoreBinariaABS;

public class TesteArvoreBinaria
{

	public static void main(String[] args) {
		
		
		
//		ArvoreBST<Integer> arv2 = new ArvoreBST<>();
//		System.out.println("Quantos nós?");
//		Scanner s = new Scanner(System.in);
//		Random r = new Random();
//		int qtde = s.nextInt();
//		int[] vetor = new int[qtde];
//		for (int i=0; i < vetor.length; i++) {
//			vetor[i] = r.nextInt(100000);
//			arv2.inserir(vetor[i]);
//		}
//		System.out.println(arv2.toString());
//		int pos;
//		while (qtde != 0) {
//			pos = r.nextInt(vetor.length);
//			if (vetor[pos] != -1) {
//				arv2.retirar(vetor[pos]);
//				vetor[pos] = -1;
//				qtde--;
//				System.out.println(arv2.toString());
//			}
//		}
//		s.close();
		
//		NoArvoreBinaria<String> no6 = new NoArvoreBinaria<String>("f");
//		NoArvoreBinaria<String> no5 = new NoArvoreBinaria<String>("e");
//		NoArvoreBinaria<String> no4 = new NoArvoreBinaria<String>("d");
//		NoArvoreBinaria<String> no3 = new NoArvoreBinaria<String>("c", no5, no6);
//		NoArvoreBinaria<String> no2 = new NoArvoreBinaria<String>("b", null, no4);
//		NoArvoreBinaria<String> no1 = new NoArvoreBinaria<String>("a", no2, no3);
//
//		ArvoreBinaria<String> arvore = new ArvoreBinaria<String>();
//		arvore.setRaiz(no1);
//		System.out.println(arvore.toString());
		
		NoArvoreBinaria<Integer> nos4 = new NoArvoreBinaria<>(4);
		NoArvoreBinaria<Integer> nos5 = new NoArvoreBinaria<>(5);
		NoArvoreBinaria<Integer> nos2 = new NoArvoreBinaria<>(2, nos4, nos5);
		 
		NoArvoreBinaria<Integer> nos7 = new NoArvoreBinaria<>(7);
		NoArvoreBinaria<Integer> nos6 = new NoArvoreBinaria<>(6, nos7, null);
		
		NoArvoreBinaria<Integer> nos3 = new NoArvoreBinaria<>(3, null, nos6);
		
		NoArvoreBinaria<Integer> nos1 = new NoArvoreBinaria<>(1, nos2, nos3);
		
		ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<>();
		arvore2.setRaiz(nos1);
		System.out.println(arvore2.toString());
		
//		System.out.println("Testando os pertences===");
//		System.out.println("f-->"+arvore.pertence("f").getInfo());
//		System.out.println("Null-->"+arvore.pertence("m"));
//		System.out.println("c-->"+arvore.pertence("c").getInfo());
//		
//		System.out.println("4-->"+arvore2.pertence(4).getInfo());
//		System.out.println("Null-->"+arvore2.pertence(200));
//		System.out.println("6-->"+arvore2.pertence(6).getInfo());
	}
}