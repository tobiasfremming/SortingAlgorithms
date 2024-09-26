package projectFiles;

import java.time.Instant;
import java.time.Duration;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
//import javafx.util.Duration;

public class Controller implements Initializable {

    private Acropolis acropolis;

    private QuickSort quickSort;

    private MergeSort mergeSort;

    private String lastSort;

    private double time = 0;

    private FileHandeler filehandeler = new FileHandeler();

    @FXML
    private CheckBox fileToggle;

    @FXML
    private TextField timeTxt;

    @FXML
    private TextField prevTimeTxt;
    

    @FXML
    private Slider slider1;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Canvas panel;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Rectangle refreshRect;


    public boolean CheckBoxIsSelected(){
        return fileToggle.isSelected();
    } 

    private void nullTime(){
        this.time = 0;
    }

    private void addTime(double milliseconds){
        this.time += milliseconds;
    }

    public double getTime(){
        return this.time;
    }

    public Acropolis getAcropolis(){
        return this.acropolis;
    }

    public void setAcropolis(Acropolis newAcropolis){
        this.acropolis = newAcropolis;
        
    }

    private void setTimeText(){
        
        String string = "time: "+ new DecimalFormat("0.000").format(this.time) + " ms";
        
        this.timeTxt.setPromptText(string);
    }

    private void setPrevTimeTxt() throws FileNotFoundException{
        List<String> timeList = this.filehandeler.getTimesFromFile();
        String string = "#";
        try {
            string = "previous time: " +  timeList.get(timeList.size()-1) + " ms";
        } catch (Exception e) {
            
        }

        this.prevTimeTxt.setPromptText(string);
        
    }

    private double nanoToMillis(long nanos){
        nanos -= 1000000;
        double millis = (double) nanos/1000000.0;
        return millis;
    }
    

    private void render() throws IllegalArgumentException, FileNotFoundException {
        if (this.acropolis == null){
            throw new IllegalArgumentException("Failed to render because there arent any pillars");

        }
        if (this.time != 0){
            setTimeText();
        }
    
        GraphicsContext mal = panel.getGraphicsContext2D();
        
        mal.clearRect(0, 0, panel.getWidth(), panel.getHeight());
        
        
        double width = this.acropolis.getPillars().get(0).getWidth();
        double space = width/2;
        double h = width + space;
        double x = 0;

        

        if (this.acropolis.isSorted()){
            try {
                if (this.time != 0){
                    this.filehandeler.addNewTime(this.time);
                    if (this.filehandeler.verifyInsert(this.time)){
                        nullTime();
                    }
                    
                }
                
            } catch (Exception e) {
                throw new FileNotFoundException();
            }
            
            for(Pillar rectangle: acropolis.getPillars()){
                rectangle.setColor(Color.LIGHTGREEN);
            }
        }
        
        for(Pillar rectangle: this.acropolis.getPillars()){
           
            
            mal.setFill(rectangle.getColor());
            int height = rectangle.getHeight();
            mal.fillRect(x,rectangle.getY(),width,height);
            rectangle.setColor(Color.WHITE);
            x += h;
        }
        
        mal.stroke();
        mal.beginPath();
        
        
        
    }

// <TextField fx:id="prevTimeTxt" alignment="TOP_LEFT" layoutX="30.0" layoutY="75.0" prefHeight="40.0" prefWidth="149.0" promptText="previous time:" style="-fx-background-color: #1e2733; -fx-control-inner-background: #ffffff;">
    @FXML
    private void start() throws IllegalArgumentException, InterruptedException, FileNotFoundException{

        nullTime();
        setTimeText();
        try {
            setPrevTimeTxt();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            double pillarSizeDouble = this.slider1.valueProperty().getValue();
            int pillarSize = (int) pillarSizeDouble;
            this.acropolis = new Acropolis(pillarSize);
            if (CheckBoxIsSelected()){
                this.acropolis.createPillarListFromFile(this.acropolis.getPillars().size());
            }
            
            this.quickSort = this.acropolis.buildQuickSort();
            this.mergeSort = this.acropolis.buildMergeSort();

            render();

        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to build the application, error:" + e);
        }
    }



    @FXML
    private void iterateMsort() throws IllegalArgumentException, FileNotFoundException{
    
        try {
            if(this.lastSort != "mSort"){
                this.mergeSort = this.acropolis.buildMergeSort();
                this.lastSort = "mSort";
            }

            int n = mergeSort.getN();

            int curr_size= mergeSort.getCurrSize();

            if (this.acropolis.isSorted() == false){
                
                Instant start = Instant.now();
                mergeSort.sort(this.acropolis);
                try {
                    Thread.sleep(1);//time is in ms (1000 ms = 1 second)
                    } catch (InterruptedException e) {e.printStackTrace();}
                    
                Instant end = Instant.now();
                addTime(nanoToMillis(Duration.between(start, end).toNanos()));

                mergeSort.setCurrSize(curr_size*2);
            
            }
        
            
            
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not do the next iteration of merge sort, error:" + e);
        } 
        finally{
            render(); 
        }
        
        
    }

    @FXML
    private void iterateQsort() throws IllegalArgumentException, FileNotFoundException {
        
        try {

            this.lastSort = "qSort";

            if (this.acropolis.isSorted() == false){
                
                Instant start = Instant.now();
                this.quickSort.sort(this.acropolis);
                try {
                    Thread.sleep(1);//time is in ms (1000 ms = 1 second)
                  }catch (InterruptedException e) {e.printStackTrace();}
                  
                Instant end = Instant.now();
                addTime(nanoToMillis(Duration.between(start, end).toNanos()));
            }
            
            
        } catch (Exception e) {
                throw new IllegalArgumentException("Could not do the next iteration of merge sort, error:" + e);

        }finally{
            render();    
        }   
    }


    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        
        // TODO Auto-generated method stub
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(refreshRect);
        translate.setDuration(javafx.util.Duration.millis(10000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(700);
        translate.setAutoReverse(true);
        //translate.setOnFinished(render());
        translate.play();
        if(refreshRect.getX()== 500){
            System.out.println(("hei"));
        }
    }

    
}
