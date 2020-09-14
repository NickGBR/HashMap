package mypackage;

import exceptions.OutOfKeyException;

import java.util.Map;
import java.util.Objects;

public class HashMap<K,V>implements Map<K,V> {
    private boolean isExistingKey;
    private int capacity = 0;
    private int counter = 0;
    private Object[] keys;
    private Object[] values;
    private Object[] previousKeys;
    private Object[] previousValues;


    public V put(K key, V value) {

        //Проверяем наличия ключа
        isExistingKey = containsKey(key);

        /*Если ключа не существует, то создаем новые массивы ключей и значений
            увеличи размерность на 1 добавив новый ключ и значение.*/
        if(!isExistingKey) {

            //Сохранием старые массивы ключей и значений.
            previousKeys = keys;
            previousValues = values;


            capacity++;

            //Создаем новые массивы для зранения ключей и значений.
            keys = new Object[capacity];
            values = new Object[capacity];

            /*В случае если массивы были проинициализированны, то переписываем старые значения
            в расширенные массивы.*/
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

            //Добавлем новые значение в массивы ключей и значений
            keys[capacity - 1] = key;
            values[capacity - 1] = value;
        }
        else {
            /*В случае дубликата ключа, меняем значение ключа
                    и возращаем старое значение.*/
            return (V)changeValue(key, value);
        }
        counter = 0;
        return null;
    }

    /**
     * Method for getting value.
     * @param key
     * @return
     * @throws Exception
     */
    @Override
    public V get(Object key){
        int counter = 0;
        if (containsKey(key)){
            for(Object a : keys){
                if(a.equals(key)){
                    return (V) values[counter];
                }
                counter++;
            }
        }
        else {
            return null;
        }
        return null;
    }

    /**
     * Method for keys deleting
     * @param key
     * @throws OutOfKeyException
     */

    @Override
    public V remove(Object key){
        previousKeys = keys;
        previousValues = values;

        int counter = 0;
        int counter1 = 0;
        int removingElement=0;
        V removedValue= null;

        if(containsKey(key)) {
            capacity--;
            for(Object a: keys) {

                //Находим индекс удаляемого эллимента
                if(a.equals(key)) {
                    removingElement = counter;
                    break;
                }

                counter++;
            }

            counter = 0;

            //Создаем новые массивы
            keys = new Object[capacity];
            values = new Object[capacity];

            //Наполняем массивы, без удаленного эллимента
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
                else{
                    removedValue = (V) a;
                }
                counter++;
            }
        }
        return removedValue;
    }

    public Object[] getKeys(){
        return keys;
    }

    public Object[] getValues(){
        return values;
    }

    @Override
    public int size() {
        return keys.length;
    }

    @Override
    public void clear(){
        keys = null;
        values = null;
    }

    @Override
    public boolean isEmpty() {
        if (values == null){
            return true;
        }
        else return false;
    }

    /**
     * Method for checking key existing
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(Object key){
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
            }
        }
        return false;
    }

    /**
     * Меняет значение ключа на новое, возращает старое значение.
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
