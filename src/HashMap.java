class HashMap<K,V> {

    private int i = 0;
    private Object[] keys;
    private Object[] values;

    public void add(K key, V value) {
        keys = new Object[3];
        values = new Object[3];
        keys[0] = key;
        values[0] = value;
    }

    public  void get(){
        System.out.println(keys[0] + " " + values[0]);
    }
}
