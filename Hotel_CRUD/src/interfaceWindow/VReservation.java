package interfaceWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VReservation extends AbstractPanel {

    private JTextField[] textInput;
    private JTable table;
    private Font[] font;

    public VReservation(int text, int button, int font, int textInput ) {
        super(text, button, "assets/HotelReceptionResize.jpg");
        this.textInput = new JTextField[textInput];
        this.font = new Font[font];

        drawComponents();
    }

    public void drawComponents(){
        font[0] =new Font("Arima Madurai", Font.BOLD, 96);
        font[1] =new Font("Arima Madurai", Font.BOLD, 48);
        font[2] =new Font("Arima Madurai", Font.BOLD, 24);
        font[3] =new Font("Arima Madurai", Font.BOLD, 18);

        drawLabel(0, font[2], "Bienvenido, USUARIO", 30, 36, 365, 42, Color.WHITE, JLabel.LEFT);
        drawLabel(1, font[2], "Inicio", 156, 533, 200, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(2, font[2], "Final", 156, 585, 200, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(3, font[2], "Personas", 772, 533, 200, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(4, font[2], "Habitación", 772, 585, 200, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(5, font[2], "0", 1050, 533, 20, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(6, font[2], "0", 1050, 585, 20, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(7, font[2], "+", 1100, 533, 20, 40, Color.WHITE, JLabel.CENTER);
        drawLabel(8, font[2], "+", 1100, 585, 20, 40, Color.WHITE, JLabel.CENTER);
        drawLabel(9, font[2], "-", 1000, 585, 20, 40, Color.WHITE, JLabel.CENTER);
        drawLabel(10, font[2], "-", 1000, 533, 20, 40, Color.WHITE, JLabel.CENTER);

        drawLabel(11, font[2], "Finalizar", 1000, 650, 200, 40, Color.WHITE, JLabel.CENTER);
        getButtonEnd().setBackground(new Color(21, 19, 111));
        getButtonEnd().setOpaque(true);
        drawLabel(12, font[2], "Disponible", 990, 36, 200, 50, Color.GRAY, JLabel.CENTER);

        drawLabel(13, font[2], "", 88, 120, 1100, 380, Color.WHITE, JLabel.CENTER);
        getText()[13].setBackground(new Color(0, 0, 0, 180));
        getText()[13].setOpaque(true);

        drawInputText(0, 250, 533, 300, 30, "AAAA/MM/DD Inicio", font[2]);
        drawInputText(1, 250, 585, 300, 30, "AAAA/MM/DD Final", font[2]);

        drawModel();

    }

    public void drawModel(){
        Object[][] data = {{"101", "Doble", "2", "false", "70000", "TV", "4.5"}};
        String[] columnNames = {"Número", "Tipo", "Capacidad", "Estado", "Precio", "Servicios", "Calificación"};
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        drawTable(tableModel);
    }

    public void drawTable(DefaultTableModel model){

        table = new JTable(model);
        table.setBackground(new Color(0, 0, 0,0));
        table.setOpaque(false);
        table.setFont(new Font("Arima Madurai", Font.BOLD, 24));
        getText()[13].add(new JScrollPane(table), BorderLayout.CENTER);
        table.repaint();
    }

    public void drawInputText(int pos, int x, int y, int width, int height, String text, Font font){
        textInput[pos] = new JTextField(text);
        textInput[pos].setBounds(x, y, width, height);
        textInput[pos].setFont(font);
        textInput[pos].setBorder(new EmptyBorder(0, 20, 0, 0));
        textInput[pos].setBackground(new Color(190, 190, 190));
        textInput[pos].setOpaque(true);
        this.add(textInput[pos]);
        textInput[pos].setVisible(true);
    }

    public JLabel getButtonPeopleAdd(){
        return getText()[7];
    }
    public JLabel getButtonPeopleSubtract(){
        return getText()[10];
    }
    public JLabel getButtonRoomAdd(){
        return getText()[8];
    }
    public JLabel getButtonRoomSubtract(){
        return getText()[9];
    }
    public JLabel getButtonEnd(){
        return getText()[11];
    }
    public JTextField getTextStart(){
        return textInput[0];
    }
    public JTextField getTextEnd(){
        return textInput[1];
    }

    public JLabel getLabelWelcome(){
        return getText()[0];
    }





}
