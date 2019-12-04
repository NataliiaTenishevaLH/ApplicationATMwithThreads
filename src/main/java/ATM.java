public class ATM {
    private static  double ammount;

    //Обналичивание
    public synchronized boolean doCashWithdrawal(double sum){
        if((ammount == 0) || (ammount  < sum)){
           System.out.println("Недостаточно остатка на счету. Операция не может быть выполнена.");
           return false;
        } else{
            System.out.println("поток - снятие - cумма " + sum);
            ammount -= sum;
            return true;
        }
    }

    //Пополнение
    public void  doReplenishment(double sum){
        System.out.println("поток - пополнение - cумма " + sum);
        ammount += sum;

    }

    public void printAmmount(){
        System.out.println(ammount);
    }

    public double getAmmount(){
        return ammount;
    }

}
