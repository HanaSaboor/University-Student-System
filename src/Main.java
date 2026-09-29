import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentLinkedList studentList = new StudentLinkedList();
        Stack actionStack = new Stack();
        Queue serviceQueue = new Queue();
        BST bst = new BST();
        HashTable hashTable = new HashTable(10);
        Graph graph = new Graph();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("==============================================");
            System.out.println(" UNIVERSITY STUDENT & CAMPUS SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Add Student Record");
            System.out.println("2. Update Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Display All Student Records");
            System.out.println("5. Add Service Request");
            System.out.println("6. Process Next Service Request");
            System.out.println("7. Display Recent Actions");
            System.out.println("8. Display Students using BST");
            System.out.println("9. Search Student using Hashing");
            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Campus Connection");
            System.out.println("13. Remove Campus Connection");
            System.out.println("14. Display Campus Connections");
            System.out.println("15. Traverse Campus using BFS");
            System.out.println("16. Traverse Campus using DFS");
            System.out.println("17. Exit");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");

            String choiceInput = scanner.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a number from 1 to 17.");
                continue;
            }

            switch (choice) {

                // ==========================================
                // 1. ADD STUDENT
                // ==========================================

                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine().trim();

                    if (studentId.isEmpty()) {
                        System.out.println("Student ID cannot be empty.");
                        break;
                    }

                    if (studentList.searchStudent(studentId) != null) {
                        System.out.println("Student ID already exists.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Programme: ");
                    String programme = scanner.nextLine().trim();

                    if (programme.isEmpty()) {
                        System.out.println("Programme cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Marks: ");
                    String marksInput = scanner.nextLine();

                    double marks;

                    try {
                        marks = Double.parseDouble(marksInput);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid marks. Please enter a number.");
                        break;
                    }

                    if (marks < 0 || marks > 100) {
                        System.out.println(
                                "Invalid marks. Enter a value between 0 and 100.");
                        break;
                    }

                    Student student = new Student(
                            studentId,
                            name,
                            programme,
                            marks
                    );

                    studentList.addStudent(student);
                    bst.insert(student);
                    hashTable.insert(student);

                    actionStack.push("Added student " + studentId);

                    System.out.println("Student added successfully.");
                    break;

                // ==========================================
                // 2. UPDATE STUDENT
                // ==========================================

                case 2:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine().trim();

                    if (updateId.isEmpty()) {
                        System.out.println("Student ID cannot be empty.");
                        break;
                    }

                    Student existingStudent =
                            studentList.searchStudent(updateId);

                    if (existingStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine().trim();

                    if (newName.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter new Programme: ");
                    String newProgramme = scanner.nextLine().trim();

                    if (newProgramme.isEmpty()) {
                        System.out.println("Programme cannot be empty.");
                        break;
                    }

                    System.out.print("Enter new Marks: ");
                    String newMarksInput = scanner.nextLine();

                    double newMarks;

                    try {
                        newMarks = Double.parseDouble(newMarksInput);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid marks. Please enter a number.");
                        break;
                    }

                    if (newMarks < 0 || newMarks > 100) {
                        System.out.println(
                                "Invalid marks. Enter a value between 0 and 100.");
                        break;
                    }

                    boolean updated = studentList.updateStudent(
                            updateId,
                            newName,
                            newProgramme,
                            newMarks
                    );

                    if (updated) {
                        actionStack.push("Updated student " + updateId);
                        System.out.println(
                                "Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                // ==========================================
                // 3. DELETE STUDENT
                // ==========================================

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine().trim();

                    if (deleteId.isEmpty()) {
                        System.out.println("Student ID cannot be empty.");
                        break;
                    }

                    boolean deleted =
                            studentList.deleteStudent(deleteId);

                    if (deleted) {
                        bst.delete(deleteId);
                        hashTable.delete(deleteId);

                        actionStack.push(
                                "Deleted student " + deleteId);

                        System.out.println(
                                "Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                // ==========================================
                // 4. DISPLAY ALL STUDENTS
                // ==========================================

                case 4:
                    System.out.println();
                    System.out.println("All Student Records:");
                    studentList.displayAllStudents();
                    break;

                // ==========================================
                // 5. ADD SERVICE REQUEST
                // ==========================================

                case 5:
                    System.out.print("Enter Student ID: ");
                    String requestStudentId =
                            scanner.nextLine().trim();

                    if (requestStudentId.isEmpty()) {
                        System.out.println("Student ID cannot be empty.");
                        break;
                    }

                    if (studentList.searchStudent(
                            requestStudentId) == null) {

                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter Service Request: ");
                    String requestText =
                            scanner.nextLine().trim();

                    if (requestText.isEmpty()) {
                        System.out.println(
                                "Service request cannot be empty.");
                        break;
                    }

                    ServiceRequest serviceRequest =
                            new ServiceRequest(
                                    requestStudentId,
                                    requestText
                            );

                    serviceQueue.enqueue(serviceRequest);

                    break;

                // ==========================================
                // 6. PROCESS SERVICE REQUEST
                // ==========================================

                case 6:
                    System.out.println(
                            "Processing next service request:");

                    ServiceRequest processedRequest =
                            serviceQueue.dequeue();

                    if (processedRequest != null) {
                        processedRequest.displayRequest();
                    }

                    break;

                // ==========================================
                // 7. DISPLAY RECENT ACTIONS
                // ==========================================

                case 7:
                    System.out.println();
                    actionStack.display();
                    break;

                // ==========================================
                // 8. DISPLAY BST
                // ==========================================

                case 8:
                    System.out.println();
                    System.out.println("Students in BST:");
                    bst.displayInOrder();
                    break;

                // ==========================================
                // 9. SEARCH USING HASHING
                // ==========================================

                case 9:
                    System.out.print(
                            "Enter Student ID to search: ");

                    String searchId =
                            scanner.nextLine().trim();

                    if (searchId.isEmpty()) {
                        System.out.println(
                                "Student ID cannot be empty.");
                        break;
                    }

                    Student foundStudent =
                            hashTable.search(searchId);

                    if (foundStudent != null) {
                        System.out.println("Student found:");
                        foundStudent.displayStudent();
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                // ==========================================
                // 10. ADD CAMPUS LOCATION
                // ==========================================

                case 10:
                    System.out.print(
                            "Enter Campus Location: ");

                    String location =
                            scanner.nextLine().trim();

                    if (location.isEmpty()) {
                        System.out.println(
                                "Campus location cannot be empty.");
                        break;
                    }

                    graph.addLocation(location);

                    break;

                // ==========================================
                // 11. REMOVE CAMPUS LOCATION
                // ==========================================

                case 11:
                    System.out.print(
                            "Enter Campus Location to remove: ");

                    String removeLocation =
                            scanner.nextLine().trim();

                    if (removeLocation.isEmpty()) {
                        System.out.println(
                                "Campus location cannot be empty.");
                        break;
                    }

                    graph.removeLocation(removeLocation);

                    break;

                // ==========================================
                // 12. ADD CAMPUS CONNECTION
                // ==========================================

                case 12:
                    System.out.print(
                            "Enter first Campus Location: ");

                    String location1 =
                            scanner.nextLine().trim();

                    System.out.print(
                            "Enter second Campus Location: ");

                    String location2 =
                            scanner.nextLine().trim();

                    if (location1.isEmpty()
                            || location2.isEmpty()) {

                        System.out.println(
                                "Campus locations cannot be empty.");
                        break;
                    }

                    graph.addConnection(
                            location1,
                            location2
                    );

                    break;

                // ==========================================
                // 13. REMOVE CAMPUS CONNECTION
                // ==========================================

                case 13:
                    System.out.print(
                            "Enter first Campus Location: ");

                    String removeLocation1 =
                            scanner.nextLine().trim();

                    System.out.print(
                            "Enter second Campus Location: ");

                    String removeLocation2 =
                            scanner.nextLine().trim();

                    if (removeLocation1.isEmpty()
                            || removeLocation2.isEmpty()) {

                        System.out.println(
                                "Campus locations cannot be empty.");
                        break;
                    }

                    graph.removeConnection(
                            removeLocation1,
                            removeLocation2
                    );

                    break;

                // ==========================================
                // 14. DISPLAY CAMPUS CONNECTIONS
                // ==========================================

                case 14:
                    System.out.println();
                    graph.displayConnections();
                    break;

                // ==========================================
                // 15. BFS
                // ==========================================

                case 15:
                    System.out.print(
                            "Enter starting Campus Location: ");

                    String bfsStart =
                            scanner.nextLine().trim();

                    if (bfsStart.isEmpty()) {
                        System.out.println(
                                "Campus location cannot be empty.");
                        break;
                    }

                    graph.BFS(bfsStart);

                    break;

                // ==========================================
                // 16. DFS
                // ==========================================

                case 16:
                    System.out.print(
                            "Enter starting Campus Location: ");

                    String dfsStart =
                            scanner.nextLine().trim();

                    if (dfsStart.isEmpty()) {
                        System.out.println(
                                "Campus location cannot be empty.");
                        break;
                    }

                    graph.DFS(dfsStart);

                    break;

                // ==========================================
                // 17. EXIT
                // ==========================================

                case 17:
                    running = false;

                    System.out.println(
                            "Thank you for using the system.");

                    break;

                // ==========================================
                // INVALID MENU OPTION
                // ==========================================

                default:
                    System.out.println(
                            "Invalid choice. Please enter 1-17.");
            }
        }

        scanner.close();
    }
}