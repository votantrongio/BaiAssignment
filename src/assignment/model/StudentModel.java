/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.model;

import assignment.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class StudentModel {

   

    public ArrayList<Student> getListStudent() {

        ArrayList<Student> listStudent = new ArrayList<>();

        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return listStudent;
        }
        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from student");

            while (rs.next()) {
                int id = rs.getInt("id");
                String rollNumber = rs.getString("rollNumber");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int status = rs.getInt("status");

                Student student = new Student(id, rollNumber, name, phone, email, status);

                listStudent.add(student);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return listStudent;
    }

    public boolean insert(Student student) {

        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return false;
        }
        try {
            String sqlInsert = "insert into student(rollNumber,name,phone,email) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, student.getRollNumber());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return false;
    }

    public Student getById(int id) {
        Student student = new Student();
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return null;
        }
        try {
            Statement stt = connection.createStatement();
            ResultSet rs = stt.executeQuery("select * from student where id = " + id);
            while (rs.next()) {
                int studentId = rs.getInt("id");
                String studentRollNumber = rs.getString("rollNumber");
                String studentName = rs.getString("name");
                String studentPhone = rs.getString("phone");
                String studentEmail = rs.getString("email");
                int studentStatus = rs.getInt("status");

                student = new Student(studentId, studentRollNumber, studentName, studentPhone, studentEmail, studentStatus);
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        return student;
    }

    public void update(Student existStudent, int id) {
        Connection connection = ConnectionHelper.getConnection();
        String sqlUpdate = "UPDATE student set name = ?, email = ?, phone = ? WHERE id = " + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, existStudent.getName());
            preparedStatement.setString(2, existStudent.getEmail());
            preparedStatement.setString(3, existStudent.getPhone());
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
     public static void DeteleStudent() {
         Connection connection = ConnectionHelper.getConnection();
        Scanner sc = new Scanner(System.in);
        int studentid;
        System.out.println(" nhap id can xoa");
        studentid =sc.nextInt();
        String sql = "UPDATE student SET status = ? WHERE student.id = ?";
      
        try {
          
            PreparedStatement stt = connection.prepareStatement(sql);
            stt.setInt(1,-1);
            stt.setInt(2,studentid);            
            stt.execute();

        } catch (SQLException ex) {
            System.err.println(ex);

        } catch (Exception e) {
        }
        
    } 
    
    }
      
