Starter file 

INSERT INTO USER (id, name, email) VALUES (1, 'Satyam', 'satyam@example.com');
INSERT INTO USER (id, name, email) VALUES (2, 'Rohit', 'rohit@example.com');


http://localhost:8081/h2-console

INSERT INTO RESTAURANT (LOCATION, NAME) VALUES ('Mumbai', 'Foodies Hub');
INSERT INTO RESTAURANT (LOCATION, NAME) VALUES ('Pune', 'Spice Kitchen');
INSERT INTO RESTAURANT (LOCATION, NAME) VALUES ('Delhi', 'Taste of India');


HIT endpoint - for placing order -
http://localhost:8082/orders/place
{
  "userId": 1,
  "restaurantId": 101,
  "itemName": "Pizza",
  "quantity": 2
}

5. Expected Response

{
{
  "orderId": 1692958371234,
  "user": {
    "id": 1,
    "name": "Test User 1",
    "email": "user1@mail.com"
  },
  "restaurant": {
    "id": 101,
    "name": "Restaurant 101",
    "location": "City Center"
  },
  "itemName": "Pizza",
  "quantity": 2,
  "status": "ORDER_PLACED"
}

Week 1 Achievements

✅ Project skeletons created inside Food Delivery App folder.

✅ User Service (CRUD with DTOs + controller).

✅ Restaurant Service (CRUD with DTOs + controller).

✅ Feign Client setup between services.

✅ Order Service business logic implemented.

✅ OrderController with /orders/place endpoint.

✅ End-to-end Postman test (User → Restaurant → Order placement).


-----------------------------------------------
📌 Week 2 – Day-by-Day Coding Milestones
Day 8 – Order Service (Phase 1)

Create Order Service (Spring Data JPA + PostgreSQL).

Entities: Order, OrderItem, OrderStatus.

APIs:

POST /orders (create order → initially PENDING)

GET /orders/{id}

Use Feign Clients to:

Fetch User info (from User Service)

Fetch Restaurant info (from Restaurant Service)

Save order in DB.

Day 9 – Introduce Kafka + Event-driven Flow

Setup Kafka Topics:

order-events

payment-events

inventory-events

notification-events

Configure Spring Kafka Producer/Consumer in Order, Payment, Inventory services.

Order Service publishes OrderCreatedEvent to order-events.

Day 10 – Payment Service

Create Payment Service (Spring Data JPA + PostgreSQL).

Entities: Payment, PaymentStatus.

Consume OrderCreatedEvent.

Process payment:

If success → publish PaymentSuccessEvent.

If failure → publish PaymentFailedEvent.

Store transactions in DB.

Day 11 – Inventory Service

Create Inventory Service (MongoDB).

Entities: Product, Stock.

On PaymentSuccessEvent:

Deduct stock

If stock available → publish InventoryReservedEvent.

If stock not available → publish InventoryFailedEvent.

Day 12 – Saga Orchestration

Implement Choreography-based Saga:

Order Service listens to payment + inventory events.

Workflow:
OrderCreatedEvent → Payment → Inventory → OrderConfirmed

Rollback cases:

If Payment fails → OrderCancelled

If Inventory fails → OrderCancelled

Use @Transactional + Outbox Pattern for reliability.

Day 13 – Notification Service

Create Notification Service.

Consume:

OrderConfirmedEvent → Send confirmation email/SMS.

OrderCancelledEvent → Send cancellation message.

Use Spring Mail or a mock service for now.

Store logs in MongoDB.

Day 14 – Integration & Testing

End-to-end workflow:

Create order → OrderCreatedEvent

Payment processed → PaymentSuccessEvent

Inventory updated → InventoryReservedEvent

Order confirmed → OrderConfirmedEvent

Notification sent

Test rollback case:

Payment fails → OrderCancelled

Inventory fails → OrderCancelled

Write integration tests with Testcontainers + Embedded Kafka.

✅ End of Week 2 Deliverables:

Order → Payment → Inventory → Notification Saga flow completed

Kafka event-driven system working

Rollback (failure scenarios) handled via Saga pattern

Event logs & resilience implemented
----------------------------------------------------------------

