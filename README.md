# Spring Boot + PostgreSQL (Local & Docker) Demo

This project is a simple **Spring Boot REST API** connected to a **PostgreSQL database**.  
It showcases a clean starter setup using:

- Spring Boot
- PostgreSQL
- Spring Data JPA
- Docker + docker-compose
- DBeaver / pgAdmin (optional for database UI)

---

## 🚀 Features

- REST API for Employee CRUD
- Automatic table creation using Hibernate
- Local PostgreSQL setup
- Optional Docker-based PostgreSQL setup
- Production-ready folder structure

---

# 📌 1. Local PostgreSQL Setup (Without Docker)

### **1. Install PostgreSQL**
Download from:  
https://www.postgresql.org/download/

During installation:
- Set username: `postgres`
- Set password: (choose your password)
- Install pgAdmin (optional)

---

### **2. Create your database**
Open **pgAdmin** → Query Tool:

```sql
CREATE DATABASE demo_db;
```
---
# 🐳 PostgreSQL Setup Using Docker

This section explains how to run PostgreSQL locally using Docker with a simple `docker-compose.yml` setup.  
This approach avoids manual installation and makes your database environment easy to reset or version.



## 📌 1. Prerequisites

Install:

### **Docker Desktop**  
Download: https://www.docker.com/products/docker-desktop/

Ensure Docker is running before executing commands.

---

## 📌 2. Create `docker-compose.yml`

Create a folder (example):

C:\postgres-docker

```yaml

Inside it, create this file:

### **docker-compose.yml**

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:15
    container_name: postgres_local
    restart: always
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: admin123
      POSTGRES_DB: demo_db
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:

```
---
## 📌 3. Start PostgreSQL Using Docker

Run inside the folder containing `docker-compose.yml`:

```sh
docker compose up -d
```
Verify the container:
```sh
docker ps
```
Expected:
```sh
postgres_local  Up  0.0.0.0:5432->5432/tcp
```

<img width="1112" height="591" alt="Screenshot 2025-12-02 144800" src="https://github.com/user-attachments/assets/b170b1e3-a9bf-44ca-bf3d-19ac36cc69fc" />

---

## 🔧 Useful Docker Commands

Stop containers
```sh
docker compose down
```
Remove containers & volume (wipe database)
```sh
docker compose down -v
```
View logs
```sh
docker logs postgres_local
```
Restart PostgreSQL
```sh
docker restart postgres_local
```


