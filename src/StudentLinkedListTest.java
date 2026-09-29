public class StudentLinkedListTest {

    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        Student student1 = new Student(
                "S001",
                "Alice",
                "Computer Science",
                78
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

        // Add students
        list.addStudent(student1);
        list.addStudent(student2);
        list.addStudent(student3);

        // Display all students
        System.out.println("All Students:");
        list.displayAllStudents();

        // Search student
        System.out.println("Searching for S002:");

        Student found = list.searchStudent("S002");

        if (found != null) {
            found.displayStudent();
        } else {
            System.out.println("Student not found.");
        }

        // Update Alice
        System.out.println();
        System.out.println("Updating Alice...");

        boolean updated = list.updateStudent(
                "S001",
                "Alice",
                "Computer Science",
                90
        );

        if (updated) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("Updated Alice:");

        Student updatedStudent = list.searchStudent("S001");

        if (updatedStudent != null) {
            updatedStudent.displayStudent();
        }

        // Delete Charlie
        System.out.println();
        System.out.println("Deleting Charlie...");

        boolean deleted = list.deleteStudent("S003");

        if (deleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }

        // Display students after deletion
        System.out.println("Students after deletion:");
        list.displayAllStudents();
    }
}