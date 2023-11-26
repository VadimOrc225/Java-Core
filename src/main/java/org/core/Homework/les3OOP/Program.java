package org.core.Homework.les3OOP;

import java.util.ArrayList;
import java.util.Collection;

public class Program {

    public static void main(String[] args) {

        Collection<BaseWorker> collection = new ArrayList<>();

        collection.add(Worker.create("Максим", 23, 100000));
        collection.add(Worker.create("Александр", 24, 100000));
        collection.add(Freelancer.create("Алексей", 24, 400));
        collection.add(Freelancer.create("Матвей", 27, 410));



        for (BaseWorker x: collection) {
            x.displaySalary();

            }


    }}


