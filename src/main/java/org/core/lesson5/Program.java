package org.core.lesson5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Program {

    /**
     * 1.  Создать папку ./backup и вкопировать файлы в нее через поток байт;
     */


    public static void main(String[] args) throws IOException {

        String[] listPaths = searchPaths(new File("."));
        String[] listNames = searchNames(new File("."));
        new File("./backup").mkdir();
        for (int i = 0; i < listPaths.length; i++) {
            copyMethod(listPaths[i], listNames[i]);
        }
    }

    /**
     *
     * @param fileIn1 имя копируемого файла (путь к нему)
     * @param fileOut имя нового файла - копии
     * @throws IOException
     */
    static void copyMethod(String fileIn1, String fileOut) throws IOException {
        // На запись
        try (FileOutputStream fileOutputStream = new FileOutputStream("./backup/" + fileOut)) {
            int c;
            // На чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn1)) {
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }

        }
    }

    /**
     *
     * @param dir директория, из которой копируются файлы
     * @return массив путей ко всем файлам в директории
     * @throws IOException
     */
    static String[] searchPaths(File dir) throws IOException {
        File[] files = dir.listFiles();
        String[] list1 = new String[files.length];
        int count = 0;

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile())
                list1[i] = files[i].getCanonicalPath();
        }
        for (String s : list1) {
            if (s != null) count++;
        }
        String[] list = new String[count];
        int i = 0;
        for (int j = 0; j < list1.length; j++) {
            if (list1[j] != null) {
                list[i] = list1[j];
                i++;
            }
        }
        return list;
    }

    /**
     *
     * @param dir директория, из которой копируются файлы
     * @return массив имен файлов в директории
     * @throws IOException
     */
    static String[] searchNames(File dir) throws IOException {
        File[] files = dir.listFiles();
        String[] list1 = new String[files.length];
        int count = 0;

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile())
                list1[i] = files[i].getName();
        }
        for (String s : list1) {
            if (s != null) count++;
        }
        String[] list = new String[count];
        int i = 0;
        for (int j = 0; j < list1.length; j++) {
            if (list1[j] != null) {
                list[i] = list1[j];
                i++;
            }
        }
        return list;
    }

}
