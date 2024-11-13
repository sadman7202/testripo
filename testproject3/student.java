package testproject3;

// Java Program to Illustrate Student Class
// to take Input from the student and related Information

// Importing required classes
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Class
public class student {

    // Class member variables
    String studentName;
    String regNum;
    String password;

    book borrowedBooks[] = new book[3];
    public int booksCount = 0;

    // Creating object of Scanner class to
    // take input from user
    Scanner input = new Scanner(System.in);

    // Constructor
    public student()
    {
        // Print statement
        System.out.println("Enter Student Name:");

        // This keywords refers to current instance
        this.studentName = input.nextLine();

        // Print statement
        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
        System.out.println("Enter Password: ");
        this.password=input.nextLine();
        try {
            FileWriter writer=new FileWriter("studentData.txt");
            writer.write("Student Name: "+studentName+"\nRegistration Number: "+regNum+"\nPassword: "+password+"\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public student(String name,String regnum,String password){
        this.studentName=name;
        this.regNum=regnum;
        this.password=password;
    }
}
