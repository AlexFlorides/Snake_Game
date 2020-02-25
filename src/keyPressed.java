import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyPressed implements KeyListener {

    public static int fruits_eaten;
    public static int score_points;

    public static boolean moveleft = false;
    public static boolean moveright = true;
    public static boolean moveup = false;
    public static boolean movedown = false;


    @Override
    public void keyPressed(KeyEvent e) {
        //move snake up
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W && (!movedown)) {
            moveup = true;
            moveright = false;
            moveleft = false;
        }
        //move snake down
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S && (!moveup)) {
            movedown = true;
            moveright = false;
            moveleft = false;
        }
        //move snake right
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D && (!moveleft)) {
            moveright = true;
            moveup = false;
            movedown = false;
        }
        //move snake left
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A && (!moveright)) {
            moveleft = true;
            moveup = false;
            movedown = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
