public class MergeSort {
    public void sort(int[] a){

        if(a.length<2){
            return;}
        

       //Divide the array into 
       int middle=a.length/2;

       int[] left=new int[middle];
       for(int i=0;i<middle;i++){
           left[i]=a[i];
       }

       int[] right=new int[a.length-middle];
       for(int i=middle;i<a.length;i++){
           right[i-middle]=a[i];
       }


       //Sort each half

       sort(right);
       sort(left);
       //Merge the result

       merge(left,right,a);

    }

    private void merge(int[]left, int[]right, int[]result){
        int i=0, j=0, k=0;

        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                result[k++]=left[i++];
            }
            else{
                result[k++]=right[j++];
            }
        }

        while(i<left.length){
            result[k++]=left[i++];
        }

        while(j<right.length){
            result[k++]=right[j++];
        }

    }
    
}
