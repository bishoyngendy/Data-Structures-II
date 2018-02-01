import java.util.Random;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 4 : Perfect Hashing
 * Created by Bishoy N. Gendy (programajor) on Saturday 20/05/2017.
 */
public class UniversalHasher implements IUniversalHasher {

    private int a, b, m, p;
    private IPrimesGenerator primesGenerator;

    public UniversalHasher(int tableSize) {
        this.primesGenerator = PrimesGenerator.getInstance(tableSize);
        this.p = primesGenerator.getRandomPrime(tableSize);
        this.m = tableSize;
        randomizeParameters();
    }

    @Override
    public int hash(int value) {
        return ((((a * value + b) % p) + m) % m);
    }

    @Override
    public void randomizeParameters() {
        Random random = new Random();
        this.a = random.nextInt();
        this.b = random.nextInt();
    }
}
