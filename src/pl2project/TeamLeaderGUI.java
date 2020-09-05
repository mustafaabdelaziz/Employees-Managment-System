package pl2project;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.*;


public class TeamLeaderGUI extends Employee{
      Employee emp;
JFrame jf=new JFrame();   
JFrame jf2=new JFrame();
JFrame jf3=new JFrame();
JTable table=new JTable();
JLabel id=new JLabel      ("ID: ");
JTextField idtf=new JTextField(5);
JLabel name=new JLabel    ("First Name:  ");
JTextField ntf=new JTextField(100);
JLabel lname=new JLabel("Last Name: ");
JTextField ltf=new JTextField();
JLabel age=new JLabel("Age");
JTextField atf=new JTextField();
JLabel idtask=new JLabel("Task ID:");
JLabel tname=new JLabel("Task Name:");
JTextField tasknamef=new JTextField();
JLabel pid=new JLabel("Project ID:");
JTextField ptf=new JTextField();
JLabel empid=new JLabel("Employee ID");
JTextField emptf=new JTextField();
JLabel user=new JLabel("User Name:");
JTextField usern=new JTextField();
JLabel pass=new JLabel("Password");
JTextField password=new JTextField();
JLabel penid=new JLabel("ID");
JTextField pensid=new JTextField();
JButton Add=new JButton("Add");
JButton Delete=new JButton("Delete");
JButton Display=new JButton("Display All");
JButton Exit=new JButton("Exit");
JButton task=new JButton("Add Task");
JButton gototasks=new JButton("Tasks");
JButton setpen=new JButton("Set Penalties");
JButton gotopens=new JButton("GO TO Penalties");
JTextField t=new JTextField();
JLabel addt=new JLabel("Add Task:");
JButton back=new JButton("Back");
JButton viewcomptasks=new JButton("View Completed Tasks");
JButton backk=new JButton("Back");
JTextArea penta=new JTextArea();
JTextArea displayarea=new JTextArea();
JTextArea comptasks=new JTextArea();
FileWriter fw;
FileReader fr;
Admin x = new Admin();
Tasks TA = new Tasks();
JScrollPane scroll=new JScrollPane(displayarea);
JScrollPane scroll2=new JScrollPane(comptasks);
JScrollPane scroll3=new JScrollPane(penta);


    public TeamLeaderGUI() {
    }


