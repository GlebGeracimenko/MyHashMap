import java.util.Arrays;

/**
 * Created by gleb on 20.05.15.
 */
public class MyHashMap implements IMyHashMap {

    private Node[] mas;

    private final int tableCapacity;
    private int size = 0;

    public MyHashMap(int capacity){
        tableCapacity = capacity;
    }

    public MyHashMap() {
        tableCapacity = 16;
        mas = new Node[tableCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public long get(int key) {
        for(int i = 0; i < mas.length; i++) {
            if (containsKey(mas[i].getKey(), key)) {
                return mas[i].value;
            }
        }
        return -1;
    }

    // dont forget about java doc
    /**
     * @return previous value if put replace existing node 
     *
     * */
    @Override
    public long put(int key, long value) throws NoFreePlaceInTableExeption {

        // has free space, oterwise throw exception or ???

        // find bucket(table column)

        // if bucket already contains node -> do action during collision(find next free column)

        // else just create new node and put in column

        if (mas.length == size()) {
            throw new NoFreePlaceInTableExeption();
        } else {
            int hash = module(key) % mas.length;
            if (mas[hash] == null) {
                mas[hash] = new Node(key, value);
                size++;
            } else {
                if (containsKey(mas[hash].getKey(), key)) {
                    long el = mas[hash].getValue();
                    mas[hash].setValue(value);
                    return el;
                } else {
                    int count = 0;
                    for (int i = hash; i < mas.length; i++) {
                        if (count <= mas.length) {
                            count++;
                            if (mas[i] == null) {
                                mas[i] = new Node(key, value);
                                size++;
                                return 0;
                            } else if (containsKey(mas[i].getKey(), key)) {
                                long el = mas[i].getValue();
                                mas[i].setValue(value);
                                return el;
                            }
                            if (i == (mas.length - 1)) {
                                i = 0;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean containsKey(int masKey, int key) {
        return masKey == key ? true : false;
    }

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
