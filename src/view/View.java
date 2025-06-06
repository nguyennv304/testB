package view;

import controller.Validate;

public class View {
    public static int menu(){
        System.out.println("===============model.Worker Managerment===============");
        System.out.println("1. Add Worker");
        System.out.println("2. Increase Salary");
        System.out.println("3. Decrease Salary");
        System.out.println("4. Print List");
        System.out.println("5. Search Worker By Code");
        System.out.println("6. Exit");
        System.out.println("Enter Your Choice");
        int choice = Validate.checkInputLimit(1,6);
        return  choice;
    }


}
