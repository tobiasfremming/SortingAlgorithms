package projectFiles;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;

public class Acropolis {
    private ArrayList<Pillar> pillars;
    private final int totalWidth = 757;  // the maximum width of the acropolis


    public Acropolis(int size) throws IllegalArgumentException{
        if (size <= 0 || size>350) throw new IllegalArgumentException("invalid number of pillars in input");
        ArrayList<Pillar> list = createPillarList(size);
        
        if(list.size() == 0 || list.size()>350) throw new IllegalArgumentException("invalid number of pillars");
        this.pillars = list;
        setWidth();
    }


    public ArrayList<Pillar> getPillars() {
        return this.pillars;
    }


    public void setPillars(ArrayList<Pillar> pillars) {
        this.pillars = pillars;
    }


    public ArrayList<Pillar> createPillarList(int n){
        ArrayList<Pillar> elements = new ArrayList<Pillar>();
        for(int i = 0; i<n; i++){
            
            Random rand = new Random();
            int randNum = rand.nextInt(1,300);
            Pillar element = new Pillar(randNum, i);
            elements.add(element);
            
        }
        
        return elements;

    }

    public void createPillarListFromFile(int n) throws FileNotFoundException, Exception{
        FileHandeler f1 = new FileHandeler();
        System.out.println("size"+ this.pillars.size());
        ArrayList<Integer> pillarHeights = f1.getPillarList(n);
        try {
            for(int i = 0; i<n; i++){
                this.getPillars().get(i).setHeight(pillarHeights.get(i));
                // this.getPillars().get(i).setHeight(this.getPillars().get(i).getHeight());
         
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        setWidth();
    
    }

    public void createSortedPillarListForTesting(int n, int ASCorDSC){

        //this.pillars.get(0).setHeight(200);
        this.pillars.remove(0);
        for(int i = 0; i<n; i++){
            int num = 170 + i*ASCorDSC;
            Pillar element = new Pillar(num, i);
            this.pillars.add(element);
        
        }
        
        
    }



    public void removeElementForTesting(){
        this.pillars.remove(0);
    }

    public Color createRandomColor(){
        Random rand = new Random();
  
        int r = rand.nextInt(200,255);
        int g = rand.nextInt(50);
        int b = rand.nextInt(50);
        Color randomColor =Color.rgb(r, g, b);
  
        return randomColor;
     }

    void swapVals(int i, int j){
        Color color = createRandomColor();
        Pillar temp = pillars.get(i);
        pillars.set(i, pillars.get(j));
        pillars.set(j,temp);
        pillars.get(i).setColor(color);
        pillars.get(j).setColor(color);
       }


    public boolean isSorted(){
        Pillar smaller = pillars.get(0);
        for(int i = 1; i < pillars.size(); i++){
            if (smaller.getHeight() > pillars.get(i).getHeight()){
                return false;
            }
            smaller = pillars.get(i);

        }
        return true;
    }

    public int gettotalWidth() {
        return this.totalWidth;
    }

    public void setWidth(){

        int n = pillars.size();
        double newWidth = this.totalWidth/(n*1.5);
        for(Pillar pillar: pillars ){
            pillar.setWidth(newWidth);
        }
    }

    public QuickSort buildQuickSort() throws IllegalArgumentException{
        
        try {
            int high =  this.getPillars().size() - 1;
            int low = 0;

            QuickSort q1 = new QuickSort(this, -1);
        
            int top = q1.getTop();
            
            q1.setMyList(++ top , low);
            q1.setMyList(++top, high);
            q1.setTop(top);
            
            return q1;
            
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not build the quicksort object, error:" + e);
        } 
    }

    public MergeSort buildMergeSort() throws IllegalArgumentException{
        try {
            MergeSort m1 = new MergeSort();
            m1.setN(this.getPillars().size());

            return m1;
            
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not build the merge sort object, error:" + e);
        }
        
    }


}


    

