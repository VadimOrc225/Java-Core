package org.core.Homework.les3OOP;

import org.core.les3OOP.Runner;

public class Freelancer extends BaseWorker{

    //region Методы

    @Override
    public void displaySalary() {
        System.out.printf("%s имеет зарплату %.2f\n", name,  (20.8 * 8 * hourSalary));
    }

    public static Freelancer create(String name, int age, double hourSalary){
        if (name == null || name.length() < 3){
            throw new RuntimeException("Некорректное имя человека.");
        }
        if (age < 18){
            throw new RuntimeException("Некорректный возраст человека.");
        }
        return new Freelancer(name, age, hourSalary);
    }

    @Override
    public String toString() {
        return String.format("%s - %d - почасовая оплата равна %f ", name, age, hourSalary);
    }



    //endregion

    //region Конструкторы

    public Freelancer(String name, int age, double salary){
        super(name, age);
        this.hourSalary = salary;


    }

    //endregion

    //region Свойства


    public double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }


    //endregion

    //region Поля

    private double hourSalary;

    @Override
    public int compareTo(BaseWorker o) {
        return super.getAge() - o.getAge();
    }


    //endregion

}
