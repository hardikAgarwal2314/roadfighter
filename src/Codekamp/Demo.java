
package Codekamp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Random;


public class Demo  implements KeyListener{
private static int redcarx=60;
    private static Random random = new Random();
    private static int flag=0;
    private static int ycord1=0;
    private static int ycord12=0;
    private static int ycord13=0;
    private static int xcord1;
    private static int xcord2;
    private static int xcord3;
    private static boolean pause=false;
    public static void main(String[] args) {

        Demo d1 = new Demo();


        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        Dimension d = new Dimension(477, 600);
        panel.setPreferredSize(d);
        panel.addKeyListener(new Demo());
        panel.setFocusable(true);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.exit(0);
        }

        panel.requestFocus();
        Graphics g = panel.getGraphics();


        Image truck;
        ycord1=700;
        ycord12=700;
        ycord13=700;
        Image redcar;
        Image greencar;
        Image purplecar;
        Image road;
        Image start;
        AudioClip bgAudio = Applet.newAudioClip(Demo.class.getResource("rse/car.wav"));
        AudioClip caraudoi = Applet.newAudioClip(Demo.class.getResource("rse/car2.wav"));
        try {

            URL Url1 = Demo.class.getResource("rse/redcar.png");
            URL Url2 = Demo.class.getResource("rse/greencar.png");
            URL Url3 = Demo.class.getResource("rse/purplecar.png");
            URL Url4 = Demo.class.getResource("rse/road.png");
            URL Url5 = Demo.class.getResource("rse/start.png");

            URL Url7 = Demo.class.getResource("rse/truck.png");

            redcar = ImageIO.read(Url1);
            greencar = ImageIO.read(Url2);
            purplecar = ImageIO.read(Url3);
            road = ImageIO.read(Url4);
            start = ImageIO.read(Url5);

            truck = ImageIO.read(Url7);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to load images");
            return;
        }

        Rectangle redrect = new Rectangle(63,84);
        Rectangle truckrect = new Rectangle(82, 171);
        Rectangle greenRect = new Rectangle(68, 87);
        Rectangle purpleRect = new Rectangle(63, 91);

int totalscore=0;
        int score = 0;
        int counter = 0;
        while (true) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {

            }counter++;

            score+=5;
            if(counter<=500) {
                Demo.ycord1 = ycord1 - 2;
                Demo.ycord12 = ycord12 + 5;
                Demo.ycord13 = ycord13 + 5;
            }

            if(counter>500&&counter<1000){
                Demo.ycord1 = ycord1 - 2;
                Demo.ycord12 = ycord12 + 4;
                Demo.ycord13 = ycord13 + 4;

            }
            if(counter>=1000&&counter<1500){
                Demo.ycord1 = ycord1 - 2;
                Demo.ycord12 = ycord12 + 6;
                Demo.ycord13 = ycord13 + 6;

            }
            if(counter>=1500&&counter<2000){
                Demo.ycord1 = ycord1 - 2;
                Demo.ycord12 = ycord12 + 8;
                Demo.ycord13 = ycord13 + 8;

            }if(counter>=2000){
                Demo.ycord1 = ycord1 - 2;
                Demo.ycord12 = ycord12 + 12;
                Demo.ycord13 = ycord13 + 12;

            }


            g.drawImage(road, 0, 0, null);

            g.drawImage(redcar, redcarx, 500, null);
            if (counter==1||ycord1 <= 0) {
                ycord1 = 700;
                xcord1 = Demo.getRandomcarcord();
            }
            if (counter==1|| ycord12 >= 600) {
                ycord12 = -100;
                xcord2 = Demo.getRandomcarcord();
            }
            if (counter==1||ycord13 >= 600) {
                ycord13 = -100;
                xcord3 = Demo.getRandomcarcord();
                }
                if(xcord1==xcord3||xcord1==xcord2)
                {
                    flag=1;

                }
                else{
                flag=0;
            }


                       if(flag==0||counter==1) {
              //             g.drawImage(purplecar, Demo.xcord1, Demo.ycord1, null);
                       }
                       g.drawImage(greencar, Demo.xcord2, Demo.ycord13, null);
                        g.drawImage(truck, Demo.xcord3, Demo.ycord12, null);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("score="+score, 300, 100);

            redrect.setLocation(redcarx, 500);
            purpleRect.setLocation(Demo.xcord1, Demo.ycord1);
            greenRect.setLocation(Demo.xcord2, Demo.ycord13);
            truckrect.setLocation(Demo.xcord3, Demo.ycord12);


            //if(redrect.intersects(purpleRect)){
            //totalscore=score-500;

            //}
            if((redcarx<60)||(redcarx>=350)){
                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Game Over"+"...totalscore="+score, 100, 200);
                return;
            }
            if( redrect.intersects(truckrect)){

                g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Game Over"+"...totalscore="+score, 100, 200);
            return;
        }
            if( redrect.intersects(greenRect)){

                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Game Over"+"...totalscore="+totalscore, 100, 200);
                return;
            }
        }

                }




        @Override
        public void keyTyped (KeyEvent e){

        }

        @Override
        public void keyPressed (KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                redcarx += 50;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                redcarx -= 50;
            }
        }


        @Override
        public void keyReleased (KeyEvent e){

        }

    public static int getRandomcarcord() {
            if (Demo.random.nextInt(3) == 0) {
                return 120;
            }
            if (Demo.random.nextInt(3) == 1) {
                return 200;
            }
            else
                return 300;
            }
        }
