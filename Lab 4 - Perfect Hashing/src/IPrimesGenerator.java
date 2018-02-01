/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 4 : Perfect Hashing
 * Created by Bishoy N. Gendy (programajor) on Saturday 20/05/2017.
 */
public interface IPrimesGenerator {

    /**
     * gets a prime number greater than a given number.
     * @param minimum number to get prime greater than it.
     * @return a prime number greater than the minimum parameter.
     */
    int getRandomPrime(int minimum);
}
