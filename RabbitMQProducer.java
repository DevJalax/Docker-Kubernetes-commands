import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RabbitMQProducer {

    private final static String QUEUE_NAME = "api_requests";

    public static void main(String[] args) {
        // Example usage
        String method = "POST"; // This would typically come from the incoming request
        String endpoint = "/api/request"; // This would also come from the incoming request
        Object params = new Params(12345); // Example parameters

        sendApiRequest(method, endpoint, params);
    }

    public static void sendApiRequest(String method, String endpoint, Object params) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            // Declare the queue
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            // Create the API request payload
            ApiRequest apiRequest = new ApiRequest(method, endpoint, params);

            // Convert the API request to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String message = objectMapper.writeValueAsString(apiRequest);

            // Send the message to the queue
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
          
            System.out.println(" [x] Sent API request: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
