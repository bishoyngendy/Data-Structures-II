package datastructure;

/**
 * Faculty of Engineering, Alexandria University
 * Computer and Systems Engineering Department
 * CS 223 : Data Structures II (File Structures)
 * Lab 1 : Implementing Binary Heap & Sorting Techniques
 * Created by Bishoy N. Gendy (programajor) on Friday 10/03/2017.
 */
public class BinaryHeapImp implements BinaryHeap {

    /**
     * representation for the heap in an array.
     */
    private int mArray[];

    /**
     * number of elements in the binary heap.
     */
    private int size;

    /**
     * Default binary heap size.
     */
    private static final int DEFAULT_HEAP_MAX_SIZE = 1000000;

    /**
     * Default constructor.
     */
    public BinaryHeapImp() {
        mArray = new int[DEFAULT_HEAP_MAX_SIZE + 1];
    }

    /**
     * initializes the heap with its maximum size.
     * @param maxSize the maximum number of elements in the heap
     */
    public BinaryHeapImp(int maxSize) {
        mArray = new int[maxSize + 1];
    }

    @Override
    public void insert(int element) {
        if(size == mArray.length) {
            throw new RuntimeException("Binary Heap is full!!");
        }

        mArray[size+1] = element;
        int elementIndex = size + 1;
        int parentIndex = elementIndex/2;

        while((parentIndex > 0) && (mArray[elementIndex] > mArray[parentIndex])) {
            int tmp = mArray[elementIndex];
            mArray[elementIndex] = mArray[parentIndex];
            mArray[parentIndex] = tmp;
            elementIndex = parentIndex;
            parentIndex = elementIndex/2;
        }
        size++;
    }

    @Override
    public int extractMax() {
        if(size <= 0) {
            throw new RuntimeException("Binary Heap is empty!!");
        }
        int ret = mArray[1];
        mArray[1] = mArray[size];
        heapify(1);
        size--;
        return ret;
    }

    @Override
    public int getMax() {
        if(size <= 0) {
            throw new RuntimeException("Binary Heap is empty!!");
        }
        return mArray[1];
    }

    @Override
    public void build(int[] arr) {
        if(arr.length > mArray.length) {
            throw new RuntimeException("Array size is larger than the Binary Heap size!!");
        }

        for(int i = 0; i < arr.length; i++) {
            mArray[i+1] = arr[i];
        }

        this.size = arr.length;
        for(int i = arr.length/2; i >= 1; i--) {
            heapify(i);
        }
    }

    @Override
    public void heapify(int index) {
        int largest = index;
        int left = 2 * index;
        int right = (2 * index) + 1;
        if(left <= size && mArray[left] > mArray[largest]) {
            largest = left;
        }
        if(right <= size && mArray[right] > mArray[largest]) {
            largest = right;
        }
        if(largest != index) {
            int tmp = mArray[index];
            mArray[index] = mArray[largest];
            mArray[largest] = tmp;
            heapify(largest);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

}
