import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ButtonHandler implements ActionListener {

    private Game theApp;
    private int action;

    Snake Snake;
    Fruit Fruit;
    keyPressed keyPressed;

    public static final int x[] = new int[400];
    public static final int y[] = new int[400];

    public static boolean inGame = true;
    public static boolean executed = false;
    public static boolean dark = false;

    //calls Music and EatSound constructors
    Music music = new Music();
    EatSound eatsound = new EatSound();

    //creates new timer
    Timer timer = new Timer(350, this);

    public ButtonHandler(Game theApp, int action) {
        this.theApp = theApp;
        this.action = action;
        startGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //button 'Start Game'
        if (this.action == 1) {
            move();
            eatFruit();
            bodyCollision();
            wallCollision();
            this.theApp.repaint();
            timer.start();
        }
        //Button 'Reset'
        if (this.action == 2) {
            resetGame();
        }
        if (this.action == 8){
            writeHighScores.resetScores();
        }
        //Radio Button 'Easy'
        if (Game.option1.isSelected()) {
            timer.setDelay(300);
        }
        //Radio Button 'Medium'
        if (Game.option2.isSelected()) {
            timer.setDelay(200);
        }
        //Radio Button 'Hard'
        if (Game.option3.isSelected()) {
            timer.setDelay(100);
        }
        //Mute music when CheckBox selected
        if (Game.music.isSelected()) {
            Music.stop();
        }
        //Continue music when CheckBox unselected
        if (!Game.music.isSelected()) {
            Music.play();
        }
        //Mute eat-sound when CheckBox selected
        if (Game.sounds.isSelected()) {
            EatSound.stop();
        }
        this.theApp.requestFocus();
    }

    //starts the game
    public void startGame() {
        Snake.snakeParts = 4;

        Game.option2.setSelected(true);
        createSnake();
        randomFruit();

    }

    //draw the fruit on random position in the grid
    public void randomFruit() {

        ArrayList<Integer> fruitcoordsx = new ArrayList<>();
        ArrayList<Integer> fruitcoordsy = new ArrayList<>();

        Fruit.size = 20;
        int start = 5;

        for (int i = 0; i < 20; i++) {
            fruitcoordsx.add(start);
            fruitcoordsy.add(start);
            start += 30;
        }

        Collections.shuffle(fruitcoordsx);
        Fruit.posX = fruitcoordsx.get(0);
        Collections.shuffle(fruitcoordsy);
        Fruit.posY = fruitcoordsy.get(0);
    }

    //draw the snake head in the grid
    public void createSnake() {

        for (int z = 1; z <= Snake.snakeParts; z++) {
            x[z] = 0;
            y[z] = 0;
        }

        inGame = true;

        Snake.size = 30;
        Game.gameover.setText("");

        //sets snake's initial position and direction moving
        x[0] = 300;
        y[0] = 300;
        keyPressed.moveleft = false;
        keyPressed.moveright = true;
        keyPressed.moveup = false;
        keyPressed.movedown = false;

        //appending the snake body in the array
        for (int z = 1; z <= Snake.snakeParts; z++) {
            x[z] -= x[0] - 30;
            y[z] = y[0];
        }
    }

    //check for snake collision with the walls
    public void wallCollision() {
        if (x[0] >= 600 || x[0] < 0 || y[0] >= 600 || y[0] < 0) {
            gameOver();
        }
    }

    //checks if snake head eats the fruit
    //change points added according to the difficulty selected
    public void eatFruit() {
        if (x[0] == Fruit.posX - 5 && y[0] == Fruit.posY - 5) {
            keyPressed.fruits_eaten += 1;
            if (Game.option1.isSelected()) {
                keyPressed.score_points += 15;
            }
            if (Game.option2.isSelected()) {
                keyPressed.score_points += 30;
            }
            if (Game.option3.isSelected()) {
                keyPressed.score_points += 50;
            }
            //draw the fruit again, changes the labels text, play sound and add one more snake body part
            randomFruit();
            Game.fruits_score.setText(String.valueOf(keyPressed.fruits_eaten));
            Game.score_score.setText(String.valueOf(keyPressed.score_points));
            Snake.snakeParts++;
            new EatSound();
            EatSound.play();
        }
    }

    //checks for snake collision with its body
    public void bodyCollision() {
        for (int i = 1; i < Snake.snakeParts; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                gameOver();
            }
        }
    }

    //moving snake by calling keyListener
    public void move() {
        for (int z = Snake.snakeParts; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (keyPressed.moveleft) {
            x[0] -= 30;
        }
        if (keyPressed.moveright) {
            x[0] += 30;
        }
        if (keyPressed.moveup) {
            y[0] -= 30;
        }
        if (keyPressed.movedown) {
            y[0] += 30;
        }
    }

    //resets everything on their original state
    public void resetGame() {
        timer.stop();
        inGame = true;
        executed = false;
        Game.option2.setSelected(true);
        Game.music.setSelected(false);
        Game.sounds.setSelected(false);
        Game.gameover.setText("");
        Game.highscores.setText("");
        Game.textarea.setText("");
        keyPressed.fruits_eaten = 0;
        keyPressed.score_points = 0;
        Game.fruits_score.setText(String.valueOf(keyPressed.fruits_eaten));
        Game.score_score.setText(String.valueOf(keyPressed.score_points));
        startGame();
    }

    //Game ends, shows high scores, stops music, prints message
    public void gameOver() {
        if (!executed) {
            Snake.size = 0;
            Fruit.size = 0;
            Music.stop();
            Game.gameover.setText("Game Over!");
            Game.textarea.setVisible(true);
            Game.highscores.setText("High Scores:");
            Game.highscores.setVisible(true);
            new writeHighScores().writeHighScores();
            timer.stop();
            inGame = false;
            executed = true;
        }
    }
}
