package interfaceWindow;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class FrameWindow {

    private JFrame jFrame;

    public FrameWindow(VSignIn one, VReservation two, VPayment three) {
        jFrame = new JFrame();
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        putPanels(one, two, three);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void putPanels(JPanel one, JPanel two, JPanel three){
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        cardPanel.add(one, "Sign_in");
        cardPanel.add(two, "Reservation");
        cardPanel.add(three, "Payment");

        cardLayout.show(cardPanel, "Sign_in");

        jFrame.getContentPane().add(cardPanel);

        jFrame.pack();
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
