public class StackTest {

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push("Added student S001");
        stack.push("Updated student S001");
        stack.push("Deleted student S002");

        stack.display();
    }
}