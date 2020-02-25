# Snake_Game

For this project I have applied what I have learned so far in order to create a 2d shaped based Snake game. The game has been designed using GUI and it is user friendly. When the game starts, the snake is being drawn to a grid tile panel and the user can change its moving direction using AWSD Keys, Arrow Keys or Mouse Click. The purpose of the game is like any other normal snake game, to eat the food, which also is being drawn in the panel at random position, and survive as much as possible without hitting on the walls or touching its own body. The user can change the game’s difficulty, so the harder the difficulty is, the faster the snake will move, and the more points will be collected when eating the fruit. When the game starts, a fun music starts playing but there is always the option to mute it and unmute it any time. The same applies to the sound that is being made when the snake eats a fruit. Also, the user has the option to turn the game into dark mode, changing the colors of the whole interface or change back into the light color shades. When the game ends, the panel with all the drawings is being cleared and the top 10 scores of all time are being printed. 

**Demonstrative Screenshots:**

Main interface showing the grid panel, the panel on the right with the game stats and controls, the bottom panel with the buttons, radio buttons, check boxes and label showing student registration number:

![1](https://user-images.githubusercontent.com/47948084/75206415-44c4f900-576e-11ea-8d8d-e9e4fe4c906d.PNG)
 
Game starts running by pressing button ‘Start Game’ and draws square shape for the snake head, circle shape for its body and circle shape for the fruit:
 
 ![2](https://user-images.githubusercontent.com/47948084/75206539-966d8380-576e-11ea-8c22-540a96c50e71.PNG)

Snake movement can be controlled using AWSD Keys, or Arrow Keys, or Mouse Click:

![3](https://user-images.githubusercontent.com/47948084/75206556-a08f8200-576e-11ea-96be-0607e59d4c28.PNG)
 
Showing top 10 scores of all time when game ends (if snake head touches the tile grid bounds or a part of its body):

![4](https://user-images.githubusercontent.com/47948084/75206583-aedd9e00-576e-11ea-892e-b418b7a20e08.PNG)
 
**Extra additions to make the game more functional:**

a)	Added 3 radio buttons at the bottom panel to select the difficulty of the game. The harder difficulty you choose, the faster the snake will move and the more points you will gain when eating a fruit

b)	Reset Button, when clicked it resets everything to their initial state except the Dark Mode option

c)	Reset High Scores Button, when clicked it changes the values of the scores in the text file to zero
 
![7](https://user-images.githubusercontent.com/47948084/75206612-c2890480-576e-11ea-92a9-dd6178eaa1c1.PNG)

d)	Dark Mode, when checkbox selected the whole interface changes its color to darker colors. When unselected the interface changes to its original colors
 
 ![5](https://user-images.githubusercontent.com/47948084/75206629-cf0d5d00-576e-11ea-9e6c-b223fcd5548c.PNG)
 
 ![6](https://user-images.githubusercontent.com/47948084/75206641-d7659800-576e-11ea-9d0e-b6fa85d16772.PNG)

e)	Added music play continuously in the background, also play a sound whenever the snake eats the fruit

f)	Mute Music check box, when selected it stops the game music, when unselected the music continue plays

g)	Mute Eat-Sound check box, when selected it stops the sound it makes when the snake eats a fruit, when unselected that sounds is playing again
