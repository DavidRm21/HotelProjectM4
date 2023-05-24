package interfaceWindow;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
        jFrame.add(one);
//        jFrame.add(two);
//        jFrame.add(three);

        jFrame.getContentPane().add(one);
//        jFrame.getContentPane().add(two);
//        jFrame.getContentPane().add(three);

        jFrame.pack();
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
