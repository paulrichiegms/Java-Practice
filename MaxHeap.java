public class MaxHeap {
    public static void heapify(int[] array){

        for(var i=array.length/2-1;i>=0;i--){
            heapify(array,i);
        }

    }

    private static void heapify(int[] array, int index){
        var largerIndex=index;

        var leftIndex=index*2+1;

        if(leftIndex< array.length && array[leftIndex]>array[largerIndex]){
            largerIndex=leftIndex;
        }
        var rightIndex=index*2+2;
        if(rightIndex< array.length && array[rightIndex]>array[largerIndex]){
            largerIndex=rightIndex;
        }

        if(index==largerIndex){
            return;
        }
        else{
            swap(array,index,largerIndex);
            heapify(array,largerIndex);
        }
    }

    private static void swap(int[]array,int first, int second){
        var temp=array[first];
        array[first]=array[second];
        array[second]=temp;
    }


}
