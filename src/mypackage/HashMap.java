package mypackage;

import exceptions.OutOfKeyException;

import java.util.Objects;

public class HashMap<K,V> {
    private boolean isExistingKey;
    private int capacity = 0;
    private int counter = 0;
    private Object[] keys;
    private Object[] values;
    private Object[] previousKeys;
    private Object[] previousValues;

    public void put(K key, V value) {

        isExistingKey = isExistingKey(key);

        if(!isExistingKey) {
            previousKeys = keys;
            previousValues = values;

            capacity++;

            keys = new Object[capacity];
            values = new Object[capacity];

            if (previousKeys != null && previousValues != null) {

                for (Object a : previousKeys) {
                    keys[counter] = a;
                    counter++;
                }


                counter = 0;

                for (Object a : previousValues) {
                    values[counter] = a;
                    counter++;
                }
            }
            keys[capacity - 1] = key;
            values[capacity - 1] = value;
        }
        else {
            changeValue(key, value);
        }
        counter = 0;
    }

    /**
     * Method for getting value.
     * @param key
     * @return
     * @throws Exception
     */


    public V get(K key) throws OutOfKeyException {
        int counter = 0;
        if (isExistingKey(key)){
            for(Object a : keys){
                if(a.equals(key)){
                    return (V) values[counter];
                }
                counter++;
            }
        }
        else {
            throw new OutOfKeyException("Key doesn't exist");
        }
        return null;
    }

    /**
     * Method for keys deleting
     * @param key
     * @throws OutOfKeyException
     */
    public void remove(K key) throws OutOfKeyException {
        previousKeys = keys;
        previousValues = values;

        int counter = 0;
        int counter1 = 0;
        int removingElement=0;

        if(isExistingKey(key)) {
            capacity--;
            for(Object a: keys) {

                if(a.equals(key)) {
                    removingElement = counter;
                    break;
                }

                counter++;
            }

            counter = 0;

            keys = new Object[capacity];
            values = new Object[capacity];

            for(Object a : previousKeys) {
                if(counter!=removingElement){
                    keys[counter1]=previousKeys[counter];
                    counter1++;
                }
                counter++;
            }

            counter=0;
            counter1=0;

            for(Object a : previousValues) {
                if(counter!=removingElement){
                    values[counter1]=previousValues[counter];
                    counter1++;
                }
                counter++;
            }
        }
        else {
            throw new OutOfKeyException("Key doesn't exist");
        }
    }

    public Object[] getKeys(){
        return keys;
    }

    public Object[] getValues(){
        return values;
    }

    /**
     * Method for checking key existing
     * @param key
     * @return
     */
    public boolean containsKey(K key){
        boolean isExistingKey;
        isExistingKey = isExistingKey(key);
        return isExistingKey;
    }

    /**
     * his method checks the same key existense.
     * @param key
     * @return
     */

    private boolean isExistingKey(Object key) {
        int counter = 0;
        if(keys == null){
            return false;
        }
        if (keys.length >= 1) {

            for (Object a : keys) {
                if (a != null) {
                    if (a.equals(key)) {
                        return true;
                    }
                }
                counter++;
            }
        }
        return false;
    }

    /**
     * Method for changing value of key
     * @param key
     * @param value
     */

    private void changeValue(Object key, Object value) {
        int counter = 0;
        for (Object a : keys) {
            if (a != null) {
                if (a.equals(key)) {
                    values[counter] = value;
                }
            }
            counter++;
        }
    }

    @Override
    public boolean equals(Object o) {

        int samePairs = 0;
        int counterA = 0;
        int counterB = 0;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMap<?, ?> hashMap = (HashMap<?, ?>) o;
        if(this.hashCode()!=o.hashCode()) return false;

        Object[] keys = ((HashMap<?, ?>) o).getKeys();
        Object[] values = ((HashMap<?, ?>) o).getValues();

        for(Object a : this.keys){
            counterB=0;
            for(Object b : keys){
                if(a.equals(b)){
                    if(this.values[counterA].equals(values[counterB])){
                        samePairs++;
                    }
                }
                counterB++;
            }
            counterA++;
        }


        return samePairs==keys.length;
    }

    @Override
    public int hashCode() {
        if(keys!=null && values!=null) {
            int result = Objects.hash(capacity, counter);
            result = 31 * result + keys.length;
            result = 31 * result + values.length;
            return result;
        }
        else return 0;
    }
}
