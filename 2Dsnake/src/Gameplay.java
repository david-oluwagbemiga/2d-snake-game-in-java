import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements KeyListener, ActionListener {
    
    
    private int[] snakexlenght = new int[750];
    private int[] snakeylenght = new int[750];
    
    
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    
    
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon rightmouth;
    private ImageIcon downmouth;
    
 
    private int lenghtofsnake = 3;
    
    private Timer timer;
    private int delay = 100;
    
    private ImageIcon snakeimage;
    
    private int [] enemyxpos = {
        25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375,
        400, 425, 450, 475, 500, 525, 550, 575, 600, 625 , 650, 675, 700, 725, 750,
        775, 800, 825, 850};
    private int [] enemyypos = {
        75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375,
        400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
    
    private ImageIcon enemyimage;
    
    private Random random = new Random();
    
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);
    
    private int score = 0;
    
    private int moves = 0;
    
    private ImageIcon titileimage;
    public Gameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }
 
    public void paint(Graphics g){
        
        if(moves == 0){
            snakexlenght[2]= 50;
            snakexlenght[1]=75;
            snakexlenght[0]=100;
            
            snakeylenght[2]=100;
            snakeylenght[1]=100;
            snakeylenght[0]=100;
        }
        
        
        //draw game border here
        g.setColor(Color.WHITE);
        g.drawRect(24,10,851,55);
        
        //draw titile image
        titileimage =  new ImageIcon("snaketitle.jpg");
        titileimage.paintIcon(this, g, 25, 11); 
        
        //draw border for gameplay
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        
        
        //draw background for the gameplay
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
        
        //draw the scores
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Scores: " + score, 780, 30);
        
        
        //draw lenght
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Lenght: " + lenghtofsnake, 780, 50);
        
        
        
        rightmouth  = new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this, g, snakexlenght[0], snakeylenght[0]);
        
        
        for(int a = 0; a < lenghtofsnake; a++){
            
            
            if(a == 0 && right){
                 rightmouth  = new ImageIcon("rightmouth.png");
                 rightmouth.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
        
            }
            if(a == 0 && left){
                leftmouth  = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
        
            }
            if(a == 0 && down){
                 downmouth  = new ImageIcon("downmouth.png");
                 downmouth.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
        
            }
            if(a == 0 && up){
                 upmouth  = new ImageIcon("upmouth.png");
                 upmouth.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
        
            }
            if(a!=0){
                snakeimage  = new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
        
            }
        }
        
        enemyimage = new ImageIcon("enemy.png");
        
        if(enemyxpos[xpos] ==  snakexlenght[0] && enemyypos[ypos] ==  snakeylenght[0]){
            
            score = +10;
            lenghtofsnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }
        
        enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
        
        
        
        for(int b =1; b< lenghtofsnake; b++){
            if(snakexlenght[b] == snakexlenght[0] && snakeylenght[b] == snakeylenght[0]){
                right = false;
                left = false;
                up = false;
                down = false;
                
                g.setColor(Color.WHITE);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("GAME OVER " , 300, 300    );
                
                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("press space to RESTART" , 350, 340);
               /* g.setColor(Color.blue);
                /g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("please donate to david oluwagbemiga" , 280, 380);
                
                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("if you're impressed" , 350, 400);*/
            }
        }
        g.dispose();
        
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(right){
            for(int r = lenghtofsnake-1; r>=0; r--){
                snakeylenght[r+1] = snakeylenght[r];
            }
            for(int r = lenghtofsnake; r>=0; r--){
                if(r == 0){
                     snakexlenght[r] = snakexlenght[r] + 25;
                }else{
                     snakexlenght[r] = snakexlenght[r - 1];
                }
               if(snakexlenght[r] > 850){
                   snakexlenght[r] = 25;
               }
            }
                repaint();
        }
         if(left){
            for(int r = lenghtofsnake-1; r>=0; r--){
                snakeylenght[r+1] = snakeylenght[r];
            }
            for(int r = lenghtofsnake; r>=0; r--){
                if(r == 0){
                     snakexlenght[r] = snakexlenght[r] - 25;
                }else{
                     snakexlenght[r] = snakexlenght[r - 1];
                }
               if(snakexlenght[r] < 25){
                   snakexlenght[r] = 850;
               }
            }
                repaint();
        }
          if(up){
            for(int r = lenghtofsnake-1; r>=0; r--){
                snakexlenght[r+1] = snakexlenght[r];
            }
            for(int r = lenghtofsnake; r>=0; r--){
                if(r == 0){
                     snakeylenght[r] = snakeylenght[r] - 25;
                }else{
                     snakeylenght[r] = snakeylenght[r- 1];
                }
               if(snakeylenght[r] < 75){
                   snakeylenght[r] = 625;
               }
            }
                repaint();
        }
           if(down){
            for(int r = lenghtofsnake-1; r>=0; r--){
                snakexlenght[r+1] = snakexlenght[r];
            }
            for(int r = lenghtofsnake; r>=0; r--){
                if(r == 0){
                     snakeylenght[r] = snakeylenght[r] + 25;
                }else{
                     snakeylenght[r] = snakeylenght[r- 1];
                }
               if(snakeylenght[r] > 625){
                   snakeylenght[r] = 75;
               }
            }
                repaint();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() ==KeyEvent.VK_SPACE){
            moves = 0;
            score = 0;
            lenghtofsnake = 3;
            repaint();
        }
        
        
        
        if(e.getKeyCode() ==KeyEvent.VK_RIGHT){
        moves++;
        right = true;
        if(!left){
            right =  true;
         }else{
            right = false;
            left = true;
        }
        up = false;
        down = false;
    }
       
        if(e.getKeyCode() ==KeyEvent.VK_LEFT){
        moves++;
        left = true;
        if(!right){
            left =  true;
         }else{
            left = false;
            right = true;
        }
        up = false;
        down = false;
    }
        
        if(e.getKeyCode() ==KeyEvent.VK_UP){
        moves++;
        up = true;
        if(!down){
            up =  true;
         }else{
            up = false;
            down = true;
        }
        right = false;
        left = false;
    }
        
        if(e.getKeyCode() ==KeyEvent.VK_DOWN){
        moves++;
        down = true;
        if(!up){
            down =  true;
         }else{
            down = false;
            up = true;
        }
        right = false;
        left = false;
    }
        
        //for the wsad keys
        if(e.getKeyCode() ==KeyEvent.VK_D){
        moves++;
        right = true;
        if(!left){
            right =  true;
         }else{
            right = false;
            left = true;
        }
        up = false;
        down = false;
    }
       
        if(e.getKeyCode() ==KeyEvent.VK_A){
        moves++;
        left = true;
        if(!right){
            left =  true;
         }else{
            left = false;
            right = true;
        }
        up = false;
        down = false;
    }
        
        if(e.getKeyCode() ==KeyEvent.VK_W){
        moves++;
        up = true;
        if(!down){
            up =  true;
         }else{
            up = false;
            down = true;
        }
        right = false;
        left = false;
    }
        
        if(e.getKeyCode() ==KeyEvent.VK_S){
        moves++;
        down = true;
        if(!up){
            down =  true;
         }else{
            down = false;
            up = true;
        }
        right = false;
        left = false;
    }
        
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
   
    }

    
}

