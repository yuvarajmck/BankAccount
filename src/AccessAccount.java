import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AccessAccount {
    void getSavingsDetails(ArrayList accountDetails){
        validateAccount(accountDetails);
    }
    void getCurrentDetails(ArrayList accountDetails){
        validateAccount(accountDetails);
    }
    private void getAccountDetails(AccountDetails accountDetails){
        Scanner userInput = new Scanner(System.in);
        String name = accountDetails.getName();
        System.out.println("Hello " + name);
        while(true){

            double bal = accountDetails.getBalance();
            System.out.println("Type 1 -> Balance enquiry\nType 2 -> Withdraw\nType 3 -> Deposit\nType 4 -> Change pin\nType 0 -> Exit");
            int choice = userInput.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Balance : " + bal);
                }
                case 2 -> {
                    System.out.print("Enter an amount to withdraw : ");

                    try {
                        double amt = userInput.nextDouble();
                        if (amt <= accountDetails.getBalance() && amt > 10) {
                            accountDetails.withdrawMoney(amt);
                            System.out.println("\nKindly tak your cash and visit again....");
                        }
                    } catch (Exception e) {
                        System.out.print("\nInvalid Input");
                    }
                }
                case 3 -> {
                    System.out.print("Enter the money to deposit : ");
                    try {
                        double amt = userInput.nextDouble();
                        if (amt > 10 && amt < 1_000_000) {
                            accountDetails.depositMoney(amt);
                            System.out.println("\nDeposited successfully");
                        }
                    } catch (Exception e) {
                        System.out.println("\nInvalid Input");
                    }
                }
                case 4 -> {
                    System.out.print("Enter New pin : ");
                    String pin = userInput.nextLine();
                    if (pin.length() == 6) {
                        System.out.println("Pin Updated successfully");
                    } else {
                        System.out.println("Invalid Pin");
                    }
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid Option");
                }
            }
        }

    }
    private void validateAccount(ArrayList<AccountDetails> accountDetails){
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.println("Enter account Number : ");

            int accountNo = userInput.nextInt();


            for (AccountDetails i : accountDetails) {
                if (i.getAccountNumber() == accountNo) {
                    System.out.print("\nEnter pin : ");
                    String Pin = userInput.next();
                    System.out.println(i.getPin().equals(Pin));
                    if (i.getPin().equals(Pin)) {
                        getAccountDetails(i);
                        return;
                    }
                    else{

                    }
                }
            }
            System.out.println("Type 0 -> Exit");
            int choice = userInput.nextInt();
            if(choice==0){
                return;
            }
        }
    }
}
