package nl.hu.taxcalculator;

import static java.time.LocalDate.of;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AOWQualifierTest {
	
	private AOWQualifier aowQualifier;
	
	@BeforeEach
	public void beforeEach() {
		aowQualifier = new AOWQualifier(of(2017,1,1));
	}

	@Test
	public void testVeryOldPerson() {
		assert aowQualifier.doesDateQualify(of(1800, 12, 25));
	}

	@Test
	public void testOldPerson() {
		assert aowQualifier.doesDateQualify(of(1900, 8, 12));
	}

	@Test
	public void testYoungPerson() {
		assert !(aowQualifier.doesDateQualify(of(1990, 12, 10)));
	}

	@Test
	public void testUnbornPerson() {
		assert !(aowQualifier.doesDateQualify(of(2020, 12, 10)));
	}

}
