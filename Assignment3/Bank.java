import java.util.*;

class BankAccount{
    // String name;
    // double accNum;
    double balance=6000;
    Scanner sc=new Scanner(System.in);
    void deposit(){};
    void withdraw(){};
    // void getinfo(){
    //     System.out.println("Enter name:");
    //     name=sc.nextLine();
    //     System.out.println("Enter account number");
    //     accNum=sc.nextDouble();
    //     System.out.println("Initial balance");
    //     balance=sc.nextDouble();
    // }

}
class Saving_Acc extends BankAccount{
    double amount;
    
    @Override
    void deposit(){
        System.out.println("Enter amount to deposit");
        amount=sc.nextDouble();
       System.out.println("Ammount Deposited Succesfully...");
       balance+=amount;
       System.out.println("Your account balance is" + balance);
    }
    void withdraw(){
        System.out.println("Enter amount to withdraw");
        amount=sc.nextDouble();
        if(balance<100 && amount>balance){
            System.out.println("Insufficient balance!");
        }else{
            balance-=amount;
            System.out.println("Amount withdrew succesfully...");
            System.out.println("Your account balance is"+ balance);
        }

    }
}
class Bank{
    public static void main(String [] args){
        Saving_Acc acc=new Saving_Acc();
        Scanner sc=new Scanner(System.in);
        int choice;
       
        do { 
           
            System.out.println("1.Deposit amount\n2.Withdraw");
            System.out.println("Enter choice");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                acc.deposit();;

                    
                    break;
                case 2:
                acc.withdraw();
                break;
                default:
                    System.out.println("invalid choice");
            }


            
        } while (choice!=2);
       
        
    }

}