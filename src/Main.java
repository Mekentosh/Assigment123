public class MyArrayList<T> implements MyList<T> {

    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10]; // initial capacity of 10
        size = 0;
    }

    public int size() {
        return size;
    }


