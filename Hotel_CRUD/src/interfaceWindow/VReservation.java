package interfaceWindow;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VReservation extends JPanel {

    private BufferedImage image;
    private JLabel[] spanText;
    private JTextField[] textInput;
    private JLabel[] button;
    private Font[] font;

    public VReservation() {

        spanText = new JLabel[5];
        button = new JLabel[5];
        textInput = new JTextField[2];
        font = new Font[4];

        this.setSizePanel();
        this.setLayout(null);
        this.setBackgroundPanel("assets/HotelReceptionResize.jpg");

    }

    private void setSizePanel(){
        Dimension size = new Dimension(1280, 720);
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
    }

    private void setBackgroundPanel(String root){
        try{
            image = ImageIO.read(new File(root));
        }catch (IOException e){
            System.out.println("[ERROR] " + e);
        }
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }



}
