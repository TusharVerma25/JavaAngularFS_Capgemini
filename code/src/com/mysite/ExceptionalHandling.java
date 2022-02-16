package com.mysite;

class InsufficientAmountException extends RuntimeException
{
    InsufficientAmountException()
    {
        System.out.println("Withdrawal amount is greater than your current balance.");
    }
}

class Account {

    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdrawAmount(double amt) throws InsufficientAmountException {
        try {
            if(amt>this.balance) {
                throw new InsufficientAmountException();
            }
            this.balance= this.balance-amt;
            System.out.println("Amount withdrawn " + amt + "\nAvailabe balance " + this.balance);

        }catch(InsufficientAmountException e) {
            e.printStackTrace();
        }
    }

}
public class ExceptionalHandling {
    public static void main(String[] args) {

        Account account = new Account(5000);
        account.withdrawAmount(8000);
        account.withdrawAmount(1000);

//        int[] arr = new int[4];
//        try {
//            System.out.println("before exception");
//            arr[4]=5;
//            System.out.println("after exception");
//        }
//        catch(Exception e) {
//            System.out.println(e);
//        }
//        finally {
//            System.out.println("finally block executed");
//        }


    }
}
