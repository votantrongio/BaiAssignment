/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.main;

import assignment.controller.StudentController;
import assignment.entity.Student;
import assignment.model.StudentModel;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admintu
 */
public class MainThread {

    public static void main(String[] args) {
        StudentController controll = new StudentController();
        System.out.println("====Menu======= ");
        System.out.println("1.ListStudent");
        System.out.println("2.AddStudent");

        System.out.println("3.EditStudent");
        System.out.println("4.DeteleStudent");
        System.out.println("5. Exit");
        int choose;
        System.out.println("moi ban nhap so");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (true) {
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    controll.printStudentList();
                    break;
                case 2:
                    controll.addStudent();
                    break;
                case 3:
                    controll.editStudent();
                    break;
                case 4:
                    StudentModel.DeteleStudent();
                case 5:
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.err.println(" err ");
                    break;

            }
            if (exit) {
                break;
            }
            System.out.println("====Menu======= ");
            System.out.println("1.ListStudent");
            System.out.println("2.AddStudent");

            System.out.println("3.EditStudent");
            System.out.println("4.DeteleStudent");
            System.out.println("5. Exit");
            System.out.println("moi ban nhap so");
        }

    }
}
