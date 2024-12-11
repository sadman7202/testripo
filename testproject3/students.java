package testproject3;

// Java Program to Illustrate students Class
// To Do all the Operations related to students:
// add Students,check-in books,check out books,ValidStudent

// Importing required classes
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// Class
public class students {

    // Creating objects of Scanner and students class
    Scanner input = new Scanner(System.in);
    public student[] theStudents = new student[100];
    public admin[] theAdmins=new admin[10];
    {
        theStudents[0]=new student("Sadman Sakib","241-50-004","1234");
        theStudents[1]=new student("Fahim Shahriar","241-50-002","1252");
        theStudents[2]=new student("Najifa Anjum","241-50-029","password");
        theStudents[3]=new student("Sufia Bindu Nira","241-50-015","2743");
        count=4;
    }


    public static int count = 0;

    // Method 1
    // To add books
    public void addStudent(student s)
    {
        for (int i = 0; i < count; i++) {

            if (s.regNum.equalsIgnoreCase(
                    theStudents[i].regNum)) {

                // Print statement
                System.out.println(
                        "Student of Reg Num " + s.regNum
                                + " is Already Registered.");

                return;
            }
        }

        if (count <= 50) {
            theStudents[count] = s;

            count++;
            System.out.println("STUDENT REGISTERD !");
        }
    }

    // Method 2
    // Displaying all students
    public void showAllStudents()
    {
        // Printing student name and
        // corresponding registered number
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {

            System.out.println(theStudents[i].studentName
                    + "\t\t\t\t"
                    + theStudents[i].regNum);
        }
    }

    // Method 3
    // To check the Student
    public int isStudent()
    {
        // Display message only
        System.out.println("Enter Reg Number:");

        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {

            if (theStudents[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }

        // Print statements
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

    // Method 4
    // To remove the book
    public void checkOutBook(books book)
    {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("checking out");

            book.showAllBooks();
            book b = book.checkOutBook();

            System.out.println("checking out");
            if (b != null) {

                if (theStudents[studentIndex].booksCount
                        <= 3) {

                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks
                            [theStudents[studentIndex]
                            .booksCount]
                            = b;
                    theStudents[studentIndex].booksCount++;

                    return;
                }
                else {

                    System.out.println(
                            "Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }

    // Method 5
    // To add the book
    public void checkInBook(books book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {

            // Printing credentials corresponding to student
            System.out.println(
                    "S.No\t\t\tBook Name\t\t\tAuthor Name");

            student s = theStudents[studentIndex];

            for (int i = 0; i < s.booksCount; i++) {

                System.out.println(
                        s.borrowedBooks[i].sNo + "\t\t\t"
                                + s.borrowedBooks[i].bookName + "\t\t\t"
                                + s.borrowedBooks[i].authorName);
            }

            // Display message only
            System.out.println(
                    "Enter Serial Number of Book to be Checked In:");

            int sNo = input.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                }
            }

            System.out.println("Book of Serial No " + sNo
                    + "not Found");
        }
    }
    //method for login
    public int login()
    {
        // Display message only
        System.out.print("Enter Reg Number: ");

        String regNum = input.nextLine();
        System.out.print("\nEnter Password: ");
        String pass=input.nextLine();


        for (int i = 0; i < count; i++) {

            if (theStudents[i].regNum.equalsIgnoreCase(regNum) &&
                    theStudents[i].password.equals(pass)) {
                return 1;
            }
        }

        // Print statements
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }
   public static int adcount;
    public void addAdmin(admin a)
    {
        for (int i = 0; i < adcount; i++) {

            if (a.regNum.equalsIgnoreCase(
                    theAdmins[i].regNum)) {

                // Print statement
                System.out.println(
                        "Admin of Reg Num " + a.regNum
                                + " is Already Registered.");

                return;
            }
        }
        if(a.getPin!=a.pin){
            System.out.println("!! WRONG PINCODE !!");
            return;
        }

        if (adcount <= 10) {
           theAdmins[adcount] = a;
            adcount++;
            System.out.println("ADMIN REGISTERD !");
        }
    }
    public int Adminlogin()
    {
        // Display message only
        System.out.print("Enter Reg Number: ");

        String regNum = input.nextLine();
        System.out.print("\nEnter Password: ");
        String pass=input.nextLine();


        for (int i = 0; i < adcount; i++) {

            if (theAdmins[i].regNum.equalsIgnoreCase(regNum) &&
                    theAdmins[i].password.equals(pass)) {
                return 1;
            }
        }

        // Print statements
        System.out.println("Admin is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

}
