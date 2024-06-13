package org.example.Dorm;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import org.example.KetNoi.KetNoi;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class DeleteStudent extends JFrame {
    KetNoi conn = new KetNoi();
    private JPanel contentPane;
    static	DefaultTableModel table;
    static JTable tbl;
    Connection cn = conn.getConnection();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteStudent frame = new DeleteStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public DeleteStudent() {
        table = new DefaultTableModel();
        table.addColumn("ID");
        table.addColumn("NAME");
        table.addColumn("SEX");
        table.addColumn("DATE OF BIRTH");
        table.addColumn("PHONE");
        table.addColumn("ROOM");
        tbl = new JTable(table);
        JScrollPane sc = new JScrollPane(tbl);
        setData();
        sc.setBounds(40, 110, 550, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(sc);
        JLabel lblDel = new JLabel("DELETE INFORMATION");
        lblDel.setBounds(150, 10, 350, 40);
        lblDel.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblDel);

        JButton btnDel = new JButton("DELETE");
        btnDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Delete();
                //Manager m = new Manager();
                //m.setVisible(true);
            }
        });
        btnDel.setBounds(250, 420, 100, 30);
        contentPane.add(btnDel);

        JLabel lblNoti = new JLabel("Select the row that you want to delete");
        lblNoti.setBounds(200, 70, 250, 15);
        contentPane.add(lblNoti);
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
    public void Delete()
    {
        String sql =  "delete from sinhvien where sid = "+"'"+tbl.getValueAt(tbl.getSelectedRow(), 0)+"'";
        try {
            cn.createStatement().execute(sql);
            table.removeRow(tbl.getSelectedRow());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}