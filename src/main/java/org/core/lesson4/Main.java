package org.core.lesson4;

public class Main {
    public static void main(String[] args) {

        int startBalance=0;
        int depositSum=0;
        Model account = new Model(startBalance,depositSum);
        View view = new View();

        view.testAccount(account);


    }
}
