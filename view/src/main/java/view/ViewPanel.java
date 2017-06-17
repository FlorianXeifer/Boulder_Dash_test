package view;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ViewPanel extends JPanel{

	
	
	private static final long	serialVersionUID	= -998294702363713521L;
	
	BufferedImage img;
    Timer timer;
    int i;
    Image subSprite;
    int[][] spriteSheetCoordsTurnLeft = { { 0, 0, 16, 16 }, { 32, 16, 16, 16 }, { 16, 16, 16, 16 }, { 0, 16, 16, 16 }};
    int[][] spriteSheetCoordsWalkLeft = { { 16, 16, 16, 16 }, { 0, 16, 16, 16 }, { 16, 16, 16, 16 }, { 0, 16, 16, 16 }};

    public ViewPanel() {
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
            }, 350, 350);
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
