package org.core.lesson4;

import java.util.Scanner;

public class View {


    /**
     * 1. Создать программу управления банковским счетом (Account).
     * <p>
     * Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств.
     * При этом она должна обрабатывать следующие исключительные ситуации:
     * <p>
     * Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException
     * с соответствующим сообщением.
     * Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException с соответствующим сообщением.
     * Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.
     * <p>
     * Продемонстрируйте работу вашего приложения:
     * Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.
     */


    Scanner iScanner = new Scanner(System.in);

    public void testAccount(Model account) {

        try {
            account.setStartBalance(inputBalance());
            System.out.printf("Начальный балланс: %d\n", account.getStartBalance());
            account.setDepositSum(inputDeposit());
            System.out.printf("Сумма депозита: %d\n",
                    account.getDepositSum());
            int sumBalance = account.getDepositSum() + account.getStartBalance();
            int summaFromDeposit = inputSumFromDeposit(sumBalance);
            account.setDepositSum(sumBalance - summaFromDeposit);
            System.out.printf("На счете осталось: %d\n",
                    (sumBalance - summaFromDeposit));


        } catch (IllegalArgumentException e) {
            System.out.printf("%s. Вы вводите [%d]\n", e.getMessage(), e.getSum());
        } catch (InsufficientFundsException e) {
            System.out.printf("%s. Вы вводите сумму: [%d]\n", e.getMessage(), e.getSum());

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
        } finally {
            iScanner.close();
        }
    }

    /**
     * Возвращает начальный балланс
     *
     * @return начальный балланс
     * @throws IllegalArgumentException некорректный ввод балланса
     */
    public int inputBalance() throws IllegalArgumentException {

        System.out.print("Введите начальный балланс\n ");
        int startBalance = Integer.parseInt(iScanner.next());
        if (startBalance < 0) {
            iScanner.close();
            throw new IllegalArgumentException("Вы ввели отрицательное число", startBalance);
        }
        return startBalance;
    }

    /**
     * Возвращает сумму депозита
     *
     * @return сумма депозита
     * @throws IllegalArgumentException некорректный ввод
     */
    public int inputDeposit() throws IllegalArgumentException {
        System.out.print("Введите сумму депозита\n ");
        int depositSum = Integer.parseInt(iScanner.next());
        if (depositSum < 0) {
            iScanner.close();
            throw new IllegalArgumentException("Вы ввели отрицательное число", depositSum);
        }
        return depositSum;
    }

    /**
     *
     * @param depositSum сумма на депозите до снятия
     * @return сумма снятия
     * @throws InsufficientFundsException
     */
    public int inputSumFromDeposit(int depositSum) throws InsufficientFundsException {
        System.out.print("Введите сумму снятия средств\n ");
        int sumFromDeposit = Integer.parseInt(iScanner.next());
        if (sumFromDeposit > depositSum) {
            iScanner.close();
            throw new InsufficientFundsException("На депозите меньше, чем Вы ввели", sumFromDeposit);
        }
        System.out.printf("Вы сняли %d\n", sumFromDeposit);


        return sumFromDeposit;
    }


}
