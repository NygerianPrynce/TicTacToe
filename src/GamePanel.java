import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.lang.Math;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.lang.Thread;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    public GameState game;
    public Boolean clickable = false;
    private BufferedImage board, x, o, bg, bg2;
    public int state;
    JTextField textField;
    JButton Computer, Person, one, two, three, four, five, six, seven, eight, nine, again;
    String textFieldData;
    BufferedImage[] imgs;
    public int[] markerXPosition = {352,610,852};
    public int[] markerYPosition = {66,303,525};
    public GamePanel(){
        setLayout(null);
        state = 0;
        try{
            board = ImageIO.read(GamePanel.class.getResource("/images/board.png"));
            x = ImageIO.read(GamePanel.class.getResource("/images/X.png"));
            o = ImageIO.read(GamePanel.class.getResource("/images/O.png"));
            bg = ImageIO.read(GamePanel.class.getResource("/images/bg.png"));
            bg2 = ImageIO.read(GamePanel.class.getResource("/images/bg2.png"));


        } catch(Exception E){
            System.out.println("Exception error");
            return;  
        }

        imgs = new BufferedImage[2];
        imgs[0] = o;
        imgs[1] = x;

        Computer = new JButton("Computer");
        Person = new JButton("Player");
        one = new JButton("");
        two = new JButton("");
        three = new JButton("");
        four = new JButton("");
        five = new JButton("");
        six = new JButton("");
        seven = new JButton("");
        eight = new JButton("");
        nine = new JButton("");
        again = new JButton("Play Again");

        add(Computer);
        add(Person);
        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);
        add(again);

        Computer.setBounds(570, 700, 140, 40);
        Person.setBounds(720, 700, 140, 40);
        
        one.setBounds(352, 66, 253, 234);two.setBounds(610, 66, 238, 234);three.setBounds(852, 66, 253, 234);
        four.setBounds(352, 303, 253, 218); five.setBounds(610, 303, 238, 218); six.setBounds(852, 303, 253, 218);
        seven.setBounds(352, 525, 253, 234); eight.setBounds(610, 525, 238, 234); nine.setBounds(852, 525, 253, 234);
        
        again.setBounds(670, 10, 100, 50); again.setVisible(false);

        one.setBorder(BorderFactory.createEmptyBorder()); one.setContentAreaFilled(false);
        two.setBorder(BorderFactory.createEmptyBorder()); two.setContentAreaFilled(false);
        three.setBorder(BorderFactory.createEmptyBorder()); three.setContentAreaFilled(false);
        four.setBorder(BorderFactory.createEmptyBorder()); four.setContentAreaFilled(false);
        five.setBorder(BorderFactory.createEmptyBorder()); five.setContentAreaFilled(false);
        six.setBorder(BorderFactory.createEmptyBorder()); six.setContentAreaFilled(false);
        seven.setBorder(BorderFactory.createEmptyBorder()); seven.setContentAreaFilled(false);
        eight.setBorder(BorderFactory.createEmptyBorder()); eight.setContentAreaFilled(false);
        nine.setBorder(BorderFactory.createEmptyBorder()); nine.setContentAreaFilled(false);



        Computer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game = new GameState(0);
                state = 1;
                Computer.setVisible(false);
                Person.setVisible(false);
                repaint();
                clickable = true;
            }
        });
        Person.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game = new GameState(1);
                state = 1;
                Computer.setVisible(false);
                Person.setVisible(false);
                repaint();
                clickable = true;
            }
        });
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickable){
                    game.markSpot(game.getCurrentPlayer(), 0, 0);
                    repaint();
                    if(game.getMakeup() == 0 && !game.GameOver()){
                        game.chooseRandomSpot(game.getCurrentPlayer());
                        repaint();
                    }
                }
            }
        });
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickable){
                game.markSpot(game.getCurrentPlayer(), 1, 0);
                repaint();
                if(game.getMakeup() == 0 && !game.GameOver()){
                    game.chooseRandomSpot(game.getCurrentPlayer());
                    repaint();
                }
                }
            }
        });
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickable){
                game.markSpot(game.getCurrentPlayer(), 2, 0);
                repaint();
                if(game.getMakeup() == 0 && !game.GameOver()){
                    game.chooseRandomSpot(game.getCurrentPlayer());
                    repaint();
                }
                }
            }
        });
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickable){
                game.markSpot(game.getCurrentPlayer(), 0, 1);
                repaint();
                if(game.getMakeup() == 0 && !game.GameOver()){
                    game.chooseRandomSpot(game.getCurrentPlayer());
                    repaint();
                }
                }
            }
        });
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickable){
                game.markSpot(game.getCurrentPlayer(), 1, 1);
                repaint();
                if(game.getMakeup() == 0 && !game.GameOver()){
                    game.chooseRandomSpot(game.getCurrentPlayer());
                    repaint();
                }
                }
            }
        });
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickable){
                game.markSpot(game.getCurrentPlayer(), 2, 1);
                repaint();
                if(game.getMakeup() == 0 && !game.GameOver()){
                    game.chooseRandomSpot(game.getCurrentPlayer());
                    repaint();
                }
                }
            }
        });
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickable){
                game.markSpot(game.getCurrentPlayer(), 0, 2);
                repaint();
                if(game.getMakeup() == 0 && !game.GameOver()){
                    game.chooseRandomSpot(game.getCurrentPlayer());
                    repaint();
                }
                }
            }
        });
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickable){
                game.markSpot(game.getCurrentPlayer(), 1, 2);
                repaint();
                if(game.getMakeup() == 0 && !game.GameOver()){
                    game.chooseRandomSpot(game.getCurrentPlayer());
                    repaint();
                }
                }
            }
        });
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickable){
                game.markSpot(game.getCurrentPlayer(), 2, 2);
                repaint();
                if(game.getMakeup() == 0 && !game.GameOver()){
                    game.chooseRandomSpot(game.getCurrentPlayer());
                    repaint();
                }
                }
            }
        });

        again.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game = new GameState(0);
                state = 1;
                repaint();
                clickable = true;
                again.setVisible(false);
            }
        });
    }
    
    //write the paint method
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }


    public void draw(Graphics g){
        if(state == 0){
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
        }
        if(state == 1){
            g.drawImage(bg2, 0, 0, getWidth(), getHeight(), null);
            g.drawImage(board, 330, 27, 800, 800, null);
            if(game.getSpotsToDraw().size()>0){
                for(int i = 0; i < game.getSpotsToDraw().size(); i++){
                    ArrayList<Integer[]> z = game.getSpotsToDraw();
                    int img = z.get(i)[0];
                    int x = z.get(i)[1];
                    int y = z.get(i)[2];
                    g.drawImage(imgs[img], markerXPosition[x], markerYPosition[y], 215, 215, null);
                }
            }
            if(game.GameOver()){
                clickable = false;
                again.setVisible(true);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 80)); 
                if(game.getWinner() == 0){
                    g.drawImage(o, 1150, 200, 235, 235, null);
                    g.setColor(Color.GREEN);
                    g.drawString("Winner!", 1150, 500);
                    g.drawImage(x, 50, 200, 235, 235, null);
                    g.setColor(Color.RED);
                    g.drawString("Loser!", 80, 500);
                }
                else if(game.getWinner() == 1){
                    g.drawImage(o, 1150, 200, 235, 235, null);
                    g.setColor(Color.RED);
                    g.drawString("Loser!", 1150, 500);
                    g.drawImage(x, 50, 200, 235, 235, null);
                    g.setColor(Color.GREEN);
                    g.drawString("Winner!", 80, 500);

                }
                else{
                    g.drawImage(o, 1150, 200, 235, 235, null);
                    g.setColor(Color.YELLOW);
                    g.drawString("Tie!", 1150, 500);
                    g.drawImage(x, 50, 200, 235, 235, null);
                    g.setColor(Color.YELLOW);
                    g.drawString("Tie!", 80, 500); 
                }

            }
            
        }
    }
    
}
