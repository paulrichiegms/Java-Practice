public class PQWithHeap {
    private Heap heap=new Heap(100);

    public void enque(int item){
        heap.insert(item);
    }

    public int deque(){
        return heap.remove();
    }

}
