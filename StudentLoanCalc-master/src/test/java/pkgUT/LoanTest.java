package pkgUT;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import pkgHelper.Loan;

public class LoanTest {

	@Test
	public void LoanTest() {
		
		double loanAmount = 150000;
		double interestRate = .07;
		int term = 25;
		double extraPayment = 0;
		Date dueDate = Loan.parseDate("2019-09-12");
		boolean Compound = false;
		double futureValue = 0;
		
		Loan l = new Loan(loanAmount, interestRate, term, extraPayment, dueDate, Compound, futureValue);
	}
}

