package org.core.lesson4.homework;


import java.util.ArrayList;


    public class Employee {
        private int id; // табельный номер
        private String name; // имя
        private int experience; // стаж
        private String telephoneNumbers; // номер телефона
        private ArrayList<Employee> catalog = new ArrayList<>();



        // ряд конструкторов
        public Employee() {

        }

        public Employee(int id, String name, int experience, String telephoneNumbers) {
            this.id = id;
            this.name = name;
            this.experience = experience;
            this.telephoneNumbers = telephoneNumbers;
        }



        public int getId() {
            return id;
        }


        public String getName() {
            return name;
        }


        public int getExperience() {
            return experience;
        }


        public String getTelephoneNumbers() {
            return telephoneNumbers;
        }


        /**
         * Метод добавления сотрудника
         * @param employee
         */

        public void addition(Employee employee) {
            catalog.add(employee);
        }



        /**
         * Метод поиска сотрудника по стажу
         *
         * @param experience - стаж
         * @return список имен сотрудников с данным стажем
         */
        public ArrayList<String> matchingExperience(int experience) {
            ArrayList<String> names = new ArrayList<>();

            for (Employee x : catalog) {
                if (experience == x.experience) {
                    names.add(x.getName());
                }
            }
            return names;  //возвращает список имен сотрудников с данным стажем
        }

        /**
         * Метод поиска сотрудника по табельному номеру
         *
         * @param id - табельный номер
         * @return имя сотрудника
         */
        public String matchingId(int id) {
            String temp = "";
            for (Employee x : catalog) {
                if (id==x.id) {
                    temp = x.name; //возвращает имя сотрудника с данным табельным номером
                }
            }
            return temp;
        }

        public ArrayList<String> telNumberByName(String name) {
            ArrayList<String> numbers = new ArrayList<>();

            for (Employee x : catalog) {
                if (name.equals(x.name)) {
                    numbers.add(x.getTelephoneNumbers());
                }
            }
            return numbers;  //возвращает список номеров сотрудников с данным именем
        }

        }




