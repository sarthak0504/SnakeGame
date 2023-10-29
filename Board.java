import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {
    private final int DISPLAY_SIZE = 600;
    private Image apple;
    private Image dot;
    private Image head;
    private int dots;
    private final int ALL_DOTS = 900;
    private final int DOT_SIZE = 10;
    private final int RANDOM_POSITION = 29;
    private  int apple_x;
    private int apple_y;
    private final int x[] = new int[ALL_DOTS];  // for position of images in x direction
    private final int y[] = new int[ALL_DOTS];  // for position of images in y direction

    // for movement of snack
    private Timer timer;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;  // to stay in the game before game over
    JButton button1;



    Board() {
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setPreferredSize( new Dimension(DISPLAY_SIZE,DISPLAY_SIZE));
        setFocusable(true);    // without clicking on frame to appear on frame
        loadImages();
        initGame();
    }

    public void loadImages() {
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons\\apple.png"));
        apple = img1.getImage(); // getting image and store into apple variable;
        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("icons\\dot.png"));
        dot = img2.getImage();
        ImageIcon img3 = new ImageIcon(ClassLoader.getSystemResource("icons\\head.png"));
        head = img3.getImage();
    }

    public void initGame() {
        dots = 3;    // initial size of snack
        for (int i = 0; i < dots; i++) {
            y[i] = 50;
            x[i] = 50 - (i * DOT_SIZE);
        }

        // invocation of location of apple
        locateApple();
        timer = new Timer(140,this);
        timer.start();
    }
    public void locateApple() {
        int randomLocation = (int)(Math.random()*RANDOM_POSITION);
        apple_x = randomLocation*DOT_SIZE;
        randomLocation = (int)(Math.random()*RANDOM_POSITION);
        apple_y = randomLocation*DOT_SIZE;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // To display apple image on frame
        if(inGame) {
            g.drawImage(apple, apple_x, apple_y, this);
            for (int i = 0; i < dots; i++) {
                if (i == 0)
                    g.drawImage(head, x[i], y[i], this);
                else
                    g.drawImage(dot, x[i], y[i], this);
            }

            Toolkit.getDefaultToolkit().sync();
        }
        else {
            SnakeGame.finalScore = (dots-3)*100;
            calScore(g,(String.valueOf(SnakeGame.finalScore)));
            gameOver(g);
            restart();
        }
    }

    public void restart(){

        button1 = new JButton("RESTART");
        button1.setFont(new Font("Arial", 1, 20));
        button1.setForeground(Color.YELLOW);
        button1.setBackground(Color.blue);
        button1.setBounds(192, 390, 230, 30);
        button1.addActionListener(this);
        add(button1);
    }
    public void gameOver(Graphics g){
        String endMessage = "Game Over!!";
        Font font = new Font("SAN_SERIF",Font.BOLD,30);
        FontMetrics  metrices = getFontMetrics(font);
        g.setColor(Color.RED);
        g.setFont(font);
        g.drawString(endMessage,(DISPLAY_SIZE-metrices.stringWidth(endMessage))/2,DISPLAY_SIZE/2);
        Toolkit.getDefaultToolkit().sync();
    }
    public void calScore(Graphics g,String finalScore){
        String endMessage = "Score : "+finalScore;
        Font font = new Font("SAN_SERIF",Font.BOLD,20);
        FontMetrics  metrices = getFontMetrics(font);
        g.setColor(Color.magenta);
        g.setFont(font);
        g.drawString(endMessage,(DISPLAY_SIZE-metrices.stringWidth(endMessage))/2,(DISPLAY_SIZE/2)+30);
        Toolkit.getDefaultToolkit().sync();
    }
    public void move() {
        for(int i=dots;i>0;i--) {
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        if(leftDirection) {
            x[0]-=DOT_SIZE;
        }
        if(rightDirection) {
            x[0]+=DOT_SIZE;
        }
        if(upDirection) {
            y[0]-=DOT_SIZE;
        }
        if(downDirection) {
            y[0]+=DOT_SIZE;
        }
    }
    public void checkApple(){
        if((apple_x == x[0] && apple_y == y[0]))  {
            new Sound();
            dots += 1;
            locateApple();
        }


    }
    public void checkCollision() {
        for(int i = 1; i<dots ; i++){
            if(x[0]==x[i] && y[0]==y[i] && i>=3)
            {
                inGame = false;
                break;
            }
        }
        if(x[0]>=DISPLAY_SIZE)
            inGame = false;
        if(x[0]<0)
            inGame = false;
        if(y[0]>=DISPLAY_SIZE)
            inGame = false;
        if(y[0]<0)
            inGame = false;
        if(!inGame) {
            timer.stop();
        }


    }

    public void actionPerformed(ActionEvent e) {
        if(inGame) {
            checkApple();
            checkCollision();
            move();
        }
        // for refreshing the screen
        repaint();
        if (e.getSource() == button1) {
            new Sound2();
            SnakeGame s = new SnakeGame();
            setVisible(false);
        }
    }
    public class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if(key == KeyEvent.VK_RIGHT && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if(key == KeyEvent.VK_UP && (!downDirection)) {
                upDirection = true;
               leftDirection = false;
               rightDirection = false;
            }
            if(key == KeyEvent.VK_DOWN && (!upDirection)) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
        }

    }

}
