package nl.hu.taxcalculator;

import java.time.LocalDate;
import static java.time.LocalDate.of;
import static java.time.Month.*;
import java.util.ArrayList;
import java.util.List;

public class AOWQualifier {

	private LocalDate forDate;

	private List<AOWTableRow> rows = new ArrayList<>();

	public AOWQualifier(LocalDate forDate) {
		this.forDate = forDate;

		rows.add(new AOWTableRow(of(1800, JANUARY, 1), of(1948, JANUARY, 1))
				.setYearsToAOW(65));
		rows.add(new AOWTableRow(of(1947, DECEMBER, 31), LocalDate.of(1948, DECEMBER, 1))
				.setYearsToAOW(65)
				.setMonthsToAOW(1));
		rows.add(new AOWTableRow(of(1948, NOVEMBER, 30), LocalDate.of(1949, NOVEMBER, 1))
				.setYearsToAOW(65)
				.setMonthsToAOW(2));
		rows.add(new AOWTableRow(of(1949, OCTOBER, 30), LocalDate.of(1950, OCTOBER, 1))
				.setYearsToAOW(65)
				.setMonthsToAOW(3));
		rows.add(new AOWTableRow(of(1950, SEPTEMBER, 30), LocalDate.of(1951, JULY, 1))
				.setYearsToAOW(65)
				.setMonthsToAOW(6));
		rows.add(new AOWTableRow(of(1951, JUNE, 30), LocalDate.of(1952, APRIL, 1))
				.setYearsToAOW(65)
				.setMonthsToAOW(9));
		rows.add(new AOWTableRow(of(1952, MARCH, 31), LocalDate.of(1953, JANUARY, 1))
				.setYearsToAOW(66));
		rows.add(new AOWTableRow(of(1953, JANUARY, 1), LocalDate.of(1953, SEPTEMBER, 1))
				.setYearsToAOW(66)
				.setMonthsToAOW(4));
		rows.add(new AOWTableRow(of(1953, AUGUST, 31), LocalDate.of(1954, MAY, 1))
				.setYearsToAOW(66)
				.setMonthsToAOW(8));
		rows.add(new AOWTableRow(of(1954, APRIL, 30), LocalDate.of(1955, JANUARY, 1))
				.setYearsToAOW(67));
		rows.add(new AOWTableRow(of(1954, DECEMBER, 31), LocalDate.of(1955, OCTOBER, 1))
				.setYearsToAOW(67)
				.setMonthsToAOW(3));
		rows.add(new AOWTableRow(of(1955, SEPTEMBER, 30), LocalDate.of(1956, OCTOBER, 1))
				.setYearsToAOW(67)
				.setMonthsToAOW(3));
	}

	public boolean doesDateQualify(LocalDate birthDay) {
		for (AOWTableRow aowTableRow : rows) {
			if (aowTableRow.appliesToThisBirthDay(birthDay)) {
				return aowTableRow.hasPassedAOWAge(birthDay, forDate);
			}
		}
		return false;
	}
}