package dictionary;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 2 : Implementing AVL Trees
 * Created by Bishoy N. Gendy (programajor) on Thursday 16/03/2017.
 * This is the AVL Tree implementation class
 */
public class AVLTree<T extends Comparable <T> > implements IAVLTree<T> {

    /**
     * The root of the tree
     */
    private INode<T> root;

    public AVLTree() {
        root = null;
    }

    @Override
    public void insert(T key) {
        root = insert(key, root);
    }

    private INode<T> insert(T key, INode<T> subtreeRoot){
        if(subtreeRoot == null) {
            return new Node<T>(key);
        }
        int compareResult = key.compareTo(subtreeRoot.getValue());
        if(compareResult < 0) {
            subtreeRoot.setLeftChild(insert(key, subtreeRoot.getLeftChild()));
        } else {
            subtreeRoot.setRightChild(insert(key, subtreeRoot.getRightChild()));
        }
        return balance(subtreeRoot);
    }

    private INode<T> balance(INode<T> subtreeRoot) {
        if(subtreeRoot == null) {
            return subtreeRoot;
        }

        int leftChildHeight = getNodeHeight(subtreeRoot.getLeftChild());
        int rightChildHeight = getNodeHeight(subtreeRoot.getRightChild());

        if(leftChildHeight - rightChildHeight > 1) {
            if(getNodeHeight(subtreeRoot.getLeftChild().getLeftChild()) >=
                    getNodeHeight(subtreeRoot.getLeftChild().getRightChild())) {
                subtreeRoot = rotateWithLeftChild(subtreeRoot);
            } else {
                subtreeRoot = doubleRotateWithLeftChild(subtreeRoot);
            }
        } else if(rightChildHeight - leftChildHeight > 1) {
            if(getNodeHeight(subtreeRoot.getRightChild().getRightChild()) >=
                    getNodeHeight(subtreeRoot.getRightChild().getLeftChild())) {
                subtreeRoot = rotateWithRightChild(subtreeRoot);
            } else {
                subtreeRoot = doubleRotateWithRightChild(subtreeRoot);
            }
        }
        subtreeRoot.setHeight(Math.max(getNodeHeight(subtreeRoot.getLeftChild()),
                                    getNodeHeight(subtreeRoot.getRightChild())) + 1);
        return subtreeRoot;
    }

    @Override
    public boolean delete(T key) {
        Boolean isNodeFound = search(key);
        if(isNodeFound) {
            root = remove(key, root);
        }
        return isNodeFound;
    }

    private INode<T> remove(T key, INode<T> subtreeNode) {
        if(subtreeNode == null) {
            return subtreeNode;
        }

        int compareResult = key.compareTo(subtreeNode.getValue());
        if(compareResult < 0) {
            subtreeNode.setLeftChild(remove(key, subtreeNode.getLeftChild()));
        } else if(compareResult > 0) {
            subtreeNode.setRightChild(remove(key, subtreeNode.getRightChild()));
        } else if((subtreeNode.getLeftChild() != null) && (subtreeNode.getRightChild() != null)) {
            subtreeNode.setValue(findMin(subtreeNode.getRightChild()).getValue());
            subtreeNode.setRightChild(remove(subtreeNode.getValue(), subtreeNode.getRightChild()));
        } else {
            if(subtreeNode.getLeftChild() != null) {
                subtreeNode = subtreeNode.getLeftChild();
            } else {
                subtreeNode = subtreeNode.getRightChild();
            }
        }
        return balance(subtreeNode);
    }

    private INode<T> findMin(INode<T> subTreeNode) {
        if((subTreeNode == null) || (subTreeNode.getLeftChild() == null)) {
            return subTreeNode;
        }
        return findMin(subTreeNode.getLeftChild());
    }

    @Override
    public boolean search(T key) {
        INode<T> currentNode = root;
        while (currentNode != null) {
            int compareResult = key.compareTo(currentNode.getValue());
            if(compareResult < 0) {
                currentNode = currentNode.getLeftChild();
            } else if(compareResult > 0) {
                currentNode = currentNode.getRightChild();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public int height() {
        return getNodeHeight(root);
    }

    private int getNodeHeight(INode<T> node) {
        if(node == null) {
            return -1;
        }
        return node.getHeight();
    }

    @Override
    public INode<T> getTree() {
        return root;
    }

    private INode<T> rotateWithLeftChild(INode<T> subTreeNode) {
        INode<T> leftChild = subTreeNode.getLeftChild();
        subTreeNode.setLeftChild(leftChild.getRightChild());
        leftChild.setRightChild(subTreeNode);

        subTreeNode.setHeight(Math.max(getNodeHeight(subTreeNode.getLeftChild()),
                                       getNodeHeight(subTreeNode.getRightChild())) + 1);
        leftChild.setHeight(Math.max(getNodeHeight(leftChild.getLeftChild()),
                                    getNodeHeight(leftChild.getRightChild())) + 1);
        return leftChild;
    }

    private INode<T> doubleRotateWithLeftChild(INode<T> subTreeNode) {
        subTreeNode.setLeftChild(rotateWithRightChild(subTreeNode.getLeftChild()));
        return rotateWithLeftChild(subTreeNode);
    }

    private INode<T> rotateWithRightChild(INode<T> subTreeNode) {
        INode<T> rightChild = subTreeNode.getRightChild();
        subTreeNode.setRightChild(rightChild.getLeftChild());
        rightChild.setLeftChild(subTreeNode);

        subTreeNode.setHeight(Math.max(getNodeHeight(subTreeNode.getLeftChild()),
                getNodeHeight(subTreeNode.getRightChild())) + 1);
        rightChild.setHeight(Math.max(getNodeHeight(rightChild.getLeftChild()),
                getNodeHeight(rightChild.getRightChild())) + 1);
        return rightChild;
    }

    private INode<T> doubleRotateWithRightChild(INode<T> subTreeNode) {
        subTreeNode.setRightChild(rotateWithLeftChild(subTreeNode.getRightChild()));
        return rotateWithRightChild(subTreeNode);
    }

}
