
class HashMap<K,V> {
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


    public V get(K key) throws Exception {
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
            throw new Exception("Key doesn't exist");
        }
        return null;
    }

    public void remove(K key) throws Exception {
        previousKeys = keys;
        previousValues = values;

        int counter = 0;
        int counter1 = 0;
        int removingElement=0;

        if(isExistingKey) {

            for(Object a: keys) {

                if(a.equals(key)) {
                    removingElement = counter;
                    break;
                }

                counter++;
            }

            counter = 0;

            keys = new Object[capacity - 1];
            values = new Object[capacity - 1];

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
            throw new Exception("Key doesn't exist");
        }
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
        if (keys.length > 1) {

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
}
