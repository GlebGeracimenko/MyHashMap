import org.junit.Test;
import static org.junit.Assert.*;
import ua.gerasimenko.data_structure.HashMapImpl;
import ua.gerasimenko.data_structure.NoFreePlaceException;

public class TestMyHashMap {

    private HashMapImpl hashMap;

    @Test
    public void checkSize() {
        int length = (int)(Math.random() * 50);
        hashMap = new HashMapImpl(length);
        for (int key = 0; key < length; key++) {
            hashMap.put(key, (long)(Math.random() * 150));
            assertEquals(hashMap.size(), key + 1);
        }
    }

    @Test
    public void checkReplacing() {
        hashMap = new HashMapImpl();
        hashMap.put(5, 40);
        assertEquals(hashMap.put(5, 100), 40);
        long newValue = hashMap.get(5);
        assertEquals(newValue, 100);
    }

    @Test
    public void checkCollision() {
        hashMap = new HashMapImpl(10);
        hashMap.put(5, 169);
        hashMap.put(35, 111);
        assertEquals(hashMap.get(5), 169);
        assertEquals(hashMap.get(35), 111);
    }

    @Test(expected = NoFreePlaceException.class)
    public void checkFullTable() {
        int length = (int)(Math.random() * 50);
        hashMap = new HashMapImpl(length);
        for (int key = 0; key <= length; key++) {
            hashMap.put(key, (long) (Math.random() * 150));
        }
    }

    @Test
    public void putZeroKey() {
        hashMap = new HashMapImpl();
        hashMap.put(0, 123);
        assertEquals(hashMap.get(0), 123);
    }

    @Test
    public void putNegativeKey() {
        hashMap = new HashMapImpl();
        hashMap.put(-3, 56);
        hashMap.put(-19, 34);
        hashMap.put(-134, 555);
        assertEquals(hashMap.get(-3), 56);
        assertEquals(hashMap.get(-19), 34);
        assertEquals(hashMap.get(-134), 555);
    }

}
