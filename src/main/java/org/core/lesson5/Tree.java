package org.core.lesson5;

import java.io.File;

/**
 * необходимо распечатывать дерево директорий и файлов
 */
public class Tree {

    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
        }
        int subFilesTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) subFilesTotal++;
        }


        int subDirCounter = 0;
        int subFilesCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirTotal == ++subDirCounter && subFilesTotal == subFilesCounter);
            } else print(files[i], indent, subFilesTotal == ++subFilesCounter && subDirTotal == subDirCounter);
        }
    }
}


