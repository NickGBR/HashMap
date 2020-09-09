
class HashMap<K,V> {
    private boolean isExistinKey;
    private int capacity = 0;
    private int counter = 0;
    private Object[] keys;
    private Object[] values;
    private Object[] previousKeys;
    private Object[] previousValues;

    public void put(K key, V value) {

        isExistinKey = isExistingKey(key);

        if(!isExistinKey) {
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


    public void get() {
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
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
