package projectFiles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MsortTest {
    
    @Test
    public void testConstructor(){

        Acropolis acropolis = new Acropolis(30);
        MergeSort m1 = new MergeSort();
        m1.setN(acropolis.getPillars().size());

        assertEquals(acropolis.getPillars().size(), m1.getN());
        assertEquals(0, m1.getLeftStart());
        assertEquals(1, m1.getCurrSize());
    }

   
    public void testSort(Acropolis acropolis){

        MergeSort m1 = new MergeSort();
        m1.setN(acropolis.getPillars().size());

        int n = m1.getN();

        while ((m1.getCurrSize() <= n-1)) {
        
            m1.sort(acropolis);
        
            m1.setCurrSize(m1.getCurrSize()*2);
        }

    }

    @Test
    public void testMsort(){
        Acropolis a1 = new Acropolis(100);
        if (a1.isSorted()){
            testMsort();
        }
    
        testSort(a1);
        assertTrue(a1.isSorted());
        
    }

    @Test
    public void sortEmpty(){

        Acropolis a1 = new Acropolis(1);
        a1.removeElementForTesting();
        testSort(a1);
    }

    @Test 
    public void sortReversedSortedTest(){
        Acropolis a1 = new Acropolis(1);
        a1.createSortedPillarListForTesting(10, -1);
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
    public void mergeTest(){
        Acropolis a1 = new Acropolis(10);
        MergeSort m1 = new MergeSort();
        m1.setN(a1.getPillars().size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            m1.merge(a1.getPillars(), 0, 5, 10);
          });
        m1.merge(a1.getPillars(), 0, 5, 9);

        assertThrows(NegativeArraySizeException.class, () -> {
            m1.merge(a1.getPillars(), 9, 5, 0);
          });

        m1.merge(a1.getPillars(), 1, 0, 3);

        m1.merge(a1.getPillars(), 0, 0, 0);

        m1.merge(a1.getPillars(), 1, 3, 5);
    }






}
