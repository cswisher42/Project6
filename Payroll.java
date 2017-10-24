import java.util.*;
import java.text.*;

public class Payroll{
	private String name;
	private int idNumber;
	private double payRate, hoursWorked;
	DecimalFormat df = new DecimalFormat("$###,##0.00");
	
	public Payroll(){
		name = "none";
		idNumber = 0;
		payRate = 0;
		hoursWorked = 0;
	}
	
	public Payroll(String n, int i){
		name = n;
		idNumber = i;
	}
	
	public Payroll(String n, int i, double p, double h){
		name = n;
		idNumber = i;
		payRate = p;
		hoursWorked = h;
	}
	
	public boolean equals(Payroll another){
		if(idNumber == another.idNumber)
			return true;
		else
			return false;
	}
	
	public String grossPay(){
		if(hoursWorked > 40)
			return df.format(payRate*40+(payRate*1.5)*(hoursWorked-40));
		else
			return df.format(payRate*hoursWorked);
	}
	
	public int getID(){
		return (idNumber);
	}
	
	public String toString(){
		return (name+"\nID #"+idNumber+"\nGross Pay - "+grossPay());
	}
}