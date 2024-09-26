package projectFiles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QsortTest {

    @Test
    public void testConstructor() {
        QuickSort quickSort;
        Acropolis a1 = new Acropolis(30);

        int top = -1;
        quickSort = new QuickSort(a1, top);
        assertEquals(top, quickSort.getTop());
            

        assertThrows(IllegalArgumentException.class, () -> {
             new QuickSort(new Acropolis(0), 1 );
            
           });
    }


    public void testSort(Acropolis a1){
        
        int high =  a1.getPillars().size() - 1;
        int low = 0;

        // int[] myList = new int[a1.getPillars().size() - low + 1];
        QuickSort quickSort = new QuickSort(a1, -1);

        quickSort.setTop(-1);
        int top = quickSort.getTop();
            
        quickSort.setMyList(++ top , low);
        quickSort.setMyList(++top, high);
        quickSort.setTop(top);

        while((quickSort.getTop() >= 0)){
            quickSort.sort(a1);

        }
    }

    @Test
    public void testQsort(){
        Acropolis a1 = new Acropolis(100);
        if (a1.isSorted()){
            testQsort();
        }
    
        testSort(a1);
        assertTrue(a1.isSorted());
        
    }


    @Test
    public void sortEmpty(){

        Acropolis a1 = new Acropolis(1);
        a1.removeElementForTesting();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            testSort(a1);
          });
    }

    @Test 
    public void sortReversedSortedTest(){
        Acropolis a1 = new Acropolis(1);
        a1.createSortedPillarListForTesting(10,-1);
        assertFalse(a1.isSorted());
        testSort(a1);
        assertTrue(a1.isSorted());
    }

    @Test 
    public void testSameHeights(){
        Acropolis a1 = new Acropolis(10);
        for (int i = 0; i<10; i++){
            a1.getPillars().get(i).setHeight(10);
        }
        assertTrue(a1.isSorted());
        testSort(a1);
        assertTrue(a1.isSorted());
    }

    @Test 
    public void testAlreadySorted(){
        Acropolis a1 = new Acropolis(10);
        testSort(a1);
        testSort(a1);
        assertTrue(a1.isSorted());

    }
    @Test
    public void partitionTest(){
        Acropolis a1 = new Acropolis(100);
        int high =  a1.getPillars().size() - 1;
        int low = 0;

        // int[] myList = new int[a1.getPillars().size() - low + 1];
        QuickSort quickSort = new QuickSort(a1, -1);

        quickSort.setTop(-1);
        int top = quickSort.getTop();
            
        quickSort.setMyList(++ top , low);
        quickSort.setMyList(++top, high);
        quickSort.setTop(top);

        quickSort.partition(a1, low, high);

        assertThrows(IllegalArgumentException.class, () -> {
            quickSort.partition(new Acropolis(0), low, high);
          });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            quickSort.partition(a1, 0, 100);
          });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            quickSort.partition(a1, 0, 101);
          });

        quickSort.partition(a1, 50, 0);

        quickSort.partition(a1, 0, 50);
    }
}
