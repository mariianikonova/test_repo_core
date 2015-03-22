package thirdPartyTechStack.queueBroker.rabbitMqDemo.workerMQDemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * Created by user on 18.03.15.
 */
public class Consumer {

    private final static String QUEUE_NAME = "hello";


    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);


            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            QueueingConsumer consumer = new QueueingConsumer(channel);
            boolean autoAck = false;
            channel.basicConsume("hello", autoAck, consumer);
            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                String message = new String(delivery.getBody());

                System.out.println(" [x] Received '" + message + "'");
                doWork(message);
                System.out.println(" [x] Done");

            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
