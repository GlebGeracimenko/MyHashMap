/**
 * Created by gleb on 20.05.15.
 */
public interface IMyHashMap {

    public int size();

    public long get(int key);

    public long put(int key, long value) throws NoFreePlaceInTableExeption;

}
