import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("Pratham","3778");
        bank1.ShowMenu();
    }
}
class BankAccount {
    int Balance;
    int PreviousTransaction;

    String CustomerName;
    String CustomerID;

    BankAccount(String cname, String cid) {
        CustomerName = cname;
        CustomerID = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            Balance = Balance + amount;
            PreviousTransaction = amount;
        }
    }

    void withdraw (int amount) {
        if (amount != 0) {
            Balance = Balance - amount;
            PreviousTransaction = -amount;
        }
    }

    void getPreviousTransaction () {
        if (PreviousTransaction > 0) {
            System.out.println("Deposited: " + PreviousTransaction);
        } else if (PreviousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(PreviousTransaction));
        }
        else {
            System.out.println("No Transaction has Occured! " );
        }
    }

    void ShowMenu () {
        char Option;
        Scanner sc =  new Scanner(System.in);

        System.out.println("Welcome " + CustomerName);
        System.out.println("Your ID is: " + CustomerID);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("===================");
            System.out.println("Enter the option: ");
            System.out.println("===================");
            Option = sc.next().charAt(0);

            switch (Option) {
                case 'A':
                    System.out.println("===================");
                    System.out.println("Balance is: " + Balance);
                    System.out.println("===================");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("===================");
                    System.out.println("Enter the amount to Deposit: ");
                    System.out.println("===================");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("===================");
                    System.out.println("Enter the amount to Withdraw: ");
                    System.out.println("===================");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("===================");
                    getPreviousTransaction();
                    System.out.println("===================");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("===================");
                    break;

                default:
                    System.out.println("Invalid Option! Please Try Again");
                    break;
            }
        }while (Option != 'E');
    }
}
