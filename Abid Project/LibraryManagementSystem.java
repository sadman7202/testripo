package lms;


import java.util.*;

class LibraryManagementSystem {
    Scanner scanner = new Scanner(System.in);
    private List<Book> books = new ArrayList<>();
    {
        books.add(new Book(1, "Harry Potter and the Sorcerer's Stone","J.K. Rowling"));
        books.add(new Book(2, "Dune","Frank Herbert"));
        books.add(new Book(3, "Gone Girl","Gillian Flynn"));
        books.add(new Book(4, "Pather Panchali","Bibhutibhushan Bandopadhyay"));
        books.add(new Book(5, "Shesher Kobita","Rabindranath Tagore"));
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // View all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    // Update a book's details
    public void updateBook(int isbn, String newTitle, String newAuthor) {
        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                b.setTitle(newTitle);
                b.setAuthor(newAuthor);
                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    // Delete a book by ISBN
    public void deleteBook(int isbn) {
        if (books.removeIf(b -> b.getIsbn() == isbn)) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    // Search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }
    private static List<Member> members = new ArrayList<>();
    {
        members.add(new Member("Mehedi Hasan", "241-50-001"));
        members.add(new Member("Fahim Shahriar", "241-50-002"));
        members.add(new Member("Taohid Ayon", "241-50-003"));
        members.add(new Member("Sadman Sakib", "241-50-004"));
        members.add(new Member("Abid Chowdhury", "241-50-011"));
    }
    public void addMembers() {



        System.out.print("Enter Member name: ");

        String name = scanner.nextLine();

        System.out.print("Enter Member ID: ");

        String ID = scanner.nextLine();





        Member member =new Member(name,ID);


        members.add(member);

        System.out.println("Member added successfully!");


    }
    public void displayMemberInfo() {
        System.out.println("Member Information:");
        for (Member member : members) {
            System.out.println("Name: " + member.getName());
            System.out.println("ID: " + member.getId());
            System.out.println("Borrowed Books:");

            System.out.println("------------------------");
        }
    }
    int count;
    public admin[] theAdmins=new admin[10];
    public void addAdmin(admin a)
    {
        for (int i = 0; i < count; i++) {

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

        if (count <= 10) {
            theAdmins[count] = a;
            count++;
            System.out.println("ADMIN REGISTERD !");
        }
    }
    public int Adminlogin()
    {
        // Display message only
        System.out.print("Enter Reg Number: ");

        String regNum = scanner.nextLine();
        System.out.print("\nEnter Password: ");
        String pass=scanner.nextLine();


        for (int i = 0; i < count; i++) {

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
