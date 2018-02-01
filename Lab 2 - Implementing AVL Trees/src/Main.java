import dictionary.*;

public class Main {

    public static void main(String[] args) {

        AVLTree<Integer> tree = new AVLTree<Integer>();

//        tree.insert(13);
//        tree.insert(8);
//        tree.insert(5);
//        tree.insert(9);
//        tree.insert(4);
//        tree.insert(6);
//        tree.insert(12);
//        tree.insert(2);
//        tree.insert(1);
//        tree.insert(3);
//        tree.insert(10);
//        tree.insert(7);
//        tree.insert(45);
//        tree.insert(3);
//        tree.insert(30);
//        tree.insert(50);
//        tree.insert(70);
//        tree.delete(3);
//        tree.delete(30);


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
