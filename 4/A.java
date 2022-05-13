
import static java.lang.Integer.parseInt;
import java.util.*;

public class A {

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            String[] s;
            int[][] array = null;
            int l = 0, c = 0;

            do {
                s = in.nextLine().split(" ");

                switch (s[0]) {
                    case "RASTER":
                        l = parseInt(s[1]);
                        c = parseInt(s[2]);

                        array = new int[l][c];

                        for (int i = 0; i < l; i++) {
                            s = in.nextLine().split(" ");
                            for (int j = 0; j < c; j++) {
                                array[i][j] = parseInt(s[j]);
                            }
                        }
                        System.out.println("RASTER GUARDADO");
                        break;
                    case "AMPLITUDE":

                        if (array != null) {
                            int min;
                            int max = min = array[0][0];
                            for (int i = 0; i < l; i++) {
                                for (int j = 0; j < c; j++) {
                                    int n = array[i][j];
                                    if (max < n) {
                                        max = n;
                                    }
                                    if (min > n) {
                                        min = n;
                                    }

                                }
                            }
                            System.out.println(max - min);
                        }
                        break;
                    case "PERCENTIL":
                        if (array != null) {
                            int total = l * c;
                            int secparam = parseInt(s[1]);
                            s = in.nextLine().split(" ");
                            for (int n = 0; n < secparam; n++) {
                                int X = parseInt(s[n]);
                                int numinf = 0;
                                for (int i = 0; i < l; i++) {
                                    for (int j = 0; j < c; j++) {
                                        int valor = array[i][j];
                                        if (valor < X) {
                                            numinf++;
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

                            int total = l * c;

                            if (total % 2 == 0) {

                                int centro1 = 0;
                                int centro2 = 0;

                                int sera1 = total / 2;
                                int sera2 = sera1 + 1;

                                int count = 0;

                                boolean flag = false;

                                while (true) {
                                    int temp = 10000;
                                    int countfunc = 0;

                                    for (int x = 0; x < l; x++) {
                                        for (int y = 0; y < c; y++) {
                                            int valor = array[x][y];
                                            if (centro2 < valor && valor < temp) {
                                                temp = valor;
                                                countfunc = 1;
                                            } else if (valor == temp) {
                                                countfunc++;
                                            }
                                        }
                                    }

                                    count += countfunc;
                                    centro2 = temp;

                                    if (count == sera1) {
                                        centro1 = centro2;
                                        flag = true;
                                    } else if (count >= sera2) {
                                        if (!flag) {
                                            centro1 = centro2;
                                        }
                                        break;
                                    }
                                }

                                double mediana = (centro1 + centro2) / 2;
                                System.out.println(Math.round(mediana));

                            } else {
                                int sera = (total - 1) / 2 + 1;
                                int mediana = 0;
                                int count = 0;
                                while (true) {
                                    int temp = 10000;
                                    int countfunc = 0;
                                    for (int x = 0; x < l; x++) {
                                        for (int y = 0; y < c; y++) {
                                            int valor = array[x][y];
                                            if (mediana < valor && valor < temp) {
                                                temp = valor;
                                                countfunc = 1;
                                            } else if (valor <= temp) {
                                                countfunc++;
                                            }
                                        }
                                    }

                                    count += countfunc;
                                    mediana = temp;

                                    if (count >= sera) {
                                        break;
                                    }
                                }
                                System.out.println(mediana);
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
