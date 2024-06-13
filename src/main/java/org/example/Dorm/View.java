package org.example.Dorm;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View frame = new View();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(675,500);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel lblDM = new JLabel("DORM MANAGEMENT");
        lblDM.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblDM.setBounds(200, 10, 330, 50);
        contentPane.add(lblDM);

        JButton btnStudent = new JButton("STUDENT");
        btnStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                Student s = new Student();
                s.setVisible(true);
            }
        });
        btnStudent.setBounds(40, 150, 150, 50);
        contentPane.add(btnStudent);

        JButton btnManager = new JButton("MANAGER");
        btnManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                LogIn lg = new LogIn();
                lg.setVisible(true);
            }
        });
        btnManager.setBounds(40, 300, 150, 50);
        contentPane.add(btnManager);

        JLabel lblIcon = new JLabel("");
        lblIcon.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\DACs\\bunk (3).png"));
        lblIcon.setBounds(300, 100, 300, 300);
        contentPane.add(lblIcon);
    }
}
