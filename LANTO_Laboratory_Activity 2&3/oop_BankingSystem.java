//create parent class bank account
class BankAccount {
    private String accountHolderName;
    private double balance;
    
    //Constructor
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    //Encapsulation Getter and Setter methods
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName){
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    //method to deposit money 
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Amount: " + amount);
        }else {
            System.out.println("Invalid deposit amount");
        }
    }

    //method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Amount: " + amount);
        }else{
            System.out.println("Invalid Withdrawal Amount or Insufficient Balance");
        }
    }

    //Polymorphism: Overridable method
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

//child class: Savings Account & extends means getting or inheriting the properties/elements from parent class to child class 
class SavingsAccount extends BankAccount {
    private double interestRate;

    //Constructor
    public SavingsAccount(String accountHolderName, double initialBalance, double interestRate) {
        super(accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }

    //Method to calculate interest
    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);

        System.out.println("Interest earned: " + interest);
    }

    //Overriding the display account details method 
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

//child class for Current Account || super is inheriting parent class
class CurrentAccount extends BankAccount {
    private double overDraftLimit;

    //Constructor 
    public CurrentAccount(String accountHolderName, double initialBalance, double overDraftLimit) {
        super(accountHolderName, initialBalance);
        this.overDraftLimit = overDraftLimit;
    }

    //Overriding withdraw method to allow overdraft
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overDraftLimit) >= amount) {
            double newBalance = getBalance() - amount;
            if (newBalance < 0) {
                overDraftLimit += newBalance; 
            }
        super.deposit(amount);

        System.out.println("Withdrawn Amount: " + amount);
        }else {
            System.out.println("Invalid withdrawal amount or overdraft limit exceeded.");
        }
    }

    //Overriding displayAccountDetails Method
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overriding Limit: " + overDraftLimit);
    }
}

//Main class to test the banking system  
public class oop_BankingSystem {
    public static void main(String[] args) {
        //creating a savings account
        SavingsAccount savings= new SavingsAccount("Marvin", 5000, 5);
        savings.displayAccountDetails();
        savings.deposit(500);
        savings.calculateInterest();
        savings.withdraw(500);
        System.out.println();

        //Creating a current account
        CurrentAccount current = new CurrentAccount("Johnny", 10000, 5000);
        current.displayAccountDetails();
        current.withdraw(1500);
        current.withdraw(500);

        current.displayAccountDetails();
        
    }
}