package pl2project;


public abstract class Person {
    protected int id;
    protected String userName;
    protected String pass;
    protected String fname;
    protected String lname;
    protected int age;

    FileManger FManger = new FileManger();

    //static MyException MyEX = new MyException("Tamer Exception");

    public Person() {
    }

    public Person(String user, String pass, int id, String fname, String lname, int age) {
             
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.userName = user;
        this.pass = pass;
    }

   @Override
    public abstract String toString();

    //setter
    public void setID(int id) {
        this.id = id;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    //getter
    public String getuserName() {
        return this.userName;
    }

    public String getPass() {
        return this.pass;
    }

    public int getID() {
        return this.id;
    }

    public String getFName() {
        return this.fname;
    }

    public String getLName() {
        return this.lname;
    }

    public int getAge() {
        return this.age;
    }

    public boolean login(String userName, String Pass) {
        if (userName.equals("a") && Pass.equals("1")) {
            return true;
        }
        return false;
    }
}


