package org.example.Dorm;


import org.example.KetNoi.KetNoi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Edit extends JFrame {

    private JPanel contentPane;
    private JTextField tfID;
    private JTextField tfName;
    private JTextField tfDoB;
    private JTextField tfPhone;
    private JTextField tfRID;
    KetNoi conn = new KetNoi();
    Connection cn = conn.getConnection();


    public Edit(String idt, String namet, String sext,String dobt, String phonet, String ridt, EditStudent a) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(10, 40, 45, 15);
        contentPane.add(lblID);

        tfID = new JTextField();
        tfID.setBounds(90, 40, 110, 20);
        contentPane.add(tfID);
        tfID.setText(idt);
        tfID.setEditable(false);
        tfID.setColumns(10);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 80, 45, 15);
        contentPane.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(90, 80, 110, 20);
        tfName.setText(namet);
        contentPane.add(tfName);
        tfName.setColumns(10);

        JLabel lblSex = new JLabel("Sex");
        lblSex.setBounds(10, 120, 45, 15);
        contentPane.add(lblSex);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(92, 120, 110, 20);
        contentPane.add(comboBox);

        JLabel lblDoB = new JLabel("Dob");
        lblDoB.setBounds(10, 160, 45, 15);
        contentPane.add(lblDoB);

        tfDoB = new JTextField();
        tfDoB.setText(dobt);
        tfDoB.setBounds(90, 160, 110, 20);
        contentPane.add(tfDoB);
        tfDoB.setColumns(10);

        JLabel lblPNumber = new JLabel("Phone number");
        lblPNumber.setBounds(10, 200, 75, 15);
        contentPane.add(lblPNumber);

        tfPhone = new JTextField();
        tfPhone.setBounds(90, 200, 110, 20);
        contentPane.add(tfPhone);
        tfPhone.setText(phonet);
        tfPhone.setColumns(10);

        JLabel lblRID = new JLabel("Room ID");
        lblRID.setBounds(10, 240, 50, 15);
        contentPane.add(lblRID);

        tfRID = new JTextField();
        tfRID.setText(ridt);
        tfRID.setBounds(90, 240, 110, 20);
        contentPane.add(tfRID);
        tfRID.setColumns(10);
        comboBox.addItem("Male");
        comboBox.addItem("Female");
        comboBox.setSelectedItem(sext);

        JButton btnEnter = new JButton("Enter");
        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String id = tfID.getText();
                String name = tfName.getText();
                String sex = comboBox.getSelectedItem().toString();
                String dob = tfDoB.getText();
                String phone = tfPhone.getText();
                String rid = tfRID.getText();
                try {
                    cn.createStatement().executeUpdate("UPDATE `sinhvien` SET `sname` = '"+name+"', `dob` = '"+dob+"',`sex`='"+sex+"', `phonenumber` = '"+phone+"', `rid` = '"+rid+"' WHERE `sinhvien`.`sid` = '"+id+"'");

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                dispose();
                //Manager m = new Manager();
                //m.setVisible(true);


            }
        });
        btnEnter.setBounds(200, 350, 120, 40);
        contentPane.add(btnEnter);
        setVisible(true);
    }
}

