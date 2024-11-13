package testproject3;



// Importing required classes
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Class
public class book {

    // Class data members
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    // Creating object of Scanner class to
    // read input from users
    Scanner input = new Scanner(System.in);

    // Method
    // To add book details
    public book()
    {
        // Display message for taking input later
        // taking input via
        // nextInt() and nextLine() standard methods
        System.out.println("Enter Serial No of Book:");
        this.sNo = input.nextInt();
        input.nextLine();
         System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();

        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
        try {
            FileWriter writer=new FileWriter("bookData.txt");
            writer.write("SL NO: "+sNo+"\nAuthor Name: "+authorName+"\nQuantity: "+bookQty+"\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public book(int sl,String n,String a,int q){
        this.sNo=sl;
        this.bookName=n;
        this.authorName=a;
        this.bookQty=q;

    }
}
