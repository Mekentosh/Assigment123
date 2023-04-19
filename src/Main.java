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
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void add(T item) {
        if (size == elements.length) {
            // double the capacity of the array
            Object[] newElements = new Object[elements.length * 2];
            // copy over the elements from the original array
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = item;
        size++;
    }

    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            // double the capacity of the array
            Object[] newElements = new Object[elements.length * 2];
            // copy over the elements from the original array up to the index
            for (int i = 0; i < index; i++) {
                newElements[i] = elements[i];
            }
            // copy over the remaining elements, shifting them to the right by one position
            for (int i = index; i < size; i++) {
                newElements[i + 1] = elements[i];
            }
            elements = newElements;
        } else {
            // shift the elements from index to size to the right by one position
            for (int i = size - 1; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
        }
        elements[index] = item;
        size++;
    }


    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                // shift the remaining elements to the left by one position
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }


    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedItem = (T) elements[index];
        // shift the remaining elements to the left by one position
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removedItem;
    }

    public void clear() {
        elements = new Object[10];
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

}

public class myArrayList<T> implements MyList<T> {

    private static final int INITIAL_CAPACITY = 10;

    private Object[] elements;
    private int size;

    public myArrayList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void add(T item) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size] = item;
        size++;
    }

    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, index);
            System.arraycopy(elements, index, newElements, index + 1, size - index);
            elements = newElements;
        } else {
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
        elements[index] = item;
        size++;
    }

    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T item = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return item;
    }
