
import java.awt.*;
import javax.swing.*;
public class SnakeGame extends JFrame  {
    static int finalScore=0;
    SnakeGame() {

        super("Snake Game");
        // creating object of board class
        add(new Board());         // to add Board on frame
        pack();                  //to refresh so  that changes could reflect

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}