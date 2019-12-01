

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;


public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st;

    /**
     * Inicializa una tabla de símbolos vacía.
     */
    public ST() {
        st = new TreeMap<Key, Value>();
    }


    /**
     * Devuelve el valor asociado con la clave dada en esta tabla de símbolos.
     * *
     * @param key the key
     * @ devuelve el valor asociado con la clave dada si la clave está en esta tabla de símbolos;
     * nulo si la clave no está en esta tabla de símbolos
     * @throws IllegalArgumentException si la clave es nula
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return st.get(key);
    }

    
    /**
     * Inserta el par clave-valor especificado en la tabla de símbolos, sobrescribiendo el antiguo
     * valor con el nuevo valor si la tabla de símbolos ya contiene la clave especificada.
     * Elimina la clave especificada (y su valor asociado) de esta tabla de símbolos
     * si el valor especificado es nulo.
     * *
     * @param key the key
     * @param val el valor
     * @throws IllegalArgumentException si la clave es nula
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");
        if (val == null) st.remove(key);
        else             st.put(key, val);
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if key is null
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with null key");
        st.remove(key);
    }

    /**
     * Elimina la clave especificada y su valor asociado de esta tabla de símbolos
     * (si la clave está en esta tabla de símbolos).
     * *
     * @param key the key
     * @throws IllegalArgumentException si la clave es nula
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("calls contains() with null key");
        return st.containsKey(key);
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return st.size();
    }

    /**
     * Devuelve el número de pares clave-valor en esta tabla de símbolos.
     * *
     * @ devuelve el número de pares clave-valor en esta tabla de símbolos
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    
    /**
     * Devuelve todas las claves en esta tabla de símbolos.
     * *
     * Para iterar sobre todas las teclas en la tabla de símbolos llamada st,
     * use para cada notación: para (Clave clave: st.keys ()).
     * *
     * @ devuelve todas las teclas en esta tabla de símbolos
     */
    public Iterable<Key> keys() {
        return st.keySet();
    }

    /**
     * Devuelve todas las claves en esta tabla de símbolos.
     * Para iterar sobre todas las teclas en una tabla de símbolos llamada st, use el
     * para cada notación: para (tecla clave: st).
     * *
     * Este método se proporciona por compatibilidad con versiones anteriores de
     * Introducción a la programación en Java: un enfoque interdisciplinario.
     * *
     * @ devuelve un iterador a todas las teclas en esta tabla de símbolos
     * @ obsoleto Reemplazado por claves ().
     */
    @Deprecated
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    /**
     * Devuelve la clave más pequeña en esta tabla de símbolos.
     * *
     * @ devuelve la clave más pequeña en esta tabla de símbolos
     * @throws NoSuchElementException si esta tabla de símbolos está vacía
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return st.firstKey();
    }

    /**
     * Devuelve la clave más grande en esta tabla de símbolos.
     * *
     * @ devuelve la tecla más grande en esta tabla de símbolos
     * @throws NoSuchElementException si esta tabla de símbolos está vacía
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return st.lastKey();
    }

    
    /**
     * Devuelve la clave más pequeña en esta tabla de símbolos mayor o igual que la clave.
     * *
     * @param key the key
     * @ devuelve la clave más pequeña en esta tabla de símbolos mayor o igual que la clave
     * @throws NoSuchElementException si no existe dicha clave
     * @throws IllegalArgumentException si la clave es nula
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        Key k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    /**
     * Devuelve la clave más grande en esta tabla de símbolos menor o igual que la clave.
     * *
     * @param key the key
     * @ devuelve la clave más grande en esta tabla de símbolos menor o igual que la clave
     * @throws NoSuchElementException si no existe dicha clave
     * @throws IllegalArgumentException si la clave es nula
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        Key k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    /**
     * La unidad prueba el tipo de datos ST.
     * *
     * @param argumenta los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}