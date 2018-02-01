import java.util.List;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 4 : Perfect Hashing
 * Created by Bishoy N. Gendy (programajor) on Saturday 20/05/2017.
 */
public class QuadraticSpaceHashTable extends HashTable {

    private int capacity = 0;
    private int collisions = 0;

    private int table[];

    private IUniversalHasher universalHasher;

    public QuadraticSpaceHashTable(int[] values) {
        super(values);
    }

    @Override
    protected void buildPerfectHashTable(List<Integer> values) {
        this.capacity = values.size() * values.size();
        this.universalHasher = new UniversalHasher(capacity);
        this.table = new int[capacity];
        boolean collisionFound;
        do {
            collisionFound = false;
            initializeArray();
            universalHasher.randomizeParameters();
            for (int value : values) {
                int key = universalHasher.hash(value);
                if (table[key] != Integer.MIN_VALUE && table[key] != value) { // collision found
                    collisionFound = true;
                    collisions++;
                    break;
                } else {
                    table[key] = value;
                }
            }
        } while (collisionFound);

    }

    private void initializeArray() {
        for (int i = 0; i < table.length; i++) {
            table[i] = Integer.MIN_VALUE;
        }
    }

    @Override
    boolean exists(int value) {
        int key = universalHasher.hash(value);
        return table[key] == value;
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
