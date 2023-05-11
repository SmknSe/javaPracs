package practice3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class ThreadSafeMap<K,V> implements Map<K, V> {
    private static final Semaphore sem = new Semaphore(1);
    private HashMap<K,V> map = new HashMap<>();
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
            V res = null;
            try {
                sem.acquire();
                res = map.put(key, value);
                sem.release();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            return res;
    }

    @Override
    public V remove(Object key) {
        V res = null;
        try {
            sem.acquire();
            res = map.remove(key);
            sem.release();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            sem.acquire();
            map.putAll(m);
            sem.release();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            sem.acquire();
            map.clear();
            sem.release();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}
