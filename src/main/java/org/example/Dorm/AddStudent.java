package org.example.Dorm;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

    private JPanel contentPane;
    private JTextField tfID;
    private JTextField tfName;
    private JTextField tfDoB;
    private JTextField tfPN;
    private JTextField tfR;
    private Statement stm;
    private PreparedStatement ps;
    private ResultSet rs;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddStudent frame = new AddStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public AddStudent() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                Manager manager = new Manager();
                manager.setVisible(true);
            }
        });
        setSize(550,500);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ADD INFORMATION");
        lblNewLabel.setBounds(120, 10, 305, 40);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblNewLabel);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(10, 100, 45, 15);
        contentPane.add(lblID);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 150, 45, 15);
        contentPane.add(lblName);

        JLabel lblSex = new JLabel("Sex");
        lblSex.setBounds(10, 200, 45, 15);
        contentPane.add(lblSex);

        JLabel lblDoB = new JLabel("Date of Birth");
        lblDoB.setBounds(10, 250, 90, 15);
        contentPane.add(lblDoB);

        JLabel lblPN = new JLabel("Phone Number");
        lblPN.setBounds(10, 300, 90, 15);
        contentPane.add(lblPN);

        JLabel lblR = new JLabel("Room");
        lblR.setBounds(10, 350, 45, 15);
        contentPane.add(lblR);

        tfID = new JTextField();
        tfID.setBounds(120, 100, 350, 20);
        contentPane.add(tfID);
        tfID.setColumns(10);

        tfName = new JTextField();
        tfName.setBounds(120, 150, 350, 20);
        contentPane.add(tfName);
        tfName.setColumns(10);

        tfDoB = new JTextField();
        tfDoB.setBounds(120, 250, 350, 20);
        contentPane.add(tfDoB);
        tfDoB.setColumns(10);

        tfPN = new JTextField();
        tfPN.setBounds(120, 300, 350, 20);
        contentPane.add(tfPN);
        tfPN.setColumns(10);

        tfR = new JTextField();
        tfR.setBounds(120, 350, 350, 20);
        contentPane.add(tfR);
        tfR.setColumns(10);

        JComboBox comboBox = new JComboBox(new String[] {"Male","Female"});
        comboBox.setBounds(120, 200, 120, 20);
        contentPane.add(comboBox);
        JButton btnEnter = new JButton("Enter");
        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {

                    String sid= tfID.getText();
                    String sname = tfName.getText();
                    String sex = (String) comboBox.getSelectedItem();
                    String phonenumber = tfPN.getText();
                    String rid=tfR.getText();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlktx","root","");
                    Statement stm = con.createStatement();
                    ps = con.prepareStatement("insert into sinhvien(sid,sname,sex,dob,phonenumber,rid) values (?,?,?,?,?,?)");
                    ps.setString(1, sid);
                    ps.setString(2, sname);
                    ps.setString(3, sex);
                    ps.setString(4, tfDoB.getText());
                    ps.setString(5, phonenumber);
                    ps.setString(6, rid);
                    ps.execute();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                    //System.out.println(e.getMessage());
                }
                dispose();
                Manager m = new Manager();
                m.setVisible(true);
            }

        });
        btnEnter.setBounds(220, 400, 120, 40);
        contentPane.add(btnEnter);



    }
}

