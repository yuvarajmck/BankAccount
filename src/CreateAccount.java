import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CreateAccount {
    void getSavingsDetails(ArrayList accountDetails){
        getDetails(accountDetails);
    }
    void getCurrentDetails(ArrayList accountDetails){
        getDetails(accountDetails);
    }
    private void getDetails(ArrayList accountDetails){
        String name;
        String pin;
        Scanner userInput= new Scanner(System.in);
        System.out.print("Enter your Name : ");
        name = userInput.nextLine();
        System.out.println("\nGenerate a pin of 6 digits : ");
        pin = userInput.nextLine();
        int accNo = (int)(Math.random()*1_000_000);
        System.out.println("Account created successfully...");
        System.out.println("Name : "+name);
        System.out.println("Account Number : "+accNo);
        AccountDetails accInfo = new AccountDetails();
        accInfo.setAccountNumber(accNo);
        accInfo.setPin(pin);
        accInfo.setName(name);
        accInfo.depositMoney(0);
        accountDetails.add(accInfo);
        System.out.println("account Created successfully");
    }
}
