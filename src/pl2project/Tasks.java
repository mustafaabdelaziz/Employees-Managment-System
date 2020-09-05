package pl2project;

import java.util.ArrayList;

/**
 *
 * @author Mohammed
 */
public class Tasks {
     private String TName;
     private int TId,PId;
     private int id;
     FileManger FManger = new FileManger();
    private final String TasksFileName = "Tasks.txt";
     public static ArrayList<Tasks> tasks = new ArrayList<Tasks>();

    
    public Tasks(){
    }
    
    public Tasks(String Tname, int TId,int PId) {
        this.TName = Tname;
        this.TId = TId;
        this.PId=PId;
        
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setTasksId(int Id) {
        this.TId = Id;
    }
     public void setTasksPId(int Id) {
        this.PId = Id;
    }
     public int getID() {
        return this.TId;
    }
    public void setTasksname(String name) {
        this.TName = name;
    }
    public int getTasksId() {
        return this.TId;
    }
    public int getTasksPId() {
        return this.PId;
    }

    public String getTasksname() {
        return this.TName;
    }
          public boolean addTasks(int id) {
              String Quary = id+"@"+getTasksData();
        if (FManger.write(Quary, TasksFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getTasksData() {
        return this.TName + "@" + this.TId + "@" + this.PId + "@";
    }

      
    private void commitToFile() {
        FManger.write(tasks.get(0).getTasksData(), TasksFileName, false);
        for (int i = 1; i < tasks.size(); i++) {
            FManger.write(tasks.get(i).getTasksData(), TasksFileName, true);
        }

    }

    private int getTasksIndex(int id){
        for (int i = 0; i == tasks.size(); i++)
            if(tasks.get(i).getID() == id)
                return i;
        
        return -1;
    }
    
    private void loadFromFile() {
            tasks = (ArrayList<Tasks>) (Object) FManger.read(TasksFileName);
    }

    public String displayAllTasks() {
        loadFromFile();
        String S = "\nAll Tasks Data:\n";
        for (Tasks x : tasks) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchTasks(int id){
        loadFromFile();
        int index = getTasksIndex(id);
        if(index != -1)
            return "\nFound ...!" + tasks.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateTasks(int oldID, Tasks x){
        loadFromFile();
        int index = getTasksIndex(oldID);
        tasks.set(index, x);
        commitToFile();
    } 
    
    public void deleteTasks(int id){
        loadFromFile();
        int index = getTasksIndex(id);
        tasks.remove(index);
        commitToFile();
    } 
  public boolean addTask() {
        if(FManger.write(getTasksData(), TasksFileName, true)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "\nTasks Name : " + TName + "\t" + "Task ID : " + TId + "\t"+"Project ID :  "+PId+"\n";
    }
}
