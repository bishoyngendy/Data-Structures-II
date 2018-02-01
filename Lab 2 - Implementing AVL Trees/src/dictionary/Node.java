package dictionary;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 2 : Implementing AVL Trees
 * Created by Bishoy N. Gendy (programajor) on Thursday 16/03/2017.
 * This is the Node implementation class
 */
public class Node<T extends Comparable<T>> implements INode<T> {

    /**
     * The left child (Node)
     */
    private INode<T> leftChild;

    /**
     * The right child (Node)
     */
    private INode<T> rightChild;

    /**
     * The value of the node
     */
    private T value;

    /**
     * The height of the node
     */
    private int height;

    public Node() {
        this(null, null, null);
    }

    public Node(T value) {
        this(null, null, value);
    }

    public Node(INode<T> leftChild, INode<T> rightChild, T value) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = value;
        this.height = 0;
    }

    @Override
    public INode<T> getLeftChild() {
        return leftChild;
    }

    @Override
    public INode<T> getRightChild() {
        return rightChild;
    }

    @Override
    public void setLeftChild(INode<T> leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public void setRightChild(INode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}
