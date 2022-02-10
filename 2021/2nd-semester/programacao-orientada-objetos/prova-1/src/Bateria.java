import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//Maria Eduarda Krutzsch e Maria Eduarda de Sousa
public class Bateria {
	private DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
	private DateTimeFormatter formatadorDia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate data;
	private LocalDateTime horaInicio;
	private int tempoCronometrado;
	private int numeroVoltas;
	
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getTempoCronometrado() {
		return tempoCronometrado;
	}
	public void setTempoCronometrado(int tempoCronometrado) {
		if (tempoCronometrado >= 0)
			this.tempoCronometrado = tempoCronometrado;
	}
	public int getNumeroVoltas() {
		return numeroVoltas;
	}
	public void setNumeroVoltas(int numeroVoltas) {
		if (numeroVoltas >= 0)
			this.numeroVoltas = numeroVoltas;
	}
	
	public double calcMediaTempo() {
		return this.numeroVoltas / this.tempoCronometrado;
	}
	
}
