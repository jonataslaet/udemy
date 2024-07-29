package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    private Integer leftChild(int index) {
        return 2 * index + 1;
    }

    private Integer rightChild(int index) {
        return 2 * index + 2;
    }

    public List<Integer> getHeap() {
        return this.heap;
    }

    public Integer parent(int index) {
        return (index - 1) / 2;
    }

    public void insert(int value) {
        this.heap.add(value);
        int currentIndex = this.heap.size() - 1;
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        this.heap.set(index1, heap.get(index2));
        this.heap.set(index2, temp);
    }
}
