/**
 * Created by Windows on 16/06/2017.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sprites extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        JFrame frm1 = new JFrame();
        frm1.setSize(400,400);
        frm1.setLocationRelativeTo(null);
        frm1.setResizable(false);
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Painel1 pn1 = new Painel1();
        frm1.getContentPane().add(pn1);
        frm1.setVisible(true);
    }

}

class Painel1 extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage img;
    Timer timer;
    int i;
    Image subSprite;
    int[][] spriteSheetCoordsTurnLeft = { { 0, 0, 16, 16 }, { 32, 16, 16, 16 }, { 16, 16, 16, 16 }, { 0, 16, 16, 16 }};
    int[][] spriteSheetCoordsWalkLeft = { { 16, 16, 16, 16 }, { 0, 16, 16, 16 }, { 16, 16, 16, 16 }, { 0, 16, 16, 16 }};

    public Painel1() {
        setBackground(Color.black);
        try
        {
            img = ImageIO.read(new File("D:/Document/test projects/Sprites/Rockford.png"));
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    subSprite = img.getSubimage(spriteSheetCoordsTurnLeft[i][0], spriteSheetCoordsTurnLeft[i][1], spriteSheetCoordsTurnLeft[i][2],
                            spriteSheetCoordsTurnLeft[i][3]);
                    i++;
                    if (i == spriteSheetCoordsTurnLeft.length) {
                        i = 0;
                    }
                    
                    
                    repaint();
                    revalidate();
                }
            }, 500, 500);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(subSprite, 0, 0, 32, 32, null);
      
    }
}

