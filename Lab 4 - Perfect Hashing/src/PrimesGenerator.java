import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 4 : Perfect Hashing
 * Created by Bishoy N. Gendy (programajor) on Saturday 20/05/2017.
 */
public class PrimesGenerator implements IPrimesGenerator {

    private static PrimesGenerator instance = null;

    private List<Integer> primes;
    private int maximumPrime = 0;

    public static IPrimesGenerator getInstance(int maxPrime) {
        if (instance == null || instance.maximumPrime < maxPrime * 2) {
            instance = new PrimesGenerator(maxPrime * 2);
        }
        return instance;
    }

    private PrimesGenerator (int maximumPrime) {
        this.maximumPrime = maximumPrime;
        this.primes = generatePrimes(maximumPrime);
    }

    private List<Integer> generatePrimes(int maximumPrime) {
        boolean isPrime[] = new boolean[maximumPrime + 1];
        for (int i = 2; i <= maximumPrime; i++) {
            isPrime[i] = true;
        }
        for (int factor = 2; factor <= maximumPrime; factor++) {
            if (isPrime[factor]) {
                primes.add(factor);
                for (int j = factor * 2; j <= maximumPrime; j += factor) {
                    isPrime[j] = false;
                }
            }
        }
        return primes;
    }

    @Override
    public int getRandomPrime(int minimum) {
        Random random = new Random();
        int minIndex = getMinimumPrimeIndex(minimum);
        int maxIndex = getMinimumPrimeIndex(minimum * 2);
        int randomIndex = maxIndex == minIndex ? 0 : random.nextInt(maxIndex - minIndex);
        return primes.get(minIndex + randomIndex);
    }

    private int getMinimumPrimeIndex(int value) {
        int left = 0, right = primes.size();
        while (left < right) {
            int mid = (left + right) / 2;
            int currentValue = primes.get(mid);
            if (currentValue >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
