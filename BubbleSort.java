public class BubbleSort{
    public void sort(int[] arr){
        for(var i=0;i<arr.length;i++){
            for(var j=1;j<arr.length;j++){
                if(arr[j]<arr[j-1]){
                   var temp=arr[j];
                   arr[j]=arr[j-1];
                   arr[j-1]=temp; 
                }

            }
        }
    }
}

/*import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        int[] numbers={7,3,1,4,6,2,3};
        var sorter=new MergeSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));

    }

}*/