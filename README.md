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
   ↓
API Gateway (JWT Validation)
   ↓
Auth Service  ←→ PostgreSQL
   ↓
Patient Service ←→ PostgreSQL
   ↓ (gRPC)
Billing Service
   ↓ (Kafka Events)
Notification / Analytics Service
🔐 Auth Service
Default Admin User
Username: admin-user
Email: testuser@test.com
Password: (BCrypt encoded in data.sql)
Role: ADMIN
Environment Variables
SPRING_DATASOURCE_PASSWORD=password
SPRING_DATASOURCE_URL=jdbc:postgresql://auth-service-db:5432/db
SPRING_DATASOURCE_USERNAME=admin_user
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_SQL_INIT_MODE=always
Auth Service DB Container
POSTGRES_DB=db
POSTGRES_PASSWORD=password
POSTGRES_USER=admin_user
🏥 Patient Service
Environment Variables
BILLING_SERVICE_ADDRESS=billing-service
BILLING_SERVICE_GRPC_PORT=9005
JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005
SPRING_DATASOURCE_PASSWORD=password
SPRING_DATASOURCE_URL=jdbc:postgresql://patient-service-db:5432/db
SPRING_DATASOURCE_USERNAME=admin_user
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9092
SPRING_SQL_INIT_MODE=always
💰 Billing Service (gRPC)

Runs on:

Port: 9005

Uses:

grpc-netty-shaded

grpc-protobuf

grpc-stub

grpc-spring-boot-starter

protobuf-java

📡 Kafka + Zookeeper Setup (Confluent)

This project uses:

Zookeeper Image:
confluentinc/cp-zookeeper:7.7.7

Kafka Image:
confluentinc/cp-kafka:latest

🧩 Zookeeper Environment Variables
ZOOKEEPER_CLIENT_PORT=2181
ZOOKEEPER_TICK_TIME=2000
📡 Kafka Environment Variables
KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:29092
KAFKA_BROKER_ID=1
KAFKA_CONTROLLER_LISTENER_NAMES=CONTROLLER
KAFKA_CONTROLLER_QUORUM_VOTERS=1@kafka:9093
KAFKA_DEFAULT_REPLICATION_FACTOR=1
KAFKA_INTER_BROKER_LISTENER_NAME=PLAINTEXT
KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT,CONTROLLER:PLAINTEXT
KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092,PLAINTEXT_HOST://0.0.0.0:29092,CONTROLLER://0.0.0.0:9093
KAFKA_LOG_DIRS=/var/lib/kafka/data
KAFKA_NODE_ID=1
KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1
KAFKA_PROCESS_ROLES=broker,controller
KAFKA_TRANSACTION_STATE_LOG_MIN_ISR=1
KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR=1
📌 Kafka Exposed Ports
9092  -> Internal container communication
29092 -> External host communication
📡 Kafka Producer Setup (Patient Service)

Add in application.properties:

spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.ByteArrayDeserializer
📊 Notification / Analytics Service
Environment Variable
SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka:9092
🧩 gRPC & Protobuf Configuration

All gRPC-enabled services use:

protobuf-maven-plugin

os-maven-plugin

protoc 3.25.5

grpc-java plugin 1.68.1

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

Located in:

integration-tests/
🛠 Tech Stack

Java 17

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
