package projectFiles;

import java.util.ArrayList;


public class QuickSort implements SortAlgorithms {

    private int[] myList;
    private int top;


   public QuickSort(Acropolis a1, int top) {
      int high =  a1.getPillars().size() - 1;
      int low = 0;
      this.myList = new int[high - low + 1];
      this.top = top;
   }

   public int getTop(){
      return this.top;
   }

   public void setTop(int val){
      this.top = val;
   }

   public int getMyList(int index) {
      return this.myList[index];
   }

   public void setMyList(int index, int value) {
      this.myList[index] = value;
   }

    

    

   public int partition(Acropolis acropolis, int low, int high){

      ArrayList<Pillar> pillars = acropolis.getPillars();

      int x = pillars.get(high).getHeight();
      int i = (low - 1);
      for (int j = low; j <= high - 1; j++){
         if (pillars.get(j).getHeight() <= x){
            i++;
            acropolis.swapVals( i, j);
         }
      }
      acropolis.swapVals( i + 1, high);
      return (i + 1);
   }
   

   public void sort(Acropolis acropolis){

      int high = getMyList(top--);
      int low = getMyList(top--);
      int p = partition(acropolis, low, high);
      if (p - 1 > low){
         setMyList(++top, low);
         setMyList(++top, p-1);

      }  
      if (p + 1 < high){
         setMyList(++top, p+1);
         setMyList(++top, high);
      
      }
   }

     
  }





