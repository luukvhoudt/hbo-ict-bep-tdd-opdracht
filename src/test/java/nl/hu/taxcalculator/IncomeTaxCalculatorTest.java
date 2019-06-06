package nl.hu.taxcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.of;

public class IncomeTaxCalculatorTest {
	
	private LocalDate forDate;
	private IncomeTaxCalculator oldPerson;
	private IncomeTaxCalculator youngPerson;

	@BeforeEach
	public void beforeEach() {
		forDate = of(2017, 1, 1);
		oldPerson = new IncomeTaxCalculator(of(1900, 1, 1), forDate);
		youngPerson = new IncomeTaxCalculator(of(2000, 1, 1), forDate);
	}

	@Test
	public void testAowFirstQuartile() {
		assertEquals(1865, oldPerson.calculateIncomeTax(10000));
	}

	@Test
	public void testAowLastQuartile() {
		assertEquals(37320, oldPerson.calculateIncomeTax(100000));
	}

	@Test
	public void testNonAowFirstQuartile() {
		assertEquals(3655, youngPerson.calculateIncomeTax(10000));
	}

	@Test
	public void testNonAowLastQuartile() {
		assertEquals(43478, youngPerson.calculateIncomeTax(100000));
	}

	@Test void testBeneathFirstQuartile() {
		assertEquals(0, oldPerson.calculateIncomeTax(-100));
		assertEquals(0, youngPerson.calculateIncomeTax(-100));
	}
}
