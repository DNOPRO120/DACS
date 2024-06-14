package org.example.Dorm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import org.example.KetNoi.KetNoi;

public class Display extends JFrame {

    private JPanel contentPane;
    private JTable tbl;
    KetNoi conn = new KetNoi();
    DefaultTableModel table = new DefaultTableModel();
    Connection cn = conn.getConnection();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Display frame = new Display();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Display() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                Manager manager = new Manager();
                manager.setVisible(true);
            }
        });
        setBounds(100, 100, 650, 400);
        setSize(650,400);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        table.addColumn("ID");
        table.addColumn("NAME");
        table.addColumn("SEX");
        table.addColumn("DATE OF BIRTH");
        table.addColumn("PHONE");
        table.addColumn("ROOM");

        tbl = new JTable(table);
        setData();
        JScrollPane sc = new JScrollPane(tbl);
        contentPane.add(sc);
        sc.setBounds(40, 110, 550, 300);
    }

    public void setData()
    {
        ResultSet rs;
        try {
            rs= cn.createStatement().executeQuery("select * from sinhvien ");
            while(rs.next())
            {
                table.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
