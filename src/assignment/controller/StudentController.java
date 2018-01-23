/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.controller;

import assignment.entity.Student;
import assignment.model.ConnectionHelper;
import assignment.model.StudentModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class StudentController {

    private final StudentModel model = new StudentModel();

    public void printStudentList() {
        ArrayList<Student> list = model.getListStudent();
        System.out.println("=======Student list======");
        System.out.println("Id \t Name");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId() + "\t" + student.getName());
        }
        System.out.println("==========================");
    }

    public void addStudent() {
        Student student = new Student();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Please enter your name: ");

            String value = scanner.nextLine();

            if (value != null && value.length() > 5) {
                student.setName(value);
                break;
            }
            System.out.println("Name's required.");
        }

        while (true) {

            System.out.println("Please enter your email: ");

            String value = scanner.nextLine();

            if (value != null && value.length() > 0) {
                student.setEmail(value);
                break;
            }
            System.out.println("Email's required.");
        }

        while (true) {

            System.out.println("Please enter your roll number: ");

            String value = scanner.nextLine();

            if (value != null && value.length() > 0) {
                student.setRollNumber(value);
                break;
            }
            System.out.println("Rollnumber's required.");
        }

        while (true) {

            System.out.println("Please enter your phone: ");

            String value = scanner.nextLine();

            if (value != null && value.length() > 0) {
                student.setPhone(value);
                break;
            }
            System.out.println("Phone's required.");
        }
        model.insert(student);
        System.out.println("============================");
    }

    public void editStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====Edit student========");
        System.out.println("Please enter student id:");
        int id = scanner.nextInt();
        Student existStudent = model.getById(id);
        if (existStudent == null) {
            System.out.println("Student is not exists or has been deleted!");

        } else {
            System.out.println("Student information");
            System.out.println("Id:" + existStudent.getId());
            System.out.println("RollNumber" + existStudent.getRollNumber());
            System.out.println("Name" + existStudent.getName());
            System.out.println("Phone" + existStudent.getPhone());
            System.out.println("Email" + existStudent.getEmail());
            System.out.println("------------------------------");
            System.out.println("Please enter new name :");
            String name = scanner.nextLine();
            System.out.println(" vui long nhap email");
            String email = scanner.nextLine();
            System.out.println(" vui long nhap phone");
            String phone = scanner.nextLine();

            existStudent.setName(name);
            existStudent.setEmail(email);
            existStudent.setPhone(phone);
            model.update(existStudent, id);
            System.out.println(" Update success");

        }
    }
    
   
}

          

