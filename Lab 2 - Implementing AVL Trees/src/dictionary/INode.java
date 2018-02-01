package dictionary;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 2 : Implementing AVL Trees
 * Created by Bishoy N. Gendy (programajor) on Thursday 16/03/2017.
 * This is the interface for the node of the AVL Tree
 */
public interface INode<T extends Comparable<T>> {

    /**
     * Returns the left child of the current element/node in the heap tree
     * @return INode wrapper to the left child of the current element/node
     */
    INode<T> getLeftChild();

    /**
     * Returns the right child of the current element/node in the heap tree
     * @return INode wrapper to the right child of the current element/node
     */
    INode<T> getRightChild();

    /**
     * Sets the left child of the current element/node in the heap tree
     */
    void setLeftChild(INode<T> leftChild);

    /**
     * Sets the right child of the current element/node in the heap tree
     */
    void setRightChild(INode<T> rightChild);

    /**
     * Get the value of the current node
     * @return Value of the current node
     */
    T getValue();

    /**
     * Set the value of the current node
     */
    void setValue(T value);

    /**
     * Get the height of the current node
     * @return the height of the current node
     */
    int getHeight();

    /**
     * Set the height of the current node
     */
    void setHeight(int height);
}
