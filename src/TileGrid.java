import java.awt.*;

public class TileGrid {

    int tile_size = 20;
    int rows = 30;
    int cols = 30;
    int game_panel_size = 600;

    //draw 20x20 grid
    public void draw(Graphics g) {
        if (ButtonHandler.inGame) {
            if (ButtonHandler.dark) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.BLACK);
            }
            for (int x = 0; x <= tile_size; x++) {
                for (int y = 0; y <= tile_size; y++) {
                    g.drawLine(x * rows, 0, x * rows, game_panel_size);
                    g.drawLine(0, y * cols, game_panel_size, y * cols);
                }
            }
        }
    }
}
