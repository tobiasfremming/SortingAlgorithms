package demoFiles;

public class QsortDemo {
    private int[] myList;
    private int top;


   public QsortDemo(int[] myList) {

      this.myList = myList;
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

   void swap_vals2(int arr[], int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
 }
 int partition2(int arr[], int l, int h){
    int x = arr[h];
    int i = (l - 1);
    for (int j = l; j <= h - 1; j++){
       if (arr[j] <= x){
          i++;
          swap_vals2(arr, i, j);
       }
    }
    swap_vals2(arr, i + 1, h);
    return (i + 1);
 }
 


 public void quick_sort2(int arr[]){
  
    int high = getMyList(top--);
    int low = getMyList(top--);
    int p = partition2(arr, low, high);
    if (p - 1 > low){
       setMyList(++top, low);
       setMyList(++top, p-1);
        // myLIst[++top] = l;
        // myLIst[++top] = p - 1;
    }  
    if (p + 1 < high){
       setMyList(++top, p+1);
       setMyList(++top, high);
        // myLIst[++top] = p + 1;
        // myLIst[++top] = high;
    }
  
    
 }

 public static void main(String args[]){

    int my_arr[] = { 34, 76, 41, 32, 11, 0 , 91, 102, -11, 55};
    int high =  my_arr.length - 1;
    int low = 0;
    QsortDemo my_ob = new QsortDemo(new int[high - low + 1]);
    my_ob.setTop(-1);
    int top = my_ob.getTop();
    
    my_ob.setMyList(++ top , low);
    my_ob.setMyList(++top, high);
    my_ob.setTop(top);
     while (my_ob.getTop() >= 0){


        // System.out.println("________________________");
        my_ob.quick_sort2(my_arr);
        // for (i = 0; i < my_arr.length; ++i)
        // System.out.print(my_arr[i] + " ");
    
     }
    int i = 0;
    System.out.println("After iteratively performing quick sort, the array is ");
    for (i = 0; i < my_arr.length; ++i)
    System.out.print(my_arr[i] + " ");
    System.out.println(" ");


    
 }
}
