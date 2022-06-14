public class Dict<K, V> {
    
    private K key;
    private V value;
    private int counter;
    private Dict<K, V> next;
    StringBuilder s = new StringBuilder();
    
    Dict(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;  
   
    };

    
    public K returnKey() {
        return this.key;
    };

    
    public V returnValue() {
        return this.value;
    };


    public Dict<K, V> returnNext(){
        return this.next;
    }


    public void changeValue(K key, Integer change){
        if (findKey(key)){ 
            Object tempValue = (Integer)getValue(key) + (Integer)change; 
            addElement(key, (V)tempValue);
        }
        else{
            return;
        }
    }


    public void addElement(K key, V value){
        if (this.returnKey() == key){
            
            this.value = (V) value;
        }
        else if (this.returnNext() == null){          
            this.next = new Dict<K ,V>(key, value);
        }
        
        else{
            this.returnNext().addElement(key, value);
        }
    };


    public boolean findKey(K key){
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


    public Object getValue(K key) {
        if (this.returnKey().equals(key)){
            return this.returnValue();
        }

        else if (this.next == null){
            System.out.println("'" + key + "' as key not found in Dictionary");
            return null;
        }
        
        else{
            return (V) this.returnNext().getValue(key);
        }
    }


    public int size(){
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
