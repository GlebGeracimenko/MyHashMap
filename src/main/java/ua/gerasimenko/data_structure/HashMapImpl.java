package ua.gerasimenko.data_structure;

public class HashMapImpl implements HashMap {

    private Node[] mas;

    private final int tableCapacity;
    private int size = 0;

    public HashMapImpl(int capacity) {
        tableCapacity = capacity;
        mas = new Node[tableCapacity];
    }

    public HashMapImpl() {
        tableCapacity = 16;
        mas = new Node[tableCapacity];
    }

    /**
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @param key key for searching value in HashMap
     * @return the value to which the specified key is mapped,
     * or hashCode message "This key is not found!" if this map contains no mapping for the key.
     */
    @Override
    public long get(int key) {
        int position = module(key) % mas.length;
        for (int i = position; i < mas.length; i++) {
            if (mas[i] != null && containsKey(mas[i], key)) {
                return mas[i].value;
            }

        }
        //return -1; // must be more good solution
        return "This key is not found!".hashCode();
    }

    /**
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return previous value if put replace existing node
     */
    @Override
    public long put(int key, long value) {
        if (mas.length == size()) {
            throw new NoFreePlaceException();
        }
        int position = module(key) % mas.length;
        for (int i = position; i < mas.length; i++) {

            if (mas[i] == null) { // put new node or collision
                mas[i] = new Node(key, value);
                size++;
                return value;
            }

            //if table contains node with same key(replace action)
            if (containsKey(mas[i], key)) { //replace
                long el = mas[i].getValue();
                mas[i].setValue(value);
                return el;
            }

            //The counter is reset to pass from the beginning of the array
            if (i == (mas.length - 1)) {
                i = 0;
            }

        }
        return value;
    }

    /**
     * @param node column in array HashMap
     * @param key key new Node
     * @return true if Node.key equals key
     */
    private boolean containsKey(Node node, int key) {
        return node.getKey() == key;
    }

    /**
     * @param key key new Node
     * @return key in module
     */
    private int module(int key) {
        return key < 0 ? key * (-1) : key;
    }

    private class Node {

        final int key;
        long value;

        public Node(int key, long value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

    }

}