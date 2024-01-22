package org.core.les6JDK;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла и
 * наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
 * Необходимо:
 * Создать свой Java Maven или Gradle проект;
 * Самостоятельно реализовать прикладную задачу;
 * Сохранить результат в HashMap<шаг теста, результат>
 * Вывести на экран статистику по победам и поражениям
 */
public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Map<Integer, Boolean> resultsWithChanging = changingChoice();
        int count1 = 0;
        for (Map.Entry<Integer, Boolean> entry : resultsWithChanging.entrySet()) {
            Boolean value = entry.getValue();
            if (value == true) count1++;
        }
        int wins1 = count1;

        int loosers1 = resultsWithChanging.size() - wins1;
        double wins1Percent = (double) wins1 / 1000 * 100;
        System.out.println("Статистика при изменении первоначального выбора:");
        System.out.printf("Количество побед: %d; поражений: %d; процент побед: %.1f%%.\n",
                wins1, loosers1, wins1Percent);

        Map<Integer, Boolean> resultsWithoutChanging = notChangingChoice();
        int count2 = 0;
        for (Map.Entry<Integer, Boolean> entry : resultsWithoutChanging.entrySet()) {
            Boolean value = entry.getValue();
            if (value == true) count2++;
        }
        int wins2 = count2;
        int loosers2 = resultsWithoutChanging.size() - wins2;
        double wins2Percent = (double) wins2 / 1000 * 100;
        System.out.println("Статистика без изменения первоначального выбора:");
        System.out.printf("Количество побед: %d; поражений: %d; процент побед: %.1f%%.\n",
                wins2, loosers2, wins2Percent);
    }

    /**
     * Выбор двери, где приз (начальное случайное условие)
     *
     * @return номер двери
     */
    private static int prizeDoor() {
        int randomDoor = random.nextInt(0, 3);
        return randomDoor;
    }

    /**
     * Ведущий открывает дверь, отличную от выбора игрока. За ней пусто
     *
     * @param firstChoice Выбор игрока
     * @param randomDoor  Призовая дверь
     * @return
     */
    private static int masterOpenDoor(int firstChoice, int randomDoor) {
        int masterDoor = 0;
        for (int i = 0; i < 3; i++) {
            if (i != firstChoice && i != randomDoor)
                masterDoor = i; //"Бессильный МОЛЛИ выбирает всегда ближайшую козу (большее i)"
            int randomX = random.nextInt(0, 2);
            if (firstChoice == randomDoor && randomDoor == 1) masterDoor = masterDoor - randomX * 2; //
            else if (firstChoice == randomDoor) masterDoor = masterDoor - randomX;
        }
        return masterDoor;
    }

    /**
     * Второй выбор, отличный от первого
     *
     * @param firstChoice Первый ход игрока
     * @param masterDoor  Открытая ведущим дверь
     * @return
     */
    private static int secondChoice(int firstChoice, int masterDoor) {
        int secondChoice = 0;
        for (int i = 0; i < 3; i++) {
            if (i != firstChoice && i != masterDoor) secondChoice = i;
        }
        return secondChoice;
    }

    /**
     * Имитация 1000 циклов игры, где игрок меняет первоначальный выбор
     *
     * @return Map<Integer, Boolean> changingResults
     */
    private static Map<Integer, Boolean> changingChoice() {
        Map<Integer, Boolean> changingResults = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int door = prizeDoor();
            int firstChoice = random.nextInt(0, 3);
            int openDoor = masterOpenDoor(firstChoice, door);
            int secondChoice = secondChoice(firstChoice, openDoor);
            if (secondChoice == door) changingResults.put(i, true);
            else changingResults.put(i, false);
        }
        return changingResults;
    }

    /**
     * Имитация 1000 циклов игры, где игрок НЕ меняет первоначальный выбор
     *
     * @return Map<Integer, Boolean> resultsWithoutChanging
     */
    private static Map<Integer, Boolean> notChangingChoice() {
        Map<Integer, Boolean> resultsWithoutChanging = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int door = prizeDoor();
            int firstChoice = random.nextInt(0, 3);
            if (firstChoice == door) resultsWithoutChanging.put(i, true);
            else resultsWithoutChanging.put(i, false);

        }
        return resultsWithoutChanging;
    }
}
