package org.core.les5JDK.homework;

public class Fork {
    private int id;
    private boolean availability = true;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public boolean getAvailability(){
        return availability;
    }

    public void setAvailability(boolean flag){
        availability = flag;
    }

    public void take() {
        if (availability) {
            System.out.println("Вилка " + id + " взята");
            setAvailability(false);
        }
    }

    public void put() {
        System.out.println("Вилка " + id + " положена");
        setAvailability(true);
        }
    }

