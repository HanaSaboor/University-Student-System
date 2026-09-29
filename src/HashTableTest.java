public class HashTableTest {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable(10);

        Student student1 = new Student(
                "S001",
                "Alice",
                "Computer Science",
                90
        );

        Student student2 = new Student(
                "S002",
                "Bob",
                "Information Technology",
                85
        );

        Student student3 = new Student(
                "S003",
                "Charlie",
                "Software Engineering",
                72
        );

        // Insert students
        hashTable.insert(student1);
        hashTable.insert(student2);
        hashTable.insert(student3);

        // Display hash table
        hashTable.display();

        // Search for Alice
        System.out.println();
        System.out.println("Searching for S001:");

        Student found = hashTable.search("S001");

        if (found != null) {
            found.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }
}