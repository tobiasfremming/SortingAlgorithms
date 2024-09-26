package projectFiles;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FileHandelerTest {

    public FileHandeler buildObjectForTest() throws FileNotFoundException{
        FileHandeler f1 = new FileHandeler();
        f1.setTimesFileName("testfile.txt");

        try {
            PrintWriter writer = new PrintWriter(f1.getTimesFileName());
            for (int i = 0; i<11; i++){
                writer.println((double) i);
            }
            
            writer.flush();
            writer.close();

        } catch (Exception e) {
            throw new FileNotFoundException();
        }
        return f1;
    }

    @Test
    public void getTimesFromFileTest() throws FileNotFoundException{
        FileHandeler f1 = buildObjectForTest();
        List<String> actualList = new ArrayList<String>() ;
        for (int i = 0; i<11; i++){
            
            actualList.add((double) i+"");
        }
    
        List<String> result = f1.getTimesFromFile();

        assertEquals(actualList, result);
    }

    
    @Test
    public void addNewTimeTest() throws FileNotFoundException{
        FileHandeler f1 = buildObjectForTest();

        List<String> result = f1.getTimesFromFile();
        result.add("11.0");
        f1.addNewTime(11.0);
        assertEquals(result, f1.getTimesFromFile());

        result.add("12.0");
        f1.addNewTime(12.0);
        assertEquals(result, f1.getTimesFromFile());

        assertTrue(f1.verifyInsert(12));
        
    
    }

    @Test
    public void writeTimeToFileTest() throws FileNotFoundException{
        FileHandeler f1 = buildObjectForTest();

        List<Double> actualList = new ArrayList<Double>() ;
        for (int i = 11; i<21; i++){
            
            actualList.add((double) i);
        }
        f1.setTimes(actualList);
        f1.writeTimeToFile();

        List<String> newResult = f1.getTimesFromFile();

        List<String> list = new ArrayList<String>() ;
        for (int i = 11; i<21; i++){
            list.add((double) i+"");
        }
        
        assertEquals(newResult, list);
    }


    @Test 
    public void readTimeFromFileTest() throws FileNotFoundException{

        FileHandeler filehandeler = new FileHandeler();
        filehandeler.setTimesFileName("test2file.txt");

        try {
            PrintWriter writer = new PrintWriter(filehandeler.getTimesFileName());
            for (int i = 0; i<11; i++){
                writer.println( i*1.0);
            }
            
            writer.flush();
            writer.close();

        } catch (Exception e) {
            throw new FileNotFoundException();
        }
        filehandeler.setReadTimeList(new ArrayList<String>());

        filehandeler.readTimeFromFile();

        List<String> list = new ArrayList<String>() ;

        for (int i = 0; i<11; i++){
            list.add((double) i+"");
        }
        filehandeler.setReadTimeList(new ArrayList<String>());
        
        assertEquals(filehandeler.getTimesFromFile(), list);
        


    }

    @Test
    public void verifyInsertTest() throws FileNotFoundException{
        FileHandeler f1 = buildObjectForTest();

        List<String> list = new ArrayList<String>() ;

        for (int i = 0; i<11; i++){
            list.add((double) i+"");
        }
        // f1.setReadTimeList(new ArrayList<String>());
        
        assertTrue(f1.verifyInsert(10));
        assertFalse(f1.verifyInsert(9));
    }



    public FileHandeler buildObject2ForTest() throws FileNotFoundException{
        FileHandeler f1 = new FileHandeler();
        f1.setPillarFileName("test2file.txt");

        return f1;
    }

    @Test
    public void writePillarsTestAndGetPillarList() throws FileNotFoundException, Exception{
        FileHandeler f1 = buildObject2ForTest();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<10; i++){
            list.add(300-i);
        }
        assertEquals(f1.getPillarList(10), list);
        assertThrows(IllegalArgumentException.class, () -> {
            f1.writePillars(0);
          });
          assertThrows(IllegalArgumentException.class, () -> {
            f1.writePillars(1000);
          });
        
    }

    @Test
    public void readPillarsTest() throws FileNotFoundException, Exception{
        FileHandeler f1 = buildObject2ForTest();
        f1.writePillars(10);
        f1.readPillars();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<10; i++){
            list.add(300-i);
        }
        assertEquals(f1.getReadPillarList(), list);

    }

}
