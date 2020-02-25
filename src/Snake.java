import java.awt.*;

public class Snake extends Shape {

    public static Integer size;

    ButtonHandler bh;
    public static int snakeParts;

    public Snake(Integer posX, Integer posY, Integer size) {
        super(posX, posY);
        this.size = size;
    }

    //draws the snake
    public void draw(Graphics g) {
        for (int i = 0; i < snakeParts; i++) {
            //draws the snake head
            if (i == 0) {
                g.setColor(Color.BLUE);
                g.fillRect(bh.x[i], bh.y[i], size, size);
            }
            //draws the snake body
            else {
                g.setColor(Color.GREEN);
                g.fillOval(bh.x[i], bh.y[i], size, size);
            }
        }
    }
}
