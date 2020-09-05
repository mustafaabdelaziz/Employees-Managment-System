package pl2project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class FileManger {
     public boolean write(String Query, String FilePath, boolean appendType) {

        PrintWriter writter = null;
        try {
            System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writter.println(Query);

            System.out.println(" ... Done ! ");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }

    public ArrayList<Object> read(String FilePath) {
        
        Scanner Reader = null;
        try {
            System.out.println("Reading ! From " + FilePath);

            Reader = new Scanner(new File(FilePath));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        if (FilePath.equals("Employee.txt")) {
           
            ArrayList<Employee> Employees = new ArrayList<Employee>();
            Employee x;

            while (Reader.hasNext()) {

                x = new Employee();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

               
                x.setID(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setUserName(seprated[4]);
                x.setPass(seprated[5]);

                Employees.add(x);
            }

            return (ArrayList<Object>) (Object) Employees;
             

        } else if (FilePath.equals("TeamLeader.txt")) {
            ArrayList<TeamLeader> leader = new ArrayList<TeamLeader>();
            TeamLeader x;

            while (Reader.hasNext()) {

                x = new TeamLeader();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");
                x.setID(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setUserName(seprated[4]);
                x.setPass(seprated[5]);

                leader.add(x);
            }

            return (ArrayList<Object>) (Object) leader;
            

        } else if (FilePath.equals("ProjectManger.txt")) {

            ArrayList<ProjectManger> PMs = new ArrayList<ProjectManger>();
            ProjectManger x;

            while (Reader.hasNext()) {

                x = new ProjectManger();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                x.setID(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setUserName(seprated[4]);
                x.setPass(seprated[5]);

                PMs.add(x);
            }

            return (ArrayList<Object>) (Object) PMs;

        } 
         else if (FilePath.equals("Tasks.txt")) {

            ArrayList<Tasks> Task = new ArrayList<Tasks>();
            Tasks x;

            while (Reader.hasNext()) {

                x = new Tasks();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                x.setTasksname(seprated[0]);
                
                x.setTasksId(Integer.parseInt(seprated[1]));
                x.setTasksPId(Integer.parseInt(seprated[2]));
                Task.add(x);
            }

            return (ArrayList<Object>) (Object) Task;
       
        } 
         else if (FilePath.equals("Projects.txt")) {

            ArrayList<Projects> Project = new ArrayList<Projects>();
            Projects x;

            while (Reader.hasNext()) {

                x = new Projects();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                x.setProjectName(seprated[0]);
                
                x.setProjectId(Integer.parseInt(seprated[1]));
                Project.add(x);
            }

            return (ArrayList<Object>) (Object) Project;
         
         }else {
            return null;
        }

    }   


        }
