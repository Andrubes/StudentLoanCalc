package pkgHelper;

import java.util.Date;
import java.text.DecimalFormat;
import java.math.*;
import org.apache.poi.ss.formula.functions.*;

import org.apache.poi.ss.formula.functions.Finance;

public class Payment {
	private int PaymentID;
	private Date DueDate;
	private double IPMT;
	private double PPMT; 
	private double TotalPrincipal; 
	private double Balance;
	private Loan l;
	
	public Payment(int paymentID, Date dueDate, double balance, Loan l) {
		PaymentID=paymentID;
		DueDate=dueDate;
		Balance=balance;
		this.l=l;
		this.PPMT=Math.abs(getPPMT());
		this.TotalPrincipal=this.PPMT +l.getExtraPayment();
		this.IPMT=(balance)*(l.getIntRate()/12);
		this.Balance=balance-this.TotalPrincipal;
	}
	private double getPPMT() {
		return Finance.ppmt(l.getIntRate()/12, this.PaymentID, l.getTerm()*12, l.getLoanAmount());
	}
	public double getBalance() {
		Balance=Math.round(Balance*100.0)/100.0;
		return Balance;
	}
	public void ZeroBalance() {
		Balance=0;
	}
	public int getPayID() {
		return PaymentID;
	}
	public double getIPMT() {
		return IPMT;
	}
}
	
	

