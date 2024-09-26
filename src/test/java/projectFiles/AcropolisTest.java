package projectFiles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

public class AcropolisTest {

    @Test
    public void testConstructorAndCreatePillarListAndSetWidth(){
        Acropolis a1 = new Acropolis(20);
        assertEquals(a1.getPillars().size(), 20);
        int[] throwList = {-100, -1, 0, 351};
        for (int element: throwList){
            assertThrows(IllegalArgumentException.class, () -> {
                Acropolis a2 = new Acropolis(element);
            });
        }
        assertEquals( ((double) a1.gettotalWidth())/ (double)(20*1.5), a1.getPillars().get(0).getWidth());
    }

    

    @Test
    public void testSwapVals(){
        Acropolis a1 = new Acropolis(2);
        ArrayList<Pillar> pillars = new ArrayList<>();
        pillars.add(a1.getPillars().get(1));
        pillars.add(a1.getPillars().get(0));
        a1.swapVals(0,1);
        assertEquals(pillars, a1.getPillars());
    }

    @Test 
    public void testIsSorted(){
     
        Acropolis a1 = new Acropolis(1);
        a1.createSortedPillarListForTesting(10,-1);
        assertFalse(a1.isSorted());
        
        Acropolis a2 = new Acropolis(1);
        a2.createSortedPillarListForTesting(10,1);
        assertTrue(a2.isSorted());
    }

    @Test
    public void testBuildMsort(){
        Acropolis a1 = new Acropolis(100);
        MergeSort msort = a1.buildMergeSort();
        int n = msort.getN();

        while ((msort.getCurrSize() <= n-1)) {
        
            msort.sort(a1);
        
            msort.setCurrSize(msort.getCurrSize()*2);
        }
        assertTrue(a1.isSorted());
    }

    @Test
    public void testBuildQsort(){
// Comment: i dont test buildQsort for values that the QuickSort constructor perhibits. 
// This is because wrong values in the constructor will throw illegalargumentexeption, and this is well tested in QsortTest. 

        Acropolis a1 = new Acropolis(100);

        QuickSort qsort = a1.buildQuickSort();

        while((qsort.getTop() >= 0)){
            qsort.sort(a1);

        }
        assertTrue(a1.isSorted());  
    }








    
}
