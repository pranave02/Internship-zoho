import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class flats {
    private JPanel flats;
    private JTable table1;
    private JTable table2;
    private JButton occupiedButton;
    private JButton vacentButton;
    private JButton exitButton;
    DbFunctions db = new DbFunctions();
    Connection conn = db.connect_to_db("maintenance","postgres","Peacebro@02");
    static JFrame frame_1 = new JFrame("flats");
    public static  void init() {

        frame_1.setContentPane(new flats().flats);
        frame_1.pack();
        frame_1.setVisible(true);
    }

    public flats() {
        occupiedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = db.occupied(conn,2);
                table1.setModel(DbUtils.resultSetToTableModel(rs));
                ResultSet rm = db.occupied(conn,3);
                table2.setModel(DbUtils.resultSetToTableModel(rm));
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_1.dispose();
            }
        });
        vacentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = db.vacent(conn,2);
                table1.setModel(DbUtils.resultSetToTableModel(rs));
                ResultSet rm = db.vacent(conn,3);
                table2.setModel(DbUtils.resultSetToTableModel(rm));
            }
        });
    }
}
