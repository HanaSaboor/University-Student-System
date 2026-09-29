public class Stack {

    private String[] actions;
    private int top;

    public Stack() {
        actions = new String[100];
        top = -1;
    }

    public void push(String action) {
        if (top == actions.length - 1) {
            System.out.println("Action history is full.");
            return;
        }

        top++;
        actions[top] = action;
    }

    public String pop() {
        if (top == -1) {
            return "No recent actions.";
        }

        String action = actions[top];
        actions[top] = null;
        top--;

        return action;
    }

    public String peek() {
        if (top == -1) {
            return "No recent actions.";
        }

        return actions[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("No recent actions.");
            return;
        }

        System.out.println("Recent Actions:");

        for (int i = top; i >= 0; i--) {
            System.out.println(actions[i]);
        }
    }
}