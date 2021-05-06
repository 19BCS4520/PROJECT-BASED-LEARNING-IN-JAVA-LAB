package interestcalculator;

import java.util.Scanner;

class RDAccount extends Account 
{ 
 double interestRate, interest= 0.0; 
 double amount; 
 int noOfMonths,age; 
 double monthlyAmount;  
 double calculateInterest() 
 { 
  Scanner ob = new Scanner(System.in); 
  System.out.println("Enter per month Ammount = "); 
  monthlyAmount = ob.nextDouble();  
  System.out.println("Enter no of Months = "); 
  noOfMonths = ob.nextInt(); 
System.out.println("Enter the age of customer = "); 
  age = ob.nextInt(); 
  amount=(monthlyAmount*noOfMonths); 
  if(age>=60) 
  { 
  if(noOfMonths>=6 &&noOfMonths<9) 
  { 
   interestRate = 8.00; 
  } 
  if(noOfMonths>=9 &&noOfMonths<12) 
  { 
   interestRate = 8.25; 
  } 
  if(noOfMonths>=12 &&noOfMonths<15) 
  { 
   interestRate = 8.50; 
  } 
  if(noOfMonths>=15 &&noOfMonths<18) 
  { 
   interestRate = 8.75; 
  } 
  if(noOfMonths>=18 &&noOfMonths<21) 
  { 
   interestRate = 9.00; 
  } 
  if(noOfMonths>=21) 
  { 
   interestRate = 9.25; 
  } 
   
  } 
  else 
   if(age<60)   
   { 
    if(noOfMonths>=6 &&noOfMonths<9) 
    { 
     interestRate = 7.50; 
    }  
    if(noOfMonths>=9 &&noOfMonths<12) 
    { 
     interestRate = 7.75; 
} 
    if(noOfMonths>=12 &&noOfMonths<15) 
    { 
     interestRate = 8.00; 
    }  
    if(noOfMonths>=15 &&noOfMonths<18) 
    { 
     interestRate = 8.25; 
    } 
    if(noOfMonths>=18 &&noOfMonths<21) 
    { 
     interestRate = 8.50; 
    } 
    if(noOfMonths>=21) 
    { 
     interestRate = 8.75; 
    } 
   } 
  ob.close(); 
  interest = (interestRate/100)*amount; 
  return interest; 
 } 
} 
class SBAccount extends Account 
{ 
 double interestRate=0.000; 
 double interest; 
 double amount; 
 int type;  
 Scanner ob = new Scanner(System.in); 
 double calculateInterest() 
 { 
  System.out.println("Enter Amount = "); 
  amount = ob.nextInt(); 
  System.out.println("Press 1 for Normal Account \nPress 2 for NRI :: "); 
  type = ob.nextInt(); 
  if(type == 1) 
   { 
   interestRate = 0.04; 
   } 
  else 
   if(type == 2) 
{ 
    interestRate = 0.06; 
    } 
  interest = interestRate*amount; 
  ob.close(); 
 return interest;  
 } 
}