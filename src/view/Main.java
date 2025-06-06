package view;

import controller.Manager;
import controller.Status;
import model.Worker;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        while (true) {
            int choice = View.menu();
            switch (choice) {
                case 1:
                    Manager.create_Worker(workers);
                    break;
                case 2:
                    Manager.changeSalary(workers, Status.UP);
                    break;
                case 3:
                    Manager.changeSalary(workers,Status.DOWN);
                    break;
                case 4:
                    Manager.printListWorker(workers);
                    break;
                case 5:
                    Manager.searchWorker(workers);
                    break;
                case 6:
                    return;
            }
        }
    }
}