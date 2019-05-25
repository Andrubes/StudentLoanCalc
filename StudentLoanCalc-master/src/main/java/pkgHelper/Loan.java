package pkgHelper;

import java.util.LinkedList;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;;
public class Loan {
	private double LoanAmount;
	private double IntRate;
	private int Term;
	private double ExtraPayment;
	private Date FirstDueDate;
	private boolean bCompoundType;
	private double FutureValue;
	
	private LinkedList<Payment> LoanPayments = new LinkedList<Payment>();
	
	public Loan(double la,double ir,int ty, double ep, Date dd, boolean bct,double fv) {
		super();
		
		LoanAmount=la;
		IntRate=ir;
		Term=ty;
		ExtraPayment=ep;
		FirstDueDate= dd;
		bCompoundType=bct;
		FutureValue=fv;
		
		double dRollingBalance=this.LoanAmount;
		int iPaymentNum=0;
		do {
			Payment p= new Payment( ++iPaymentNum, dd , dRollingBalance ,this);
			LoanPayments.add(p);
			dRollingBalance=p.getBalance();
			
			System.out.print("Payment Num ");
			System.out.print(iPaymentNum);
			System.out.print(" ");
			System.out.println(LoanPayments.getLast().getBalance());
			
			if(LoanPayments.getLast().getBalance()<=0) {
				LoanPayments.getLast().ZeroBalance();
				break;
			}	
		}while(true);
		System.out.println(LoanPayments.size());
	}
	
	public double getLoanAmount() {
		return LoanAmount;
	}
	
	public double getIntRate() {
		return IntRate;
	}
	
	public int getTerm() {
		return Term;
	}
	
	public double getExtraPayment() {
		return ExtraPayment;
	}
	
	public double getFutureValue() {
		return FutureValue;
	}
	
	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyy-MM-dd").parse(date);
		}
		catch(ParseException e) {
			return null;
		}
	}
	
	public String getTotalInterest() {
		double sum=0;
		for(Payment p:LoanPayments) {
			sum+=p.getIPMT();
		}
		return ""+(sum);
	}
	public String getTotalPayment() {
		double sum=0;
		for(Payment p:LoanPayments) {
			sum+=p.getIPMT();
		}
		return ""+(sum+LoanAmount);
	}
	
	
}
