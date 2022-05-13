
import static java.lang.Integer.parseInt;
import java.util.*;

public class D {

    static int linhas = 0;
    static int colunas = 0;

    private static int l(int[][] array, int i) {
        return i / colunas;
    }

    private static int c(int[][] array, int i) {
        return i % colunas;
    }

    private static int array(int[][] array, int i) {
        return array[l(array, i)][c(array, i)];
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            String[] s;
            int[][] array = null;

            linhas = colunas = 5;

            array = new int[5][5];

            do {
                s = in.nextLine().split(" ");

                switch (s[0]) {
                    case "RASTER":
                        linhas = parseInt(s[1]);
                        colunas = parseInt(s[2]);

                        array = new int[linhas][colunas];

                        for (int i = 0; i < linhas; i++) {
                            s = in.nextLine().split(" ");
                            for (int j = 0; j < colunas; j++) {
                                array[i][j] = parseInt(s[j]);
                            }
                        }
                        int[] ns = new int[10000];

                        for (int i = 0; i < linhas; i++) {
                            for (int j = 0; j < colunas; j++) {
                                ns[array[i][j]]++;
                            }
                        }
                        for (int i = 1; i < 10000; i++) {
                            ns[i] += ns[i - 1];
                        }
                        for (int i = 10000 - 1; i > 1; i--) {
                            ns[i] = ns[i - 1];
                        }
                        ns[0] = 0;

                        int[] newarray = new int[linhas * colunas];

                        for (int i = 0; i < linhas * colunas; i++) {
                            //newarray[ns[array[i]]++] = array[i];
                            int temp = array[l(array, i)][c(array, i)];
                            newarray[ns[temp]++] = temp;

                        }

                        for (int i = 0; i < linhas * colunas; i++) {
                            array[l(array, i)][c(array, i)] = newarray[i];
                        }

                        System.out.println("RASTER GUARDADO");
                        break;
                    case "AMPLITUDE":

                        if (array != null) {
                            if (linhas * colunas == 1) {
                                System.out.println(array[0][0]);
                            } else {
                                System.out.println(array[linhas - 1][colunas - 1] - array[0][0]);
                            }
                        }
                        break;
                    case "PERCENTIL":
                        if (array != null) {
                            int total = linhas * colunas;
                            int secparam = parseInt(s[1]);
                            s = in.nextLine().split(" ");
                            for (int n = 0; n < secparam; n++) {
                                int X = parseInt(s[n]);
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
                                double res = (100 * numinf) / total;
                                System.out.print(Math.round(res));
                                if (n != secparam - 1) {
                                    System.out.print(" ");
                                }
                            }
                            System.out.println();
                        }
                        break;
                    case "MEDIANA":
                        if (array != null) {

                            int total = linhas * colunas;

                            if (total % 2 == 0) {

                                int sera1 = (total / 2) - 1;
                                int l = sera1 / colunas;
                                int c = sera1 % colunas;

                                int centro1 = array[l][c];

                                int sera2 = sera1 + 1;
                                l = sera2 / colunas;
                                c = sera2 % colunas;

                                int centro2 = array[l][c];

                                double mediana = (centro1 + centro2) / 2;
                                System.out.println(Math.round(mediana));
                            } else {
                                if (total == 1) {
                                    System.out.println(array[0][0]);
                                } else {
                                    int sera = (total - 1) / 2 + 1;
                                    int l = sera / colunas;
                                    int c = sera % colunas;

                                    System.out.println(array[l][c]);
                                }

                            }
                        }

                        break;
                    default:
                        break;
                }
            } while (!s[0].equals("TCHAU"));
        } catch (NumberFormatException e) {
        }
    }
}
