package zw.co.equals.accountmanagementservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import zw.co.equals.accountmanagementservice.config.RabbitMqProperties;
import zw.co.equals.accountmanagementservice.dto.Request;
import zw.co.equals.accountmanagementservice.exception.InvalidRequestException;
import zw.co.equals.accountmanagementservice.service.RabbitMQService;

@Slf4j
@Service
public class RabbitMQServiceImpl implements RabbitMQService {

    private final RabbitMqProperties rabbitMqProperties;
    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper mapper;

    public RabbitMQServiceImpl(RabbitMqProperties rabbitMqProperties, RabbitTemplate rabbitTemplate, ObjectMapper mapper) {
        this.rabbitMqProperties = rabbitMqProperties;
        this.rabbitTemplate = rabbitTemplate;
        this.mapper = mapper;
    }

    @Override
    public void creditAccount(Request request) {
        log.info("Publishing credit request to transaction processor: {}", request);
        try {
            rabbitTemplate.convertAndSend(
                    rabbitMqProperties.getExchange(),
                    rabbitMqProperties.getPaymentsInQueueRoutingKey(),
                    mapper.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            log.error("Could not process payload as json: {}", e.getOriginalMessage());
            throw new InvalidRequestException(e.getOriginalMessage());
        }
        log.info("Successfully published credit request to transaction processor: {}", request);
    }
}
