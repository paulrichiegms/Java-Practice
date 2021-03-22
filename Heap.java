public class Heap {
    private int[] items;
    private int size;
    public Heap(int capacity){
         items=new int[capacity];
    }


    public void insert(int value){
        if(size==items.length){
            throw new IllegalStateException();
        }
        items[size++]=value;
        bubbleUp();
    }

    private void bubbleUp() {
        //Bubbleup operation
        var index = size - 1;
        var parentIndex = (index - 1) / 2;
        while (index > 0 && items[index] > items[parentIndex]) {
            swap(index, parentIndex);
            index = (index - 1) / 2;
        }
    }

    private void swap(int first,int second){
        var temp=items[first];
        items[first]=items[second];
        items[second]=temp;
    }

    public int remove(){

        if(size==0){
            throw new IllegalStateException();
        }
        var root=items[0];
        items[0]=items[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown(){
        var index=0;
        while(index<=size && !isValidParent(index)){
            var largerChildIndex=largerChildIndex(index);
            swap(index,largerChildIndex);
            index=largerChildIndex;
        }
    }

    private boolean isValidParent(int index){

        if(!hasLeftChild(index)){
            return true;
        }
        boolean isValid=items[index]>=leftChild(index);
        if(!hasRightChild(index)){
            isValid=  isValid && items[index]>=rightChild(index);
        }

        return isValid;
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index){
        return index*2+1;
    }

    private int rightChildIndex(int index){
        return index*2+2;
    }

    private int largerChildIndex(int index){
        if(!hasLeftChild(index)){
            return index;
        }
        if(!hasRightChild(index)){
            return leftChildIndex(index);
        }
        return (leftChild(index)>rightChild(index)) ? leftChildIndex(index):rightChildIndex(index);
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index)<=size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index)<=size;
    }




}
