package vistas;

import com.toedter.calendar.JDateChooser;
import interfaceWindow.AbstractPanel;
import model.Room;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
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

    public VReservation(int text, int button, int font, int textInput ) {
        super(text, button, textInput, "assets/HotelReceptionResize.jpg");
        this.font = new Font[font];
        this.calendar = new JDateChooser[2];

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
        drawLabel(3, font[2], "Servicios", 772, 533, 200, 33, Color.WHITE, JLabel.LEFT);
        drawLabel(4, font[3], "Cerrar Sesión", 20, 650, 200, 40, Color.WHITE, JLabel.CENTER);

        drawLabel(5, font[2], "Finalizar", 1000, 650, 200, 40, Color.WHITE, JLabel.CENTER);
        getButtonEnd().setBackground(new Color(21, 19, 111));
        getButtonEnd().setOpaque(true);
        drawLabel(6, font[2], "", 990, 36, 200, 50, Color.GRAY, JLabel.CENTER);
        getText()[6].setBackground(new Color(0,0,0,0));
        getText()[6].setForeground(Color.black);
        getText()[6].setOpaque(true);

        tablaPanel = new JPanel(new BorderLayout());
        tablaPanel.setBounds(88, 120, 1100, 368);
        tablaPanel.setBackground(new Color(0, 0, 0));
        tablaPanel.setBorder(null);
        tablaPanel.setOpaque(true);
        this.add(tablaPanel);

        drawDateTime(0, 250, 533, 150, 30, font[3]);
        drawDateTime(1, 250, 585, 150, 30, font[3]);

        int hour = LocalTime.now().getHour();
        int minute = LocalTime.now().getMinute();
        drawInputText(0, font[3], hour + " : " + minute, 430, 533, 150, 30);
        drawInputText(1, font[3], hour + " : " + minute, 430, 585, 150, 30);
    }

    public ArrayList<Room> drawModel(ArrayList<Room> rooms){
        roomList = rooms;
        String[] columnNames = {"Número", "Tipo", "Capacidad", "Precio", "Estado"};

        model = new DefaultTableModel();
        for(String column : columnNames){
            model.addColumn(column);
        }

        for(Room room : roomList){
            model.addRow(new Object[] {room.getId(), room.getType(), room.getCapacity(), room.getPrice(), room.isState()});
        }

        drawTable(model);
        return rooms;
    }

    public void drawTable(DefaultTableModel model){

        model.isCellEditable(11, 4);
        table = new JTable(model);
        table.setBorder(null);
        table.setRowHeight(27);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.setFont(new Font("Arima Madurai", Font.PLAIN, 18));
        table.isCellEditable(12, 4);

        table.setShowGrid(true);

        JTableHeader headerColumn = table.getTableHeader();
        headerColumn.setPreferredSize(new Dimension(headerColumn.getWidth(), 40));
        headerColumn.setBackground(new Color(0,0,0));
        headerColumn.setFont(new Font("Arima Madurai", Font.BOLD, 26));
        headerColumn.setForeground(Color.WHITE);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBorder(BorderFactory.createEmptyBorder());
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        cellRenderer.setOpaque(true);
        cellRenderer.setBackground(new Color(0, 0, 0));
        cellRenderer.setForeground(Color.WHITE);

        for (int i = 0; i < 5; i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        tablaPanel.add(new JScrollPane(table), BorderLayout.CENTER);
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
    public JDateChooser getEndDate() {
        return calendar[1];
    }
}
