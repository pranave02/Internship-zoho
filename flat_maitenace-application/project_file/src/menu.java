import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {
    private JButton maintenance;
    private JPanel menu;
    private JButton flatStatusButton;
    private JButton enterRecordButton;
    private JButton deleteRecordButton;

    public static void main(String[] args) {
        init();
    }
    static JFrame frame = new JFrame("menu");
    public static void init()
    {
        frame.setContentPane(new menu().menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public menu() {
        maintenance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maintenance m = new maintenance();
                m.init();
            }
        });
        flatStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flats f = new flats();
                f.init();
            }
        });
    }

}
