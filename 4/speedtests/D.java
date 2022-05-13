/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;

/**
 *
 * @author Gustavo Lima
 */
public class okapa {

    public static void main(String[] args) {
        Random rand = new Random();

        int arraylen = 1000;

        int[] array = new int[arraylen];

        for (int i = 0; i < arraylen; i++) {
            array[i] = rand.nextInt(10000);
        }

        quicksort(array, 0, array.length - 1);

        for (int i = 0; i < arraylen; i++) {
            System.out.println(array[i]);
        }
    }

    private static void quicksort(int[] a, int lo, int hi) {

        if (hi <= lo + 30 - 1) {
            sort(a, lo, hi);
            return;
        }
        int meio = (lo + hi) / 2;

        if (a[meio] < (a[lo])) {
            troca(a, lo, meio);
        }

        if (a[hi] < (a[lo])) {
            troca(a, lo, hi);
        }

        if (a[hi] < (a[meio])) {
            troca(a, meio, hi);
        }

        troca(a, meio, hi - 1);

        int median = a[hi - 1];

        int i = lo, j = hi - 1;
        while (true) {
            while (a[++i] < (median));
            while ((a[--j]) > median);
            if (i < j) {
                troca(a, i, j);
            } else {
                break;
            }
        }
        troca(a, i, j);

        quicksort(a, lo, i - 1);
        quicksort(a, i + 1, hi);

    }

    private static void troca(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    private static void sort(int[] a, int low, int high) {

        for (int i = low; i < high; i++) {
            for (int j = low; j < high - 1; j++) {
                if (a[j] > a[j + 1]) {
                    troca(a, j, j + 1);
                }
            }
        }
    }
}
