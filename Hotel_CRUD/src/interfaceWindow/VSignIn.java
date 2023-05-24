package interfaceWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VSignIn extends JPanel {

    private BufferedImage image;
    private JPanel[] panel;
    private JLabel[] spanText;
    private JTextField[] textInput;
    private JButton[] button;
    private Font[] font;

    public VSignIn() {

        panel = new JPanel[2];
        spanText = new JLabel[3];
        textInput = new JTextField[2];
        button = new JButton[2];
        font = new Font[4];

        this.setSizePanel();
        this.setLayout(null);
        this.setBackgroundPanel("assets/HotelmenuResize.jpg");
        this.drawComponents();
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

    public void drawComponents(){

        font[0] =new Font("Arima Madurai", Font.BOLD, 96);
        font[1] =new Font("Arima Madurai", Font.BOLD, 48);
        font[2] =new Font("Arima Madurai", Font.BOLD, 24);
        font[3] =new Font("Arima Madurai", Font.BOLD, 18);

        drawLabel(0, font[0], "Hotel Risdamel", 0, 79, 1280, 170, Color.WHITE, JLabel.CENTER);
        drawLabel(1, font[2], "Correo electrónico", 440, 304, 400, 42, Color.WHITE, JLabel.LEFT);
        drawLabel(2, font[2], "Contraseña", 440, 412, 400, 42, Color.WHITE, JLabel.LEFT);

        drawInputText(0, font[2], 440, 346, 400, 50);
        drawInputText(1, font[2], 440, 444, 400, 50);

        drawButton(0, font[2], "Registrar", 440, 550, 147, 48, new Color(28, 151, 18));
        drawButton(1, font[2], "Entrar", 693, 550, 147, 48, new Color(21, 19, 111));
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

    public void drawInputText(int pos, Font font, int x, int y, int width, int height){
        textInput[pos] = new JTextField();
        textInput[pos].setBounds(x, y, width, height);
        textInput[pos].setFont(font);
        textInput[pos].setBorder(new EmptyBorder(0, 20, 0, 0));
        textInput[pos].setBackground(new Color(190, 190, 190));
        textInput[pos].setOpaque(true);
        this.add(textInput[pos]);
        textInput[pos].setVisible(true);
    }

    public void drawButton(int pos, Font font, String text, int x, int y, int width, int height, Color color){
        button[pos] = new JButton(text);
        button[pos].setBounds(x, y, width, height);
        button[pos].setBorder(null);
        button[pos].setFont(font);
        button[pos].setContentAreaFilled(false);
        button[pos].setForeground(Color.WHITE);
        button[pos].setFocusPainted(false);
        button[pos].setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(button[pos]);

        panel[pos] = new JPanel();
        panel[pos].setBounds(x, y, width, height);
        panel[pos].setBorder(null);
        panel[pos].setBackground(color);
        this.add(panel[pos]);
        panel[pos].setVisible(true);
        button[pos].setVisible(true);
    }


}
