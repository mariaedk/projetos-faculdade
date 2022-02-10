import java.util.ArrayList;

public class Agenda {
	private ArrayList<DataAgenda> dataAgendas = new ArrayList<DataAgenda>();
	

	public Compromisso getMenorCompromisso() {
		Compromisso menorCompromisso = null;
		int menorTempoCompromisso = Integer.MAX_VALUE;
		for (DataAgenda dataAgenda: this.dataAgendas) {
			for (Compromisso comp: dataAgenda.getCompromissos()) {
				if (comp.getTempo() < menorTempoCompromisso) {
					menorCompromisso = comp;
					menorTempoCompromisso = comp.getTempo();
				}
			}
		}
		return menorCompromisso;
	}
	
	public void addDataAgenda() {
		
	}
	
}
