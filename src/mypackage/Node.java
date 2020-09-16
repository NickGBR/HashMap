package mypackage;

public class Node<K,V>{
    private int hash;
    private K key;
    private V value;
    private Node<K,V> nextElement;

    public Node(int hash, K key, V value, Node<K,V> nextElement) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.nextElement = nextElement;
    }

    public int getHash() {
        return hash;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
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

    public void setValue(V value) {
        this.value = value;
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