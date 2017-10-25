/** 
* Payroll creates four class variables to hold the employee's name, idNumber
* pay rate, and hours worked. The class has several constructors to create
* objects to be used in differnt situations. There are methods to test if
* two objects are equal, calculate pay, get an employee's id nubmer, and 
* return the information in a formatted string.
* @author (Chuck Swisher) 
* @version (Project 6) 
*/ 

import java.util.*;
import java.text.*;

public class Payroll{
	private String name;
	private int idNumber;
	private double payRate, hoursWorked;
	DecimalFormat df = new DecimalFormat("$###,##0.00");
	
	/** Payroll constructor
	* (Empty constructor that sets all variables to blank values) 
	* @param (describe first parameter) 
	*/ 
	public Payroll(){
		name = "none";
		idNumber = 0;
		payRate = 0;
		hoursWorked = 0;
	}
	
	/** Payroll constructor
	* (Constructor takes a string and integer to be assigned to name and idNumber) 
	* @param String n(Variable that is assigned to name)
	* @param int i(Variable that is assigned to the employee's id number)
	*/ 
	public Payroll(String n, int i){
		name = n;
		idNumber = i;
	}
	
	/** Payroll constructor
	* (Constructor takes a string, integer, and two doubles to be assigned to class variables) 
	* @param String n(Variable that is assigned to name) 
	* @param int i(Variable that is assigned to the employee's id number)
	* @param double p(Variable that is assigned to employee's pay rate)
	* @param double h(Variable that is assigned to employee's total hours worked)
	*/ 
	public Payroll(String n, int i, double p, double h){
		name = n;
		idNumber = i;
		payRate = p;
		hoursWorked = h;
	}
	
	/** equals
	* (Checks if the idNumber of one payroll object equals another) 
	* @param Payroll another(The payroll object that is being compared to the current payroll object)
	* @return boolean(Returns true if the two id numbers are equal and false if they are not) 
	*/ 
	public boolean equals(Payroll another){
		if(idNumber == another.idNumber)
			return true;
		else
			return false;
	}
	
	/** grossPay
	* (The gross pay of the employee is calculated by multiplying payRate and hours.
	* Employee is paid 1.5 as much for hours worked over 40)  
	* @return String(A formatted string ($0.00) of the employee's gross pay is returned) 
	*/ 
	public String grossPay(){
		if(hoursWorked > 40)
			return df.format(payRate*40+(payRate*1.5)*(hoursWorked-40));
		else
			return df.format(payRate*hoursWorked);
	}
	
	/** getId
	* (The id of the object is returned)  
	* @return int(idNumber is returned as an integer) 
	*/ 
	public int getID(){
		return (idNumber);
	}
	
	/** toString
	* (The class variables are formatted and returned as a string)
	* @return String(Name, idNumber, and grossPay are formatted and returned) 
	*/ 
	public String toString(){
		return (name+"\nID #"+idNumber+"\nGross Pay - "+grossPay());
	}
}