/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 4 : Perfect Hashing
 * Created by Bishoy N. Gendy (programajor) on Saturday 20/05/2017.
 */
public interface IUniversalHasher {

    /**
     * hash the given value to a specific key.
     * @param value to be hashed.
     * @return the key corresponding to the given value.
     */
    int hash(int value);

    /**
     * randomize the parameters of the hashing function.
     */
    void randomizeParameters();
}
