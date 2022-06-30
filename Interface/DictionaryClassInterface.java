package Interface;

import Exceptions.*;

public interface DictionaryClassInterface <K, V> {
   
    public K getKey();

    public V getValue();

    public DictionaryClassInterface<K, V> getNextItem();

    // public void changeValue(K key, V newValue) throws missingKeyException;

    public void addNewElement(K key, V value) throws doubleKeyException;

    public boolean findKey(K key);

    public int getSize();
}
