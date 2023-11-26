package org.core.Homework.les3OOP;

public abstract class BaseWorker {

    //region Поля
    protected String name;
    protected int age;
    //endregion

    //region Свойства

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3){
            throw new RuntimeException("Некорректное имя человека.");
        }
        this.name = name;
    }
    //endregion

    //region Конструкторы
    protected BaseWorker(String name){
        this(name, 18);
    }

    protected BaseWorker(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //endregion

    //region Методы
    public abstract void displaySalary();
    //endregion




}