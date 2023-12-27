package org.core.lesson4.homework;

public class Main {
    public static void main(String[] args) {
        Employee model = new Employee();
        EmployeeCatalogView view = new EmployeeCatalogView();
        EmployeeCatalogPresenter presenter = new EmployeeCatalogPresenter(model, view);
        presenter.performAction();

    }
}