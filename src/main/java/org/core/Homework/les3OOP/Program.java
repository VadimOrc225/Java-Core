package org.core.Homework.les3OOP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Program {

    public static void main(String[] args) {

        ArrayList<BaseWorker> collection = new ArrayList<>();

        collection.add(Worker.create("Максим", 23, 100000));
        collection.add(Worker.create("Александр", 24, 105000.50));
        collection.add(Freelancer.create("Алексей", 24, 400.33));
        collection.add(Freelancer.create("Матвей", 27, 410.66));
        collection.add(Freelancer.create("Анна", 20, 398.00));


        for (BaseWorker x : collection) { // foreach
            x.displaySalary();
        }
        System.out.println("****---****");
        for (BaseWorker x : collection) {    // foreach вывод более полной информации
            System.out.println(x.toString());
        }

        Collections.sort(collection);  // реализована сортировка по возрасту
        System.out.println("****---****");

        for (BaseWorker x : collection) {    // foreach вывод после сортировки
            System.out.println(x.toString());
        }


    }
}


