package mypackage;

import java.util.Map;

public class Node<K,V> implements Map.Entry<K,V> {
    private int hash;
    private K key;
    private V value;
    private Node<K,V> nextElement;

    public Node(int hash, K key, V value, Node<K,V> nextElement) {
        this.key = key;
        this.hash = hash;
        this.value = value;
        this.nextElement = nextElement;
    }

    public int getHash() {
        return hash;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    public Node<K,V> getNextElement() {
        return nextElement;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public void setKey(K key) {
        this.key = key;
    }


    public void setNextElement(Node<K,V> nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public boolean equals(Object node){
        boolean result = false;
        if (this == node) return true;
        if (node == null || getClass() != node.getClass()) return false;
        Node a = (Node) node;
        if(a.getKey().equals(this.getKey()) && a.getValue().equals(this.getValue())){
            result = true;
        }
        return result;
    }

}