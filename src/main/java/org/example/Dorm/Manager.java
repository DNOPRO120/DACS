package org.example.Dorm;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Manager extends JFrame {

    private JPanel contentPane;
    View view = new View();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Manager frame = new Manager();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Manager() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                view.back();
            }
        });
        setSize(450,400);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblManager = new JLabel("MANAGER");
        lblManager.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblManager.setBounds(130, 10, 170, 40);
        contentPane.add(lblManager);

        JButton btnAdd = new JButton("ADD");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                AddStudent as = new AddStudent();
                as.setVisible(true);
            }
        });
        btnAdd.setBounds(50, 90, 120, 40);
        contentPane.add(btnAdd);

        JButton btnDel = new JButton("DELETE");
        btnDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                DeleteStudent ds = new DeleteStudent();
                ds.setVisible(true);
            }
        });
        btnDel.setBounds(50, 170, 120, 40);
        contentPane.add(btnDel);

        JButton btnEdit = new JButton("EDIT");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                EditStudent es = new EditStudent();
                es.setVisible(true);
            }
        });
        btnEdit.setBounds(250, 90, 120, 40);
        contentPane.add(btnEdit);

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                SearchStudentManager ss = new SearchStudentManager();
                ss.setVisible(true);
            }
        });
        btnSearch.setBounds(250, 170, 120, 40);
        contentPane.add(btnSearch);

        JButton btnShow = new JButton("SHOW ALL");
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                Display display = new Display();
                display.setVisible(true);
            }
        });
        btnShow.setBounds(50, 250, 120, 40);
        contentPane.add(btnShow);
    }
}
