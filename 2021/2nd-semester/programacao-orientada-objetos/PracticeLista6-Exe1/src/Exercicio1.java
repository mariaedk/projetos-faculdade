import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio1
{
	public static void main(String[] args)
	{
		// é gravar texto -> Writer
		// é arquivo -> File = filewriter
		try {
			// criou um arquivo txt com "12345" dentro dele
			FileWriter fw = new FileWriter("ArquivoTexto.txt");
			fw.write("12345");
			fw.close();
			
			// quando é binário é stream
			// Arquivo binario, saída -> fileoutputstream
			FileOutputStream fos = new FileOutputStream("ArquivoBinario.dat");
			// fos.write() : int, escreve apenas um byte e um inteiro tem 4 bytes, ai usou o dataoutputstream
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(12345);
			dos.close();
			
			// ler como texto
			FileReader fr = new FileReader("ArquivoTexto.txt");
			BufferedReader br = new BufferedReader(fr); // para poder ler a linha toda, o fr.read() lê um caracter por vez só
			String linha = br.readLine();
			System.out.println("Leitura texto do arquivo texto: " + linha);
			br.close();
			
			fr = new FileReader("ArquivoBinario.dat");
			br = new BufferedReader(fr);
			linha = br.readLine();
			
			System.out.println("Leitura texto do arquivo binário: " + linha);
			br.close();
			
			//leitura binaria a partir de um arquivo
			FileInputStream fis = new FileInputStream("ArquivoBinario.dat");
			DataInputStream dis = new DataInputStream(fis); // pra poder ler um inteiro
			int valor = dis.readInt();
			
			System.out.println("Leitura binária do arquivo binário: " + valor);
			dis.close();
			
			
			fis = new FileInputStream("ArquivoTexto.txt");
			dis = new DataInputStream(fis); // pra poder ler um inteiro
			valor = dis.readInt();
			
			System.out.println("Leitura binária do arquivo texto: " + valor);
			dis.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
