package Interface;

import Exceptions.*;

public interface DictionaryClassInterface <K, V> {
    public K returnKey();

    public V returnValue();

    public DictionaryClassInterface<K, V> returnNext();

    public void changeValue(K key, Integer newValue) throws missingKeyException;

    public void addElement(K key, V value) throws doubleKeyException;

    public boolean findKey(K key);

    public Object getValue(K key)throws missingKeyException;

    public int size();
}
