# 🍴 Food-Restaurant Backend (Spring Boot + Kafka)

This is a **food ordering backend system** built with **Spring Boot**, **Spring Data JPA**, and **Kafka**.  
It provides a seamless flow between **Users, Restaurants, Orders, and Delivery Partners**, with automatic **order assignment** via a scheduler.

---

## 🚀 Features

- **User Management**
    - Register new users

- **Restaurant Management**
    - Register restaurants
    - Update restaurant menus
    - View all restaurants
    - View active and historical orders

- **Order Management**
    - Place new orders
    - Mark orders as ready for pickup
    - Auto-assign orders to free delivery partners

- **Delivery Partner Management**
    - Register delivery partners
    - Toggle active/inactive status
    - Mark order as completed

- **Order Scheduler**
    - Runs every 1 second
    - Assigns ready orders to free delivery partners automatically
    - Updates order status from *Ready for pick* → *Picked*

- **Kafka Integration**
    - Publishes events when delivery partners become free
    - Enables real-time tracking of delivery updates

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA (Hibernate)**
- **MySQL** (or any JPA-supported DB)
- **Apache Kafka**
- **Lombok**

---

## ⚡ API Endpoints

### 👤 User APIs
- `POST /user/new` → Create a new user

Example request:
```json
{
  "uname": "Akhil",
  "uphoneno": 9876543210
}