 public void test()
 {
     jf.setSize(800, 500);
     jf.setTitle("TEAM LEADER");
     jf.setVisible(true);
     jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     jf.setResizable(false);
     jf.setLocationRelativeTo(null);
     
     
     jf2.setSize(800, 700);
     jf2.setTitle("Tasks");
     jf2.setVisible(false);
     jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     jf2.setResizable(false);
     jf2.setLocationRelativeTo(null);
     
     jf3.setSize(800, 500);
     jf3.setTitle("Penalties");
     jf3.setVisible(false);
     jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     jf3.setResizable(false);
     jf3.setLocationRelativeTo(null);
     
             
    JPanel p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p2=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p3=new JPanel(new FlowLayout(FlowLayout.CENTER));
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scroll.setVisible(true);
    scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scroll2.setVisible(true);
    scroll3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scroll3.setVisible(true);
    
    
    
    jf.add(p1);
    jf2.add(p2);
    jf3.add(p3);
    p1.setLayout(null);
    p2.setLayout(null);
    p3.setLayout(null);
    id.setBounds(10, 10, 100,25);
    idtf.setBounds(100, 10, 150, 25);
    name.setBounds(10, 50, 100, 25);
    ntf.setBounds(100, 50, 150, 25);
    lname.setBounds(10, 90, 100, 25);
    ltf.setBounds(100, 90, 150, 25);
    age.setBounds(10, 130, 100, 25);
    atf.setBounds(100, 130, 150, 25);
    user.setBounds(10, 170, 100, 25);
    usern.setBounds(100,170 , 150, 25);
    pass.setBounds(10, 210, 100, 25);
    password.setBounds(100, 210, 150, 25);
    
    addt.setBounds(10,10,100,25);
    empid.setBounds(10,50,100,25);
    emptf.setBounds(100, 50, 150, 25);
    idtask.setBounds(10, 90, 100, 25);
    t.setBounds(100, 90, 150, 25);
    tname.setBounds(10, 130, 100, 25);
    tasknamef.setBounds(100, 130, 150, 25);
    pid.setBounds(10, 170, 100, 25);
    ptf.setBounds(100, 170, 150, 25);
    task.setBounds(10,210, 110, 25);
    viewcomptasks.setBounds(10, 260, 200, 25);
    setpen.setBounds(10, 50, 200, 25);
    gotopens.setBounds(200, 500, 200, 25);
    penid.setBounds(10, 100, 100, 25);
    pensid.setBounds(50, 100, 100, 25);
    backk.setBounds(10, 600, 110, 25);
    
    Add.setBounds(10, 250,75,25);
    Delete.setBounds(110, 250,75,25);
    Display.setBounds(200, 250,110,25);
    Exit.setBounds(10, 300,75,25);
    gototasks.setBounds(100,300,100,25);
    back.setBounds(10, 500, 110, 25);
    
    scroll.setBounds(350, 10, 400, 170);   

    scroll2.setBounds(10, 300, 400, 170);
    scroll3.setBounds(10, 150, 400, 170);
    
 
    
    
    p1.add(id);p1.add(idtf);p1.add(name);p1.add(ntf);p1.add(lname);p1.add(ltf);p1.add(age);p1.add(atf);
    p2.add(idtask);p2.add(tname);p2.add(tasknamef);p2.add(pid);p2.add(ptf);p1.add(user);p1.add(usern);p1.add(pass);p1.add(password);
    p1.add(Add);p1.add(Delete);p1.add(Display);p1.add(Exit);p2.add(addt);p1.add(scroll);p2.add(empid);p2.add(emptf);p2.add(back);
    p2.add(t);p2.add(task);p1.add(gototasks);p2.add(viewcomptasks);p2.add(scroll2);p2.add(gotopens);p3.add(setpen);//p3.add(setpens);
    p3.add(scroll3);p3.add(penid);p3.add(pensid);p3.add(backk);
     

      Exit.addActionListener       (event -> Exit ());
      
      
      
      
      Add.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed (ActionEvent e)
         {
             try{
            x.addNewEmployee(usern.getText(),password.getText(),Integer.parseInt(idtf.getText()),ntf.getText(),ltf.getText(),Integer.parseInt(atf.getText()));
            usern.setText("");password.setText("");idtf.setText("");ntf.setText("");ltf.setText("");atf.setText("");
            JOptionPane.showMessageDialog(null, "Employee was added");

             }catch(NumberFormatException x){
                 JOptionPane.showMessageDialog(null, "There was an ERROR!!");
             }
         }
      });
              
      Display.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              ArrayList<Employee> emplist=new ArrayList<Employee>();
              File FilePath = new File("Employee.txt");
              try{
              Scanner scan = new Scanner(FilePath);
              while(scan.hasNext()){
                  String Line =scan.nextLine();
                  String[] saperat = Line.split("@");
                  Employee emp = new Employee(saperat[4],saperat[5],Integer.parseInt(saperat[0]),saperat[1],saperat[2],Integer.parseInt(saperat[3]));
                  emplist.add(emp);
              }
          }catch(FileNotFoundException ex){
              
          }
              displayarea.append("All Employees\n"+emplist+"\n");
              
          }
      });
      
      Delete.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
             int id =Integer.parseInt(idtf.getText());
             ArrayList<Employee> emplist=new ArrayList<Employee>();
              File FilePath = new File("Employee.txt");
              try{
              Scanner scan = new Scanner(FilePath);
              while(scan.hasNext()){
                  String Line =scan.nextLine();
                  String[] saperat = Line.split("@");
                  Employee emp = new Employee(saperat[4],saperat[5],Integer.parseInt(saperat[0]),saperat[1],saperat[2],Integer.parseInt(saperat[3]));
                  emplist.add(emp);
              }
               JOptionPane.showMessageDialog(null, "Employee was deleted.");

          }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "There was an ERROR!!");

          }
              for(int i=0;i<emplist.size();i++){ 
                  if(emplist.get(i).getID()==id){
                      
                   
              emplist.remove(i);
              }
              }
          FileManger FManger = new FileManger();
          FManger.write(emplist.get(0).getEmpData(), "Employee.txt", false);
          for(int i=1;i<emplist.size();i++){
            FManger.write(emplist.get(i).getEmpData(), "Employee.txt", true);
            idtf.setText("");
          }

     }});
      
      task.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              TA.setTasksname(tasknamef.getText());
              TA.setTasksId(Integer.parseInt(t.getText()));
              TA.setTasksPId(Integer.parseInt(ptf.getText()));
              TA.addTasks(Integer.parseInt(emptf.getText()));
// x.addTask(Integer.parseInt(emptf.getText()),tasknamef.getText(),Integer.parseInt(t.getText()),Integer.parseInt(ptf.getText()));
              tasknamef.setText("");t.setText("");ptf.setText("");emptf.setText("");
          }
                  
      });
      gototasks.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              jf.setVisible(false);
              jf2.setVisible(true);
            
          }
                  
      });
      back.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              jf.setVisible(true);
              jf2.setVisible(false);
            
          }
                  
      });
      
      viewcomptasks.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              ArrayList<String> tasklist=new ArrayList<String>();
              File filePath=new File("FinishedTasks.txt");
              try{
              Scanner scan2=new Scanner(filePath);
              while(scan2.hasNext()){
                  String Line =scan2.nextLine();
                  String[] saperat = Line.split("@");
                  tasklist.add(saperat[1]);
                  
              }  
              }catch(FileNotFoundException ex){ 
              }
              comptasks.append("All Tasks\n"+tasklist);
              
              }
          
      });
      gotopens.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              jf2.setVisible(false);
              jf3.setVisible(true);
            
          }
                  
      });
      
      setpen.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              
              String query=pensid.getText()+"@"+penta.getText();
              try{
              FileManger FManger = new FileManger();
              FManger.write(query, "Penalties.txt", true);
                  JOptionPane.showMessageDialog(null, "The Penalty was added");

              jf3.setVisible(false);
              jf2.setVisible(true);
              }catch(Exception e1){
                  JOptionPane.showMessageDialog(null, "There was an ERROR!!");
              }
                          
          }
                  
      });
      
     
      }
              
  
 
          public String getEmpData(){
             return emp.id + "@" + emp.fname + "@" + emp.lname + "@" + emp.age + "@" + emp.userName + "@" + emp.pass + "@";
          

      }
      
   private void Exit ()
   {
      System.exit (0); // All is OK.
   }}