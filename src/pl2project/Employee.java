package pl2project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Employee extends Person {
    FileManger FManger = new FileManger();
    private final String EmployeeFileName = "Employee.txt";
    Date entryTime;
    private Date exitTime;
    protected String vacation;
    private Date monthlyWorkingHours;
    private String penalteis;
    private ArrayList<String> finishedTasks;
    
    private JFrame f1,f2,f3;
    private JButton entry,exit,calcHours,finishTasks,assignedTasks,vacations,penalties,setTasks,submitVacation,setFTasks;
    private JLabel l1,l2,l3;
    private JPanel p1,p2,p3;
    private JTextArea t1,t2,t3;
    String text,fTasks;
    JScrollPane scroll;
    Tasks task;

    public static ArrayList<Employee> Employees = new ArrayList<Employee>();

    public Employee() {
       
    }

    

    Employee(String userName, String Pass, int id, String Fname, String Lname, int age) {
        super(userName,Pass,id,Fname,Lname,age);
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public void setVacation(String vacation) {
        this.vacation = vacation;
    }

    public void setMonthlyWorkingHours(Date monthlyWorkingHours) {
        this.monthlyWorkingHours = monthlyWorkingHours;
    }

    public void setPenalteis(String penalteis) {
        this.penalteis = penalteis;
    }

    public void setFinishedTasks(ArrayList<String> finishedTasks) {
        this.finishedTasks = finishedTasks;
    }

    public static void setEmployees(ArrayList<Employee> Employees) {
        Employee.Employees = Employees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getEmployeeFileName() {
        return EmployeeFileName;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public String getVacation() {
        return vacation;
    }

    public Date getMonthlyWorkingHours() {
        return monthlyWorkingHours;
    }

    public String getPenalteis() {
        return penalteis;
    }

    public ArrayList<String> getFinishedTasks() {
        return finishedTasks;
    }

    public static ArrayList<Employee> getEmployees() {
        return Employees;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getAge() {
        return age;
    }



    public boolean addEmployee() {
        if (FManger.write(getEmployeeData(), EmployeeFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getEmployeeData() {
        return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.userName + "@" + this.pass + "@";
    }


    private void commitToFile() {
        FManger.write(Employees.get(0).getEmployeeData(), EmployeeFileName, false);
        for (int i = 1; i < Employees.size(); i++) {
            FManger.write(Employees.get(i).getEmployeeData(), EmployeeFileName, true);
        }

    }

    private int getEmployeeIndex(int id){
        for (int i = 0; i < Employees.size(); i++)
            if(Employees.get(i).getID() == id)
                return i;

        return -1;
    }

    private void loadFromFile() {
            Employees = (ArrayList<Employee>) (Object) FManger.read(EmployeeFileName);
    }

    public String displayAllEmployees() {
        loadFromFile();
        String S = "\nAll Employees Data:\n";
        for (Employee x : Employees) {
            S = S + x.toString();
        }
        return S;
    }
    public String searchEmployee(int id){
        loadFromFile();
        int index = getEmployeeIndex(id);
        if(index != -1)
            return "\nFound ...!" + Employees.get(index).toString();
        else
            return "\nNot Found ...!";
    }

    public void updateEmployee(int oldID, Employee x){
        loadFromFile();
        int index = getEmployeeIndex(oldID);
        Employees.set(index, x);
        commitToFile();
    }

    public void deleteEmployee(int id){
        loadFromFile();
        int index = getEmployeeIndex(id);
        Employees.remove(index);
        commitToFile();
    }


    @Override
    public String toString() {
        return "\nI'm Employee : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age +  "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }
    
    /* Set Entry Time Method*/

    public void setEntryTime(){
        entryTime = new Date();
        String Query = this.id+"@"+entryTime.getHours()+"@"+entryTime.getMinutes()+"@";    
        FManger.write(Query, "EntryTime.txt", true);
    }
    
    /* Set Exit Time Method*/

    public void setExitTime(){
        exitTime =new Date();
        String Query = this.id+"@"+exitTime.getHours()+"@"+exitTime.getMinutes()+"@";
        FManger.write(Query, "ExitTime.txt", true);
    }
    
    /* Calculate Mounthly working hours Method*/

    public String  calcMounthlyWorkingHours() {
        
            int entryHours = 0;
            int entryMinute = 0;
            int exitHours = 0;
            int exitMinute =0;
            int totalWorkingMinutes = 0;
            int totalWorkingHours = 0;
            String total="";
            try {            
            Scanner  scanEntry = new Scanner(new File("EntryTime.txt"));
            Scanner scanExit = new Scanner(new File("ExitTime.txt"));
            while(scanEntry.hasNext() && scanExit.hasNext()){
                String LineEntry=scanEntry.nextLine();
                String LineExit=scanExit.nextLine();
                String[] saperatEntry =  LineEntry.split("@");
                       
                String[] saperatExit =LineExit.split("@");
                if(Integer.parseInt(saperatEntry[0])==this.id){
                    entryHours = Integer.parseInt(saperatEntry[1]);
                    entryMinute =Integer.parseInt(saperatEntry[2]);
                    if(Integer.parseInt(saperatEntry[0])==this.id){
                        exitHours = Integer.parseInt(saperatExit[1]);
                        exitMinute =Integer.parseInt(saperatExit[2]);
                    }
                    totalWorkingHours += (exitHours) - (entryHours);
                    totalWorkingMinutes +=((exitMinute) - (entryMinute));
                    
                    if(totalWorkingMinutes >= 60){
                        totalWorkingHours +=1;
                        totalWorkingMinutes -= 60;
                    }
                }    
            }
              total = totalWorkingHours +":"+totalWorkingMinutes;     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return total;
    }
    /* View Penalties Method*/

    public String viewPenalties (){
        String FilePath="Penalties.txt";
        
        try{
            Scanner scan =new Scanner(new File(FilePath));
            
       
        while(scan.hasNext()){
            String Line = scan.nextLine();
            String[] saperat = Line.split("@");
            
            if(Integer.parseInt(saperat[0])== this.id){
                penalteis = saperat[1];
            }
        }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        return "You have a penalty: "+penalteis+"\n";
    }
            /* Set Finished Tasks Method*/

    public void setfinishedTasks(String finishedTasks){
        File MyFile = new File("Tasks.txt");
        int TaID = 0,PID=0;
        try{
        Scanner scan = new Scanner (MyFile);
        while(scan.hasNext()){

            String Line = scan.nextLine();
            String[] saperat = Line.split("@");
            if(Integer.parseInt(saperat[0])==this.id){
            TaID = Integer.parseInt(saperat[2]);
            PID = Integer.parseInt(saperat[3]);
        }
        }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        String Query = id+"@"+finishedTasks+"@"+TaID+"@"+PID;
        FManger.write(Query, "FinishedTasks.txt", true);
    }
    /* View Assigned Tasks Method*/

    public ArrayList<String> viewAssignedTasks(){
        String FilePath="Tasks.txt";
        File MYFile = new File(FilePath);
        ArrayList<String> tasks= new ArrayList<String>() ;
        try{
          Scanner  scan=new Scanner(MYFile);
          while(scan.hasNext()){
            String Line =scan.nextLine();
            String[] saperat =Line.split("@");
            if(Integer.parseInt(saperat[0])==this.id){
               tasks.add(saperat[1]);
            
        }
        }

        }catch(NumberFormatException e){
            System.out.println(e);
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
       
        return tasks;
    }
    
    /* View Finished Tasks Method*/
    
    public ArrayList<String> viewFinishedTasks() {
        
            String FilePath="FinishedTasks.txt";
            File MyFile = new File(FilePath);
            ArrayList<String> finishedTasks = new ArrayList<String>();
            try {
            Scanner scan = new Scanner(MyFile);
            while(scan.hasNext()){
                String Line = scan.next();
                String[] saperat = Line.split("@");
                if(Integer.parseInt(saperat[0]) == this.id){
                    finishedTasks.add(saperat[1]);
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
            return finishedTasks;
    }
        public String getEmpData(){
             return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.userName + "@" + this.pass + "@";
          

      }
    
    public void requestVacations(String vacation){
        String FilePath="VacationsRequests.txt";
        String Query = this.id+"@"+vacation;
        FManger.write(Query, FilePath, true);
        
    }
    public void test(){
        //Employee Frame
        
        f1 = new JFrame("Employee");
        f1.setSize(400,400);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(false);
        f1.setVisible(true);
        f1.setTitle("Employee");
        p1 = new JPanel();
        p1.setLayout(null);
        entry = new JButton("Entry Time");
        entry.setBounds(20,40,150,30);
        entry.setVisible(true);
        exit = new JButton("Exit Time");
        exit.setBounds(200,40,150,30);
        exit.setVisible(true);
        calcHours= new JButton("Monthly Hours");
        calcHours.setBounds(20,80,150,30);
        calcHours.setVisible(true);
        finishTasks = new JButton("Finished Tasks");
        finishTasks.setBounds(200,80,150,30);
        finishTasks.setVisible(true);
        assignedTasks=new JButton("AssignedTasks");
        assignedTasks.setBounds(20,120,150,30);
        assignedTasks.setVisible(true);
        vacations = new JButton("Vacations");
        vacations.setBounds(200,120,150,30);
        vacations.setVisible(true);
        penalties = new JButton("Penalties");
        penalties.setBounds(20,160,150,30);
        penalties.setVisible(true);
        setTasks = new JButton("Set Finished Tasks");
        setTasks.setBounds(200,160,150,30);
        setTasks.setVisible(true);
        l1 = new JLabel("Welcome to the main Page");
        l1.setBounds(10,10,180,30);
        t1 = new JTextArea();   
        t1.setBounds(20,200,350,150);
        t1.setVisible(true);
        scroll = new JScrollPane(t1);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setVisible(true);
        scroll.setBounds(20,200,350,150);
        p1.add(scroll);
        p1.add(l1);
        p1.add(entry);
        p1.add(exit);
        p1.add(calcHours);
        p1.add(finishTasks);
        p1.add(assignedTasks);
        p1.add(vacations);
        p1.add(penalties);
        p1.add(setTasks);
        //p1.add(t1);
        f1.add(p1);
        f1.setVisible(true);
        
        //Vacation Frame
        
        f2 = new JFrame();
        f2.setSize(400,400);
        f2.setResizable(false);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setLocationRelativeTo(null);
        f2.setTitle("Vacations");
        l2 = new JLabel("Submit The vacation date");
        l2.setBounds(10, 10, 180, 30);
        l2.setVisible(true);
        submitVacation = new JButton("Submit");
        submitVacation.setBounds(120,250,150,30);
        submitVacation.setVisible(true);
        t2 = new JTextArea();
        t2.setBounds(100,80,200,150);
        t2.setVisible(true);
        p2 = new JPanel();
        p2.setLayout(null);
        p2.add(l2);
        p2.add(submitVacation);
        p2.add(t2);
        f2.add(p2);
        
        //set Finished tasks
        f3 = new JFrame();
        f3.setSize(400,400);
        f3.setResizable(false);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f3.setLocationRelativeTo(null);
        f3.setTitle("Finished Tasks");
        l3 = new JLabel("Set Task Name");
        l3.setBounds(10, 10, 180, 30);
        l3.setVisible(true);
        t3 = new JTextArea();
        t3.setBounds(100,80,200,150);
        t3.setVisible(true);
        setFTasks=new JButton("Submit");
        setFTasks.setBounds(120, 250, 150, 30);
        setFTasks.setVisible(true);
        p3 = new JPanel();
        p3.setLayout(null);
        p3.add(l3);
        p3.add(t3);
        p3.add(setFTasks);
        f3.add(p3);
        f3.setVisible(false);
        
        
        entry.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
             try{
             setEntryTime();
             JOptionPane.showMessageDialog(null, "Entry time added successfully");
             }catch(Exception e2){
                 JOptionPane.showMessageDialog(null, "There is an ERROR!!");
             }
         }
        });
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
             try{
             setExitTime();
             JOptionPane.showMessageDialog(null, "Exit time added successfully");
             }catch(Exception e2){
                 JOptionPane.showMessageDialog(null, "There is an ERROR!!");
             }            }
        });
        calcHours.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String Hours = calcMounthlyWorkingHours();
                t1.append("The total mounthly hours is :"+Hours+"\n");
            }
        });
        finishTasks.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              ArrayList<String> tasks = viewFinishedTasks();
              
                  t1.append("Your Finished tasks are :"+tasks+"\n");
              
            }
        });
        assignedTasks.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
              ArrayList<String>  tasks = viewAssignedTasks();
              t1.append("Your assigned tasks are :"+tasks+"\n");
            }
        }
        );
       
        penalties.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String pen=viewPenalties();
                t1.append(pen);
            }
        });
        
        vacations.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                f1.setVisible(false);
                f2.setVisible(true);
        }
    });
        submitVacation.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                String Vacation=t2.getText();
                requestVacations(Vacation);
                t2.setText(null);
                JOptionPane.showMessageDialog(null, "Your Requst was added.");
                f2.setVisible(false);
                f1.setVisible(true);
                }catch(Exception e3){
                    JOptionPane.showMessageDialog(null, "There was an ERROR!!");

                }            
            }
    });
        setTasks.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                f1.setVisible(false);
                f3.setVisible(true);
            }
        });
        setFTasks.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                String Tasks =t3.getText();
                setfinishedTasks(Tasks);
                t3.setText(null);
                JOptionPane.showMessageDialog(null, "Your Finished Task was added.");
                f3.setVisible(false);
                f1.setVisible(true);
                }catch(Exception e4){
                    JOptionPane.showMessageDialog(null, "There was an ERROR!!");

                }
            }
        });
        
        
    }
     @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (Employee x : Employees) {
            if (userName.equals(x.userName) && Pass.equals(x.pass)) {
                this.setId(x.id);
                this.setFname(x.fname);
                this.setLname(x.lname);
                this.setAge(x.age);
                this.setUserName(x.userName);
                this.setPass(x.pass);
                return true;
            }
        }
        return false;
    }
}

