
import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
   JLabel label1,label2,label3;

   JButton button3;


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

//    label1 = new JLabel("Snake World!!");
//    label1.setForeground(Color.RED);
//    label1.setFont(new Font("AvantGrade",Font.BOLD, 36));
//    label1.setBounds(230, 50, 450, 40);
//     add(label1);

    add(img_bg);

//adding the button for starting the game.
    button3 = new JButton("LETS GO!!");
    button3.setFont(new Font("Arial", 1, 20));
    button3.setForeground(Color.YELLOW);
    button3.setBackground(Color.black);
    button3.setBounds(335, 353, 230, 30);
    button3.addActionListener(this);
    add(button3);


 }
 
 public void actionPerformed(ActionEvent e) {
       try {
          if (e.getSource() == button3) {
             SnakeGame s = new SnakeGame();
             setVisible(false);
          }
       } catch (Exception E) {
          E.printStackTrace();
       }

    }
    public static void main(String[] args) {
    new Login();
 }   
}
