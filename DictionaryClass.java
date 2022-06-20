package DictionaryClass;

public class DictionaryClass<K, V> {
    
    private K key;
    private V value;
    private int counter;
    private DictionaryClass<K, V> next;
    StringBuilder s = new StringBuilder();
    
    DictionaryClass(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;  
   
    };

    
    public K returnKey() {
        // helper function, returns the key of an dictionary element

        return this.key;
    };

    
    public V returnValue() {
        // helper function, returns the value stored for a specific key element.

        return this.value;
    };


    public DictionaryClass<K, V> returnNext(){
        // helper function for going through the dictionary.
        // returns the next dictionary item which the pointer points to.

        return this.next;
    }


    public void changeValue(K key, Integer newValue) throws missingKeyException {
        // takes keys and the new value as input. changes the value stored for 'key' to 'newValue'
        // puts an information string on the screen if key does not exist.

        if (findKey(key)){ 
            Object tempValue = (Integer)getValue(key) + (Integer)newValue; 
            addElement(key, (V)tempValue);
        }
        else{
            throw new missingKeyException(key + " does not exist within the dictionary. Use 'addElement' to add it.");
        };
    }

    public void addElement(K key, V value) throws doubleKeyException {
        // adds new key = value pair to the dictionary as well as changing the value of a
        // key if a user forgot that it already existed.

        if (this.returnKey() == key){
            
            throw new doubleKeyException("Key does already exist in dictionary.");
        }
        else if (this.returnNext() == null){          
            this.next = new DictionaryClass<K ,V>(key, value);
        }
        
        else{
            this.returnNext().addElement(key, value);
        }
    };


    public boolean findKey(K key){
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
    }


    public Object getValue(K key)throws missingKeyException{
        // iteratres over the whole dictionary and looks for the respective key to return the related value.
        // throws an exception if key does not exist, otherwise returns the key related value.

        if (this.returnKey().equals(key)){
            return this.returnValue();
        }

        else if (this.next == null){
            throw new missingKeyException(key + " does not exist within the dictionary. Use 'addElement' to add it.");
        }
        
        else{
            return (V) this.returnNext().getValue(key);
        }
    }


    public int size(){
        // returns the size of the dictionary. 

        if (this.next == null)
        {
            return 1;
        }
        else{
            return 1 + this.next.size();
        }
    }

    @Override
    public String toString(){
        // String representation of the dictionary, overrode the standard toString method to implement own style.

        s.delete(0, s.length());
        s.append("'" + this.returnKey() + "'" + ": " + this.returnValue() + ", ");

        if (this.next == null){
            s.delete(s.length() - 2, s.length());
            s.append("");
        }
        else if (this.returnNext() != null)
        {
            s.append(this.returnNext().toString());
        };

        return s.toString();
    };
  

}
