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

    public static void main(String[] args) {

        Random rand = new Random();

        for (int N = 1; N < 11; N++) {
            int arraylen = 100000 * N;
            int[] array = new int[arraylen];/*
            for (int i = 0; i < arraylen; i++) {
                array[i] = rand.nextInt(10000);
            }*/

            int[] ns = new int[10000];
            System.out.println("lol");/*
            for (int i = 0; i < 10000; i++) {
                ns[i] = 0;
            }*/
            //System.out.println(ns);

            long start = System.currentTimeMillis();

            quicksort(array, 0, array.length - 1);

            for (int n = 0; n < arraylen; n++) {
                int X = rand.nextInt(10000);
                int numinf = 0;
                boolean flag = true;

                for (int i = 0; flag && i < arraylen; i++) {
                    int valor = array[i];
                    if (valor < X) {
                        numinf++;
                    } else {
                        flag = false;
                    }
                }

                int res = (int) ((100 * numinf) / arraylen);
            }
            long finish = System.currentTimeMillis();
            System.out.println(finish - start);
        }
    }

    private static void quicksort(int[] array) {

    }
}
