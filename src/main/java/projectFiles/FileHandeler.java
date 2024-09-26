package projectFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandeler implements FileHandeling{

    private List<Double> times = new ArrayList<>();
    private List<String> readTimeList = new ArrayList<>();
    private ArrayList<Integer> readPillarList = new ArrayList<>();


    private String timesFileName = "times.txt";
    private String pillarFileName = "pillars.txt";



    public List<Double> getTimes() {
        return this.times;
    }

    public void setTimes(List<Double> times) {
        this.times = times;
    }

    public List<String> getReadTimeList() {
        return this.readTimeList;
    }

    public void setReadTimeList(List<String> readTimeList) {
        this.readTimeList = readTimeList;
    }


    public void setReadPillarList(ArrayList<Integer> readPillarList) {
        this.readPillarList = readPillarList;
    }

    public String getTimesFileName() {
        return this.timesFileName;
    }

    public void setTimesFileName(String timesFileName) {
        this.timesFileName = timesFileName;
    }

    public String getPillarFileName() {
        return this.pillarFileName;
    }

    public void setPillarFileName(String pillarFileName) {
        this.pillarFileName = pillarFileName;
    }

    

    public List<String> getTimesFromFile() throws FileNotFoundException{
        readTimeFromFile();
        return this.readTimeList;
    }

    public ArrayList<Integer> getReadPillarList(){
        return this.readPillarList;
    }
    

    public void addNewTime(double time) throws FileNotFoundException{
        this.times.add(time);
        writeTimeToFile();
    }


    public void writeTimeToFile() throws FileNotFoundException{
        try {
            PrintWriter writer = new PrintWriter(this.timesFileName);
            for (double time : times){
                writer.println(time);
            }
            
            writer.flush();
            writer.close();

        } catch (Exception e) {
           throw new FileNotFoundException();
        }
        
    }

    public void readTimeFromFile() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(this.timesFileName));

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            this.readTimeList.add(line);
        }
    }

    public boolean verifyInsert(double time) throws FileNotFoundException{
        readTimeFromFile();
        if (this.readTimeList.get(this.readTimeList.size()-1).equals(Double.toString(time)) ){

            return true;
        }
        return false;
    }

    public void writePillars(int size) throws FileNotFoundException{
        if (size > 300 ){
            throw new IllegalArgumentException("invalid number of pillars to write to file");
        }
        if (size < 10 ){
            throw new IllegalArgumentException("invalid number of pillars to write to file");
        }

        try {
            PrintWriter writer = new PrintWriter(this.pillarFileName);
            for (int i = 0; i<size; i++){
                writer.println(300-i);
            }
            
            writer.flush();
            writer.close();

        } catch (Exception e) {
           throw new FileNotFoundException();
        }

    }


    
    public void readPillars() throws FileNotFoundException, Exception {
        Scanner scanner = new Scanner(new File(this.pillarFileName));

        while(scanner.hasNextLine()){
            try {
                int line = Integer.parseInt(scanner.nextLine());
                this.readPillarList.add(line);
            } catch (Exception e) {
                throw new Exception();
            }
            
            
        }
    }

    public ArrayList<Integer> getPillarList(int size) throws FileNotFoundException, Exception{
        writePillars(size);
        readPillars();
        return this.readPillarList;
    }
    
}
