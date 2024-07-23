import com.rabbitmq.client.*;

public class RabbitMQConsumer {

    private final static String QUEUE_NAME = "api_requests";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            // Declare the queue
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for API requests. To exit press CTRL+C");

            // Define the callback for processing messages
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received API request: " + message);
                processApiRequest(message);
            };

            // Start consuming messages from the queue
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        }
    }

    private static void processApiRequest(String message) {
        // Implement your API processing logic here
        System.out.println("Processing request: " + message);
        // You can parse the message and perform actions based on the method and endpoint
    }
}
