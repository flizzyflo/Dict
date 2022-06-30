

import Interface.DictionaryClassInterface;


import Exceptions.doubleKeyException;


public class DictionaryClass <K, V> implements DictionaryClassInterface <K, V> {
    
    private K key;
    private V value;
    private DictionaryClass<K, V> next;
    StringBuilder s = new StringBuilder();
    
    DictionaryClass(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;  
   
    };

    @Override
    public K getKey() {
        // helper function, returns the key of an dictionary element

        return this.key;
    };
    
    @Override    
    public V getValue() {
        // helper function, returns the value stored for a specific key element.

        return this.value;
    };
    
    @Override
    public DictionaryClass<K, V> getNextItem(){
        // helper function for going through the dictionary.
        // returns the next dictionary item which the pointer points to.

        return this.next;
    };

    @Override
    public int getSize(){
        // returns the size of the dictionary. 

        if (this.next == null)
        {
            return 1;
        }
        else{
            return 1 + this.next.getSize();
        }
    };

    @Override
    public String toString(){
        // String representation of the dictionary, overrode the standard toString method to implement own style.

        s.delete(0, s.length());
        s.append("'" + this.getKey() + "'" + ": " + this.getValue() + ", ");

        if (this.next == null){
            s.delete(s.length() - 2, s.length());
            s.append("");
        }
        else if (this.getNextItem() != null)
        {
            s.append(this.getNextItem().toString());
        };

        return s.toString();
    };

    @Override
    public void addNewElement(K key, V value) throws doubleKeyException {
        // adds new key = value pair to the dictionary as well as changing the value of a
        // key if a user forgot that it already existed.

        if (this.getKey() == key){
            
            throw new doubleKeyException("Key does already exist in dictionary.");
        }
        else if (this.getNextItem() == null){          
            this.next = new DictionaryClass<K, V>(key, value);
        }
        
        else{
            this.getNextItem().addNewElement(key, value);
        }
    };

    @Override
    public boolean findKey(K key) {
        // Iterates over the dictionary to look for the key. Returns true if found, false if not.

        if (this.key == key){
            return true;
        }
        else if (this.next == null){
            return false;
        }
        else{
            return this.next.findKey(key);
        }
    };

};
