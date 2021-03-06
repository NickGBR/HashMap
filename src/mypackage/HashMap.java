package mypackage;

import java.util.*;

import static java.lang.Math.abs;

public class HashMap<K,V> implements Map<K,V> {


    private Node<K,V>[] nodes = new Node[16];

    @Override
    public String toString(){
        String result = "{}";

        for (int i = 0; i<nodes.length;i++) {
            Node element = nodes[i];
            if (element != null) {

                while (true) {

                    if (element.getNextElement() != null) {
                        result = result + element.getKey().toString() + "=" + element.getValue().toString() + ", ";
                        element = element.getNextElement();
                    } else {
                        result = result + element.getKey() + "=" + element.getValue() + ", ";

                        break;
                    }
                }
            }
        }
        if (!result.equals("{}")){
            int endIndex = result.length() - 2;
            result = result.trim();
            result = result.substring(2, endIndex);
            result = "{" + result + "}";
        }
        return result;
    }


    public String toStringService() {
        String result = "{}";

        for (int i = 0; i < nodes.length; i++) {
            Node element = nodes[i];
            if (element != null) {

                while (true) {
                    if (element.getNextElement() != null) {
                        if(element.getKey() == null) result = result + "null" + "=" + element.getValue().toString() + ", ";
                        else result = result + element.getKey().toString() + "=" + element.getValue().toString() + ", ";

                        element = element.getNextElement();
                    } else {
                        result = result + element.getKey() + "=" + element.getValue() + " - bucket " + i + "\n";
                        break;
                    }
                }
                result = result.replaceAll("\\{", "").replaceAll("}", "");
            }
        }

        return result;
    }

    public V put(K key, V value) {

        int position = getIndex(key, nodes.length);
        Node <K,V> newPair;

        Node <K,V> lastNode = nodes[position];

        if(position == 0){
            if(nodes[position]==null){
                nodes[position] = new Node<>(0,null,value,null);
                return null;
            }
            else {
                V oldValue = nodes[position].getValue();
                nodes[position].setValue(value);
                return oldValue;
            }
        }

        newPair = new Node<>(key.hashCode(), key, value, null);

        if (lastNode == null) {
            nodes[position] = newPair;
        }
        else {
            while(true) {
                if (lastNode.getKey().equals(newPair.getKey())) {
                    V oldVal = lastNode.getValue();
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

    @Override
    public V get(Object key) {
        int position = getIndex((K)key,nodes.length);
        Node <K,V> element = nodes[position];
        if (element != null) {
            while (true) {
                if(key == null){
                    return element.getValue();
                }
                if (element.getKey().equals(key)) return element.getValue();
                if (element.getNextElement() != null) {
                    element = element.getNextElement();
                } else {
                    if (element.getKey().equals(key)) return element.getValue();
                    break;
                }
            }
        }


        return null;
    }

    @Override
    public V remove(Object key) {
        int position = getIndex((K) key,nodes.length);

        Node element = nodes[position];

        if(element == null){
            return null;
        }

        if(element.getKey() == null){
            V oldValue = nodes[position].getValue();
            nodes[position]=null;
            return oldValue;
        }

        if(element.getKey().equals(key)){
            nodes[position] = element.getNextElement();
            return (V) element.getValue();
        }
        while (true) {
            if (element.getNextElement() != null) {
                Node newElement = element.getNextElement();
                if (newElement.getKey().equals(key)){
                    V value = (V)newElement.getValue();
                    element.setNextElement(newElement.getNextElement());
                    return value;
                }
                element = element.getNextElement();
            } else {
                break;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

        if(m==null){
        }

        Iterator it = m.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<K,V> pair = (Entry<K,V>)it.next();
            this.put(pair.getKey(),pair.getValue());
        }
    }

    private Object[] getKeys() {
        int counter = 0;
        Object[] keys = new Object[this.size()];
        Node <K,V> element;

        for(Node<K,V> node:nodes){
            if(node!=null){

                keys[counter] = node.getKey();
                counter++;
                element=node.getNextElement();

                while(true){
                    if(element != null){

                        keys[counter] = element.getKey();
                        element = element.getNextElement();

                        counter++;
                    }
                    else break;
                }
            }

        }

        return keys;
    }

    private Object[] getValues() {
        int counter = 0;

        Object[] values = new Object[this.size()];
        Node <K,V> element;

        for(Node<K,V> node:nodes){
            if(node!=null){

                values[counter] = node.getValue();
                counter++;
                element = node.getNextElement();

                while(true){
                    if(element != null){

                        values[counter] = element.getValue();
                        element = element.getNextElement();

                        counter++;
                    }
                    else break;
                }
            }

        }

        return values;
    }

    private int numberOfElements(){
        int counter = 0;
        Node <K,V> element;
        for(Node<K,V> node:nodes){
            if(node != null){
                counter++;
                element = node.getNextElement();
                while(true){
                    if(element != null){
                        counter++;
                        element = element.getNextElement();
                    }
                    else break;
                }
            }
        }
        return counter;
    }

    @Override
    public int size() {
        return numberOfElements();
    }

    @Override
    public void clear() {
        nodes  = new Node[18];
    }

    @Override
    public boolean isEmpty() {
        int nullElements = countNullElements(nodes);
        if (nullElements == nodes.length) {
            return true;
        } else return false;
    }

    private int countNullElements(Node<K,V>[] nodes) {
        int counter = 0;
        for (Node<K, V> element : nodes) {
            if (element == null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean containsKey(Object key) {
        Node<K, V> element;

        for (Node<K, V> node : nodes) {
            if (node != null) {

                if (node.getKey().equals(key)) return true;

                element = node.getNextElement();

                while (true) {
                    if (element != null) {

                        if (element.getKey().equals(key)) return  true;
                        element = element.getNextElement();
                    } else break;
                }
            }

        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Object[] values = this.getValues();
        for (Object value1 : values){
            if (value.equals(value1)) return true;
        }
        return false;
    }

    private int getIndex(K key, int bucketLength) {
        if(key==null){
            return 0;
        }
        return abs(key.hashCode() % (bucketLength - 1))+1;
    }

    @Override
    public boolean equals(Object object) {

        int counter = 0;

        int samePairs = 0;
        int counterA = 0;
        int counterB = 0;

        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        HashMap<?, ?> hashMap = (HashMap<?, ?>) object;

        Object[] newKeys =  ((HashMap<K, V>) object).getKeys();
        Object[] newValues = ((HashMap<K, V>) object).getValues();
        Object[] values = this.getValues();
        Object[] keys = this.getKeys();

        if(newKeys.length!=keys.length) return false;

        for(int i = 0; i<keys.length;i++){
            for (int j = 0; j<newKeys.length;j++){
                if(keys[i].equals(newKeys[j])){
                    if(values[i].equals(newValues[j])){
                        counter++;
                    }
                    else return false;
                }
            }
        }

        return counter == keys.length;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Node <K,V> element;

        Set<Entry<K,V>> set = new HashSet<>();

        for(Node<K,V> node:nodes){

            if(node != null){

                set.add(node);

                element=node.getNextElement();
                while(true){
                    if(element != null){
                        set.add(element);
                        element = element.getNextElement();
                    }
                    else break;
                }
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> set = new ArrayList<>();
        Object[] values  = this.getValues();
        for(int i = 0; i<values.length; i++){
            set.add((V)values[i]);
        }
        return set;
    }

    @Override
    public Set<K> keySet() {

        Set<K> set = new HashSet<K>();
        Object[] key = this.getKeys();

        for(int i = 0; i<key.length;i++){
            set.add((K)key[i]);
        }
        return set;
    }
}
