package interestcalculator;

import java.util.Scanner;

public class SBaccount {
    
    double SBamount , SbInterestRate, interest;
    Scanner SBScanner = new Scanner(System.in);
    
    double calculateInterest(double amount) throws InvalidAmountException{
        this.SBamount = amount;
        if(SBamount < 0 ){
            throw new InvalidAmountException();
        }
        System.out.println("Select account type \n1. NRI \n2. Normal ");
        int accountChoice = SBScanner.nextInt();
        switch (accountChoice) {
            case 1:
                SbInterestRate = .06;
                break;
            case 2:
                SbInterestRate = .04;
                break;
            default:
                System.out.println("Please choose right account again");
                
        }
     return amount * SbInterestRate;
   
}
    
}