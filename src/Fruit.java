import java.awt.*;

public class Fruit extends Shape {

    public static Integer size;

    public Fruit(Integer posX, Integer posY, Integer size) {
        super(posX, posY);
        this.size = size;
    }

    //draws the fruit
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(posX, posY, size, size);
    }
}
