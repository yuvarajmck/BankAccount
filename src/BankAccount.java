import java.util.ArrayList;
import java.util.Scanner;

class AccountDetails{
    private int accNo;
    private String pin;
    private String Name;
    private double balance;


    void accDetails(int accNo, String pin, String Name, double balance){
        this.accNo = accNo;
        this.pin = pin;
        this.Name = Name;
        this.balance = balance;
    }

    void setName(String name){
        this.Name = name;
    }
    void setAccountNumber(int accNo){
        this.accNo = accNo;
    }
    void setPin(String pin){
        this.pin = pin;
    }

    void depositMoney(double amt){
        balance+=amt;
    }
    void withdrawMoney(double amt){
        balance-=amt;
    }
    String getName(){
        return Name;
    }

    int getAccountNumber(){
        return accNo;
    }
    double getBalance(){
        return balance;
    }
    String getPin(){
        return pin;
    }

}
public class BankAccount {

    public static void main(String[] args) {
        ArrayList<AccountDetails> accountDetails = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);

        while(true){
            System.out.println("Welcome to the bank of Kraigo...");
            System.out.println("Type 1 -> Create new Account\nType 2 -> Login");
            System.out.print("Choice : ");
            int choice = userInput.nextInt();
            switch (choice) {
                case 1 -> {
                    createNewAccount(accountDetails);
                }
                case 2 -> {
                    getAccountInfo(accountDetails);
                }
                default -> {
                    System.out.println("Invalid entry");
                }
            }
        }
    }

    private static void createNewAccount(ArrayList accountDetails) {
        System.out.println("Choose Account Type : ");
        System.out.println("Type 1 -> Current Account\nType 2 -> Savings AccountType 3 -> Exit");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();
        CreateAccount createAccount = new CreateAccount();
        switch (choice) {
            case 1 -> {
                createAccount.getSavingsDetails(accountDetails);
            }
            case 2-> {
                createAccount.getCurrentDetails(accountDetails);
            }
            case 3 -> {
                return;
            }
            default -> {
                System.out.println("Invalid Choice");
            }
        }
    }
    private static void getAccountInfo(ArrayList accountDetails){
        System.out.println("Choose Account Type : ");
        System.out.println("Type 1 -> Current Account\nType 2 -> Savings AccountType 3 -> Exit");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();
        AccessAccount accessAccount = new AccessAccount();
        switch (choice) {
            case 1 -> {
                accessAccount.getSavingsDetails(accountDetails);
            }
            case 2-> {
                accessAccount.getCurrentDetails(accountDetails);
            }
            case 3 -> {
                return;
            }
            default -> {
                System.out.println("Invalid Choice");
            }
        }
    }
}
