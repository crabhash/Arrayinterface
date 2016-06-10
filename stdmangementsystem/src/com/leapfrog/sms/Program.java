 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sms;

import com.leapfrog.sms.ai.dao.StudentDAO;
import com.leapfrog.sms.dao.impl.StudentDAOimpl;
import com.leapfrog.sms.entity.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Abhash
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void menu() {
        System.out.println("===============================");
        System.out.println("MENU");
        System.out.println("1.ADD");
        System.out.println("2 .DELETE");
        System.out.println("3.SHOW ALL");
        System.out.println("4.SEARCH BY ID");
        System.out.println("5.SEARCH BY ALL");
        System.out.println("6.Exit");
        System.out.println("===============================");

        System.out.println("ENTER YOUR CHOICE(1-5): ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO stdDAO = new StudentDAOimpl();
        while (true) {
            menu();
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                      while(true){
                    Student s = new Student();
                    s.setId(stdDAO.getid());
                    System.out.println("Enter First Name:");
                    s.setFirstName(sc.next());
                    System.out.println("Enter last Name:");
                    s.setLastName(sc.next());
                    System.out.println("Enter Email:");
                    s.setEmail(sc.next());
                   
                    stdDAO.insert(s);
                    
                   
                        System.out.println("Do you want to add more:[y/n]");
                        String c=sc.next();
                        if(c.equalsIgnoreCase("n")){
                            break;
                        }
                    }
                    break;
                    
                case 2:
                    while(true){
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    stdDAO.delete(id);
                    
                    
                     System.out.println("Do you want to delete more:[y/n]");
                        String c=sc.next();
                        if(c.equalsIgnoreCase("n")){
                            break;
                        }
                    }
                    break;
                    
                case 3:
                    stdDAO.getAll().forEach(a -> {
                        if (a != null) {
                            System.out.println(a.getId() + "," + a.getFirstName() + "," + a.getLastName() + "," + a.getEmail());
                        }
                    });
                    break;
                case 4:
                    System.out.println("Enter your ID to be search");
                     int s=sc.nextInt();
                    System.out.println(stdDAO.getById(s).getId() + "," + stdDAO.getById(s).getFirstName() + "," + stdDAO.getById(s).getLastName() + "," + stdDAO.getById(s).getEmail());
                    break;
                    
                case 5:
                    System.out.println("Search By Any->");
                    String a=sc.next();
                    stdDAO.getbyany(a);
                    break;
                   case 6:
                    System.exit(0);
                       break;
                default:
                    System.out.println("Invalid command");

            }
            System.out.println("Do you want to go to Menu[Y/N]");
            String chh = sc.next();
            if (chh.equalsIgnoreCase("n")) {
                System.exit(0);

            }

        }
    }
}
