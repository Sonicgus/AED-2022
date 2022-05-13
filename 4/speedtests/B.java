
import java.util.Random;

public class B {

    public static void main(String[] args) {
        Random rand = new Random();

        for (int N = 1; N < 11; N++) {
            int linhas = 1000;
            int colunas = 100 * N;

            int[][] array = new int[linhas][colunas];

            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    array[i][j] = rand.nextInt(10000);
                }
            }//gerar matriz

            long start = System.currentTimeMillis();

            int min = array[0][0],
                    minl = 0,
                    minc = 0;
            for (int linha = 0; linha < linhas; linha++) {
                for (int coluna = 0; coluna < colunas; coluna++) {
                    boolean flag = false;

                    for (int l = 0; l < linhas; l++) {
                        for (int c = 0; c < colunas; c++) {

                            if (!flag) {
                                l = linha;
                                c = coluna;
                            }
                            int elem = array[l][c];
                            if (!flag) {
                                flag = true;
                                min = elem;
                                minl = l;
                                minc = c;

                            } else if (elem < min) {
                                min = elem;
                                minl = l;
                                minc = c;
                            }

                        }
                    }
                    array[minl][minc] = array[linha][coluna];
                    array[linha][coluna] = min;
                }
            }

            int total = linhas * colunas;

            for (int n = 0; n < total; n++) {
                int X = rand.nextInt(10000);
                int numinf = 0;
                boolean flag = false;
                for (int i = 0; i < linhas && !flag; i++) {
                    for (int j = 0; j < colunas && !flag; j++) {
                        int valor = array[i][j];
                        if (valor < X) {
                            numinf++;
                        } else {
                            flag = true;
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
