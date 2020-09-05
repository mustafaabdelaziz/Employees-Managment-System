/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class TeamLeader extends Person {
// private JFrame f;
// private JButton b,b1,b2,b3,b4,b5,b6;
 Scanner input = new Scanner(System.in);
 private final String TeamLeaderFileName = "TeamLeader.txt";
    
    public static ArrayList<TeamLeader> Leader = new ArrayList<TeamLeader>();

    public TeamLeader() {

    }

    public TeamLeader(String user, String pass, int id, String fname, String lname, int age) {
        super(user, pass, id, fname, lname, age);

    }
    

    private String getTeamLeaderData() {
        return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.userName + "@" + this.pass + "@";
    }

    private void commitToFile() {
        FManger.write(Leader.get(0).getTeamLeaderData(), TeamLeaderFileName, false);
        for (int i = 1; i < Leader.size(); i++) {
            FManger.write(Leader.get(i).getTeamLeaderData(), TeamLeaderFileName, true);
        }

    }

    private int getTeamLeaderIndex(int id){
        for (int i = 0; i < Leader.size(); i++)
            if(Leader.get(i).getID() == id)
                return i;
        
        return -1;
    }
    
    private void loadFromFile() {
            Leader = (ArrayList<TeamLeader>) (Object) FManger.read(TeamLeaderFileName);
    }
    public boolean addTeamLeader() {
        if (FManger.write(getTeamLeaderData(), TeamLeaderFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    public String displayAllTeamLeader() {
        loadFromFile();
        String S = "\nAll TeamLeaders Data:\n";
        for (TeamLeader x : Leader) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchTeamLeader(int id){
        loadFromFile();
        int index = getTeamLeaderIndex(id);
        if(index != -1)
            return "\nFound ...!" + Leader.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateTeamLeader(int oldID, TeamLeader x){
        loadFromFile();
        int index = getTeamLeaderIndex(oldID);
        Leader.set(index, x);
        commitToFile();
    } 
    
    public void deleteTeamLeader(int id){
        loadFromFile();
        int index = getTeamLeaderIndex(id);
        Leader.remove(index);
        commitToFile();
    } 
    
    @Override
    public String toString() {
        return "\nI'm Team Leader : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + "\n"
                + "\nUserName: " + userName + "\t Password: " + pass + "\n";
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
    
    public void addTask(String TaskName,int TaskId,int ProjectId) {
        Tasks x = new Tasks(TaskName,TaskId,ProjectId);
        if (x.addTask()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }
    
           @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (TeamLeader x : Leader) {
            if (userName.equals(x.userName) && Pass.equals(x.pass)) {
                return true;
            }
        }
        return false;
    }
    
    
}

