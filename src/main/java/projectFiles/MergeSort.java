package projectFiles;

import java.util.ArrayList;


public class MergeSort implements SortAlgorithms{
    
    private int currSize = 1;
    private int leftStart = 0;
    private int n;


    public MergeSort() {
    }

    public int getN(){
        return this.n;
    }

    public void setN(int n){
        this.n = n;
    }


    public int getCurrSize() {
        return this.currSize;
    }

    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }

    public int getLeftStart() {
        return this.leftStart;
    }

    public void setLeftStart(int leftStart) {
        this.leftStart = leftStart;
    }



    public void sort(Acropolis acropolis){

        
        
            // Pick starting point of different
            // subarrays of current size
            for (leftStart = 0; leftStart < n-1;
                        leftStart += 2*currSize)
            {
                // Find ending point of left
                // subarray. mid+1 is starting
                // point of right
                int mid = Math.min(leftStart + currSize - 1, n-1);
         
                int right_end = Math.min(leftStart
                             + 2*currSize - 1, n-1);
         
                // Merge Subarrays arr[left_start...mid]
                // & arr[mid+1...right_end]
                merge(acropolis.getPillars(), leftStart, mid, right_end);
            
        }
    }
     
    /* Function to merge the two haves arr[l..m] and
    arr[m+1..r] of array arr[] */


    public void merge(ArrayList<Pillar> pillars, int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
     
        /* create temp arrays */
        Pillar L[] = new Pillar[n1];
        Pillar R[] = new Pillar[n2];
     
        /* Copy data to temp arrays L[]
        and R[] */
        for (i = 0; i < n1; i++)
            L[i] = pillars.get(l+i);
        for (j = 0; j < n2; j++)
            R[j] = pillars.get(m + 1+ j);
     
        /* Merge the temp arrays back into
        arr[l..r]*/
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2){

            

            if (L[i].getHeight() <= R[j].getHeight()){
                pillars.set(k, L[i]);
                
                i++;
            }
            else{
                pillars.set(k, R[j]);
                j++;
            }
            k++;
        }
     
        /* Copy the remaining elements of
        L[], if there are any */
        while (i < n1)
        {
            pillars.set(k, L[i]);
            i++;
            k++;

        }
     
        /* Copy the remaining elements of
        R[], if there are any */
        while (j < n2)
        {
            pillars.set(k, R[j]);
            j++;
            k++;

        }
        
    }
    
}

// https://www.geeksforgeeks.org/iterative-merge-sort/

