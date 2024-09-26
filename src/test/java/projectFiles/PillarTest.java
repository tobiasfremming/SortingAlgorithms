package projectFiles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javafx.scene.paint.Color;


public class PillarTest {
    

    @Test
    public void testConstructor(){
        Pillar p1 = new Pillar(200, 0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            Pillar p2 = new Pillar(301, 1);
          });
        assertThrows(IllegalArgumentException.class, () -> {
            Pillar p4 = new Pillar(20, -2);
          });
    }
    @Test
    public void testSetY() {
        Pillar p1 = new Pillar(200, 0);
        p1.setY();
        assertEquals(310 - 200, p1.getY());
    }

    @Test
    public void testGettersAndSetters(){
        Pillar pillar = new Pillar(200, 0);
        pillar.setColor(Color.BLUE);
        assertEquals(Color.BLUE, pillar.getColor() );

        pillar.setHeight(30);
        assertEquals(30, pillar.getHeight() );

        pillar.setIndex(1);
        assertEquals(1, pillar.getIndex() );

    }


}
