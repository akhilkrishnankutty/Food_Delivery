🍴 Food-Restaurant Backend (Spring Boot + Kafka)

This is a food ordering backend system built with Spring Boot, Spring Data JPA, and Kafka.
It provides a seamless flow between Users, Restaurants, Orders, and Delivery Partners, with automatic order assignment via a scheduler.

🚀 Features

User Management

Register new users

Restaurant Management

Register restaurants

Update restaurant menus

View all restaurants

View active and historical orders

Order Management

Place new orders

Mark orders as ready for pickup

Auto-assign orders to free delivery partners

Delivery Partner Management

Register delivery partners

Toggle active/inactive status

Mark order as completed

Order Scheduler

Runs every 1 second

Assigns ready orders to free delivery partners automatically

Updates order status from Ready for pick → Picked

Kafka Integration

Publishes events when delivery partners become free

Enables real-time tracking of delivery updates

🛠️ Tech Stack

Java 17

Spring Boot 3

Spring Data JPA (Hibernate)

MySQL (or any JPA-supported DB)

Apache Kafka

Lombok (for boilerplate reduction)

⚡ API Endpoints
👤 User APIs

POST /user/new → Create a new user

🍴 Restaurant APIs

POST /restaurant/new → Register a new restaurant

GET /restaurant/all → Get all restaurants

PUT /restaurant/{id}/menu → Update restaurant menu

GET /restaurant/{id}/orders → Get active orders

GET /restaurant/{id}/orders/history → Get completed orders

PUT /restaurant/order/{id}/ready → Mark order as ready

📦 Order APIs

POST /order/new → Place a new order

PUT /order/{id}/ready → Mark order as ready

🚴 Delivery Partner APIs

POST /delivery/new → Register a new delivery partner

PUT /delivery/{id}/active → Toggle partner active/inactive

PUT /delivery/{id}/complete → Mark order as completed

🔄 Order Flow

User places an order.

Restaurant prepares the order → marks it as Ready for pick.

Scheduler picks it up → assigns it to a free Delivery Partner.

Delivery Partner picks the order → marks it as Completed.

Order status updates to Completed and partner becomes free again.

⚙️ Setup Instructions

Clone repo

git clone https://github.com/your-username/Food-Restaurant.git
cd Food-Restaurant


Configure Database in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/food_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


Start Kafka locally (or use Docker).

Run Spring Boot App

mvn spring-boot:run

📝 Future Improvements

JWT-based authentication

Role-based access (User, Restaurant, Delivery Partner, Admin)

Payment gateway integration

WebSocket for live order tracking