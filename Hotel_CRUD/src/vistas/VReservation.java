package vistas;

import com.toedter.calendar.JDateChooser;
import inputMouse.MouseInputs;
import interfaceWindow.AbstractPanel;
import model.Room;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Font;
import java.awt.Color;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class VReservation extends AbstractPanel {

    private DefaultTableModel model;
    private JTable table;
    private Font[] font;
    private JPanel tablaPanel;
    private ArrayList<Room> roomList;
    private JDateChooser[] calendar;
    private JCheckBox[] checkBox;


    public VReservation(int text, int button, int font, int textInput ) {
        super(text, button, textInput, "assets/HotelReceptionResize.jpg");
        this.font = new Font[font];
        this.calendar = new JDateChooser[2];
        this.checkBox = new JCheckBox[6];

        drawComponents();

    }

    public void drawComponents(){
        font[0] =new Font("Arima Madurai", Font.BOLD, 96);
        font[1] =new Font("Arima Madurai", Font.BOLD, 48);
        font[2] =new Font("Arima Madurai", Font.BOLD, 24);
        font[3] =new Font("Arima Madurai", Font.BOLD, 18);

        tablaPanel = new JPanel(new BorderLayout());
        tablaPanel.setBounds(88, 120, 1100, 368);
        tablaPanel.setBackground(new Color(0, 0, 0, 180));
        tablaPanel.setBorder(null);
        tablaPanel.setOpaque(true);
        this.add(tablaPanel);

        drawLabel(0, font[2], "Bienvenido, USUARIO", 30, 36, 365, 42, Color.WHITE, JLabel.LEFT);
        drawLabel(1, font[2], "Inicio", 156, 533, 200, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(2, font[2], "Final", 156, 585, 200, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(3, font[2], "Servicios", 772, 530, 200, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(4, font[3], "         ", 20, 650, 200, 40, Color.WHITE, JLabel.CENTER);

        drawLabel(5, font[2], "Finalizar", 1000, 650, 200, 40, Color.WHITE, JLabel.CENTER);
        getButtonEnd().setBackground(new Color(19, 31, 54));
        getButtonEnd().setOpaque(true);
        drawLabel(6, font[2], "", 1140, 130, 20, 20, Color.GRAY, JLabel.CENTER);
        getText()[6].setBackground(new Color(0,0,0,0));
        getText()[6].setForeground(Color.black);
        getText()[6].setOpaque(true);

        drawCheckBox(0, 900, 530, font[3], "Desayuno");
        drawCheckBox(1, 900, 555, font[3], "Cena");
        drawCheckBox(2, 900, 580, font[3], "Club");
        drawCheckBox(3, 1050, 530, font[3], "Traslado");
        drawCheckBox(4, 1050, 555, font[3], "Spa");
        drawCheckBox(5, 1050, 580, font[3], "Sauna");

        drawDateTime(0, 250, 533, 150, 30, font[3]);
        drawDateTime(1, 250, 585, 150, 30, font[3]);

        int hour = LocalTime.now().getHour();
        int minute = LocalTime.now().getMinute();
        drawInputText(0, font[3], hour + " : " + minute, 430, 533, 150, 30);
        drawInputText(1, font[3], hour + " : " + minute, 430, 585, 150, 30);
    }

    public void createModel(ArrayList<Room> rooms, MouseInputs inputs){
        roomList = rooms;
        String[] columnNames = {"Número", "Tipo", "Capacidad", "Precio", "Estado"};

        model = new DefaultTableModel();

        for(String column : columnNames){
            model.addColumn(column);
        }

        for(Room room : roomList){
            model.addRow(new Object[] {room.getId(), room.getType(), room.getCapacity(), room.getPrice(), room.isState()});
        }
        drawTable(model, inputs);
    }

    public void drawTable(DefaultTableModel model, MouseInputs inputs){

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBorder(null);
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        cellRenderer.setBackground(new Color(87,69, 45));
        cellRenderer.setForeground(Color.WHITE);

        table = new JTable(model);
        table.setBorder(new EmptyBorder(5,5,5,5));
        table.setRowHeight(27);
        table.setFont(new Font("Arima Madurai", Font.PLAIN, 18));
        table.setBackground(new Color(30,30,30));
        table.setDefaultEditor(Object.class, null);
        table.setDefaultRenderer(Object.class, cellRenderer);
        table.setShowGrid(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(true);

        JTableHeader headerColumn = table.getTableHeader();
        headerColumn.setPreferredSize(new Dimension(headerColumn.getWidth(), 40));
        headerColumn.setBackground(new Color(66,49,27));
        headerColumn.setFont(new Font("Arima Madurai", Font.BOLD, 26));
        headerColumn.setForeground(Color.WHITE);

        tablaPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        table.addMouseListener(inputs);
        getModel().fireTableDataChanged();
        table.repaint();
    }

    public void drawDateTime(int pos, int x, int y, int width, int height, Font font){
        calendar[pos] = new JDateChooser();
        calendar[pos].setBounds(x, y, width, height);
        calendar[pos].setFont(font);
        calendar[pos].setBackground(Color.GRAY);
        calendar[pos].setDate(new Date());
        this.add(calendar[pos]);
    }

    public void drawCheckBox(int pos, int x, int y, Font font, String text){
        checkBox[pos] = new JCheckBox();
        checkBox[pos].setBounds(x, y, 130, 30);
        checkBox[pos].setOpaque(false);
        checkBox[pos].setText(text);
        checkBox[pos].setFont(font);
        checkBox[pos].setForeground(Color.WHITE);
        this.add(checkBox[pos]);
    }

    public JLabel getButtonEnd(){
        return getText()[5];
    }
    public JLabel getLabelWelcome(){
        return getText()[0];
    }
    public JLabel getSignOut(){
        return getText()[4];
    }
    public JLabel isAvailableRoom(){
        return getText()[6];
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JDateChooser getStartDate() {
        return calendar[0];
    }
    public JTextField getStartTime(){
        return getTextInput()[0];
    }
    public JDateChooser getEndDate() {
        return calendar[1];
    }
    public JTextField getEndTime(){
        return getTextInput()[1];
    }
    public JCheckBox getCheckBreak() {
        return checkBox[0];
    }
    public JCheckBox getCheckDinner() {
        return checkBox[1];
    }
    public JCheckBox getCheckClub() {
        return checkBox[2];
    }
    public JCheckBox getCheckRelocation() {
        return checkBox[3];
    }
    public JCheckBox getCheckSpa() {
        return checkBox[4];
    }
    public JCheckBox getCheckSauna() {
        return checkBox[5];
    }

    public JCheckBox[] getCheckBox() {
        return checkBox;
    }
}
