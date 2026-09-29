public class BST {

    private class Node {
        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    // Insert a student
    public void insert(Student student) {

        Node newNode = new Node(student);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;

        while (true) {

            int comparison =
                    student.getStudentId().compareTo(
                            current.student.getStudentId());

            if (comparison < 0) {

                if (current.left == null) {
                    current.left = newNode;
                    return;
                }

                current = current.left;

            } else if (comparison > 0) {

                if (current.right == null) {
                    current.right = newNode;
                    return;
                }

                current = current.right;

            } else {
                System.out.println("Duplicate Student ID.");
                return;
            }
        }
    }

    // Search for a student
    public Student search(String studentId) {

        Node current = root;

        while (current != null) {

            int comparison =
                    studentId.compareTo(
                            current.student.getStudentId());

            if (comparison == 0) {
                return current.student;
            }

            if (comparison < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // Display students in sorted order
    public void displayInOrder() {

        if (root == null) {
            System.out.println("No students in BST.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);

        node.student.displayStudent();
        System.out.println("--------------------");

        inOrder(node.right);
    }

    // Delete a student
    public boolean delete(String studentId) {

        if (search(studentId) == null) {
            return false;
        }

        root = deleteNode(root, studentId);
        return true;
    }

    private Node deleteNode(Node node, String studentId) {

        if (node == null) {
            return null;
        }

        int comparison =
                studentId.compareTo(
                        node.student.getStudentId());

        if (comparison < 0) {

            node.left = deleteNode(node.left, studentId);

        } else if (comparison > 0) {

            node.right = deleteNode(node.right, studentId);

        } else {

            // Case 1: No left child
            if (node.left == null) {
                return node.right;
            }

            // Case 2: No right child
            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children
            Node smallestNode = findSmallest(node.right);

            node.student = smallestNode.student;

            node.right =
                    deleteNode(
                            node.right,
                            smallestNode.student.getStudentId());
        }

        return node;
    }

    private Node findSmallest(Node node) {

        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
}