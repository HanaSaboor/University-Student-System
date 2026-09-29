public class Queue {

    private ServiceRequest[] requests;
    private int front;
    private int rear;

    public Queue() {
        requests = new ServiceRequest[100];
        front = 0;
        rear = -1;
    }

    public void enqueue(ServiceRequest request) {
        if (rear == requests.length - 1) {
            System.out.println("Service request queue is full.");
            return;
        }

        rear++;
        requests[rear] = request;

        System.out.println("Service request added successfully.");
    }

    public ServiceRequest dequeue() {
        if (isEmpty()) {
            System.out.println("No service requests.");
            return null;
        }

        ServiceRequest request = requests[front];
        requests[front] = null;
        front++;

        return request;
    }

    public ServiceRequest peek() {
        if (isEmpty()) {
            return null;
        }

        return requests[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No service requests.");
            return;
        }

        System.out.println("Service Requests:");

        for (int i = front; i <= rear; i++) {
            requests[i].displayRequest();
            System.out.println("--------------------");
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        return rear - front + 1;
    }
}