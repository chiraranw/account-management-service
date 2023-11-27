package zw.co.equals.accountmanagementservice.service;

import zw.co.equals.accountmanagementservice.dto.Request;

public interface RabbitMQService {
    void creditAccount(Request request);
}
