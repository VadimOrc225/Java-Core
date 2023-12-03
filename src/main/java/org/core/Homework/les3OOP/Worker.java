package org.core.Homework.les3OOP;

import org.core.les3OOP.Runner;

public class Worker extends BaseWorker{

    //region Методы



    @Override
    public void displaySalary() {
        System.out.printf("%s имеет зарплату - %.2f \n", name, salary);
    }



    public static Worker create(String name, int age, double salary){
        if (name == null || name.length() < 3){
            throw new RuntimeException("Некорректное имя человека.");
        }
        if (age < 18){
            throw new RuntimeException("Некорректный возраст человека.");
        }
        return new Worker(name, age, salary);
    }

    @Override
    public String toString() {
        return String.format("%s - %d - зарплата %f ", name, age, salary);
    }

    @Override
    public int compareTo(BaseWorker o) {
        return super.getAge() - o.getAge();
    }


    //endregion

    //region Конструкторы

    public Worker(String name, int age, double salary){
        super(name, age);
        this.salary = salary;


    }

    //endregion

    //region Свойства


    public void setSalary(float salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }


    //endregion

    //region Поля

    private double salary;


    //endregion

}
