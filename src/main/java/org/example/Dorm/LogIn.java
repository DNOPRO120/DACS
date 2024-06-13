package org.example.Dorm;


import java.awt.BorderLayout;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {
    String user = "admin";
    String pass = "1";
    private JPanel contentPane;
    private JTextField tfMID;
    private JPasswordField tfPass;
    private Statement stmt;
    private PreparedStatement ps;
    private ResultSet rs;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
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
                if(tfMID.getText().equals(user) && tfPass.getText().equals(pass))
                {
                    Manager m = new Manager();
                    m.setVisible(true);
                    dispose();
                }
                else
                {
                    Error e = new Error();
                    e.setVisible(true);
                    dispose();
                }
            }
        });
        btnLogIn.setBounds(150, 200, 100, 30);
        contentPane.add(btnLogIn);
    }
}