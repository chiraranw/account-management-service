package zw.co.equals.accountmanagementservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class RabbitMqProperties {

    @Value("${rabbitmq.host}")
    private String host;
    @Value("${rabbitmq.port}")
    private int port;
    @Value("${rabbitmq.username}")
    private String username;
    @Value("${rabbitmq.password}")
    private String password;
    @Value("${rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${zw.co.equals.banking.payments-queue}")
    private String paymentsInQueue;
    @Value("${zw.co.equals.banking.payments-routing-key}")
    private String paymentsInQueueRoutingKey;
    @Value("${zw.co.equals.banking.exchange}")
    private String exchange;
}
