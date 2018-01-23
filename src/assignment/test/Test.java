/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.test;

import assignment.entity.Student;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        // de kiem tra tinh hop le
        boolean isValidName = false;
         while(!isValidName ){ //vong lap luon chay
        System.out.println(" please Enter you name ");
        String value =scanner.nextLine();
        if (value != null && value.length()>10){ 
            student.setName(value);
            
            System.out.println("hello" + value);
            break;//thoat vong lap
        }
             System.out.println(" name's requied");
           
         }
             while(true){ //vong lap luon chay
        System.out.println("please Enter email you ");
        String value =scanner.nextLine();
        if (value != null && value.length()>10){ 
            student.setName(value);
            
            System.out.println("hello" + value);
            break;//thoat vong lap
        }
             System.out.println(" email requied");
           
         }
         
     }

    
}
