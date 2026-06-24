class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}
class Author extends Book {
    String name;
    String bio;
    Author(String title,
           int publicationYear,
           String name,
           String bio) {

        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    void displayInfo() {

        System.out.println("Title : " + title);
        System.out.println("Year : " + publicationYear);
        System.out.println("Author : " + name);
        System.out.println("Bio : " + bio);
    }
}

public class LibraryDemo {
    public static void main(String[] args) {

        Author a =
                new Author(
                        "Java Programming",
                        2024,
                        "James Gosling",
                        "Creator of Java");

        a.displayInfo();
    }
}
