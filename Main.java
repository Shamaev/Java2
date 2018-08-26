
import data.MyArrayDataException;
import size.MyArraySizeException;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NumberFormatException;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(4,4);
        try {
            table.tab();
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }
    }
}
