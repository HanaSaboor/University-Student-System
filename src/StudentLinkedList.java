public class StudentLinkedList {

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head;

    public StudentLinkedList() {
        head = null;
    }

    public void addStudent(Student student) {
        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Node current = head;

        while (current != null) {
            current.student.displayStudent();
            System.out.println("--------------------");
            current = current.next;
        }
    }

    public Student searchStudent(String studentId) {
        Node current = head;

        while (current != null) {

            if (current.student.getStudentId().equals(studentId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    public boolean deleteStudent(String studentId) {
        if (head == null) {
            return false;
        }

        if (head.student.getStudentId().equals(studentId)) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId().equals(studentId)) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean updateStudent(String studentId, String name,
                                 String programme, double marks) {

        Student student = searchStudent(studentId);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        return true;
    }
}