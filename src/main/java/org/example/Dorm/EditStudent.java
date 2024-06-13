package org.example.Dorm;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import org.example.KetNoi.KetNoi;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditStudent extends JFrame {

    private JPanel contentPane;
    private JTable tbl;
    KetNoi conn = new KetNoi();
    DefaultTableModel table = new DefaultTableModel();
    JScrollPane sc ;
    Connection cn = conn.getConnection();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditStudent frame = new EditStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public EditStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 400);
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
        sc = new JScrollPane(tbl);
        contentPane.add(sc, BorderLayout.CENTER);
        JPanel pnEdit = new JPanel();
        pnEdit.setLayout(new FlowLayout());
        JButton btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Vector data = table.getDataVector();
                Vector row = (Vector) data.elementAt(tbl.getSelectedRow());
                new Edit(row.elementAt(0).toString(), row.elementAt(1).toString(),row.elementAt(2).toString(),row.elementAt(3).toString(),row.elementAt(4).toString(),row.elementAt(5).toString(),EditStudent.this);
                dispose();
            }
        });
        pnEdit.add(btnEdit);
        contentPane.add(pnEdit, BorderLayout.SOUTH);
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

