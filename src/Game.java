import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Game extends JFrame {

    TileGrid tilegrid;
    Snake snake;
    Fruit fruit;

    //creating JLables, JtextArea, JRadioButtons and JCheckBoxes that can be accessed from any class
    public JLabel stats = new JLabel("Stats:", SwingConstants.HORIZONTAL);
    public JLabel score = new JLabel("Score:   ");
    public static JLabel score_score = new JLabel("0");
    public JLabel fruits = new JLabel("Fruits eaten:   ");
    public static JLabel fruits_score = new JLabel("0");
    public static JLabel gameover = new JLabel();

    public static JLabel highscores = new JLabel("");
    public static JTextArea textarea = new JTextArea("");

    public static JRadioButton option1 = new JRadioButton("Easy");
    public static JRadioButton option2 = new JRadioButton("Medium");
    public static JRadioButton option3 = new JRadioButton("Hard");

    public static JCheckBox darkmode = new JCheckBox("Dark Mode");
    public static JCheckBox music = new JCheckBox("Mute Music");
    public static JCheckBox sounds = new JCheckBox("Mute Eat-Sound");

    public Game() {

        setTitle("Snake Game: Alexandros Florides");
        setLayout(new BorderLayout());

        tilegrid = new TileGrid();
        snake = new Snake(0, 0, 0);
        fruit = new Fruit(0, 0, 0);

        //draws snake, fruit and grid
        JPanel tiles_panel = new JPanel() {
            public void paintComponent(Graphics g) {
                snake.draw(g);
                fruit.draw(g);
                tilegrid.draw(g);
            }
        };

        //creates JPanels and setting their layout
        JPanel labels_panel = new JPanel();
        JPanel buttons_panel = new JPanel();

        tiles_panel.setLayout(new GridBagLayout());
        labels_panel.setLayout(new GridBagLayout());
        buttons_panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;

        //adding components in the tiles_panel using grid-bag-constraint
        c.gridy = 1;
        tiles_panel.add(gameover, c);
        c.gridy = 2;
        tiles_panel.add(highscores, c);
        c.gridy = 3;
        tiles_panel.add(textarea, c);
        c.gridy = 0;
        tiles_panel.addMouseListener(new mouseClicked());

        //adds JRadioButtons in group
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        //creating labels and adding them to buttons_panel using grid-bag-constraint
        JLabel difficulty = new JLabel("Game difficulty: ");
        //JLabel student = new JLabel("Registration number: Alexandros Florides");
        buttons_panel.add(difficulty);
        c.insets = new Insets(10, 0, 10, 10);
        buttons_panel.add(option1, c);
        buttons_panel.add(option2, c);
        buttons_panel.add(option3, c);

        JButton start_button = new JButton("Start Game");
        JButton reset_button = new JButton("Reset");
        JButton reset_scores = new JButton("Reset High Scores");
        c.insets = new Insets(10, 0, 10, 0);
        buttons_panel.add(start_button, c);
        c.insets = new Insets(10, 20, 10, 0);
        buttons_panel.add(reset_button, c);
        buttons_panel.add(reset_scores, c);
        buttons_panel.add(darkmode, c);
        c.insets = new Insets(10, 10, 10, 0);
        buttons_panel.add(music, c);
        buttons_panel.add(sounds, c);
        //c.insets = new Insets(10, 10, 10, 0);
        //buttons_panel.add(student, c);

        start_button.setPreferredSize(new Dimension(100, 30));

        stats.setPreferredSize(new Dimension(300, 30));

        //creates labels and adding them to lables_panel using grid-bag-constraint
        JLabel control_title = new JLabel("Controls: ", SwingConstants.HORIZONTAL);
        JLabel move_up = new JLabel("Move Up:           Up Arrow Key / W Key / Mouse click above of the snake head");
        JLabel move_down = new JLabel("Move Down:      Down Arrow Key / S Key / Mouse click below of the snake head");
        JLabel move_left = new JLabel("Move Left:         Left Arrow Key / A Key / Mouse click left of the snake head");
        JLabel move_right = new JLabel("Move Right:      Right Arrow Key / D Key / Mouse click right of the snake head");

        JLabel start_game = new JLabel("Press 'Start Game' button to start playing");
        JLabel reset = new JLabel("Press 'Reset' button to reset the game");

        c.insets = new Insets(0, 0, 0, 0);
        labels_panel.add(stats, c);
        c.gridy = 1;
        labels_panel.add(score, c);
        c.insets = new Insets(0, 20, 0, 20);
        labels_panel.add(score_score, c);
        c.gridy = 2;
        c.insets = new Insets(0, 0, 0, 0);
        labels_panel.add(fruits, c);
        c.insets = new Insets(0, 20, 0, 20);
        labels_panel.add(fruits_score, c);

        c.insets = new Insets(50, 0, 10, 0);
        c.gridy = 3;
        labels_panel.add(control_title, c);
        c.insets = new Insets(0, 0, 0, 0);
        c.gridy = 4;
        labels_panel.add(move_up, c);
        c.gridy = 5;
        labels_panel.add(move_down, c);
        c.gridy = 6;
        labels_panel.add(move_left, c);
        c.gridy = 7;
        labels_panel.add(move_right, c);

        c.insets = new Insets(40, 0, 0, 0);
        c.gridy = 8;
        labels_panel.add(start_game, c);
        c.gridy = 9;
        c.insets = new Insets(0, 0, 0, 0);
        labels_panel.add(reset, c);

        //changing some properties of the labels
        highscores.setVisible(false);
        highscores.setFont(new Font("Times Roman", Font.BOLD, 22));

        textarea.setVisible(false);
        textarea.setEditable(false);
        textarea.setOpaque(false);
        textarea.setFont(new Font("Times Roman", Font.BOLD, 20));

        option1.setOpaque(false);
        option2.setOpaque(false);
        option3.setOpaque(false);

        option1.setFont(new Font("TimerRoman", Font.BOLD, 14));
        option2.setFont(new Font("TimerRoman", Font.BOLD, 14));
        option3.setFont(new Font("TimerRoman", Font.BOLD, 14));

        darkmode.setFont(new Font("TimerRoman", Font.BOLD, 14));
        music.setFont(new Font("TimerRoman", Font.BOLD, 14));
        sounds.setFont(new Font("TimerRoman", Font.BOLD, 14));

        stats.setFont(new Font("TimeRoman", Font.BOLD, 20));

        score.setFont(new Font("TimeRoman", Font.BOLD, 14));
        score_score.setFont(new Font("TimeRoman", Font.BOLD, 14));
        score_score.setForeground(Color.RED);

        fruits.setFont(new Font("TimeRoman", Font.BOLD, 14));
        fruits_score.setFont(new Font("TimeRoman", Font.BOLD, 14));
        fruits_score.setForeground(Color.RED);

        gameover.setFont(new Font("TimeRoman", Font.BOLD, 70));

        control_title.setFont(new Font("TimeRoman", Font.BOLD, 20));
        move_up.setFont(new Font("TimeRoman", Font.BOLD, 14));
        move_down.setFont(new Font("TimeRoman", Font.BOLD, 14));
        move_left.setFont(new Font("TimeRoman", Font.BOLD, 14));
        move_right.setFont(new Font("TimeRoman", Font.BOLD, 14));

        start_game.setFont(new Font("TimeRoman", Font.BOLD, 14));
        reset.setFont(new Font("TimeRoman", Font.BOLD, 14));
        difficulty.setFont(new Font("TimeRoman", Font.BOLD, 14));
        //student.setFont(new Font("TimeRoman", Font.BOLD, 14));

        //adding panels to the frame
        add(tiles_panel, BorderLayout.CENTER);
        add(labels_panel, BorderLayout.EAST);
        add(buttons_panel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(1300, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);

        //ActionListener for JRadioButtons
        option1.addActionListener(new ButtonHandler(this, 3));
        option2.addActionListener(new ButtonHandler(this, 4));
        option3.addActionListener(new ButtonHandler(this, 5));
        //ItemListener for JCheckBox darkmode
        darkmode.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //changes the colors of every component when darkmode selected
                if (darkmode.isSelected()) {
                    ButtonHandler.dark = true;
                    labels_panel.setBackground(Color.BLACK);
                    buttons_panel.setBackground(Color.BLACK);
                    getContentPane().setBackground(Color.BLACK);
                    stats.setForeground(Color.WHITE);
                    score.setForeground(Color.WHITE);
                    fruits.setForeground(Color.WHITE);
                    gameover.setForeground(Color.WHITE);
                    highscores.setForeground(Color.WHITE);
                    control_title.setForeground(Color.WHITE);
                    move_up.setForeground(Color.WHITE);
                    move_down.setForeground(Color.WHITE);
                    move_left.setForeground(Color.WHITE);
                    move_right.setForeground(Color.WHITE);
                    start_game.setForeground(Color.WHITE);
                    reset.setForeground(Color.WHITE);
                    difficulty.setForeground(Color.WHITE);
                   //student.setForeground(Color.WHITE);
                    textarea.setForeground(Color.WHITE);
                    option1.setForeground(Color.WHITE);
                    option2.setForeground(Color.WHITE);
                    option3.setForeground(Color.WHITE);
                    start_button.setBackground(Color.BLACK);
                    reset_button.setBackground(Color.BLACK);
                    reset_scores.setBackground(Color.BLACK);
                    start_button.setForeground(Color.WHITE);
                    reset_button.setForeground(Color.WHITE);
                    reset_scores.setForeground(Color.WHITE);
                    darkmode.setOpaque(false);
                    darkmode.setForeground(Color.WHITE);
                    music.setOpaque(false);
                    music.setForeground(Color.WHITE);
                    sounds.setOpaque(false);
                    sounds.setForeground(Color.WHITE);
                }
                //resets color of all components to their original when darkmode unselected
                if (!darkmode.isSelected()) {
                    ButtonHandler.dark = false;
                    labels_panel.setBackground(Color.WHITE);
                    buttons_panel.setBackground(Color.WHITE);
                    getContentPane().setBackground(Color.WHITE);
                    stats.setForeground(Color.BLACK);
                    score.setForeground(Color.BLACK);
                    fruits.setForeground(Color.BLACK);
                    gameover.setForeground(Color.BLACK);
                    highscores.setForeground(Color.BLACK);
                    control_title.setForeground(Color.BLACK);
                    move_up.setForeground(Color.BLACK);
                    move_down.setForeground(Color.BLACK);
                    move_left.setForeground(Color.BLACK);
                    move_right.setForeground(Color.BLACK);
                    start_game.setForeground(Color.BLACK);
                    reset.setForeground(Color.BLACK);
                    difficulty.setForeground(Color.BLACK);
                    //student.setForeground(Color.BLACK);
                    textarea.setForeground(Color.BLACK);
                    option1.setForeground(Color.BLACK);
                    option2.setForeground(Color.BLACK);
                    option3.setForeground(Color.BLACK);
                    start_button.setBackground(UIManager.getColor("Button.background"));
                    reset_button.setBackground(UIManager.getColor("Button.background"));
                    reset_scores.setBackground(UIManager.getColor("Button.background"));
                    start_button.setForeground(Color.BLACK);
                    reset_button.setForeground(Color.BLACK);
                    reset_scores.setForeground(Color.BLACK);
                    darkmode.setForeground(Color.BLACK);
                    music.setForeground(Color.BLACK);
                    sounds.setForeground(Color.BLACK);
                }
            }
        });
        //ActionListener for buttons and radiobuttons
        music.addActionListener(new ButtonHandler(this, 6));
        sounds.addActionListener(new ButtonHandler(this, 7));
        start_button.addActionListener(new ButtonHandler(this, 1));
        reset_button.addActionListener(new ButtonHandler(this, 2));
        reset_scores.addActionListener(new ButtonHandler(this, 8));
        addKeyListener(new keyPressed());
    }

    public static void main(String[] args) {
        new Game();
    }
}
