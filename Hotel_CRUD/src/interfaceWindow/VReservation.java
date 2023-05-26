package interfaceWindow;

import model.Room;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VReservation extends AbstractPanel {

    private JTextField[] textInput;
    private JTable table;
    private Font[] font;
    private JPanel tablaPanel;

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
        drawLabel(14, font[3], "Cerrar Sesión", 20, 650, 200, 40, Color.WHITE, JLabel.CENTER);

        drawLabel(11, font[2], "Finalizar", 1000, 650, 200, 40, Color.WHITE, JLabel.CENTER);
        getButtonEnd().setBackground(new Color(21, 19, 111));
        getButtonEnd().setOpaque(true);
        drawLabel(12, font[2], "Disponible", 990, 36, 200, 50, Color.GRAY, JLabel.CENTER);

        tablaPanel = new JPanel(new BorderLayout());
        tablaPanel.setBounds(88, 120, 1100, 368);
        tablaPanel.setBackground(new Color(0, 0, 0));
        tablaPanel.setBorder(null);
        tablaPanel.setOpaque(true);
        this.add(tablaPanel);

        drawInputText(0, 250, 533, 300, 30, "AAAA/MM/DD Inicio", font[2]);
        drawInputText(1, 250, 585, 300, 30, "AAAA/MM/DD Final", font[2]);



    }

    public void drawModel(ArrayList<Room> rooms){
        ArrayList<Room> roomList = rooms;
        String[] columnNames = {"Número", "Tipo", "Capacidad", "Precio", "Estado"};

        DefaultTableModel model = new DefaultTableModel();
        for(String column : columnNames){
            model.addColumn(column);
        }

        for(Room room : roomList){
            model.addRow(new Object[] {room.getId(), room.getType(), room.getCapacity(), room.getPrice(), room.isState()});
        }

        drawTable(model);
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
    public JLabel getButtonFinish(){
        return getText()[11];
    }
    public JLabel getSignOut(){
        return getText()[14];
    }





}
