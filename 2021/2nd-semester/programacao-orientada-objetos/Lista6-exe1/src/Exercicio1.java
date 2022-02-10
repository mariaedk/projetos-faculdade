import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercicio1 {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("ArquivoTexto.txt");
			fw.write("12345");   
			fw.close();
			
			FileOutputStream fos = new FileOutputStream("ArquivoBinario.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(12345);
			dos.close();
			
			FileReader fr = new FileReader("ArquivoTexto.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = br.readLine();
			System.out.println("Leitura texto do arquivo texto: "+linha);
			br.close();
			
			fr = new FileReader("ArquivoBinario.dat");
			br = new BufferedReader(fr);
			linha = br.readLine();
			System.out.println("Leitura texto do arquivo binário: "+linha);
			br.close();
			
			FileInputStream fis = new FileInputStream("ArquivoBinario.dat");
			DataInputStream dis = new DataInputStream(fis);
			int valor = dis.readInt();
			System.out.println("Leitura binária do arquivo binário: "+valor);
			dis.close();
			
			fis = new FileInputStream("ArquivoTexto.txt");
			dis = new DataInputStream(fis);
			valor = dis.readInt();
			System.out.println("Leitura binária do arquivo texto: "+valor);
			dis.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}