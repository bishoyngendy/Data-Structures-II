import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 4 : Perfect Hashing
 * Created by Bishoy N. Gendy (programajor) on Saturday 20/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
                + "TestCases" + File.separator + "keys10000001000000.txt";
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        String line = scanner.next();
        String numberString[] = line.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numberString.length; i++) {
            numbers.add(Integer.parseInt(numberString[i]));
        }

        int array[] = getArray(numbers);

        HashTable quadraticHashTable = new QuadraticSpaceHashTable(array);
        System.out.println("Quadratic HashTable");
        System.out.println("Collision: " + quadraticHashTable.getCollisions());
        System.out.println("Capacity: " + quadraticHashTable.getCapacity());
        System.out.println("Size: " + quadraticHashTable.getSize());

        HashTable linearHashTable = new LinearSpaceHashTable(array);
        System.out.println("Linear HashTable");
        System.out.println("Collision: " + linearHashTable.getCollisions());
        System.out.println("Capacity: " + linearHashTable.getCapacity());
        System.out.println("Size: " + linearHashTable.getSize());
    }

    private static int[] getArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list) {
            arr[i++] = num;
        }
        return arr;
    }
}
