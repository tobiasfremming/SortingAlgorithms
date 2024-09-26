package projectFiles;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileHandeling {

    public List<String> getTimesFromFile() throws FileNotFoundException;

    public void writeTimeToFile() throws FileNotFoundException;

    public void readTimeFromFile() throws FileNotFoundException;

    public void writePillars(int size) throws FileNotFoundException;


    
}
