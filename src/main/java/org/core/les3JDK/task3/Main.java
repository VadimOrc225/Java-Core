package org.core.les3JDK.task3;

public class Main {
    public static void main(String[] args) {
        Pair<String,Integer>myPair = new Pair<>("Первый", 4);
        Pair<Object,Double>myPair2 = new Pair<>(1111, 4.9);
        System.out.println(myPair.toString());
        System.out.println(myPair);
        System.out.println(myPair2);
    }
}
