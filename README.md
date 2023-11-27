# Account Management Service

This microservice exposes two APIs as follows:

##### 1. Create Account
URL - POST /api/v1.0/account
Create an account, sample payload:

```json
{
  "user": {
    "username": "chiraranw",
    "firstName": "John",
    "lastName": "Doe",
    "address": "15133 Tynwald North, Harare",
    "mobile": "0776072174",
    "email": "john@gmail.com"
  },
  "accountNumber": "44086004870364",
  "type": "SAVINGS",
  "status": "OPEN",
  "description": "ACount",
  "currentBalance": "12.0099"
}
```

When an account is created successfully, it publishes a **CREDIT** request payload
into a queue **IN.ZW.PAYMENTS**. This request is then consumed by the Transaction Processor Service
and asynchronously credit the newly created account. 


##### 2. Update Account

Updates account from CURRENT to SAVINGS or vice vesa.

Sample payload:
```json
{
    "accountNumber": "44086004870364",
    "accountType": "SAVINGS"
}
```
