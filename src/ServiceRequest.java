public class ServiceRequest {

    private String studentId;
    private String request;

    public ServiceRequest(String studentId, String request) {
        this.studentId = studentId;
        this.request = request;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getRequest() {
        return request;
    }

    public void displayRequest() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Request: " + request);
    }
}