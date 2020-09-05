/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;

public class Login extends Person {

    private JFrame f;
    private JButton b;
    private JLabel lab, lab1, lab2;
    private JPanel p;
    private JTextArea t, t1;
    private JTextField jf, jf1;

    public Login() {
    }

    void test() {
        f = new JFrame("LOG in");
        f.setVisible(true);
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ///////////
        p = new JPanel();
        p.setLayout(null);
        ///
        lab = new JLabel("Welcome");
        lab.setBounds(150, 10, 200, 20);
        lab1 = new JLabel("UserName :");
        lab1.setBounds(10, 50, 180, 20);
        lab2 = new JLabel("Password :");
        lab2.setBounds(10, 110, 180, 20);
        lab.setVisible(true);
        lab1.setVisible(true);
        lab2.setVisible(true);
        //////////////
        b = new JButton("LogIn");
        b.setBounds(100, 200, 200, 30);
        b.setVisible(true);
        /////////////
//        t = new JTextArea("");
//        t.setBounds(45, 140, 300, 30);
//        t.setVisible(true);
//        //ID
//        t1 = new JTextArea("");
//        t1.setBounds(45, 70, 300, 30);
//        t1.setVisible(true);
        jf = new JTextField("");
        jf.setBounds(45, 75, 300, 30);
        jf.setVisible(true);
        //ID
        jf1 = new JTextField("");
        jf1.setBounds(45, 140, 300, 30);
        jf1.setVisible(true);
        ///////
        p.add(lab);
        p.add(lab1);
        p.add(lab2);
        p.add(jf);
        p.add(jf1);
        p.add(b);

        f.add(p);
        f.setVisible(true);
        ////
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!jf.getText().equals("") && !jf.getText().equals("")) {
                    System.out.println(jf.getText() + jf1.getText());
                    Admin x = new Admin();
                    if (x.login(jf.getText(), jf1.getText())) {
                        f.setVisible(false);
                        x.admin();
                    } else {
                        ProjectManger x1 = new ProjectManger();

                        if (x1.login(jf.getText(), jf1.getText())) {
                            f.setVisible(false);
                            x1.test();
                        } else {
                            TeamLeader x2 = new TeamLeader();

                            if (x2.login(jf.getText(), jf1.getText())) {
                                f.setVisible(false);
                                TeamLeaderGUI x4=new TeamLeaderGUI();
                                x4.test();
                            } else {
                                Employee x3 = new Employee();
                                if (x3.login(jf.getText(), jf1.getText())) {
                                    f.setVisible(false);
                                    x3.test();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Worng UserNAme and Password");
                                }
                
                            }
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter userNAme and password");
                }

            }
        });

    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
