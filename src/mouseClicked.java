import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseClicked implements MouseListener {

    keyPressed keyPressed;
    ButtonHandler bh;

    //MouseListener that compares snake's position and mouse click position and changes snake's moving direction
    @Override
    public void mouseClicked(MouseEvent e) {
        if (ButtonHandler.inGame) {
            if (keyPressed.moveup && e.getX() > bh.x[0] && (e.getY() > 0 && e.getY() < 600)) {
                keyPressed.moveright = true;
                keyPressed.moveup = false;
            }
            else if (keyPressed.moveup && e.getX() < bh.x[0] && (e.getY() > 0 && e.getY() < 600)) {
                keyPressed.moveleft = true;
                keyPressed.moveup = false;
            }
            else if (keyPressed.movedown && e.getX() > bh.x[0] && (e.getY() > 0 && e.getY() < 600)) {
                keyPressed.moveright = true;
                keyPressed.movedown = false;
            }
            else if (keyPressed.movedown && e.getX() < bh.x[0] && (e.getY() > 0 && e.getY() < 600)) {
                keyPressed.moveleft = true;
                keyPressed.movedown = false;
            }
            else if (keyPressed.moveleft && e.getY() > bh.y[0] && (e.getX() > 0 && e.getX() < 600)) {
                keyPressed.movedown = true;
                keyPressed.moveleft = false;
            }
            else if (keyPressed.moveleft && e.getY() < bh.y[0] && (e.getX() > 0 && e.getX() < 600)) {
                keyPressed.moveup = true;
                keyPressed.moveleft = false;
            }
            else if (keyPressed.moveright && e.getY() > bh.y[0] && (e.getX() > 0 && e.getX() < 600)) {
                keyPressed.movedown = true;
                keyPressed.moveright = false;
            }
            else if (keyPressed.moveright && e.getY() < bh.y[0] && (e.getX() > 0 && e.getX() < 600)) {
                keyPressed.moveup = true;
                keyPressed.moveright = false;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
