/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;

/**
 *
 * @author Gustavo Lima
 */
public class novo {

    private static int c(int[][] array, int i) {
        return i % 100;
    }

    private static int l(int[][] array, int i) {
        return i / 100;
    }

    private static int getelem(int[][] array, int i) {
        return array[l(array, i)][c(array, i)];
    }

    public static void main(String[] args) {
        int ls = 100;
        int cs = 100;
        Random rand = new Random();
        int[][] array = new int[ls][cs];

        for (int i = 0; i < 10000; i++) {
            array[l(array, i)][c(array, i)] = rand.nextInt(10000);
            getelem(array, 1);
        }
        /*
        quicksort(array, 0, array.length - 1);
         */
        for (int i = 0; i < 10000; i++) {
            System.out.println(i+" "+l(array, i)+" "+c(array, i));            
            //System.out.println(array[l(array, i)][c(array, i)]);
        }
    }

    private static void quicksort(int[] array, int primeiro, int ultimo) {

        if (primeiro + 30 > ultimo) {
            sort(array, primeiro, ultimo);
            return;
        }
        int meio = (primeiro + ultimo) / 2;

        if (array[meio] < (array[primeiro])) {
            troca(array, primeiro, meio);
        }

        if (array[ultimo] < (array[primeiro])) {
            troca(array, primeiro, ultimo);
        }

        if (array[ultimo] < (array[meio])) {
            troca(array, meio, ultimo);
        }

        troca(array, meio, ultimo - 1);

        int pivot = array[ultimo - 1];

        int i = primeiro + 1, j = ultimo - 1;
        while (true) {
            while (array[++i] < (pivot));
            while ((array[--j]) > pivot);
            if (i < j) {
                troca(array, i, j);
            } else {
                break;
            }
        }
        troca(array, i, ultimo - 1);

        quicksort(array, primeiro, i - 1);
        quicksort(array, i + 1, ultimo);

    }

    private static void troca(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    private static void sort(int[] a, int low, int high) {

        for (int i = low; i < high; i++) {
            for (int j = low; j < high; j++) {
                if (a[j] > a[j + 1]) {
                    troca(a, j, j + 1);
                }
            }
        }
    }

}
