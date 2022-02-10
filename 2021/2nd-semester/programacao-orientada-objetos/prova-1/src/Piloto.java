import java.util.ArrayList;
import java.util.HashMap;
// Maria Eduarda Krutzsch e Maria Eduarda de Sousa
public class Piloto {
	private int numeroIdentificador;
	private String nome;
	private ArrayList <Bateria> baterias = new ArrayList();
	
	public int getNumeroIdentificador() {
		return numeroIdentificador;
	}
	public void setNumeroIdentificador(int numeroIdentificador) {
		if (numeroIdentificador >= 0)
			this.numeroIdentificador = numeroIdentificador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome != null && nome.isEmpty())
			this.nome = nome;
	}
	
	public boolean addBateria(Bateria bateria) {
		for (Bateria b: this.baterias) {
			if (b.getData().equals(bateria.getData()) && b.getHoraInicio().equals(bateria.getHoraInicio())
					&& b.getNumeroVoltas() == bateria.getNumeroVoltas()) {
				return false;
			}
		}
		this.baterias.add(bateria);
		return true;
	}
	
	public double valorPagarPorVolta() {
		int totalTempo = 0;
		for(Bateria b: this.baterias) {
			totalTempo+= b.getTempoCronometrado();
		}
		
		int totVoltas = 0;
		for (Bateria b: this.baterias) {
			totVoltas+= b.getNumeroVoltas();
		}
		
		if (totalTempo > 12000) {
			return 5.0;
		}
		else if (totalTempo >= 8501) {
			return 6.0;
		}
		else if (totalTempo >= 5001) {
			return 7.0;
		}
		else if (totalTempo >= 2001) {
			return 4.0;
		}
		else {
			return 3.0;
		}
	}
	public double valorTotalPagar() {
		int totVoltas = 0;
		for (Bateria b: this.baterias) {
			totVoltas+= b.getNumeroVoltas();
		}
		return this.valorPagarPorVolta() * totVoltas;
	}
	
	public double calcMediaTempo() {
		int totVoltas = 0;
		for (Bateria b: this.baterias) {
			totVoltas+= b.getNumeroVoltas();
		}
		
		int totalTempo = 0;
		for(Bateria b: this.baterias) {
			totalTempo+= b.getTempoCronometrado();
		}
		
		return totalTempo / totVoltas;
	}
	
	public int getBateriaMaisRapida() {
		int bateriaMaisRapida = Integer.MIN_VALUE;
		for (Bateria b: this.baterias) {
			if (bateriaMaisRapida < b.getTempoCronometrado()) {
				bateriaMaisRapida = b.getTempoCronometrado();
			}
		}
		return bateriaMaisRapida;
	}
}
