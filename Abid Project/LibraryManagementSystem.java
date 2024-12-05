package lms;


import java.util.*;

class LibraryManagementSystem {
    private List<Book> books = new ArrayList<>();

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
    public void addMembers() {

        Scanner scanner = new Scanner(System.in);

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
}
