import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ATMTest {

    @Test
    public void testMethod_doCashWithdrawal_doReplenishment() throws InterruptedException {

        ATM mock = mock(ATM.class);
        ATM atm = new ATM();

        //Пополняем АТМ на 10000 и проверяем, что остаток в банкомате 10000
        atm.doReplenishment(10000.0);
        when(mock.getAmmount()).thenReturn(atm.getAmmount());
        Thread.sleep(1000);
        Assertions.assertEquals(mock.getAmmount(), 10000.0);

        //Обналичиваем 3000 и проверяем что остаток 7000
        atm.doCashWithdrawal(3000.0);
        when(mock.getAmmount()).thenReturn(atm.getAmmount());
        Assertions.assertEquals(mock.getAmmount(), 7000.0);

        //Пытаемся обналичить больше чем на остатке и проверяем, что сумма не снята
        atm.doCashWithdrawal(8000.0);
        when(mock.getAmmount()).thenReturn(atm.getAmmount());
        Assertions.assertEquals(mock.getAmmount(), 7000.0);
    }

    @RepeatedTest(10)
    void repeatedTest(TestInfo testInfo) throws InterruptedException {
        ATM atm = new ATM();
        atm.doReplenishment(10000.0);
        ATM mock = mock(ATM.class);
        atm.doCashWithdrawal(10000.0);
        when(mock.getAmmount()).thenReturn(atm.getAmmount());
        Thread.sleep(1000);
        Assertions.assertEquals(mock.getAmmount(), 0.0);
    }

    @Test
    void testExpectedException() {
        ATM mock = mock(ATM.class);
        //Проверка на RuntimeException
        when(mock.doCashWithdrawal(Mockito.anyDouble())).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () -> {
            mock.doCashWithdrawal(5000.0);
            Assertions.assertEquals(mock.getAmmount(), 5000.0);
        });
    }

}
