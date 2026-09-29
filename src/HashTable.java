public class HashTable {

    private Student[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new Student[size];
    }

    // Convert Student ID into a table position
    private int hash(String studentId) {

        int hashValue = 0;

        for (int i = 0; i < studentId.length(); i++) {
            hashValue = hashValue + studentId.charAt(i);
        }

        return hashValue % size;
    }

    // Add a student to the hash table
    public void insert(Student student) {

        int index = hash(student.getStudentId());

        if (table[index] == null) {
            table[index] = student;
            return;
        }

        // Handle collision using linear probing
        int originalIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId()
                    .equals(student.getStudentId())) {

                System.out.println("Duplicate Student ID.");
                return;
            }

            index = (index + 1) % size;

            if (index == originalIndex) {
                System.out.println("Hash table is full.");
                return;
            }
        }

        table[index] = student;
    }

    // Search for a student using Student ID
    public Student search(String studentId) {

        int index = hash(studentId);
        int originalIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId().equals(studentId)) {
                return table[index];
            }

            index = (index + 1) % size;

            if (index == originalIndex) {
                break;
            }
        }

        return null;
    }

    // Delete a student from the hash table
    public boolean delete(String studentId) {

        int index = hash(studentId);
        int originalIndex = index;

        while (table[index] != null) {

            if (table[index].getStudentId().equals(studentId)) {
                table[index] = null;
                return true;
            }

            index = (index + 1) % size;

            if (index == originalIndex) {
                break;
            }
        }

        return false;
    }

    // Display the hash table
    public void display() {

        System.out.println("Hash Table:");

        for (int i = 0; i < size; i++) {

            if (table[i] != null) {
                System.out.println(
                        "Index " + i + ": "
                        + table[i].getStudentId()
                        + " - "
                        + table[i].getName()
                );
            } else {
                System.out.println(
                        "Index " + i + ": Empty"
                );
            }
        }
    }
}