import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class maintenance {
    private JPanel maintenance;
    private JButton PAID;
    private JButton NOTPAID;
    private JTable DISPLAY;
    private JButton EXITButton;

    DbFunctions db = new DbFunctions();
    Connection conn = db.connect_to_db("maintenance","postgres","Peacebro@02");
    public maintenance() {
        PAID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = db.read(conn,"yes");
                DISPLAY.setModel(DbUtils.resultSetToTableModel(rs));
            }
        });
        NOTPAID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = db.read(conn,"no");
                DISPLAY.setModel(DbUtils.resultSetToTableModel(rs));

            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
    static JFrame frame = new JFrame("maintenance");
    public static void init()
    {

        frame.setContentPane(new maintenance().maintenance);
        frame.pack();
        frame.setVisible(true);
    }


}



