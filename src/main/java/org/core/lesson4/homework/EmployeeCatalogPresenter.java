package org.core.lesson4.homework;


import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeCatalogPresenter {
    private Employee model;
    private EmployeeCatalogView view;

    public EmployeeCatalogPresenter(Employee model, EmployeeCatalogView view) {
        this.model = model;
        this.view = view;
    }

    public void performAction() {
        // первоначально в справочнике
        Employee employee = new Employee(1, "Иван", 10, "+79111111111, +79212453535");
        model.addition(employee);
        Employee employee2 = new Employee(2, "Иван", 11, "+79311111111, +79042453535");
        model.addition(employee2);
        Employee employee3 = new Employee(3, "Максим", 10, "+79281111111");
        model.addition(employee3);
        Employee employee4 = new Employee(4, "Сергей", 2, "+79041111111");
        model.addition(employee4);

        char operator = view.getInputOperator(); // запрос желаемого действия пользователя
        switch (operator) {
            case '1': // добавление сотрудника
                int id = view.getInputId();
                String name = view.getInputName();
                int experience = view.getInputExperience();
                String telephoneNumbers = view.getTelephoneNumber();
                Employee empl = new Employee(id, name, experience, telephoneNumbers);
                model.addition(empl);
                break;
            case '2': // поиск по стажу
                experience = view.getInputExperience();
                view.printingResult(model.matchingExperience(experience));
                break;

            case '3':
                id = view.getInputId(); // поиск по табельному номеру
                view.printingResult(model.matchingId(id));
                break;
            case '4':
                name = view.getInputName(); // поиск телефонов по имени
                view.printingResult(model.telNumberByName(name));
                break;

        }
//
//        char operator2 = view.getInputAction();
//        switch (operator2) {
//            case '1': // продолжить
//                performAction();
//                break;
//
//            case '9': // выход
//
//                break;
//        }
    }
}