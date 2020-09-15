package mypackage;

import exceptions.OutOfKeyException;

import java.util.Map;
import java.util.Objects;

public class HashMap<K,V> {//implements Map<K,V> {
    private boolean isExistingKey;
    private int capacity = 0;
    private int counter = 0;
    private Object[] keys;
    private Object[] values;
    private Object[] previousKeys;
    private Object[] previousValues;
    private Node<K,V>[] nodes = new Node[18];

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i<nodes.length;i++) {
            Node element = nodes[i];
            if (element != null) {

                while (true) {

                    if (element.getNextElement() != null) {
                        result = result + element.getKey().toString() + " " + element.getValue().toString() + " | ";
                        element = element.getNextElement();
                    } else {
                        result = result + element.getKey() + " " + element.getValue()  + " - bucket " + i + "\n";
                        break;
                    }
                }
            }
        }

        return result;
    }

    public V put(K key, V value) {

        int position = getIndex(key, nodes.length);
        Node newPair = new Node(key.hashCode(), key, value, null);
        Node lastNode = nodes[position];

        if (lastNode == null) {
            nodes[position] = newPair;
        } else {
            while (true) {

                if(lastNode.getKey().equals(newPair.getKey())){
                    V oldVal = (V)lastNode.getValue();
                    lastNode.setValue(newPair.getValue());
                    return oldVal;
                }

                if (lastNode.getNextElement() != null) {
                    lastNode = lastNode.getNextElement();
                } else {
                    lastNode.setNextElement(newPair);
                    break;
                }
            }
        }
        return null;
    }

    //@Override
    public V get(Object key) {
        int position = getIndex((K) key,nodes.length);
            Node element = nodes[position];
            if (element != null) {
                while (true) {
                    if(element.getKey().equals(key)) return (V) element.getValue();
                    if (element.getNextElement() != null) {
                        element = element.getNextElement();
                    } else {
                        if(element.getKey().equals(key)) return (V) element.getValue();
                        break;
                    }
                }
            }


        return null;
    }

    //@Override
    public V remove(Object key) {
        int position = getIndex((K) key,nodes.length);

            Node element = nodes[position];

        if(element.getKey().equals(key)){
            nodes[position] = element.getNextElement();
            return (V) element.getValue();
        }

            if (element != null) {
                while (true) {
                    if (element.getNextElement() != null) {
                        Node newElement = element.getNextElement();
                        if(newElement.getKey().equals(key)){
                            V value = (V)newElement.getValue();
                            element.setNextElement(newElement.getNextElement());
                            return value;
                        }
                        element = element.getNextElement();
                    } else {
                        break;
                    }
                }
            }

        return null;
    }


    public Object[] getKeys() {
        return keys;
    }

    public Object[] getValues() {
        return values;
    }

    //@Override
    public int size() {
        return keys.length;
    }

    // @Override
    public void clear() {
        keys = null;
        values = null;
    }

    // @Override
    public boolean isEmpty() {
        if (values == null) {
            return true;
        } else return false;
    }

    /**
     * Method for checking key existing
     *
     * @param key
     * @return
     */
    //  @Override
    public boolean containsKey(Object key) {
        if (keys == null) {
            return false;
        }
        if (keys.length >= 1) {

            for (Object a : keys) {
                if (a != null) {
                    if (a.equals(key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int getIndex(K key, int bucketLength) {
        return key.hashCode() & (bucketLength - 1);
    }

    /**
     * Меняет значение ключа на новое, возращает старое значение.
     *
     * @param key
     * @param value
     * @return oldValue
     */

    private Object changeValue(Object key, Object value) {
        int counter = 0;
        Object oldValue = null;
        /*Находим позицию ключе в массива ключей,
            в случае совпадения меняем значение в этой позиции на новое.*/
        for (Object a : keys) {
            if (a != null) {
                if (a.equals(key)) {
                    oldValue = values[counter];
                    values[counter] = value;
                }
            }
            counter++;
        }
        return oldValue;
    }

    @Override
    public boolean equals(Object o) {

        int samePairs = 0;
        int counterA = 0;
        int counterB = 0;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMap<?, ?> hashMap = (HashMap<?, ?>) o;
        if (this.hashCode() != o.hashCode()) return false;

        Object[] keys = ((HashMap<?, ?>) o).getKeys();
        Object[] values = ((HashMap<?, ?>) o).getValues();

        for (Object a : this.keys) {
            counterB = 0;
            for (Object b : keys) {
                if (a.equals(b)) {
                    if (this.values[counterA].equals(values[counterB])) {
                        samePairs++;
                    }
                }
                counterB++;
            }
            counterA++;
        }


        return samePairs == keys.length;
    }

    @Override
    public int hashCode() {
        if (keys != null && values != null) {
            int result = Objects.hash(capacity, counter);
            result = 31 * result + keys.length;
            result = 31 * result + values.length;
            return result;
        } else return 0;
    }

}
