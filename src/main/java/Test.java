/**
 * Created by gleb on 20.05.15.
 */
public class Test {
    public static void main(String[] args) throws NoFreePlaceInTableExeption {
        MyHashMap myHashMap = new MyHashMap();
        for (int i = 0; i < 32; i++) {
            myHashMap.put((int) (Math.random() * -32), (long)(Math.random() * 150));
        }
    }
}
