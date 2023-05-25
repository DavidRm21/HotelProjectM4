package interfaceWindow;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class AbstractPanel extends JPanel {

    private BufferedImage image;
    private JLabel[] spanText;
    private JLabel[] button;


    public AbstractPanel(int text, int button, String root) {
        this.spanText = new JLabel[text];
        this.button = new JLabel[button];

        setSizePanel();
        setLayout(null);
        setBackgroundPanel(root);
    }

    public void setSizePanel(){
        Dimension size = new Dimension(1280, 720);
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
    }

    public void setBackgroundPanel(String root){
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

    public void drawLabel(int pos, Font font, String text, int x, int y, int width, int height, Color color, int align){
        spanText[pos] = new JLabel(text);
        spanText[pos].setBounds(x, y, width, height);
        spanText[pos].setForeground(color);
        spanText[pos].setFont(font);
        spanText[pos].setHorizontalAlignment(align);
        this.add(spanText[pos]);
        spanText[pos].setVisible(true);
    }

    public void drawButton(int pos, Font font, String text, int x, int y, int width, int height, Color color, int align){
        button[pos] = new JLabel(text);
        button[pos].setBounds(x, y, width, height);
        button[pos].setBorder(null);
        button[pos].setFont(font);
        button[pos].setHorizontalAlignment(align);
        button[pos].setForeground(Color.WHITE);
        button[pos].setBackground(color);
        button[pos].setOpaque(true);
        button[pos].setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(button[pos]);

        button[pos].setVisible(true);
    }


    public JLabel[] getText() {
        return spanText;
    }

    public JLabel[] getButton() {
        return button;
    }

}
