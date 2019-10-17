import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Timer;

public class Pong extends JPanel implements KeyListener,Action{

    private boolean game = false;
    private Timer timer;
    private int delay = 5;
    private int p1PosiY = 260;
    private int p2PosiY = 260;
    private int bpx = 345;
    private int bpy = 280;
    private int bdirX /*= 1*/;
    private int bdirY /*= 1*/;
    private int score1 = 0;
    private int score2 = 0;
    private ArrayList<Integer> directionX;
    private ArrayList<Integer> directionY;


    public Pong(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        directionX = new ArrayList<>();
        for(int i = -1;i<2;i++){
            if(i!=0){
                directionX.add(i);
            }
        }
        directionY = new ArrayList<>();
        for(int i = -1;i<2;i++){
            if(i!=0){
                directionY.add(i);
            }
        }
        random();
        timer = new Timer(delay,this);
        timer.start();
    }

    public void paint(Graphics g){
        // background
        g.setColor((Color.black));
        g.fillRect(1,1,700,600);

        //player 1
        g.setColor(Color.white);
        g.fillRect(10,p1PosiY,10,50);

        //player 2
        g.setColor(Color.white);
        g.fillRect(680,p2PosiY,10,50);

        //ball
        g.setColor(Color.white);
        g.fillOval(bpx/*20*/,bpy/*270*/,20,20);

        //separation
        g.setColor((Color.white));
        for(int i=10;i<600;i+=30){
            g.fillRect(350,i,8,15);
        }
        //score player 1
        g.setColor(Color.white);
        g.setFont(new Font("roboto",Font.BOLD,60));
        g.drawString(""+score1,150,100);
        // score player 2
        g.setColor(Color.white);
        g.setFont(new Font("roboto",Font.BOLD,60));
        g.drawString(""+score2,500,100);

        if(bpx<=0){
            random();
            score2++;
            bpx = 345;
            bpy = 280;
            game = false;
            delay--;
        }
        if(bpx>=700){
            random();
            score1++;
            bpx = 345;
            bpy = 280;
            game = false;
            delay--;
        }
        // game over
        if(score1==10){
            g.setColor(Color.WHITE);
            g.setFont(new Font("roboto",Font.BOLD,35));
            g.drawString("Player 1 WON",40,500);
            game = false;

        }
        if(score2==10){
            g.setColor(Color.WHITE);
            g.setFont(new Font("roboto",Font.BOLD,35));
            g.drawString("Player 2 WON",380,500);
            game = false;

        }


        g.dispose();
    }

    public void moveUp1(){
        game=true;
        p1PosiY -= 15;
    }

    public void moveDown1(){
        game=true;
        p1PosiY += 15;
    }

    public void moveUp2(){
        game=true;
        p2PosiY -= 15;
    }

    public void moveDown2(){
        game=true;
        p2PosiY += 15;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        timer.start();
        if(game){
            if(new Rectangle(bpx,bpy,20,20).intersects(10,p1PosiY,10,50) || new Rectangle(bpx,bpy,20,20).intersects(680,p2PosiY,10,50)){
                bdirX = -bdirX;
            }
            bpx += bdirX;
            bpy += bdirY;

            if(bpy > 560){
                bdirY = -bdirY;
            }
            if(bpy < 0){
                bdirY = - bdirY;
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == keyEvent.VK_UP){
            if(p1PosiY<=10){
                p1PosiY = 10;
            }
            moveUp1();
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_DOWN){
            if(p1PosiY >= 500){
                p1PosiY = 500;
            }
            moveDown1();
        }

        if(keyEvent.getKeyCode() == keyEvent.VK_Z){
            if(p2PosiY<=10){
                p2PosiY = 10;
            }
            moveUp2();
        }
        if(keyEvent.getKeyCode() == keyEvent.VK_S){
            if(p2PosiY >= 500){
                p2PosiY = 500;
            }
            moveDown2();
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
            game = !game;
            if(score1 == 10 || score2 == 10){
                reset();
            }
        }
    }

    public void random(){
        Collections.shuffle(directionX);
        Collections.shuffle(directionY);
        bdirX = directionX.get(0);
        bdirY = directionY.get(0);
    }

    public void reset(){
        score1 = 0;
        score2 = 0;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public Object getValue(String s) {
        return null;
    }

    @Override
    public void putValue(String s, Object o) {

    }
}
