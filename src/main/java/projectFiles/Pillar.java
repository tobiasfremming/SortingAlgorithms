package projectFiles;

import javafx.scene.paint.Color;

public class Pillar {
    private int height;
    private double width = 5;
    private int index;
    private double y;
    private Color color = Color.WHITE;
    


    public Pillar(int height, int index) throws IllegalArgumentException{
        if(validateInput(height, index) == false) throw new IllegalArgumentException("wrong values");
        this.height = height;
        this.index = index;
        setY();

    }

    public void setColor(Color newColor){
        this.color = newColor;
    }

    public Color getColor(){
        return this.color;
    }
    

    public int getHeight() {
        return this.height;
    }
    public double getWidth() {
        return this.width;
    }

    public int getIndex() {
        return this.index;
    }
    public double getY() {
        // 310 is decided through calibration, where the bottom of the pillars should be in gui
        return this.y;
    }
    

    public void setHeight(int height) {
        this.height = height;
        setY();
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setY() {
        // 310 is decided through calibration, where the bottom of the pillars should be in gui
        this.y =  (310 - height);
    }


    private boolean validateInput(int height, int index){
        if(height>300) return false;
        if(index < 0) return false;

        return true;
    }

    
}
