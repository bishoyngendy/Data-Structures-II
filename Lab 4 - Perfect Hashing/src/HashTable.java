import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 4 : Perfect Hashing
 * Created by Bishoy N. Gendy (programajor) on Saturday 20/05/2017.
 */
public abstract class HashTable {

    /**
     * Number of distinct elements in the hash table.
     */
    private int size = 0;

    public HashTable(int[] values) {
        List<Integer> simplifiedValues = removeDuplicates(values);
        this.size = simplifiedValues.size();
        buildPerfectHashTable(simplifiedValues);
    }

    protected abstract void buildPerfectHashTable(List<Integer> values);

    private List<Integer> removeDuplicates(int[] values) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int val : values) set.add(val);
        for (int val : set) list.add(val);
        return list;
    }

    /**
     * checks whether a specific value is present in the hash table or not.
     * @param value to check its existence in the hash table.
     * @return true if exists else false.
     */
    abstract boolean exists(int value);

    /**
     * gets the number of distinct elements in the hash table.
     * @return the number of distinct elements in the hash table.
     */
    int getSize() {
        return size;
    }

    /**
     * gets the actual memory capacity reserved for the hash table including empty slots.
     * @return the actual memory capacity reserved for the hash table including empty slots.
     */
    abstract int getCapacity();

    /**
     * gets the number of collisions to build the hash table.
     * @return the number of collisions to build the hash table.
     */
    abstract int getCollisions();
}
