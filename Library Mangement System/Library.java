package testproject3;
import java.util.Scanner;
public class Library {


    // Main driver method
    public static void main(String[] args) {
        // Creating object of Scanner class
        Scanner input = new Scanner(System.in);
        books ob = new books();
        int choice;
        int searchChoice;

        // Displaying menu
        System.out.println(
                "********************Welcome to the DIU Library!********************");
        System.out.println(
                "                 Select From The Following Options:                 ");
        System.out.println(
                "**********************************************************************");
        int primaryChoice;
        students obStudent = new students();

        do {
            System.out.println("1. LOGIN\n2. REGISTER\n0. CLOSE THE APPLICATION");
            primaryChoice = input.nextInt();

            switch (primaryChoice) {
                case 1:
                    System.out.print("1. LOGIN AS STUDENT\n2. LOGIN AS ADMIN: ");
                    int secondaryChoice2 = input.nextInt();
                    switch (secondaryChoice2) {
                        case 1: {
                            int reminder = obStudent.login();
                            if (reminder != -1) {
                                // Creating menu using do-while loop
                                do {
                                    ob.dispMenu1();
                                    choice = input.nextInt();

                                    // Switch case
                                    switch (choice) {
                                        case 1:
                                            ob.showAllBooks();
                                            break;

                                        case 2:
                                            System.out.println("Press 1 to Search with Book Serial No.");
                                            System.out.println("Press 2 to Search with Book's Author Name.");
                                            searchChoice = input.nextInt();

                                            // Nested switch
                                            switch (searchChoice) {
                                                case 1:
                                                    ob.searchBySno();
                                                    break;
                                                case 2:
                                                    ob.searchByAuthorName();
                                                    break;
                                                default:
                                                    System.out.println("Invalid choice!");
                                                    break;
                                            }
                                            break;

                                        case 3:
                                            obStudent.checkOutBook(ob);
                                            break;

                                        case 4:
                                            obStudent.checkInBook(ob);
                                            break;

                                        default:
                                            System.out.println("ENTER BETWEEN 0 TO 8.");
                                    }
                                } while (choice != 0);
                            }
                            break;
                        }

                        case 2: {
                            int reminder2 = obStudent.Adminlogin();
                            if (reminder2 != -1) {
                                do {
                                    ob.dispMenu2();
                                    choice = input.nextInt();
                                    switch (choice) {
                                        case 1:
                                            book b = new book();
                                            ob.addBook(b);
                                            break;

                                        case 2:
                                            ob.upgradeBookQty();
                                            break;

                                        case 3:
                                            ob.showAllBooks();
                                            break;

                                        case 4:
                                            student a = new student();
                                            obStudent.addStudent(a);
                                            break;

                                        case 5:
                                            obStudent.showAllStudents();
                                            break;

                                        default:
                                            System.out.println("ENTER BETWEEN 0 TO 8.");
                                    }
                                } while (choice != 0);
                            }
                            break;  // Added break to prevent fall-through
                        }
                         // End of LOGIN switch case
                    }
                    break;  // End of LOGIN case in primaryChoice switch

                case 2: // REGISTER
                    System.out.print("1. REGISTER AS STUDENT\n2. REGISTER AS ADMIN: ");
                    int secondaryChoice = input.nextInt();
                    switch (secondaryChoice) {
                        case 1:
                            student s = new student();
                            obStudent.addStudent(s);
                            break;
                        case 2:
                            admin a = new admin();
                            obStudent.addAdmin(a);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                    break;  // End of REGISTER case in primaryChoice switch
            }
        } while (primaryChoice != 0);

        System.out.println("Application closed.");
    }
}
