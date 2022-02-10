
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio2 
{
	public static void main(String[] args) 
	{	
		Scanner teclado = new Scanner(System.in);
		int k;
		try 
		{
			
			FileWriter fw = new FileWriter("oi.txt");
			
			System.out.println("Conteúdo do arquivo: ");
			String msg = teclado.nextLine();
			fw.write(msg);
			fw.close();
		
			System.out.print("Chave: ");
			do 
			{
				k = teclado.nextInt();
			} while (k < 1 && k > 200);
	
			FileReader fr = new FileReader("oi.txt");
			FileWriter fw2 = new FileWriter("oi-saida.txt");
			
			int cont = 0;
			int leitura = fr.read();
			while (cont != msg.length())
			{
				
				if (leitura >= 65 && leitura <= 90)
				{
					leitura = leitura + k;
					if (leitura > 90)
					{
						leitura = (leitura - 90) + 65;
					}
				} 
				else if (leitura >= 97 && leitura <= 122)
				{
					leitura = leitura + k;
					if (leitura > 122)
					{
						leitura = (leitura - 122) + 97;
					}
				} 
				else if (leitura >= 32 && leitura <= 64)
				{
					leitura = leitura + k;
					if (leitura > 64)
					{
						leitura = (leitura - 64) + 32;
					}
				}
				
				fw2.write(leitura);			
				System.out.print((char)leitura);
				leitura = fr.read();
				cont++;
			}
			
			fr.close();
			fw2.close();
			teclado.close();

		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
