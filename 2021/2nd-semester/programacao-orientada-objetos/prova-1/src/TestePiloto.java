import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//Maria Eduarda Krutzsch e Maria Eduarda de Sousa
import org.junit.jupiter.api.Test;

class TestePiloto {
	
	private DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
	private DateTimeFormatter formatadorDia = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	
	@Test
	void testValorPagarPiloto() {
		Piloto piloto = new Piloto();
		
		piloto.setNome("Pedro Rocha");
		piloto.setNumeroIdentificador(2);
		
		Bateria bateria1 = new Bateria();
		Bateria bateria2 = new Bateria();
		Bateria bateria3 = new Bateria();
		
		bateria1.setData(LocalDate.parse("26/04/2021",formatadorDia));
		bateria1.setNumeroVoltas(3);
		bateria1.setTempoCronometrado(644);
		
		bateria2.setData(LocalDate.parse("26/04/2021",formatadorDia));
		bateria2.setNumeroVoltas(2);
		bateria2.setTempoCronometrado(400);
		
		bateria3.setData(LocalDate.parse("27/04/2021",formatadorDia));
		bateria3.setNumeroVoltas(5);
		bateria3.setTempoCronometrado(1083);
		
		
		piloto.addBateria(bateria1);
		piloto.addBateria(bateria2);
		piloto.addBateria(bateria3);
		
		assertEquals(40, piloto.valorTotalPagar());
	
	}
	

}
