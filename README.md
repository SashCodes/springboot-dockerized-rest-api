# Spring Boot Dockerized REST API

This project demonstrates a Spring Boot REST API integrated with PostgreSQL and containerized using Docker.

## 🚀 Features
- CRUD APIs for Product
- PostgreSQL integration
- Dockerized application
- Environment-based configuration

## 🐳 Docker Setup

### Build image
docker build -t product-service .

### Run PostgreSQL
docker run -d \
  --name postgres-container \
  -e POSTGRES_DB=productdb \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=<your_password> \
  -p 5432:5432 postgres

### Run App
docker run -d \
  --name product-app \
  --network my-network \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres-container:5432/productdb \
  product-service

## 📌 Future Improvements
- Docker Compose setup
- Kubernetes deployment