package practice3;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList <E> implements List<E> {
    private static final Lock lock = new ReentrantLock();
    private ArrayList<E> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(E e) {
        lock.lock();
        boolean res = list.add(e);
        lock.unlock();
        return res;
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        boolean res = list.remove(o);
        lock.unlock();
        return res;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        lock.lock();
        boolean res = list.addAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        lock.lock();
        boolean res = list.addAll(index,c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        lock.lock();
        boolean res = list.removeAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        lock.lock();
        boolean res = list.retainAll(c);
        lock.unlock();
        return res;
    }

    @Override
    public void clear() {
        lock.lock();
        list.clear();
        lock.unlock();
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public E set(int index, E element) {
        lock.lock();
        list.set(index,element);
        lock.unlock();
        return element;
    }

    @Override
    public void add(int index, E element) {
        lock.lock();
        list.add(index,element);
        lock.unlock();
    }

    @Override
    public E remove(int index) {
        lock.lock();
        E res = list.remove(index);
        lock.unlock();
        return res;
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex,toIndex);
    }
}
