package nl.hu.taxcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuartileTest {
	private Quartile quartile;

	@BeforeEach
	public void beforeEach() {
		quartile = new Quartile(100, 200, 10);
	}

	@Test
	public void testDoesNotQualifyForQuartile() {
		assertFalse(quartile.qualifies(50));
	}

	@Test
	public void testDoesQualifyForQuartile() {
		assertTrue(quartile.qualifies(150));
	}

	@Test
	public void testDoesQualifyForQuartileMin() {
		assertTrue(quartile.qualifies(100));
	}

	@Test
	public void testResult() {
		assertEquals(5, quartile.result(150));
	}
}