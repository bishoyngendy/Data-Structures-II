package dictionary;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 2 : Implementing AVL Trees
 * Created by Bishoy N. Gendy (programajor) on Sunday 26/03/2017.
 * This is
 */
public class Test {
    public static void Main(String[] args) {
        IDictionary dict = new Dictionary();
        boolean test = dict.insert("Bishoy");
        if(test) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

        test = dict.insert("Bishoy");
        if(test) {
            System.out.println("fail");
        } else {
            System.out.println("success");
        }

        test = dict.exists("Bishoy");
        if(test) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

        test = dict.delete("Marc");
        if(test) {
            System.out.println("fail");
        } else {
            System.out.println("success");
        }

        test = dict.delete("Bishoy");
        if(test) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }


    }
}
