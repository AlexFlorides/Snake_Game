import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class writeHighScores {

    //opens the HighScores file, and makes changes if necessary
    public void writeHighScores() {
        if (!ButtonHandler.executed) {
            try {
                String filePath = "./src/HighScores.txt";
                BufferedReader br = null;
                br = new BufferedReader(new FileReader(filePath));
                String line;
                ArrayList<Integer> scorearray = new ArrayList<>();
                int highest = keyPressed.score_points;

                //reads file, and sorts the high scores
                while ((line = br.readLine()) != null) {
                    String arr[] = line.split("\\s+");
                    scorearray.add(Integer.parseInt(arr[1]));
                }
                Collections.sort(scorearray);

                //compares current score with smallest high score of the file and sort it again in descending order
                if (highest > scorearray.get(0)) {
                    scorearray.set(0, highest);
                }
                Collections.sort(scorearray, Collections.reverseOrder());

                //write in the file the changes
                FileWriter writer = new FileWriter(filePath, false);
                int number = 1;
                for (int i = 0; i < scorearray.size(); i++) {
                    if (i == scorearray.size() - 1) {
                        writer.write(number + ") " + scorearray.get(i) + "\n");
                    } else {
                        writer.write("0" + number + ") " + scorearray.get(i) + "\n");
                    }
                    number++;
                }
                writer.flush();
                writer.close();

                ButtonHandler.executed = true;

            } catch (IOException ex) {
                System.out.println("File not Found!");
            }
        }

        //prints high scores on Text Area
        try {
            BufferedReader br = null;
            String filePath = "./src/HighScores.txt";
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                Game.textarea.append(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println("File not Found!");
        }
    }

    //reset the high score text file
    public static void resetScores(){
        try {
            String filePath = "./src/HighScores.txt";
            FileWriter writer = new FileWriter(filePath, false);
            int number = 1;
            for (int i = 0; i < 10; i++) {
                if (i == 9) {
                    writer.write(number + ") 000 \n");
                } else {
                    writer.write("0" + number + ") 000 \n");
                }
                number++;
            }
            writer.flush();
            writer.close();
        }
        catch (IOException ex) {
            System.out.println("File not Found!");
        }
    }
}
