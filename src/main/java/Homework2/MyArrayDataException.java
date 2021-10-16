package Homework2;

public class MyArrayDataException extends RuntimeException {
    public int i;
    public int j;

    public MyArrayDataException(String message, int i, int j) {
        super("Неверные данные в ячейке " + (i+1) + " " + (j+1));
        this.i = i;
        this.j = j;
    }

    public MyArrayDataException(String message, Throwable cause, int i, int j) {
        super(message, cause);
        this.i = i;
        this.j = j;
    }

    public MyArrayDataException(Throwable cause, int i, int j) {
        super(cause);
        this.i = i;
        this.j = j;
    }

    public MyArrayDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int i, int j) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.i = i;
        this.j = j;
    }
}
