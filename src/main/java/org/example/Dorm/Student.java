package org.example.Dorm;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Student extends JFrame {

    private JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Student frame = new Student();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Student() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                back();
            }
        });
        setSize(450,300);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblStudent = new JLabel("STUDENT");
        lblStudent.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblStudent.setBounds(132, 11, 149, 47);
        contentPane.add(lblStudent);

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                SearchStudent ss = new SearchStudent();
                ss.setVisible(true);
            }
        });
        btnSearch.setBounds(160, 200, 120, 40);
        contentPane.add(btnSearch);

        JLabel lbl1 = new JLabel("WELCOME TO VKU's DOMITORY");
        lbl1.setBounds(34, 93, 376, 14);
        contentPane.add(lbl1);

        JLabel lbl2 = new JLabel("THE HOUSE FOR ALL VKU's STUDENTS");
        lbl2.setBounds(34, 118, 247, 14);
        contentPane.add(lbl2);
    }
    public void back(){
        dispose();
        new View().setVisible(true);
    }
}