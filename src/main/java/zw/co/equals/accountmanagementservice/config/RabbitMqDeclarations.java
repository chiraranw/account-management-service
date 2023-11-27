package zw.co.equals.accountmanagementservice.config;

import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
public class RabbitMqDeclarations {


    private final RabbitMqProperties rabbitMqProperties;

    public RabbitMqDeclarations(RabbitMqProperties rabbitMqProperties) {
        this.rabbitMqProperties = rabbitMqProperties;
    }


    @Bean
    Queue paymentsInQueue() {
        return new Queue(rabbitMqProperties.getPaymentsInQueue(), true, false, false);
    }

    @Bean
    public Declarables directBindings() {
        Queue paymentsInQueue = this.paymentsInQueue();
        DirectExchange paymentsExchange = new DirectExchange(rabbitMqProperties.getExchange());
        return new Declarables(
                paymentsExchange,
                bind(paymentsInQueue).to(paymentsExchange).with(rabbitMqProperties.getPaymentsInQueueRoutingKey()));
    }

}