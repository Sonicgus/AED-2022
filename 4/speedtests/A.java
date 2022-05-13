
import java.util.Random;

public class A {

    public static void main(String[] args) {
        Random rand = new Random();

        for (int N = 1; N < 11; N++) {
            int l = 1000;
            int c = 100 * N;

            int[][] array = new int[l][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < c; j++) {
                    array[i][j] = rand.nextInt(10000);
                }
            }//gerar matriz

            long start = System.currentTimeMillis();

            int total = l * c;
            for (int n = 0; n < total; n++) {
                int X = rand.nextInt(10000);
                int numinf = 0;
                for (int i = 0; i < l; i++) {
                    for (int j = 0; j < c; j++) {
                        int valor = array[i][j];
                        if (valor < X) {
                            numinf++;
                        }
                    }
                }
                int res = (int) ((100 * numinf) / total);
            }

            long finish = System.currentTimeMillis();
            System.out.println(finish - start);
        }
    }
}
