import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import fifa.Condition;

// Maria Eduarda Krutzsch e Maria Eduarda de Sousa
public class Selecao 
{
	private String pais;
	private ArrayList<Membro> membros = new ArrayList<>();
	
	public Selecao(String nome)
	{
		this.setName(nome);
	}

	public String getName() {
		return pais;
	}

	public void setName(String pais) {
		if (pais != null && pais.length() > 0)
		{
			this.pais = pais;			
		}
		else
		{
			throw new IllegalArgumentException("Nome não pode ser nulo ou vazio!");
		}

	}

	public boolean addMembro(Membro m)
	{
		for(Membro membro: membros)
		{
			if (membro.getNome() == m.getNome() && membro.getDataNascimento() == m.getDataNascimento())
			{
				return false;
			}
		}
		return true;
	}
	
	public int getWaterComfort()
	{
		int hidratados = 0, desidratados = 0, desgastados = 0;
		for (Membro m: membros)
		{
			if (m.getGrauHidratacao() == 'H')
			{
				hidratados++;
			}
			else if (m.getGrauHidratacao() == 'D')
			{
				desidratados++;
			}
			else 
			{
				desgastados++;
			}
		}
		
		int qtdDesidratados = (100 * desidratados) / membros.size();
		int qtdDesgastados = (100 * desgastados) / membros.size();
		
		 if (membros.size() == hidratados)
		 {
			 return 10;
		 }
		 else if (qtdDesidratados < 10 || qtdDesgastados < 20)
		 {
			 return 9;
		 }
		 else if ((qtdDesidratados > 10 && qtdDesidratados < 30) || (qtdDesgastados > 20 && qtdDesgastados < 40))
		 {
			 return 7;
		 }
		 else if ((qtdDesidratados > 30 && qtdDesidratados < 50) || (qtdDesgastados > 40 && qtdDesgastados < 60))
		 {
			 return 5;
		 }
		 else {
			 return 2;
		 }
	}
	
	public void simulating(Condition c)
	{
		for (Membro m: membros)
		{
			m.go(c);
		}
	}
	
	public String statusReport()
	{
		String nomeArquivo = "statusReportFIFA.txt";
		try {
			
			FileWriter fw = new FileWriter(nomeArquivo);
			BufferedWriter bw = new BufferedWriter(fw);
			LocalDateTime dataHoraAtual = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String dataHoraFormatado = dataHoraAtual.format(formatador);
			String membro = "";
			
			bw.write("Seleção: " + this.getName());
			bw.newLine();
			bw.write(dataHoraFormatado);
			bw.newLine();
			
			for (Membro m: membros)
			{
				String nomeClasse = m.getClass().getSimpleName();
				switch (nomeClasse)
				{
				case "Jogador":
					Jogador jogador = (Jogador) m;
					membro = m.getApelido() + ", " + m.getNome() + ", " + jogador.getNumero() + ", " +
							jogador.getPosicao() + ", " + jogador.getAltura() + ", "
							+ jogador.getPeso() + ", " + jogador.getHidratacao() + ", " + jogador.getTemperatura()
							+ ", " + jogador.getGrauHidratacao();
					bw.write(membro);
					bw.newLine();	
					break;
				
				case "ComissaoTecnica":
					ComissaoTecnica ct = (ComissaoTecnica) m;
					membro = m.getApelido() + ", " + m.getNome() + ", " + ct.getFuncao() + ", "
							+ ct.getHidratacao() + ", " + ct.getTemperatura() + ", " + ct.getGrauHidratacao();
					bw.write(membro);
					bw.newLine();	
					break;	
				}
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nomeArquivo;
		
	}
	
}
