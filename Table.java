import data.MyArrayDataException;
import size.MyArraySizeException;

import java.lang.String;

public class Table {
    int size1, size2;

    public Table(int size1, int size2) {
        this.size1 = size1;
        this.size2 = size2;
    }

    public void tab() {
        if (size1 != 4 || size2 != 4) throw new MyArraySizeException();
        String[][] arr = new String[size1][size2];
        int i, j;
        for (i = 0; i <4; i++) {
            for (j = 0; j <4; j++) {
                arr[i][j] = "1";
            }
        }
        int sum = 0;
        arr[2][2] = "A";
        for (i = 0; i <4; i++) {
            for (j = 0; j <4; j++) {

                try {
                    int a = Integer.parseInt(arr[i][j]);
                    sum += a;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
            System.out.println();
        }
        System.out.println("SUM = " + sum);

    }

}
