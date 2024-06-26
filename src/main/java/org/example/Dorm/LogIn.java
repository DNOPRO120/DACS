package org.example.Dorm;


import org.example.KetNoi.KetNoi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {
    KetNoi conn = new KetNoi();
    Connection cn = conn.getConnection();
    private JPanel contentPane;
    private JTextField tfMID;
    private JPasswordField tfPass;
    private Statement stmt;
    private PreparedStatement ps;
    private ResultSet rs;
    View view =new View();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogIn frame = new LogIn();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public LogIn() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                view.back();
            }
        });
        setSize(450,300);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogIn = new JLabel("LOG IN");
        lblLogIn.setBounds(160, 10, 110, 40);
        lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblLogIn);

        JLabel lblMID = new JLabel("User");
        lblMID.setBounds(20, 70, 45, 15);
        contentPane.add(lblMID);

        JLabel lblPass = new JLabel("Pass");
        lblPass.setBounds(20, 120, 45, 15);
        contentPane.add(lblPass);

        tfMID = new JTextField();
        tfMID.setBounds(100, 70, 300, 20);
        contentPane.add(tfMID);
        tfMID.setColumns(10);

        tfPass = new JPasswordField();
        tfPass.setBounds(100, 120, 300, 20);
        contentPane.add(tfPass);


        JButton btnLogIn = new JButton("Log In");
        btnLogIn.addActionListener(new ActionListener() {
            private Object Error;

            public void actionPerformed(ActionEvent arg0) {
                String username = tfMID.getText();
                char[] password = tfPass.getPassword();
                System.out.println(username+password);
                login(username,new String(password));
                System.out.println("hi");
            }
        });
        btnLogIn.setBounds(150, 200, 100, 30);
        contentPane.add(btnLogIn);
    }
    public void login(String username, String password) {
        System.out.println("A "+username+" "+password);

        String sql = "select * from manager where mid = '" + username + "' and mpass = '" +password+"'";

        try (Connection cn = conn.getConnection()){
            PreparedStatement preparedStatement = cn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(sql);

            if (resultSet.next()) {
                System.out.println("1");
                System.out.println(username + password);
                Manager m = new Manager();
                m.setVisible(true);
                dispose();
            } else {
                System.out.println("2");
                System.out.println(username + password);
                Error e = new Error();
                e.setVisible(true);
                dispose();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("3");
        }
    }
}