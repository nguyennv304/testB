package controller;

import model.Worker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Manager {

    public static void create_Worker(ArrayList<Worker> lw) {
        System.out.println(" Enter ID: ");
        String id = Validate.checkString();
        if(Validate.checkCodeExist(lw,id)){
            System.err.println("Code Exist!");
            System.out.println("Enter again!");
            return;
        }
        System.out.println("Enter name: ");
        String name = Validate.checkString();
        System.out.println("Enter age: ");
        int age = Validate.checkInputLimit(18,50);
        System.out.println("Enter Salary: ");
        double salary = Validate.checkInputDouble();
        System.out.println("Enter Work Location: ");
        String workLocation = Validate.checkString();
        lw.add(new Worker(id,name,age,salary,salary,workLocation,"-----","Current"));
        System.out.println("Add sucessful");
    }
    public static void changeSalary(ArrayList<Worker> lw, Enum<Status> statusEnum){
        System.out.println("Enter id: ");
        String id = Validate.checkString();
        Worker worker = getWorkerByCode(lw, id);
        if(!Validate.checkCodeExist(lw,id)){
            System.err.println("Code Doesn't Exist!");
            System.out.println("Enter again!");
            return;
        }
        double salaryCurrent = worker.getSalary();
        double salaryUpdate;
        Status status = Status.UP;
        if( statusEnum == status.UP ){
            System.out.println("Enter New Salary: ");
            while (true) {
                salaryUpdate = Validate.checkInputDouble();
                //check user input salary update > salary current
                if (salaryUpdate <= salaryCurrent) {
                    System.err.println("Must be greater than current salary.");
                    System.out.print("Enter again: ");
                } else {
                    break;
                }
            }

            lw.add(new Worker(worker.getId(), worker.getName(), worker.getAge(), salaryUpdate,salaryCurrent, worker.getWorkLocation(), getCurrentDate(),"UP "+Math.round(((salaryUpdate- salaryCurrent)/ salaryCurrent)*100)+" %"));


        }else{

                System.out.print("Enter salary: ");
                //loop until user input salary update < salary current
                while (true) {
                    salaryUpdate = Validate.checkInputDouble();
                    //check user input salary update < salary current
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }

                lw.add(new Worker(worker.getId(), worker.getName(), worker.getAge(),salaryUpdate,salaryCurrent, worker.getWorkLocation(), getCurrentDate(),"DOWN "+ Math.round(((salaryCurrent - salaryUpdate) / salaryCurrent)*100)+" %"));


        }

                worker.setSalary(salaryUpdate);
                System.err.println("Update success");

    }
    public static void printListWorker(ArrayList<Worker> lw){
            if(lw.isEmpty()){
                System.out.println("List Empty");
                return;
            }
        System.out.printf("%-5s%-15s%-5s%-15s%-15s%-20s%-15s%-15s\n", "Code", "Name", "Age",
                "Salary After","Base Salary" ,"controller.Status", "Date","Location");
        Collections.sort(lw);
        for(Worker worker : lw){
            prinWorker(worker);
        }
    }
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
    public static void prinWorker(Worker worker) {

        System.out.printf("%-5s%-15s%-5s%-15s%-15s%-20s%-15s%-15s\n", worker.getId(),
                worker.getName(), worker.getAge(), worker.getSalary(),worker.getBaseSalary(),
                worker.getStatus(), worker.getDate(),worker.getWorkLocation());
    }
    public static Worker getWorkerByCode(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }
    public static void searchWorker(ArrayList<Worker> lw){
        System.out.println("Enter id: ");
        String id = Validate.checkString();
        ArrayList<Worker> listFoundByCode = listFoundByCode(lw, id);
        if(listFoundByCode.isEmpty()){
            System.out.println("Cannot Found " + id);
        }
        else{

            System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s%-15s%-15s\n", "Code", "Name", "Age",
                    "Salary","Base Salary","Location","controller.Status","Date");
            for(Worker worker : listFoundByCode){

                System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s%-15s%-15s\n", worker.getId(),
                        worker.getName(), worker.getAge(), worker.getSalary(),worker.getBaseSalary(),
                        worker.getWorkLocation(),worker.getStatus(),worker.getDate());
            }
        }


    }




    public static ArrayList<Worker> listFoundByCode(ArrayList<Worker> lw , String id){
        ArrayList<Worker> listFoundByCode = new ArrayList<>();
        for(Worker worker : lw ){
            if(worker.getId().equalsIgnoreCase(id) ){
                listFoundByCode.add(worker);
            }
        }
        return listFoundByCode;

    }




}
