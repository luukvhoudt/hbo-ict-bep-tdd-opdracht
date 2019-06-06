package nl.hu.taxcalculator;

import java.time.LocalDate;

public class AOWTableRow {

		private LocalDate startDate;
		private LocalDate endDate;
		private int yearsToAOW;
		private int monthsToAOW;

		public AOWTableRow(LocalDate startDate, LocalDate endDate) {
			this.startDate = startDate;
			this.endDate = endDate;
		}

		public boolean appliesToThisBirthDay(LocalDate birthDay) {
			return birthDay.isAfter(startDate) && birthDay.isBefore(endDate);
		}

		public boolean hasPassedAOWAge(LocalDate birthDay, LocalDate forDate) {
			if (appliesToThisBirthDay(birthDay)) {
				return calculateAOWStartDate(forDate).isAfter(birthDay);
			}
			return false;
		}

		private LocalDate calculateAOWStartDate(LocalDate forDate) {
			return forDate
					.minusYears(yearsToAOW)
					.minusMonths(monthsToAOW);
		}

		public AOWTableRow setYearsToAOW(int yearsToAOW) {
			this.yearsToAOW = yearsToAOW;
			return this;
		}

		public AOWTableRow setMonthsToAOW(int monthsToAOW) {
			this.monthsToAOW = monthsToAOW;
			return this;
		}
		
		
	}