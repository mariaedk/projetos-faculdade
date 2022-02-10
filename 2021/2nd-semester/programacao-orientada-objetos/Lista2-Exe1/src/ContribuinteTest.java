import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContribuinteTest {

	@Test
	void test06SetUfSC() {
		Contribuinte c = new Contribuinte();
		c.setUf("SC");
		assertEquals("SC", c.getUf());
	}
	@Test
	void test06SetUfPR() {
		Contribuinte c = new Contribuinte();
		c.setUf("PR");
		assertEquals("PR", c.getUf());
	}
	@Test
	void test06SetUfRS() {
		Contribuinte c = new Contribuinte();
		c.setUf("RS");
		assertEquals("RS", c.getUf());
	}
	@Test
	void test06SetUfSP() {
		Contribuinte c = new Contribuinte();
		c.setUf("SP");
		assertEquals(null, c.getUf());
	}
	@Test
	void test06SetUfRJ() {
		Contribuinte c = new Contribuinte();
		c.setUf("RJ");
		assertEquals(null, c.getUf());
	}
	

	@Test
	void test05SetRendaAnualNegativa() {
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(-818.50);
		assertEquals(0,c.getRendaAnual());
	}

	@Test
	void testCalcularImposto_9000_imposto522() {
		Contribuinte contribuinte = new Contribuinte();
		contribuinte.setRendaAnual(9000);
		
		double imposto = contribuinte.calcularImposto();
		assertEquals(522, imposto);

	}
}
