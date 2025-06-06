package controller;

import model.Worker;

import java.util.ArrayList;
import java.util.Scanner;

public class Validate {
    static Scanner sc = new Scanner(System.in);

//    public static boolean validateID(String id) {
//        return id.length() == 3 &&  id.startsWith("C",0) && id.startsWith("N",1) && Character.isDigit(id.charAt(2));
//    }
    public static String checkString(){
        while(true){
            try{
                String result = sc.nextLine();
                if(!result.matches("^[a-zA-Z\\s]+$")){
                    throw new StringIndexOutOfBoundsException();
                }
                if(result.isEmpty()){
                    throw new RuntimeException();
                }
                return result;
            }
            catch(StringIndexOutOfBoundsException e ){
                System.err.println("Cannot having special character");
                System.out.println("Enter again: ");
            }
            catch(RuntimeException e){
                System.out.println("Cannot be empty");
                System.out.println("Enter again: ");
            }
        }
    }
    public static int checkInputLimit(int a , int b ){
        while(true){
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result<a || result>b){
                    throw new NumberFormatException();
                }
                return result;
            }
            catch(NumberFormatException e ){
                System.err.println("Out of bound!!!");
                System.out.println("Enter again: ");
            }
        }
    }
    public static double checkInputDouble(){
        while(true){
            try{
                double result = Double.parseDouble(sc.nextLine().trim());
                if(result<0){
                    throw new NumberFormatException();
                }
                return result;
            }
            catch(NumberFormatException e ){
                System.err.println("Please enter the right input!!!");
                System.out.println("Enter again: ");
            }
        }
    }
    public static boolean checkCodeExist(ArrayList<Worker> lw, String id){
        for(Worker worker : lw){
            if(id.equalsIgnoreCase(worker.getId()) ){
                return true;
            }
        }
        return false;
    }



}
