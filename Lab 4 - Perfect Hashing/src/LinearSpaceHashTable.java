import java.util.ArrayList;
import java.util.List;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 4 : Perfect Hashing
 * Created by Bishoy N. Gendy (programajor) on Saturday 20/05/2017.
 */
public class LinearSpaceHashTable extends HashTable {

    private int capacity = 0;
    private int collisions = 0;

    private HashTable table[];

    private IUniversalHasher universalHasher;

    public LinearSpaceHashTable(int[] values) {
        super(values);
    }

    @Override
    protected void buildPerfectHashTable(List<Integer> values) {
        this.universalHasher = new UniversalHasher(values.size());
        this.table = new QuadraticSpaceHashTable[values.size()];
        List<Integer> integerList[] = new List[values.size()];
        for (int i = 0; i < values.size(); i++) integerList[i] = new ArrayList<>();
        capacity += values.size();
        for (int value : values) {
            int key = universalHasher.hash(value);
            integerList[key].add(value);
        }

        for (int i = 0; i < integerList.length; i++) {
            List<Integer> list = integerList[i];
            if (list != null && list.size() > 0) {
                HashTable hashtable = new QuadraticSpaceHashTable(getArray(list));
                collisions += hashtable.getCollisions();
                capacity += hashtable.getCapacity();
                table[i] = hashtable;
            }
        }
    }

    private int[] getArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list) {
            arr[i++] = num;
        }
        return arr;
    }

    @Override
    boolean exists(int value) {
        int key = universalHasher.hash(value);
        return (table[key] != null && table[key].exists(value));
    }

    @Override
    int getCapacity() {
        return capacity;
    }

    @Override
    int getCollisions() {
        return collisions;
    }
}
