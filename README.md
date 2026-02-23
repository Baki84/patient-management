🏥 Patient Management Microservices System

This project is a Java / Spring Boot Microservices Architecture demonstrating a real-world healthcare backend system.

It includes:

🔐 JWT Authentication

🌐 API Gateway

🏥 Patient Management

💰 Billing Service (gRPC)

📡 Kafka Event-Driven Communication

🐘 PostgreSQL (Database per service)

🐳 Docker-based infrastructure

🧪 Integration Testing

🏗 Architecture Overview


Client
   ->
API Gateway (JWT Validation)
   ->
Auth Service  ←→ PostgreSQL
   ->
Patient Service ←→ PostgreSQL
   -> (gRPC)
Billing Service
   -> (Kafka Events)
Notification / Analytics Service
Uses:

grpc-netty-shaded

grpc-protobuf

grpc-stub

grpc-spring-boot-starter

protobuf-java

📡 Kafka + Zookeeper Setup (Confluent)

🚀 How To Run
1️⃣ Start Zookeeper
2️⃣ Start Kafka
3️⃣ Start PostgreSQL containers
4️⃣ Run Auth Service
5️⃣ Run Billing Service
6️⃣ Run Patient Service
7️⃣ Run API Gateway
8️⃣ Test endpoints using .http files
🧪 Integration Tests


🛠 Tech Stack

Java 21

Spring Boot 3+

Spring Security

JWT

Kafka (Confluent)

Zookeeper

gRPC

Protobuf

PostgreSQL

Docker

Maven

🎯 Features

✔ API Gateway Routing
✔ JWT Token Authentication
✔ Role-based Authorization
✔ gRPC Inter-service Communication
✔ Kafka Event Publishing
✔ Database per Service Pattern
✔ Integration Testing
✔ Containerized Infrastructure



📚 Purpose

This project is built for educational purposes and demonstrates real-world microservices architecture using Spring Boot ecosystem.


