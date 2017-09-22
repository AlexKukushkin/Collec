import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {

    private static final int def_capacity = 10;

    private int size;
    private E[] items;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        size = 0;
        ensureCapacity(def_capacity);
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size)
            return;

        E[] old = items;
        items = (E[]) new Object[newCapacity];
        for (int i = 0; i < getSize(); i++) {
            items[i] = old[i];
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void trimToSize() {
        ensureCapacity(getSize());
    }

    public E get(int index) {
        if (index < 0 || index >= getSize()) throw new ArrayIndexOutOfBoundsException();

        return items[index];
    }

    public E set(int index, E newVal) {
        if (index < 0 || index >= getSize()) throw new ArrayIndexOutOfBoundsException();
        E old = items[index];
        items[index] = newVal;
        return old;
    }

    public boolean add(E element) {
        add(getSize(), element);
        return true;
    }

    public void add(int index, E element) {
        if (items.length == getSize())
            ensureCapacity(getSize() * 2 + 1);
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = element;
        size++;
    }

    public E remove(int index) {
        E removeItem = items[index];
        for (int i = index; i < getSize() - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return removeItem;
    }


    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E> {

        private int current = 0;

        public boolean hasNext() {
            return current < getSize();
        }

        public E next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return items[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}