package model;

public class Worker implements Comparable<Worker> {
private String id; // ValidateID
private String name; // check String
private int age; // check input limit
private double salary; // check double
     private double baseSalary;
private String workLocation; // check String
private String date;
private String status ;

    public Worker() {
    }



    public Worker(String id, String name, int age, double salary,double baseSalary, String workLocation, String date, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.baseSalary = baseSalary;
        this.workLocation = workLocation;
        this.date = date;
        this.status = status;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Worker o) {
        return this.getDate().compareTo(o.getDate());
    }
}
