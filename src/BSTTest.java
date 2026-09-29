public class BSTTest {

    public static void main(String[] args) {

        BST bst = new BST();

        Student student1 = new Student(
                "S002",
                "Bob",
                "Information Technology",
                85
        );

        Student student2 = new Student(
                "S001",
                "Alice",
                "Computer Science",
                90
        );

        Student student3 = new Student(
                "S003",
                "Charlie",
                "Software Engineering",
                72
        );

        // Insert students into BST
        bst.insert(student1);
        bst.insert(student2);
        bst.insert(student3);

        // Display students in Student ID order
        System.out.println("Students in BST:");
        bst.displayInOrder();

        // Search for Alice
        System.out.println("Searching for S001:");

        Student found = bst.search("S001");

        if (found != null) {
            found.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }
}