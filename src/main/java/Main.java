public class Main {

    public static void main(String args[]) throws InterruptedException {
        ATM atm = new ATM();
        Thread customer1 = new CustomerThread(atm, Transaction.replenishment, 5000);
        customer1.start();
        Thread.sleep(1000);
        System.out.println(atm.getAmmount());
        Thread.sleep(1000);
        atm.printAmmount();

        Thread customer2 = new CustomerThread(atm, Transaction.replenishment, 5000);
        customer2.start();
        Thread.sleep(1000);
        atm.printAmmount();

        Thread customer3 = new CustomerThread(atm, Transaction.withdrawal, 3000);
        customer3.start();
        Thread.sleep(1000);
        atm.printAmmount();

        Thread customer4 = new CustomerThread(atm, Transaction.withdrawal, 8000);
        customer4.start();
        Thread.sleep(1000);
        atm.printAmmount();

        Thread customer5 = new CustomerThread(atm, Transaction.withdrawal, 7000);
        customer5.start();
        Thread.sleep(1000);
        atm.printAmmount();

        Thread customer6 = new CustomerThread(atm, Transaction.withdrawal, 0.01);
        customer6.start();
        Thread.sleep(1000);
        atm.printAmmount();
    }
}
