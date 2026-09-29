public class QueueTest {

    public static void main(String[] args) {

        Queue queue = new Queue();

        ServiceRequest request1 =
                new ServiceRequest("S001", "Need a student ID card");

        ServiceRequest request2 =
                new ServiceRequest("S002", "Need a transcript");

        ServiceRequest request3 =
                new ServiceRequest("S003", "Need help with registration");

        queue.enqueue(request1);
        queue.enqueue(request2);
        queue.enqueue(request3);

        queue.display();
        System.out.println("Number of waiting requests: " + queue.size());

        System.out.println("Processing first request:");

        ServiceRequest processed = queue.dequeue();

        if (processed != null) {
            processed.displayRequest();
        }
    }
}
