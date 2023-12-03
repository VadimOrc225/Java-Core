package org.core.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Model {

    //region Поля
    protected int startBalance;
    protected int depositSum;
    //endregion

    public Model(int startBalance, int depositSum) {
        this.startBalance = startBalance;
        this.depositSum = depositSum;
    }



    //region Свойства
    public int getDepositSum() {
        return depositSum;
    }

    public void setDepositSum(int depositSum) {
        this.depositSum = depositSum;
    }

    public int getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(int startBalance) {
        this.startBalance = startBalance;
    }
    //endregion


}
