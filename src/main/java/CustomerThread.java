public class CustomerThread extends Thread {

    private ATM atm;
    private double ammount;
    private Transaction transaction;

    public CustomerThread(ATM atm, Transaction transaction, double ammount) {
        this.atm = atm;
        this.ammount = ammount;
        this.transaction = transaction;
    }

    @Override
    public void run() {
        if (this.transaction.equals(Transaction.replenishment)) {
            atm.doReplenishment(this.ammount);
        } else if (this.transaction.equals(Transaction.withdrawal)) {
            atm.doCashWithdrawal(this.ammount);
        }
    }
}
