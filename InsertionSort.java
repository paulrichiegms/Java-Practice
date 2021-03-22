public class InsertionSort{
    public void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            var currentitem=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>currentitem){
                arr[j+1]=arr[i];
                j--;
            }
            arr[j+1]=currentitem;

        }
    }
}