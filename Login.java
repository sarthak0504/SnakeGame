
import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{

   JButton button3;
   JButton button2;


 Login(){
   super("Snake World...");
   //inserting background image.
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("IMG\\bg11.png"));
   Image i2 = i1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel img_bg = new JLabel(i3);
   img_bg.setBounds(0,0,850,480);
   
//creating the layout
    setLayout(null);
    setSize(850,480);
    setLocation(450, 200);
    setVisible(true);


    add(img_bg);

//adding the button for starting the game.
    button3 = new JButton("LETS GO!!");
    button3.setFont(new Font("Arial", 1, 20));
    button3.setForeground(Color.YELLOW);
    button3.setBackground(Color.black);
    button3.setBounds(335, 348, 230, 30);
    button3.addActionListener(this);
    add(button3);

     button2 = new JButton("INSTRUCTIONS");
     button2.setFont(new Font("Arial", 1, 20));
     button2.setForeground(Color.YELLOW);
     button2.setBackground(Color.black);
     button2.setBounds(335, 385, 230, 30);
     button2.addActionListener(this);
     add(button2);



 }
 
 public void actionPerformed(ActionEvent e) {
       try {
          if (e.getSource() == button3) {
             SnakeGame s = new SnakeGame();
             setVisible(false);
          }
           else if (e.getSource() == button2) {
              SnakeGameInstructions sgi = new SnakeGameInstructions();
               setVisible(false);
           }

       } catch (Exception E) {
          E.printStackTrace();
       }

    }

}
