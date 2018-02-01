package dictionary;

import java.io.*;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 2 : Implementing AVL Trees
 * Created by Bishoy N. Gendy (programajor) on Thursday 16/03/2017.
 * This is the Dictionary implementation class
 */
public class Dictionary implements IDictionary {

    /**
     * The AVL Tree representing the dictionary
     */
    private IAVLTree<String> dictionary;

    /**
     * The number of words in the dictionary
     */
    private int size;

    public Dictionary() {
        dictionary = new AVLTree<String>();
        size = 0;
    }

    @Override
    public void load(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while((line = bufferedReader.readLine()) != null) {
                insert(line);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean insert(String word) {
        if(dictionary.search(word)) {
            return false;
        } else {
            dictionary.insert(word);
            size++;
            return true;
        }
    }

    @Override
    public boolean exists(String word) {
        return dictionary.search(word);
    }

    @Override
    public boolean delete(String word) {
        boolean ret = dictionary.delete(word);
        if(ret) {
            size--;
        }
        return ret;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return dictionary.height();
    }



}
