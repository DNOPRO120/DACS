package org.example.Dorm;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.example.KetNoi.KetNoi;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SearchStudent extends JFrame {

    private JPanel contentPane;
    private JTextField tfID;
    private JTable tbl;
    KetNoi conn = new KetNoi();
    Connection cn = conn.getConnection();
    View view = new View();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchStudent frame = new SearchStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public SearchStudent() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                view.back();
            }
        });
        setBounds(100, 100, 550, 500);
        setLocationRelativeTo(null);
        setSize(550,500);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("SEARCH INFORMATION");
        lblNewLabel.setBounds(80, 10, 370, 40);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblNewLabel);

        tfID = new JTextField();
        tfID.setBounds(40, 80, 450, 20);
        contentPane.add(tfID);
        tfID.setColumns(10);

        JLabel lblNoti = new JLabel("Enter the ID's student that you want to find");
        lblNoti.setBounds(130, 60, 250, 15);
        contentPane.add(lblNoti);

        JButton btnEnter = new JButton("ENTER");

        btnEnter.setBounds(200, 130, 110, 40);
        contentPane.add(btnEnter);



        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String id = tfID.getText();
                DefaultTableModel table = new DefaultTableModel();
                JTable tbl = new JTable(table);
                table.addColumn("ID");
                table.addColumn("NAME");
                table.addColumn("SEX");
                table.addColumn("DATE OF BIRTH");
                table.addColumn("PHONE");
                table.addColumn("ROOM");
                JScrollPane sc = new JScrollPane(tbl);
                contentPane.add(sc);
                sc.setBounds(10, 181, 514, 269);
                ResultSet rs;
                try {
                    rs= cn.createStatement().executeQuery("select * from sinhvien where sid='"+id+"'");
                    while(rs.next())
                    {
                        table.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("hi");
                    //System.out.println(e.getMessage());
                }
            }
        });
    }
}
