import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeGameInstructions extends JFrame {

    public SnakeGameInstructions() {
        setTitle("Snake Game Instructions");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setText("Please read instructions carefully.. \n \n  Instructions:\n\n" +
                "1. *Starting the Game:*\n" +
                "   - Press the \"Lets go!!\" button to begin the game.\n" +
                "   - The snake starts as a small line segment on the screen, usually in the center.\n" +
                "   - A piece of food appears at a random location. \n \n " +
                        "2. *Moving the Snake:*\n" +
                        "   - Use the arrow keys (Up, Down, Left, Right) to control the direction in which the snake moves.\n" +
                        "   - The snake will continuously move in the direction it's facing, and you have to change its course to collect food and avoid collisions.\n\n" +

                        "3. *Collecting Food:*\n" +
                        "   - Guide the snake to the piece of food on the screen.\n" +
                        "   - When the snake's head touches the food, it will \"eat\" it, and its length will increase by one segment.\n" +
                        "   - New food will appear in a random location.\n\n" +

                        "4. *Growing the Snake:*\n" +
                        "   - As the snake eats more food, it will grow longer.\n" +
                        "   - The challenge increases as the snake gets longer, making it easier to collide with the walls or itself.\n\n" +

                        "5. *Avoiding Collisions:*\n" +
                        "   - The game ends if the snake runs into the game's boundaries (the walls) or collides with its own body.\n" +
                        "   - Be careful not to make sharp turns or change direction too quickly, as this can lead to self-collisions.\n\n" +

                        "6. *Scoring:*\n" +
                        "   - Some versions of Snake games keep track of your score...\n \n "+
                "Have fun playing the Snake Game!");

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Login");
        setVisible(true);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the instruction window
                new Sound();
                // Add  code to go back to the login or main menu here
                new Login().setVisible(true);
            }
        });
        add(backButton, BorderLayout.SOUTH);
    }
}
