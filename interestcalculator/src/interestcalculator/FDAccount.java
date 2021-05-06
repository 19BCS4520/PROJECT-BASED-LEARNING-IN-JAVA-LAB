package interestcalculator;

import java.util.Scanner;

class FDAccount extends Account 
{ 
 double calculateInterest() 
 { 
  double interestRate = 0 ; 
  double amount; 
  int noofdays ; 
  int age;   
  Scanner ob  =new Scanner(System.in); 
  System.out.println("Enter ammount = "); 
  amount = ob.nextInt(); 
  System.out.println("Enter number of days  = "); 
  noofdays = ob.nextInt();  
  if(amount< 10000000) 
  { 
   System.out.println("Enter age of Customer = "); 
   age = ob.nextInt();  
   if(age>= 60) 
   { 
    if((noofdays>= 7) && (noofdays<=14)) 
    { 
     double r = ((5.0)/100); 
     System.out.println(r); 
     interestRate = amount * r;   
    } 
    if((noofdays>= 15) && (noofdays<=29)) 
{ 
     double r= ((5.25)/100); 
     System.out.println(r); 
     interestRate = amount * r;  
    } 
    if((noofdays>= 30) && (noofdays<=45)) 
    { 
     double r= ((6.0)/100); 
     System.out.println(r); 
     interestRate = amount * r;  
    } 
    if((noofdays> 45) && (noofdays<=60)) 
    { 
     double r= ((7.5)/100); 
     System.out.println(r); 
     interestRate = amount * r;   
    } 
    if((noofdays>= 61) && (noofdays<=184)) 
    { 
     double r= ((8.0)/100); 
     System.out.println(r); 
     interestRate = amount * r;  
    } 
    if((noofdays>= 185) && (noofdays<=365)) 
    { 
     double r= ((8.50)/100); 
     System.out.println(r); 
     interestRate = amount * r;   
    } 
   } 
   else 
    if(age< 60)  
    { 
     if((noofdays>= 7) && (noofdays<=14)) 
     { 
      double r= ((4.5)/100); 
      System.out.println(r); 
      interestRate = amount * r;  
     } 
     if((noofdays>= 15) && (noofdays<=29)) 
     { 
      double r= ((4.75)/100); 
      System.out.println(r); 
      interestRate = amount * r; 
} 
     if((noofdays>= 30) && (noofdays<=45)) 
     { 
      double r= ((5.50)/100); 
      System.out.println(r); 
      interestRate = amount * r;   
     } 
      
     if((noofdays> 45) && (noofdays<=60)) 
     { 
      double r= ((7.0)/100); 
      System.out.println(r); 
      interestRate = amount * r;  
     } 
     if((noofdays>= 61) && (noofdays<=184)) 
     { 
      double r= ((7.5)/100); 
      System.out.println(r); 
      interestRate = amount * r;   
     } 
      
     if((noofdays>= 185) && (noofdays<=365)) 
     { 
      double r= ((8.0)/100); 
      System.out.println(r); 
      interestRate = amount * r;  
     } 
    } 
  } 
  else 
   if(amount>=10000000) 
   { 
    if((noofdays>= 7) && (noofdays<=14)) 
    { 
     double r= ((6.50)/100); 
     System.out.println(r); 
     interestRate = amount * r;  
    } 
    if((noofdays>= 15) && (noofdays<=29)) 
    { 
     double r= ((6.75)/100); 
     System.out.println(r); 
     interestRate = amount * r;   
    } 
    if((noofdays>= 30) && (noofdays<=45)) 
{ 
     double r= ((6.75)/100); 
     System.out.println(r); 
     interestRate = amount * r;   
    } 
    if((noofdays> 45) && (noofdays<=60)) 
    { 
     double r= ((8.0)/100); 
     System.out.println(r); 
     interestRate = amount * r;   
    } 
    if((noofdays>= 61) && (noofdays<=184)) 
    { 
     double r= ((8.50)/100); 
     System.out.println(r); 
     interestRate = amount * r;     
    } 
    if((noofdays>= 185) && (noofdays<=365)) 
    { 
     double r= ((10.0)/100); 
     System.out.println(r); 
     interestRate = amount * r;  
    } 
   } 
  ob.close(); 
  return interestRate; 
 } 
}