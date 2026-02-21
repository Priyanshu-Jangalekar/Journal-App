📓 Journal App – Secure Backend System 

Author: Priyanshu Jangalekar

Feel free to create a Pull Request 🚀

----------------------------------------------------------------------------------------------------------------------------------------------------
📓 Journal App – Secure Backend System with Analytics

Journal App is a secure, production-ready backend application built using Spring Boot and MongoDB.
It allows users to create and manage personal journal entries with authentication, caching, and automated weekly sentiment analysis via email.
This project demonstrates strong backend fundamentals including authentication, caching, lifecycle management, and background analytics processing.

----------------------------------------------------------------------------------------------------------------------------------------------------
🛠️ Tech Stack

Java

Spring Boot

Spring Security

JWT Authentication

MongoDB

Redis (Caching)

In-Memory Caching

Maven

REST APIs

Role-Based Authorization

SMTP (Email Integration)

SLF4J (Logging)

----------------------------------------------------------------------------------------------------------------------------------------------------
⚙️ Installation & Setup Guide
Follow the steps below to run this project locally.☺️

📋 Prerequisites

Make sure you have the following installed:

Java 17+

Maven

MongoDB (running locally or Atlas)

Redis (running locally)

Git

Optional:

Postman (for testing APIs)


📥 1️⃣ Clone the Repository

git clone https://github.com/Priyanshu-Jangalekar/Journal-App.git

cd Journal-App

🔑 2️⃣ Configure Environment Variables

This project requires certain API keys and credentials.

Create or update your application.properties (or application.yml) file:

👉👉👉MongoDB

spring.data.mongodb.uri=mongodb://localhost:27017/journaldb

👉👉👉Redis

spring.redis.host=localhost

spring.redis.port=6379

👉👉👉JWT Secret

jwt.secret=your_secret_key_here

👉👉👉mail Configuration

-->spring.mail.host=smtp.gmail.com

-->spring.mail.port=587

-->spring.mail.username=your_email

-->spring.mail.password=your_app_password

-->spring.mail.properties.mail.smtp.auth=true

-->spring.mail.properties.mail.smtp.starttls.enable=true

👉👉👉Sentiment API Key (if applicable)

sentiment.api.key=your_api_key_here


▶️ 3️⃣ Run the Application

Using Maven

mvn clean install

mvn spring-boot:run


🌐 4️⃣ Access the Application

The server will start on:

http://localhost:8080

Now use Postman to hit api


🧪 5️⃣ Testing Authentication Flow

Register a new user

Login to receive JWT token

Use the token in the Authorization header:

----------------------------------------------------------------------------------------------------------------------------------------------------

🔐 Key Features

1️⃣ JWT-Based Authentication
Stateless authentication using JSON Web Tokens
Secure login & signup flow
Role-based access control (USER / ADMIN)

2️⃣ Redis Integration
Used for caching frequently accessed data
Improves response time and reduces database load
Demonstrates real-world scalable backend design

3️⃣ Weekly Sentiment Analysis via Email
Analyzes journal entries weekly
Performs sentiment classification
Sends automated email reports to users
Simulates real-world background job processing

4️⃣ Application Startup Configuration
Uses @PostConstruct to:
Fetch and cache API keys
Initialize required resources at application startup
Ensures secure and controlled configuration loading

5️⃣ Clean REST Architecture
Layered architecture:
Controller
Service
Repository
Proper exception handling
Modular and scalable design

----------------------------------------------------------------------------------------------------------------------------------------------------
-->Future Improvements
Docker containerization
CI/CD integration
Rate limiting
Deployment on cloud (AWS / GCP)
Frontend integration (MERN / React)
