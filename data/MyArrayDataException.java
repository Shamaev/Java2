package data;

public class MyArrayDataException extends NumberFormatException {
    int a, b;

    public MyArrayDataException(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString (){
        return "Координаты ошибки: " + a + " " + b ;
    }
}
