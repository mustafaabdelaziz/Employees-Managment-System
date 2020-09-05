/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Mohammed
 */
public class Admin extends Person {

    FileManger FManger = new FileManger();

    public Admin() {

    }

    public Admin(String user, String pass, int id, String fname, String lname, int age) {
        super(user, pass, id, fname, lname, age);
    }

    public void addNewEmployee(String user, String pass, int id, String fname, String lname, int age) {
        Employee x = new Employee(user, pass, id, fname, lname, age);
        if (x.addEmployee()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayEmployees() {
        Employee x = new Employee();
        System.out.println(x.displayAllEmployees());
    }

    public void searchForEmployee(int id) {
        Employee x = new Employee();
        System.out.println(x.searchEmployee(id));
    }

    public void updateEmployee(int oldID, Employee newStudentValues) {
        Employee x = new Employee();
        x.updateEmployee(oldID, newStudentValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteEmployee(int Id) {
        Employee x = new Employee();
        x.deleteEmployee(Id);
        System.out.println("deleted Successfully ... !");
    }

    public void addNewTeamLeader(String user, String pass, int id, String fname, String lname, int age) {
        TeamLeader x = new TeamLeader(user, pass, id, fname, lname, age);
        if (x.addTeamLeader()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayTeamLeader() {
        TeamLeader x = new TeamLeader();
        System.out.println(x.displayAllTeamLeader());
    }

    public void searchForTeamLeader(int id) {
        TeamLeader x = new TeamLeader();
        System.out.println(x.searchTeamLeader(id));
    }

    public void updateTeamLeader(int oldID, TeamLeader newProfValues) {
        TeamLeader x = new TeamLeader();
        x.updateTeamLeader(oldID, newProfValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteTeamLeader(int Id) {
        TeamLeader x = new TeamLeader();
        x.deleteTeamLeader(Id);
        System.out.println("deleted Successfully ... !");
    }

    public void addNewPM(String user, String pass, int id, String fname, String lname, int age) {
        ProjectManger x = new ProjectManger(user, pass, id, fname, lname, age);
        if (x.addPM()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayPMs() {
        ProjectManger x = new ProjectManger();
        System.out.println(x.displayAllPMs());
    }

    public void searchForPMs(int id) {
        ProjectManger x = new ProjectManger();
        System.out.println(x.searchPM(id));
    }

    public void updatePMs(int oldID, ProjectManger newTAValues) {
        ProjectManger x = new ProjectManger();
        x.updatePM(oldID, newTAValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deletePM(int Id) {
        ProjectManger x = new ProjectManger();
        x.deletePM(Id);
        System.out.println("deleted Successfully ... !");
    }

    public void displayTasks() {
        Tasks x = new Tasks();
        System.out.println(x.displayAllTasks());
    }

    public void addTask(String TaskName, int TaskId, int ProjectId) {
        Tasks x = new Tasks(TaskName, TaskId, ProjectId);
        if (x.addTask()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void searchForTask(int id) {
        Tasks x = new Tasks();
        System.out.println(x.searchTasks(id));
    }

    public void updateTasks(int oldID, Tasks newTaskValues) {
        Tasks x = new Tasks();
        x.updateTasks(oldID, newTaskValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteTask(int Id) {
        Tasks x = new Tasks();
        x.deleteTasks(Id);
        System.out.println("deleted Successfully ... !");
    }

    public void displayProjects() {
        Projects x = new Projects();
        System.out.println(x.displayAllProjects());
    }

    public void addProject(String ProjectName, int ProjectId) {
        Projects x = new Projects(ProjectName, ProjectId);
        if (x.addProject()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void searchForProject(int id) {
        Projects x = new Projects();
        System.out.println(x.searchProjects(id));
    }

    public void updateProjects(int oldID, Projects newProjectValues) {
        Projects x = new Projects();
        x.updateProjects(oldID, newProjectValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteProject(int Id) {
        Projects x = new Projects();
        x.deleteProjects(Id);
        System.out.println("deleted Successfully ... !");
    }

    @Override
    public String toString() {
        return "I'm Manager : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + userName + "\t Password: " + pass + "\n";
    }

    public void admin() {
        JTable table;
        JScrollPane js;
        JFrame ftab = new JFrame("ViewProjects ");
        ftab.setSize(710, 600);
        ftab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ftab.setVisible(false);
        ////////////
        JFrame f1 = new JFrame("admin ");
        f1.setSize(710, 600);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);

        JFrame em = new JFrame("emplyee");
        em.setSize(700, 600);
        em.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        em.setVisible(false);
        em.setLayout(null);

        //dlete emplyee
        JFrame delem = new JFrame("emplyee");
        delem.setSize(400, 300);
        delem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        delem.setVisible(false);
        delem.setLayout(null);
        JButton btn_clear = new JButton("delete");
        btn_clear.setBounds(70, 200, 70, 30);
        JButton hd = new JButton("Home");
        hd.setBounds(150, 200, 70, 30);
        delem.add(btn_clear);
        JLabel dell = new JLabel("ID");
        dell.setBounds(30, 90, 100, 25);
        JTextField delID = new JTextField();
        delID.setBounds(120, 90, 130, 25);
        delem.add(dell);
        delem.add(delID);
        delem.add(hd);

        //dlete Team leader
        JFrame dt = new JFrame("Team leader");
        dt.setSize(400, 300);
        dt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dt.setVisible(false);
        dt.setLayout(null);
        JButton dtb = new JButton("delete");
        dtb.setBounds(70, 200, 70, 30);
        JButton h = new JButton("Home");
        h.setBounds(150, 200, 70, 30);
        dt.add(dtb);
        JLabel de = new JLabel("ID");
        de.setBounds(30, 90, 100, 25);
        JTextField deID = new JTextField();
        deID.setBounds(120, 90, 130, 25);
        dt.add(de);
        dt.add(deID);
        dt.add(h);

        //dlete project manager 
        JFrame dp = new JFrame("project manager ");
        dp.setSize(400, 300);
        dp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dp.setVisible(false);
        dp.setLayout(null);
        JButton dpb = new JButton("delete");
        dpb.setBounds(70, 200, 70, 30);
        JButton hp = new JButton("Home");
        hp.setBounds(150, 200, 70, 30);
        dp.add(dpb);
        JLabel dep = new JLabel("ID");
        dep.setBounds(30, 90, 100, 25);
        JTextField depID = new JTextField();
        depID.setBounds(120, 90, 130, 25);
        dp.add(dep);
        dp.add(depID);
        dp.add(hp);

        JFrame p = new JFrame("Project manager");
        p.setSize(710, 600);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setLayout(null);

        JFrame t = new JFrame(" team");
        t.setSize(710, 600);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setLayout(null);

        JFrame um = new JFrame("emplyee");
        um.setSize(700, 600);
        um.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        um.setVisible(false);
        um.setLayout(null);
        //admain frame

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Add");
        JMenu m3 = new JMenu("Delete");
        JMenu m4 = new JMenu("update");
        JButton m2 = new JButton("view tasks");
        JMenuItem m11 = new JMenuItem("employee");
        JMenuItem m22 = new JMenuItem("team leader");
        JMenuItem m33 = new JMenuItem("project managment");
        JMenuItem m111 = new JMenuItem("employee");
        JMenuItem m222 = new JMenuItem("team leader");
        JMenuItem m333 = new JMenuItem("project managment");
        JMenuItem m112 = new JMenuItem("employee");
        JMenuItem m223 = new JMenuItem("team leader");
        JMenuItem m332 = new JMenuItem("project managment");
        JPanel panel = new JPanel();
        Font newFont = new Font("Serif", Font.BOLD, 25);
        JLabel label = new JLabel("Welcome to Admin ");
        f1.getContentPane().add(BorderLayout.CENTER, panel);
        f1.getContentPane().add(BorderLayout.NORTH, mb);
        f1.getContentPane().add(BorderLayout.NORTH, mb);
        /////////////
       JPanel p2 = new JPanel();
        p2.setLayout(null);
        js = new JScrollPane();
        js.setBounds(10, 21, 500, 368);
        ftab.getContentPane().add(js);
        JButton b3 ;
        b3 = new JButton("<-");
        b3.setBounds(520,10, 60, 30);
        b3.setVisible(true);
        ftab.getContentPane().add(p2);
        String[] columns = {"ProjectName", "ProjectID"};
        table = new JTable();
        p2.add(m2);
        p2.add(b3);
        js.setViewportView(table);
        DefaultTableModel tableModel;
        tableModel = new DefaultTableModel(0, 2);
        tableModel.setColumnIdentifiers(columns);
        table.setModel(tableModel);
        ///////////////
        label.setFont(newFont);
        panel.add(label);
        mb.add(m1);
        mb.add(m3);
        mb.add(m4);
        mb.add(m2);
        m1.add(m11);
        m1.add(m33);
        m1.add(m22);
        m3.add(m111);
        m3.add(m333);
        m3.add(m222);
        m4.add(m112);
        m4.add(m332);
        m4.add(m223);

        //nn
        //label em
        JLabel l1 = new JLabel("users");
        JLabel l2 = new JLabel("ID");
        JLabel l3 = new JLabel("First Name");
        JLabel l4 = new JLabel("Last Name ");
        JLabel l5 = new JLabel("age");
        JLabel l6 = new JLabel("password");
        l1.setBounds(30, 50, 100, 25);
        l2.setBounds(30, 90, 100, 25);
        l3.setBounds(30, 130, 100, 25);
        l4.setBounds(30, 170, 100, 25);
        l5.setBounds(30, 210, 100, 25);
        l6.setBounds(30, 250, 100, 25);

        //textfileand password
        JTextField jTextFieldUserName = new JTextField();
        JTextField jTextFieldID = new JTextField();
        JTextField jTextFieldFname = new JTextField();
        JTextField jTextFieldLname = new JTextField();
        JTextField jTextFieldAge = new JTextField();
        JPasswordField jPasswordField1 = new JPasswordField();
        jTextFieldUserName.setBounds(120, 50, 130, 25);
        jTextFieldID.setBounds(120, 90, 130, 25);
        jTextFieldFname.setBounds(120, 130, 130, 25);
        jTextFieldLname.setBounds(120, 170, 130, 25);
        jTextFieldAge.setBounds(120, 210, 130, 25);
        jPasswordField1.setBounds(120, 250, 130, 25);
        //button
        JButton btn_add = new JButton("Add");
        JButton btn_hom = new JButton("home");
        btn_add.setBounds(150, 300, 70, 30);

        btn_hom.setBounds(230, 300, 90, 30);
        //add em
        em.add(l1);
        em.add(l2);
        em.add(l3);
        em.add(l4);
        em.add(l5);
        em.add(l6);
        em.add(jTextFieldUserName);
        em.add(jTextFieldID);
        em.add(jTextFieldFname);
        em.add(jTextFieldLname);
        em.add(jTextFieldAge);
        em.add(jPasswordField1);
        em.add(btn_add);

        em.add(btn_hom);

        //add t
        JLabel lt = new JLabel("users");
        JLabel lt2 = new JLabel("ID");
        JLabel lt3 = new JLabel("First Name");
        JLabel lt4 = new JLabel("Last Name ");
        JLabel lt5 = new JLabel("age");
        JLabel lt6 = new JLabel("password");
        lt.setBounds(30, 50, 100, 25);
        lt2.setBounds(30, 90, 100, 25);
        lt3.setBounds(30, 130, 100, 25);
        lt4.setBounds(30, 170, 100, 25);
        lt5.setBounds(30, 210, 100, 25);
        lt6.setBounds(30, 250, 100, 25);

        //textfileand password
        JTextField tUser = new JTextField();
        JTextField tID = new JTextField();
        JTextField tFname = new JTextField();
        JTextField tLname = new JTextField();
        JTextField tAge = new JTextField();
        JPasswordField tPassword1 = new JPasswordField();
        tUser.setBounds(120, 50, 130, 25);
        tID.setBounds(120, 90, 130, 25);
        tFname.setBounds(120, 130, 130, 25);
        tLname.setBounds(120, 170, 130, 25);
        tAge.setBounds(120, 210, 130, 25);
        tPassword1.setBounds(120, 250, 130, 25);
        //button
        JButton tadd = new JButton("Add");
        JButton thom = new JButton("home");
        tadd.setBounds(150, 300, 70, 30);
        thom.setBounds(230, 300, 90, 30);
        t.add(lt);
        t.add(lt2);
        t.add(lt3);
        t.add(lt4);
        t.add(lt5);
        t.add(lt6);
        t.add(tUser);
        t.add(tID);
        t.add(tFname);
        t.add(tLname);
        t.add(tAge);
        t.add(tPassword1);
        t.add(tadd);
        t.add(thom);

        //add p
        JLabel lp1 = new JLabel("users");
        JLabel lp2 = new JLabel("ID");
        JLabel lp3 = new JLabel("First Name");
        JLabel lp4 = new JLabel("Last Name ");
        JLabel lp5 = new JLabel("age");
        JLabel lp6 = new JLabel("password");
        lp1.setBounds(30, 50, 100, 25);
        lp2.setBounds(30, 90, 100, 25);
        lp3.setBounds(30, 130, 100, 25);
        lp4.setBounds(30, 170, 100, 25);
        lp5.setBounds(30, 210, 100, 25);
        lp6.setBounds(30, 250, 100, 25);

        //textfileand password
        JTextField pUser = new JTextField();
        JTextField pID = new JTextField();
        JTextField pFname = new JTextField();
        JTextField pLname = new JTextField();
        JTextField pAge = new JTextField();
        JPasswordField pPassword1 = new JPasswordField();
        pUser.setBounds(120, 50, 130, 25);
        pID.setBounds(120, 90, 130, 25);
        pFname.setBounds(120, 130, 130, 25);
        pLname.setBounds(120, 170, 130, 25);
        pAge.setBounds(120, 210, 130, 25);
        pPassword1.setBounds(120, 250, 130, 25);
        //button
        JButton padd = new JButton("Add");
        JButton phome = new JButton("home");
        padd.setBounds(150, 300, 70, 30);
        phome.setBounds(230, 300, 90, 30);
        p.add(lp1);
        p.add(lp2);
        p.add(lp3);
        p.add(lp4);
        p.add(lp5);
        p.add(lp6);
        p.add(pUser);
        p.add(pID);
        p.add(pFname);
        p.add(pLname);
        p.add(pAge);
        p.add(pPassword1);
        p.add(padd);
        p.add(phome);

        //update 
        //em
        JFrame upp = new JFrame("Prect manager");
        upp.setSize(700, 600);
        upp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        upp.setVisible(false);
        upp.setLayout(null);
        JFrame ut = new JFrame("Team leader");
        ut.setSize(700, 600);
        ut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ut.setVisible(false);
        ut.setLayout(null);

        //label 
        JLabel u = new JLabel("OlD ID");
        JLabel u1 = new JLabel("users");
        JLabel u2 = new JLabel("ID");
        JLabel u3 = new JLabel("First Name");
        JLabel u4 = new JLabel("Last Name ");
        JLabel u5 = new JLabel("age");
        JLabel u6 = new JLabel("password");
        u.setBounds(30, 50, 100, 25);
        u1.setBounds(30, 90, 100, 25);
        u2.setBounds(30, 130, 100, 25);
        u3.setBounds(30, 170, 100, 25);
        u4.setBounds(30, 210, 100, 25);
        u5.setBounds(30, 250, 100, 25);
        u6.setBounds(30, 290, 100, 25);
        //textfileand password
        JTextField uo = new JTextField();
        JTextField us = new JTextField();
        JTextField ui = new JTextField();
        JTextField uf = new JTextField();
        JTextField ul = new JTextField();
        JTextField ua = new JTextField();
        JPasswordField up = new JPasswordField();
        uo.setBounds(120, 50, 130, 25);
        us.setBounds(120, 90, 130, 25);
        ui.setBounds(120, 130, 130, 25);
        uf.setBounds(120, 170, 130, 25);
        ul.setBounds(120, 210, 130, 25);
        ua.setBounds(120, 250, 130, 25);
        up.setBounds(120, 290, 130, 25);
        //button
        JButton uu = new JButton("Update");
        JButton uh = new JButton("Home");
        uu.setBounds(70, 350, 120, 30);
        uh.setBounds(210, 350, 120, 30);
        um.add(u);
        um.add(u1);
        um.add(u2);
        um.add(u3);
        um.add(u4);
        um.add(u5);
        um.add(u6);
        um.add(uo);
        um.add(ui);
        um.add(us);
        um.add(uf);
        um.add(ul);
        um.add(ua);
        um.add(up);
        um.add(uu);
        um.add(uh);
//            p.add(pclear);
//            p.add(pupdate);
        f1.setVisible(true);
        //label 
        JLabel utt = new JLabel("OlD ID");
        JLabel ut1 = new JLabel("users");
        JLabel ut2 = new JLabel("ID");
        JLabel ut3 = new JLabel("First Name");
        JLabel ut4 = new JLabel("Last Name ");
        JLabel ut5 = new JLabel("age");
        JLabel ut6 = new JLabel("password");
        utt.setBounds(30, 50, 100, 25);
        ut1.setBounds(30, 90, 100, 25);
        ut2.setBounds(30, 130, 100, 25);
        ut3.setBounds(30, 170, 100, 25);
        ut4.setBounds(30, 210, 100, 25);
        ut5.setBounds(30, 250, 100, 25);
        ut6.setBounds(30, 290, 100, 25);
        //textfileand password
        JTextField uto = new JTextField();
        JTextField uts = new JTextField();
        JTextField uti = new JTextField();
        JTextField utf = new JTextField();
        JTextField utl = new JTextField();
        JTextField ura = new JTextField();
        JPasswordField utp = new JPasswordField();
        uto.setBounds(120, 50, 130, 25);
        uts.setBounds(120, 90, 130, 25);
        uti.setBounds(120, 130, 130, 25);
        utf.setBounds(120, 170, 130, 25);
        utl.setBounds(120, 210, 130, 25);
        ura.setBounds(120, 250, 130, 25);
        utp.setBounds(120, 290, 130, 25);
        //button
        JButton utu = new JButton("Update");
        JButton uth = new JButton("Home");
        utu.setBounds(70, 350, 120, 30);
        uth.setBounds(210, 350, 120, 30);
        ut.add(utt);
        ut.add(ut1);
        ut.add(ut2);
        ut.add(ut3);
        ut.add(ut4);
        ut.add(ut5);
        ut.add(ut6);
        ut.add(uto);
        ut.add(uti);
        ut.add(uts);
        ut.add(utf);
        ut.add(utl);
        ut.add(ura);
        ut.add(utp);
        ut.add(utu);
        ut.add(uth);
        //label 
        JLabel upt = new JLabel("OlD ID");
        JLabel up1 = new JLabel("users");
        JLabel up2 = new JLabel("ID");
        JLabel up3 = new JLabel("First Name");
        JLabel up4 = new JLabel("Last Name ");
        JLabel up5 = new JLabel("age");
        JLabel up6 = new JLabel("password");
        upt.setBounds(30, 50, 100, 25);
        up1.setBounds(30, 90, 100, 25);
        up2.setBounds(30, 130, 100, 25);
        up3.setBounds(30, 170, 100, 25);
        up4.setBounds(30, 210, 100, 25);
        up5.setBounds(30, 250, 100, 25);
        up6.setBounds(30, 290, 100, 25);
        //textfileand password
        JTextField upo = new JTextField();
        JTextField ups = new JTextField();
        JTextField upi = new JTextField();
        JTextField upf = new JTextField();
        JTextField upl = new JTextField();
        JTextField upa = new JTextField();
        JPasswordField upp1 = new JPasswordField();
        upo.setBounds(120, 50, 130, 25);
        ups.setBounds(120, 90, 130, 25);
        upi.setBounds(120, 130, 130, 25);
        upf.setBounds(120, 170, 130, 25);
        upl.setBounds(120, 210, 130, 25);
        upa.setBounds(120, 250, 130, 25);
        upp1.setBounds(120, 290, 130, 25);
        //button
        JButton upu = new JButton("Update");
        JButton uph = new JButton("Home");
        upu.setBounds(70, 350, 120, 30);
        uph.setBounds(210, 350, 120, 30);
        upp.add(upt);
        upp.add(up1);
        upp.add(up2);
        upp.add(up3);
        upp.add(up4);
        upp.add(up5);
        upp.add(up6);
        upp.add(upo);
        upp.add(upi);
        upp.add(ups);
        upp.add(upf);
        upp.add(upl);
        upp.add(upa);
        upp.add(upp1);
        upp.add(upu);
        upp.add(uph);

        //Actions;     
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                em.setVisible(true);

            }
        });

        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if (!jTextFieldID.getText().equals("") && !jTextFieldFname.getText().equals("") && !jTextFieldLname.getText().equals("") && !jTextFieldUserName.getText().equals("") && !jPasswordField1.getText().equals("") && !jTextFieldAge.getText().equals("")) {

                    Admin x = new Admin();
                    x.setID(Integer.parseInt(jTextFieldID.getText()));
                    x.setFName(jTextFieldFname.getText());
                    x.setLName(jTextFieldLname.getText());
                    x.setUserName(jTextFieldUserName.getText());
                    x.setPass(jPasswordField1.getText());
                    x.setAge(Integer.parseInt(jTextFieldAge.getText()));

                    x.addNewEmployee(x.userName, x.pass, x.id, x.fname, x.lname, x.age);

                }
                jTextFieldID.setText("");
                jTextFieldFname.setText("");
                jTextFieldLname.setText("");
                jTextFieldUserName.setText("");
                jPasswordField1.setText("");
                jTextFieldAge.setText("");
                 JOptionPane.showMessageDialog(null, "ADD successfully");
               
            }catch(Exception ev){
                 JOptionPane.showMessageDialog(null, "ERROR");

        }
  
            
            }   
        });

        m22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                t.setVisible(true);

            }
        });
        tadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if (tUser.getText().equals("") && tID.getText().equals("") && tFname.getText().equals("") && tLname.getText().equals("") && tAge.getText().equals("") && tPassword1.getText().equals(""));
                Admin t = new Admin();
                t.setID(Integer.parseInt(tID.getText()));
                t.setFName(tFname.getText());
                t.setLName(tLname.getText());
                t.setUserName(tUser.getText());
                t.setPass(tPassword1.getText());
                t.setAge(Integer.parseInt(tAge.getText()));
                t.addNewTeamLeader(t.userName, t.pass, t.id, t.fname, t.lname, t.age);
                tID.setText("");
                tFname.setText("");
                tLname.setText("");
                tUser.setText("");
                tPassword1.setText("");
                tAge.setText("");
               JOptionPane.showMessageDialog(null, "ADD successfully");
               
            }catch(Exception ev){
                 JOptionPane.showMessageDialog(null, "ERROR");

        }
            }

        });

        m33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                p.setVisible(true);

            }
        });
        padd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if (pUser.getText().equals("") && pID.getText().equals("") && pFname.getText().equals("") && pLname.getText().equals("") & pAge.getText().equals("") && pPassword1.getText().equals(""));
                Admin p = new Admin();
                p.setID(Integer.parseInt(pID.getText()));
                p.setFName(pFname.getText());
                p.setLName(pLname.getText());
                p.setUserName(pUser.getText());
                p.setPass(pPassword1.getText());
                p.setAge(Integer.parseInt(pAge.getText()));
                p.addNewPM(p.userName, p.pass, p.id, p.fname, p.lname, p.age);
                pID.setText("");
                pFname.setText("");
                pLname.setText("");
                pUser.setText("");
                pPassword1.setText("");
                pAge.setText("");
                JOptionPane.showMessageDialog(null, "ADD successfully");
               
            }catch(Exception ev){
                 JOptionPane.showMessageDialog(null, "ERROR");

        }
            }
        });
        m111.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                delem.setVisible(true);

            }
        });
        //btn_clear  
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                Admin xd = new Admin();
                xd.setID(Integer.parseInt(delID.getText()));
                xd.deleteEmployee(xd.id);
                delID.setText("");
               JOptionPane.showMessageDialog(null, "DELETE successfully");
               
            }catch(Exception ev){
                 JOptionPane.showMessageDialog(null, "ERROR");

        }
            }
        });

        hd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                delem.setVisible(false);

            }
        });

        m222.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                dt.setVisible(true);

            }
        });
        dtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                Admin td = new Admin();
                td.setID(Integer.parseInt(deID.getText()));
                td.deleteTeamLeader(td.id);
                deID.setText("");
                JOptionPane.showMessageDialog(null, "delete successfully");
               
            }catch(Exception ev){
                 JOptionPane.showMessageDialog(null, "ERROR");

        }
            }
        });

        h.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                dt.setVisible(false);

            }
        });

        m333.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                dp.setVisible(true);

            }
        });
        dpb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                Admin pd = new Admin();
                pd.setID(Integer.parseInt(depID.getText()));
                pd.deletePM(pd.id);
                depID.setText("");
                 JOptionPane.showMessageDialog(null, "DELETE successfully");
               
            }catch(Exception ev){
                 JOptionPane.showMessageDialog(null, "ERROR");

        }
            }
        });

        hp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                dp.setVisible(false);

            }
        });
        //update
        m112.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                um.setVisible(true);

            }
        });
        uu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if (us.getText().equals("") && ui.getText().equals("") && uf.getText().equals("") && ul.getText().equals("") & ua.getText().equals("") && up.getText().equals("") && uo.getText().equals(""));
                Employee ee = new Employee();
                Admin u = new Admin();
                ee.setID(Integer.parseInt(ui.getText()));
                ee.setID(Integer.parseInt(uo.getText()));
                ee.setFName(uf.getText());
                ee.setLName(ul.getText());
                ee.setUserName(us.getText());
                ee.setPass(up.getText());
                ee.setAge(Integer.parseInt(ua.getText()));
                u.setID(Integer.parseInt(uo.getText()));
                u.updateEmployee(u.id, ee);
                uo.setText("");
                ui.setText("");
                uf.setText("");
                ul.setText("");
                us.setText("");
                up.setText("");
                ua.setText("");
                JOptionPane.showMessageDialog(null, "UPDATE successfully");
               
            }catch(Exception ev){
                 JOptionPane.showMessageDialog(null, "ERROR");

        }
            }
        });

        uh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                um.setVisible(false);

            }
        });

        m223.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                ut.setVisible(true);

            }
        });
        utu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if (uts.getText().equals("") && uti.getText().equals("") && utf.getText().equals("") && utl.getText().equals("") & ura.getText().equals("") && utp.getText().equals("") && uto.getText().equals(""));
                TeamLeader ete = new TeamLeader();
                Admin ee = new Admin();
                ete.setID(Integer.parseInt(uti.getText()));
                ete.setID(Integer.parseInt(uto.getText()));
                ete.setFName(utf.getText());
                ete.setLName(utl.getText());
                ete.setUserName(uts.getText());
                ete.setPass(utp.getText());
                ete.setAge(Integer.parseInt(ura.getText()));
                ee.setID(Integer.parseInt(uto.getText()));
                ee.updateTeamLeader(ee.id, ete);
                uto.setText("");
                uti.setText("");
                utf.setText("");
                utl.setText("");
                uts.setText("");
                utp.setText("");
                ura.setText("");
               JOptionPane.showMessageDialog(null, "UPDATE successfully");
               
            }catch(Exception ev){
                 JOptionPane.showMessageDialog(null, "ERROR");

        }
            }
        });

        uth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                ut.setVisible(false);

            }
        });
        m332.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                upp.setVisible(true);

            }
        });
        upu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if (ups.getText().equals("") && upi.getText().equals("") && upf.getText().equals("") && upl.getText().equals("") & upa.getText().equals("") && upp1.getText().equals("") && upo.getText().equals(""));
                ProjectManger pmm = new ProjectManger();
                Admin ap = new Admin();
                pmm.setID(Integer.parseInt(upi.getText()));
                pmm.setID(Integer.parseInt(upo.getText()));
                pmm.setFName(upf.getText());
                pmm.setLName(upl.getText());
                pmm.setUserName(ups.getText());
                pmm.setPass(upp1.getText());
                pmm.setAge(Integer.parseInt(upa.getText()));   
                ap.setID(Integer.parseInt(upo.getText()));
                ap.updatePMs(ap.id, pmm);
                upo.setText("");
                upi.setText("");
                upf.setText("");
                upl.setText("");
                ups.setText("");
                upp1.setText("");
                upa.setText("");
                JOptionPane.showMessageDialog(null, "UPDATE successfully");
               
            }catch(Exception ev){
                 JOptionPane.showMessageDialog(null, "ERROR");

        }
            }
        });

        uph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                upp.setVisible(false);

            }
        });
        btn_hom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                em.setVisible(false);

            }
        });
        thom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                t.setVisible(false);

            }
        });
        phome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                p.setVisible(false);

            }
        });

        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                ftab.setVisible(true);
                try {
                    FileInputStream fis = new FileInputStream("Projects.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    String line;
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
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ftab.setVisible(false);
                f1.setVisible(true);

            }
        });

    }

}
