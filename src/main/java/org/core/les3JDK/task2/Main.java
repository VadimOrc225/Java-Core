package org.core.les3JDK.task2;

public class Main {

    public static <T> boolean compareArrays(T[] array1, T[]array2){
        if (array1.length != array2.length){
            return false;
        }
        for (int i=0; i< array1.length; i++){
            if(!array1[i].getClass().equals(array2[i].getClass())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4};
        Integer[] arr2 = {1,9};
        Object[] arr3 = {1, 3, 4};
        Object[] arr4 = {1,9};
        Object[] arr5 = {4,3,2,1};

        System.out.println(compareArrays(arr1,arr2));
        System.out.println(compareArrays(arr3,arr4));
        System.out.println(compareArrays(arr1,arr5));
        System.out.println(compareArrays(arr2,arr4));

    }

}
