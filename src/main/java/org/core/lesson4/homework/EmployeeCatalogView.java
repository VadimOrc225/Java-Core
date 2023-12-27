package org.core.lesson4.homework;


import java.util.Scanner;

public class EmployeeCatalogView {

    Scanner iScanner = new Scanner(System.in);
    public char getInputOperator() {
        System.out.println("Что Вы хотите? (Добавить сотрудника - введите 1; Вывести список сотрудников по конкретному стажу -" +
                " введите 2; Найти сотрудника по табельному номеру - введите 3; Вывести телефонные номера по имени - введите 4 ");

        char op = iScanner.next().charAt(0);
        String s = "1234";
        if (s.indexOf(op) == -1) {            // проверка на ввод правильного символа операции
            System.out.println("Ввод неверный.Повторите ввод");
            getInputOperator();
        }

        return op;
    }

    public int getInputId() {
        System.out.println("Введите табельный номер сотрудника");
        int id = -1;
        try {
            id = Integer.parseInt(iScanner.next());
            return id;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            getInputId();
            return id;
        }
    }

    public String getInputName() {
        System.out.println("Введите имя сотрудника");
        String name = iScanner.next();
        return name;
    }

    public int getInputExperience() {
        System.out.println("Введите стаж ");
        int experience = -1;
        try {

            experience = Integer.parseInt(iScanner.next());
String w = iScanner.nextLine();
            return experience;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            getInputExperience();
            return experience;
        }

    }
    public String getTelephoneNumber() {
        System.out.println("Введите телефонный номер ");
        String numbers = iScanner.nextLine();
        return numbers;
    }

    public void displayInfo(Employee employee) {
        System.out.printf("Id: %s; Имя сотрудника: %s, Стаж: %d, Телефоны: %s\n", employee.getId(), employee.getName(),
                employee.getExperience(), employee.getTelephoneNumbers());
    }



    public char getInputAction() {
        System.out.println("Что Вы хотите? (Продолжить - введите 1; " +
                " Выход - 9)");
        char op2 = iScanner.next().charAt(0);
        String s = "19";
        if (s.indexOf(op2) == -1) {            // проверка на ввод правильного знака операции
            System.out.println("Ввод неверный.Повторите ввод");
            getInputAction();
        }
        return op2;
    }


    public <T> void printingResult(T result) {
        System.out.println("Результат работы метода: " +
                result);
    }

}
