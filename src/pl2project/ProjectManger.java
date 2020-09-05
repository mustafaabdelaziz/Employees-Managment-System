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
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Mohammed
 */
public class ProjectManger extends Person {

    private JFrame f, f1, f2, f3;
    private JButton b, b1, b2, b3, b4, b5, b6, b7;
    private JLabel lab, lab1, lab2, lab3, lab4, lab5;
    private JPanel p, p1, p2, p3;
    private JTextArea t, t1;
    private JTable table;
    private JScrollPane js;
    private JTextField tf, tf1;
    private String name;
    private String number;
    private String projectid;
    String line = null;

    private final String PMFileName = "ProjectManger.txt";

    public static ArrayList<ProjectManger> PMs = new ArrayList<ProjectManger>();

    public ProjectManger() {

    }

    public ProjectManger(String user, String pass, int id, String fname, String lname, int age) {
        super(user, pass, id, fname, lname, age);

    }

    public boolean addPM() {
        if (FManger.write(getPMData(), PMFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getPMData() {
        return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.userName + "@" + this.pass + "@";
    }

    private void commitToFile() {
        FManger.write(PMs.get(0).getPMData(), PMFileName, false);
        for (int i = 1; i < PMs.size(); i++) {
            FManger.write(PMs.get(i).getPMData(), PMFileName, true);
        }

    }

    private int getPMIndex(int id) {
        for (int i = 0; i < PMs.size(); i++) {
            if (PMs.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    private void loadFromFile() {
        PMs = (ArrayList<ProjectManger>) (Object) FManger.read(PMFileName);
    }

    public String displayAllPMs() {
        loadFromFile();
        String S = "\nAll TAs Data:\n";
        for (ProjectManger x : PMs) {
            S = S + x.toString();
        }
        return S;
    }

    public String searchPM(int id) {
        loadFromFile();
        int index = getPMIndex(id);
        if (index != -1) {
            return "\nFound ...!" + PMs.get(index).toString();
        } else {
            return "\nNot Found ...!";
        }
    }

    public void updatePM(int oldID, ProjectManger x) {
        loadFromFile();
        int index = getPMIndex(oldID);
        PMs.set(index, x);
        commitToFile();
    }

    public void deletePM(int id) {
        loadFromFile();
        int index = getPMIndex(id);
        PMs.remove(index);
        commitToFile();
    }

    public void percentofcom() {
        int i = 0;
        int j;
        double noft = 0;
        double task = 0;
        int l;
        double percent;

        String FilePath = "Projects.txt";
        File MYFile = new File(FilePath);
        File File1 = new File("FinishedTasks.txt");
        File File2 = new File("Tasks.txt");
        ArrayList<String> project = new ArrayList<String>();
        ArrayList<String> fintasks = new ArrayList<String>();
        ArrayList<String> tasks1 = new ArrayList<String>();
        ArrayList<String> project1 = new ArrayList<String>();
        try ( BufferedWriter fileOut = new BufferedWriter(new FileWriter("project.txt", false))) {
            fileOut.write("");

            fileOut.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        //finishedtaskfile
        try {
            Scanner scan = new Scanner(File1);

            while (scan.hasNext()) {

                String Line1 = scan.nextLine();

                String[] seprate = Line1.split("@");

                fintasks.add(seprate[3]);

            }
            //System.out.println(fintasks.size());

        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        ///projectfile 
        try {
            Scanner scan = new Scanner(MYFile);

            while (scan.hasNext()) {

                String Line = scan.nextLine();

                String[] seprate = Line.split("@");

                project.add(seprate[1]);

            }
            //System.out.println(tasks.size());

        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        try {
            Scanner scan2 = new Scanner(File2);

            while (scan2.hasNext()) {

                String Line2 = scan2.nextLine();

                String[] seprate = Line2.split("@");

                tasks1.add(seprate[3]);

            }
            // System.out.println(tasks1.size());

        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        for (i = 0; i < project.size(); i++) {

            noft = 0;
            task = 0;
            for (j = 0; j < fintasks.size(); j++) {

                if (Integer.parseInt(project.get(i)) == Integer.parseInt(fintasks.get(j))) {
                    noft++;
                }

            }
            for (l = 0; l < tasks1.size(); l++) {

                if (Integer.parseInt(project.get(i)) == Integer.parseInt(tasks1.get(l))) {

                    task++;
                }

            }
            percent = (noft / task) * 100;
            String s = String.valueOf(percent);

            File MyFile = new File("Projects.txt");

            try {

                Scanner scan = new Scanner(MyFile);
                while (scan.hasNext()) {
                    String Line = scan.nextLine();
                    String[] seprate = Line.split("@");

                    project1.add(0, seprate[0]);
                    project1.add(1, seprate[1]);
                    String name = project1.get(0);
                    String x = project1.get(1);
                    if (Integer.parseInt(x) == Integer.parseInt(project.get(i))) {

                        try ( BufferedWriter fileOut = new BufferedWriter(new FileWriter("project.txt", true))) {
                            fileOut.write(name + "@" + x + "@" + s);

                            fileOut.append("\n");
                            fileOut.close();
                        } catch (IOException ex) {
                            System.err.println(ex);
                        }

                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }

    }

    public void test() {
        //Frames    
        f = new JFrame("Project Manager");
        f.setVisible(true);
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //report frame
        f1 = new JFrame("Report");

        f1.setSize(600, 600);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ///////
        f2 = new JFrame("Report");

        f2.setSize(600, 600);
        f2.setLocationRelativeTo(null);
        f2.setResizable(false);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ///
        f3 = new JFrame("SetProject");

        f3.setSize(600, 600);
        f3.setLocationRelativeTo(null);
        f3.setResizable(false);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Panels
        //pmPanal
        p = new JPanel();
        p.setLayout(null);

        //reportPanal 
        p1 = new JPanel();
        p1.setLayout(null);
        p2 = new JPanel();
        p2.setLayout(null);
        p3 = new JPanel();
        p3.setLayout(null);
//Labels
        lab = new JLabel("Welcome Manager");
        lab.setBounds(10, 10, 180, 20);
        lab1 = new JLabel("ID");
        lab1.setBounds(10, 10, 180, 20);
        lab2 = new JLabel("Reports");
        lab2.setBounds(10, 45, 180, 20);
        lab.setVisible(true);
        lab1.setVisible(true);
        lab3 = new JLabel("Please set Reports");
        lab3.setBounds(10, 0, 220, 20);
        lab4 = new JLabel("Project ID");
        lab4.setBounds(10, 120, 180, 20);
        lab5 = new JLabel("Project Name");
        lab5.setBounds(10, 70, 180, 20);

//buttons
        //Report buuton
        b = new JButton("Report");
        b.setBounds(100, 50, 200, 80);
        b.setVisible(true);
        //% button 
        b1 = new JButton("%");
        b1.setBounds(100, 150, 200, 80);
        b1.setVisible(true);
        // back
        b3 = new JButton("<-");
        b3.setBounds(520, 10, 60, 30);
        b3.setVisible(true);
        // Submit button
        b2 = new JButton("Submit");
        b2.setBounds(45, 450, 500, 60);
        b2.setVisible(true);
        b5 = new JButton("Set Project");
        b5.setBounds(100, 250, 200, 80);
        b5.setVisible(true);
        ///setProject
        b4 = new JButton("Submit");
        b4.setBounds(45, 450, 500, 60);
        b4.setVisible(true);
        /////
        b6 = new JButton("<-");
        b6.setBounds(520, 10, 60, 30);
        b6.setVisible(true);
        b7 = new JButton("<-");
        b7.setBounds(520, 10, 60, 30);
        b7.setVisible(true);
//TextArea
        //REports
        t = new JTextArea("");
        t.setBounds(45, 70, 500, 350);
        t.setVisible(true);
        //ID
        t1 = new JTextArea("");
        t1.setBounds(45, 10, 500, 30);
        t1.setVisible(true);
        //Table
        js = new JScrollPane();
        js.setBounds(10, 21, 500, 368);
        f2.getContentPane().add(js);
        f2.getContentPane().add(p2);
        String[] columns = {"ProjectName", "ProjectID", "Precent of complete"};
        table = new JTable();
        p2.add(b3);
        js.setViewportView(table);
        DefaultTableModel tableModel;
        tableModel = new DefaultTableModel(0, 3);
        tableModel.setColumnIdentifiers(columns);
        table.setModel(tableModel);
        tf = new JTextField();
        tf.setBounds(40, 90, 180, 20);
        tf.setVisible(true);
        tf1 = new JTextField();
        tf1.setBounds(40, 140, 180, 20);
        tf1.setVisible(true);
        //Mix 
        //pmFrame
        p.add(lab);
        p.add(b);
        p.add(b1);
        p.add(b5);
        f.add(p);
        f.setVisible(true);
        //ReportFrame

        p1.add(lab1);
        p1.add(lab2);
        p1.add(t);
        p1.add(t1);
        p1.add(b2);
        p1.add(b7);

        f1.add(p1);
        ////////
        p3.add(lab3);
        p3.add(lab4);
        p3.add(lab5);
        p3.add(b4);
        p3.add(tf);
        p3.add(tf1);
        p3.add(b6);
        f3.add(p3);
//Actions;     
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                f1.setVisible(true);

            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(false);
                f.setVisible(true);
                tableModel.getDataVector().removeAllElements();
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                f3.setVisible(true);

            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(true);
                f3.setVisible(false);

            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(true);
                f1.setVisible(false);

            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Query1 = tf.getText() + "@" + Integer.parseInt(tf1.getText()) + "@";
                    FManger.write(Query1, "Projects.txt", true);
                    tf.setText(null);
                    tf1.setText(null);
                    JOptionPane.showMessageDialog(null, "ADD successfully");
                } catch (NumberFormatException h) {
                    JOptionPane.showMessageDialog(null, "Please Enter integer in id");
                }

            }

        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                f2.setVisible(true);
                percentofcom();
                try {
                    FileInputStream fis = new FileInputStream("project.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    while ((line = br.readLine()) != null) {
                        tableModel.addRow(line.split("@"));
                    }
                    br.close();

                } catch (IOException j) {
                    // JOptionPane.showMessageDialog(null, "Error");
                    j.printStackTrace();
                }

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try ( BufferedWriter fileOut = new BufferedWriter(new FileWriter("Report.txt", true))) {
                    
                    t1.write(fileOut);
                    fileOut.append("@");
                    t.write(fileOut);
                    fileOut.append("\n");
                    fileOut.close();

                    
                    JOptionPane.showMessageDialog(null, "added");
                
                  

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

    }

    @Override
    public String toString() {
        return "\nI'm Project Manger : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (ProjectManger x : PMs) {
            if (userName.equals(x.userName) && Pass.equals(x.pass)) {
                return true;
            }
        }
        return false;
    }
}
