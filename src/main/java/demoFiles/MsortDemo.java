package demoFiles;

public class MsortDemo {
    private int curr_size = 0;
    private int left_start = 0;


    public MsortDemo() {
    }


    public int getCurr_size() {
        return this.curr_size;
    }

    public void setCurr_size(int curr_size) {
        this.curr_size = curr_size;
    }

    public int getLeft_start() {
        return this.left_start;
    }

    public void setLeft_start(int left_start) {
        this.left_start = left_start;
    }



    public void mergeSort(int arr[], int n)
    {
        
            // Pick starting point of different
            // subarrays of current size
            for (left_start = 0; left_start < n-1;
                        left_start += 2*curr_size)
            {
                // Find ending point of left
                // subarray. mid+1 is starting
                // point of right
                int mid = Math.min(left_start + curr_size - 1, n-1);
         
                int right_end = Math.min(left_start
                             + 2*curr_size - 1, n-1);
         
                // Merge Subarrays arr[left_start...mid]
                // & arr[mid+1...right_end]
                merge(arr, left_start, mid, right_end);
            
        }
    }
     
    /* Function to merge the two haves arr[l..m] and
    arr[m+1..r] of array arr[] */


    public void merge(int arr[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
     
        /* create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
     
        /* Copy data to temp arrays L[]
        and R[] */
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];
     
        /* Merge the temp arrays back into
        arr[l..r]*/
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
     
        /* Copy the remaining elements of
        L[], if there are any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
     
        /* Copy the remaining elements of
        R[], if there are any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
     
    /* Function to print an array */
    public void printArray(int A[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.printf("%d ", A[i]);
        System.out.printf("\n");
    }
     



    /* Driver program to test above functions */
    public static void main(String[] args){
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        MsortDemo a1 = new MsortDemo();
     
        System.out.println("Given array is ");
        a1.printArray(arr, n);
        
                         
         
        // Merge subarrays in bottom up
        // manner. First merge subarrays
        // of size 1 to create sorted
        // subarrays of size 2, then merge
        // subarrays of size 2 to create
        // sorted subarrays of size 4, and
        // so on.
        int curr_size= a1.getCurr_size();
        for (curr_size = 1; curr_size <= n-1; curr_size = 2*curr_size){
            a1.setCurr_size(curr_size);
            a1.mergeSort(arr, n);
     
        System.out.println("Sorted array is ");
        a1.printArray(arr, n);
        }
    }
    
}

// https://www.geeksforgeeks.org/iterative-merge-sort/
