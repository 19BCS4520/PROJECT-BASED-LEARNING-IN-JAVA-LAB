package interestcalculator;

import java.util.Scanner;

public class InterestCalculator {

    public static void main(String[] args) {
        
        String name = null; 
		  int choice; 
		  Scanner o = new Scanner(System.in);
		  System.out.print(" Select the following options: \n1. Interest Calculator -- SB\n2. Interest Calculator -- FD\n3. Interest Calculator -- RD\n4. Exit\nWhat is your Choice "+name+" : "); 
		  choice  =o.nextInt(); 
		  switch(choice) 
		  { 
		  case 1 : SBAccount ob1 = new SBAccount(); 
		    System.out.println(" Interest amount you will get = "+ob1.calculateInterest()); 
		    break; 
		  case 2 : FDAccount ob2 = new FDAccount(); 
		  System.out.println(" Interest amount you will get = "+ob2.calculateInterest()); 
		  break; 
		  case 3 : RDAccount ob = new RDAccount(); 
		    System.out.println(" Interest amount you will get = "+ob.calculateInterest()); 
		  break; 
		  case 4 : break; 
		  } 
		  o.close();
       
    }
    
}