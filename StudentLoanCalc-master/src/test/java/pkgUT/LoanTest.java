package pkgUT;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import pkgHelper.Loan;

public class LoanTest {

	@Test
	public void LoanTest() {
		
		double loanAmount = 100000;
		double interestRate = .07;
		int term = 20;
		double extraPayment = 0;
		Date dueDate = Loan.parseDate("2019-07-04");
		boolean Compound = false;
		double futureValue = 0;
		
		Loan l = new Loan(loanAmount, interestRate, term, extraPayment, dueDate, Compound, futureValue);
	}
}