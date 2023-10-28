import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
   JLabel label1,label2,label3;
   JTextField textField2;
   JPasswordField passwordField3;
   JButton button1 , button2 , button3;


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
//    button3.addActionListener(this);
    add(button3);


 }
 
 public void actionPerformed(ActionEvent e) {
       try {
          if (e.getSource() == button1) {
             // Connn c = new Connn();
             // String cardno = this.textField2.getText();
             // String pin = this.passwordField3.getText();
             // String q = "select * from login where card_number = '" + cardno + "' and  pin = '" + pin + "'";
             // ResultSet resultSet = c.statement.executeQuery(q);
             // if (resultSet.next()) {
             //    this.setVisible(false);
             //    new main_Class(pin);
             // } else {
             //    JOptionPane.showMessageDialog((Component)null, "Incorrect Card Number or PIN");
             // }
          } else if (e.getSource() == button2) {
             this.textField2.setText("");
             this.passwordField3.setText("");
          } else if (e.getSource() == button3) {
             // new Signup();
             // this.setVisible(false);
          }
       } catch (Exception var7) {
          var7.printStackTrace();
       }

    }
    public static void main(String[] args) {
    new Login();
 }   
}
