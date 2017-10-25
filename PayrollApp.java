/** 
* Payroll App asks for user input and validates it. Payroll objects
* are added to an array list based on the validated input. The array
* list is displayed using toString. The user then inputs an id to
* be deleted. If the id does not exist, the user is prompted to enter
* a different id until a valid one is entered. Afterwards, another
* worker's payroll information is entered and added to the array list.
* The updated array list is displayed again. 
* @author (Chuck Swisher) 
* @version (Project 6) 
*/ 
import java.util.*;

public class PayrollApp{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		ArrayList<Payroll> roll = new ArrayList<>();
		char ans;
		String name="";
		int id = 0;
		double pay=0, hours=0;
		boolean flag = true;
		do{
			do{
				try{
					System.out.print("Enter the employee's name: ");
					name = s.nextLine();
				if(name.equals(""))
					throw new Exception("Name required. Please re-enter.");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}while(name.equals(""));
			do{
				try{
					System.out.print("Enter "+name+"'s 6-digit ID #: ");
					id = Integer.parseInt(s.nextLine());
					flag = true;
				}
				catch(NumberFormatException n){
					System.out.println("No characters allowed. Enter integers only.");
					flag = false;
				}
				if(flag){
					String check = Integer.toString(id);
					if(check.length() != 6){
						System.out.println("ID must be exactly 6-digits.");
						flag = false;
					}
					if(flag){
						Payroll idCheck = new Payroll(name, id);
						for(int i = 0; i < roll.size(); i++){
							if(idCheck.equals(roll.get(i))){
								System.out.println("ID already exists. Please re-enter.");
								flag = false;
							}
						}
					}
				}
			}while(!flag);
			do{
				try{
					System.out.print("Enter "+name+"'s pay rate: ");
					pay = Double.parseDouble(s.nextLine());
					flag = true;
				}
				catch(NumberFormatException u){
					System.out.println("No characters allowed.");
					flag = false;
				}
				if(flag){
					if(pay < 5 || pay > 99.99){
						System.out.println("Payrate must be at least $5 and no more than $99.99");
						flag = false;
					}
				}
			}while(!flag);
			do{
				try{
					System.out.print("Enter "+name+"'s hours worked: ");
					hours = Double.parseDouble(s.nextLine());
					flag = true;
				}
				catch(NumberFormatException m){
					System.out.println("No characters allowed.");
					flag = false;
				}
				if(flag){
					if(hours < 0 || hours > 80){
						System.out.println("Hours must be between 0-80 (inclusive).");
						flag = false;
					}
				}
			}while(!flag);
			roll.add(new Payroll(name, id, pay, hours));
			System.out.print("Would you like to enter another employee? (Y/N): ");
			ans = s.nextLine().toLowerCase().charAt(0);
		}while(ans == 'y');
		
		System.out.println("\nCurrent contents of ArrayList...");
		for(int i = 0; i < roll.size(); i++)
			System.out.println(roll.get(i).toString()+"\n");
		
		do{
			flag = false;
			System.out.print("Enter an ID number to delete corresponding record: ");
			int delete = Integer.parseInt(s.nextLine());
			for(int i = 0; i < roll.size(); i++){
				if(delete == (roll.get(i).getID())){
					roll.remove(i);
					System.out.println("Employee with ID# "+delete+" removed from ArrayList.\n");
					flag = true;
				}
			}
			if(!flag)
				System.out.println("ERROR - ID# not found. Please try again.");
			
		}while(!flag);
		
		System.out.println("Enter the info for the final employee to be added to the list.");
		do{
				try{
					System.out.print("Enter the employee's name: ");
					name = s.nextLine();
				if(name.equals(""))
					throw new Exception("Name required. Please re-enter.");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}while(name.equals(""));
			do{
				try{
					System.out.print("Enter "+name+"'s 6-digit ID #: ");
					id = Integer.parseInt(s.nextLine());
					flag = true;
				}
				catch(NumberFormatException n){
					System.out.println("No characters allowed. Enter integers only.");
					flag = false;
				}
				if(flag){
					String check = Integer.toString(id);
					if(check.length() != 6){
						System.out.println("ID must be exactly 6-digits.");
						flag = false;
					}
					if(flag){
						Payroll idCheck = new Payroll(name, id);
						for(int i = 0; i < roll.size(); i++){
							if(idCheck.equals(roll.get(i))){
								System.out.println("ID already exists. Please re-enter.");
								flag = false;
							}
						}
					}
				}
			}while(!flag);
			do{
				try{
					System.out.print("Enter "+name+"'s pay rate: ");
					pay = Double.parseDouble(s.nextLine());
					flag = true;
				}
				catch(NumberFormatException u){
					System.out.println("No characters allowed.");
					flag = false;
				}
				if(flag){
					if(pay < 5 || pay > 99.99){
						System.out.println("Payrate must be at least $5 and no more than $99.99");
						flag = false;
					}
				}
			}while(!flag);
			do{
				try{
					System.out.print("Enter "+name+"'s hours worked: ");
					hours = Double.parseDouble(s.nextLine());
					flag = true;
				}
				catch(NumberFormatException m){
					System.out.println("No characters allowed.");
					flag = false;
				}
				if(flag){
					if(hours < 0 || hours > 80){
						System.out.println("Hours must be between 0-80 (inclusive).");
						flag = false;
					}
				}
			}while(!flag);
			roll.add(new Payroll(name, id, pay, hours));
			
		System.out.println("\nFinal contents of ArrayList...");
		for(int i = 0; i < roll.size(); i++){
			System.out.println(roll.get(i).toString()+"\n");
		}
	}
}