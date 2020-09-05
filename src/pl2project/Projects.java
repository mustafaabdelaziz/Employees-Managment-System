/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2project;

import java.util.ArrayList;

/**
 *
 * @author Mohammed
 */
public class Projects {
 private int ProjectId;
 private String ProjectName;
 FileManger FManger = new FileManger();
     private final String ProjectsFileName = "Projects.txt";
     public static ArrayList<Projects> projects = new ArrayList<Projects>();

 public Projects(){
}
public Projects(String Name,int id){
this.ProjectId=id;
this.ProjectName=Name;
}
 public void setProjectId(int Id) {
        this.ProjectId = Id;
    }
  public void setProjectName(String name) {
        this.ProjectName = name;
    }
   public int getID() {
        return this.ProjectId;
    }
 public int getProjectId() {
        return this.ProjectId;
    }
  public String getProjectname() {
        return this.ProjectName;
    }


 public boolean addProjects() {
        if (FManger.write(getProjectsData(), ProjectsFileName, true)) {
            return true;
        } else {
            return false;
        }
    }
 
 private String getProjectsData() {
        return this.ProjectName + "@" + this.ProjectId + "@" ;
    }
  private void commitToFile() {
        FManger.write(projects.get(0).getProjectsData(), ProjectsFileName, false);
        for (int i = 1; i < projects.size(); i++) {
            FManger.write(projects.get(i).getProjectsData(), ProjectsFileName, true);
        }

    }
 
  private int getProjectIndex(int id){
        for (int i = 0; i < projects.size(); i++)
            if(projects.get(i).getID() == id)
                return i;
        
        return -1;
    }
  private void loadFromFile() {
            projects = (ArrayList<Projects>) (Object) FManger.read(ProjectsFileName);
    }

    public String displayAllProjects() {
        loadFromFile();
        String S = "\nAll Tasks Data:\n";
        for (Projects x : projects) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchProjects(int id){
        loadFromFile();
        int index = getProjectIndex(id);
        if(index != -1)
            return "\nFound ...!" + projects.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateProjects(int oldID, Projects x){
        loadFromFile();
        int index = getProjectIndex(oldID);
        projects.set(index, x);
        commitToFile();
    } 
    
    public void deleteProjects(int id){
        loadFromFile();
        int index = getProjectIndex(id);
        projects.remove(index);
        commitToFile();
    } 
  public boolean addProject() {
        if(FManger.write(getProjectsData(), ProjectsFileName, true)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "\n Project Name : " + ProjectName + "\t" + "Project ID :  "+ProjectId+"\n";
    }
 
 
 
}