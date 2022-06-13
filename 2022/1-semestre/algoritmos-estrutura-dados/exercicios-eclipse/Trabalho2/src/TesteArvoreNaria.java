public class TesteArvoreNaria 
{

	public static void main(String[] args) 
	{
		/*
     	NoArvore<Integer> n9 = new NoArvore<Integer>(9);
        NoArvore<Integer> n10 = new NoArvore<Integer>(10);
        NoArvore<Integer> n4 = new NoArvore<Integer>(4);
        NoArvore<Integer> n8 = new NoArvore<Integer>(8);
        NoArvore<Integer> n3 = new NoArvore<Integer>(3);
        NoArvore<Integer> n5 = new NoArvore<Integer>(5);
        NoArvore<Integer> n6 = new NoArvore<Integer>(6);
        NoArvore<Integer> n7 = new NoArvore<Integer>(7);
        NoArvore<Integer> n2 = new NoArvore<Integer>(2);
        NoArvore<Integer> n11 = new NoArvore<Integer>(11);
        NoArvore<Integer> n12 = new NoArvore<Integer>(12);
        NoArvore<Integer> n13 = new NoArvore<Integer>(13);
        NoArvore<Integer> n14 = new NoArvore<Integer>(14);
        NoArvore<Integer> n15 = new NoArvore<Integer>(15);
        
        NoArvore<Integer> n1 = new NoArvore<Integer>(1);

        Arvore<Integer> a = new Arvore<>();
        a.setRaiz(n1);

        n1.inserirFilho(n2);
        n1.inserirFilho(n3);
        n1.inserirFilho(n4);
        n2.inserirFilho(n5);
        n2.inserirFilho(n6);
        n5.inserirFilho(n7);
        n4.inserirFilho(n8);
        n4.inserirFilho(n9);
        n9.inserirFilho(n10);
        n10.inserirFilho(n11);
        n10.inserirFilho(n12);
        n3.inserirFilho(n13);
        n11.inserirFilho(n14);
        n10.inserirFilho(n15);

        System.out.println(a.getAltura());
        System.out.println(" nivel n1 : " + n1.getNivel());
        System.out.println(" nivel n2: " + n2.getNivel());
        System.out.println(" nivel n3: " + n3.getNivel());
        System.out.println(" nivel n4: " + n4.getNivel());
        System.out.println("---");
        System.out.println(" nivel n5: " + n5.getNivel());
        System.out.println(" nivel n6: " + n6.getNivel());
        System.out.println(" nivel n7: " + n7.getNivel());
        System.out.println(" nivel n8: " + n8.getNivel());
        System.out.println(" nivel n9: " + n9.getNivel());
        System.out.println(" nivel n10: " + n10.getNivel());
        System.out.println(" nivel n11: " + n11.getNivel());
        System.out.println(" nivel n12: " + n12.getNivel());
        System.out.println(" nivel n13: " + n13.getNivel());
        System.out.println(" nivel n14: " + n14.getNivel());
        System.out.println(" nivel n15: " + n15.getNivel());
        
        System.out.println(a.getPrimeiroNoFolha().getInfo());
        */
		
		NoArvore<Integer> n1 = new NoArvore<Integer>(1);
		NoArvore<Integer> n2 = new NoArvore<Integer>(2);
		NoArvore<Integer> n3 = new NoArvore<Integer>(3);
		NoArvore<Integer> n4 = new NoArvore<Integer>(4);
		NoArvore<Integer> n5 = new NoArvore<Integer>(5);
		NoArvore<Integer> n6 = new NoArvore<Integer>(6);
		NoArvore<Integer> n7 = new NoArvore<Integer>(7);
		NoArvore<Integer> n8 = new NoArvore<Integer>(8);
		NoArvore<Integer> n9 = new NoArvore<Integer>(9);
		NoArvore<Integer> n10 = new NoArvore<Integer>(10);
		NoArvore<Integer> n11 = new NoArvore<Integer>(11);
		NoArvore<Integer> n12 = new NoArvore<Integer>(12);
		NoArvore<Integer> n13 = new NoArvore<Integer>(13);
		NoArvore<Integer> n14 = new NoArvore<Integer>(14);
		
		Arvore<Integer> a = new Arvore<>();
        a.setRaiz(n1);
		
		n1.inserirFilho(n4);
		n1.inserirFilho(n3);
		n1.inserirFilho(n2);
		
		n2.inserirFilho(n5);
		n5.inserirFilho(n6);
		n6.inserirFilho(n8);
		
		n3.inserirFilho(n10);
		n3.inserirFilho(n7);
		n7.inserirFilho(n9);
		
		n4.inserirFilho(n12);
		n4.inserirFilho(n11);
		
		n11.inserirFilho(n14);
		
		n12.inserirFilho(n13);
		
        System.out.println(" nivel n1 : " + n1.getNivel());
        System.out.println(" nivel n2: " + n2.getNivel());
        System.out.println(" nivel n3: " + n3.getNivel());
        System.out.println(" nivel n4: " + n4.getNivel());
        System.out.println("---");
        System.out.println(" nivel n5: " + n5.getNivel());
        System.out.println(" nivel n6: " + n6.getNivel());
        System.out.println(" nivel n7: " + n7.getNivel());
        System.out.println(" nivel n8: " + n8.getNivel());
        System.out.println(" nivel n9: " + n9.getNivel());
        System.out.println(" nivel n10: " + n10.getNivel());
        System.out.println(" nivel n11: " + n11.getNivel());
        System.out.println(" nivel n12: " + n12.getNivel());
        System.out.println(" nivel n13: " + n13.getNivel());
        System.out.println(a.getAltura());
        
        System.out.println(a.isBalanceada());
	}

}