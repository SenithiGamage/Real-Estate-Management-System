CREATE DATABASE IF NOT EXISTS real_estate_db;
USE real_estate_db;

CREATE TABLE users (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) NOT NULL UNIQUE,
       password VARCHAR(255) NOT NULL,
       full_name VARCHAR(100),
       email VARCHAR(100) NOT NULL UNIQUE,
       phone VARCHAR(20),
       role ENUM('CUSTOMER', 'SELLER', 'AGENT', 'ADMIN') NOT NULL,
       status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE properties (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(100) NOT NULL,
        location VARCHAR(100) NOT NULL,
        address TEXT,
        property_type ENUM('HOUSE', 'LAND', 'APARTMENT') NOT NULL,
        price DOUBLE NOT NULL,
        size DOUBLE, -- In perches or square feet
        bedrooms INT,
        bathrooms INT,
        description TEXT,
        status ENUM('AVAILABLE', 'SOLD', 'RENTED') DEFAULT 'AVAILABLE',
        owner_id BIGINT, -- Links to the User who is the Seller/Owner
        agent_id BIGINT,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE SET NULL,
        FOREIGN KEY (agent_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE inquiries (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       property_id BIGINT NOT NULL,
       customer_id BIGINT NOT NULL,
       customer_name VARCHAR(100) NOT NULL,
       customer_email VARCHAR(100) NOT NULL,
       message TEXT NOT NULL,
       visit_date DATE,
       status ENUM('PENDING', 'RESPONDED', 'CLOSED') DEFAULT 'PENDING',
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (property_id) REFERENCES properties(id) ON DELETE CASCADE,
       FOREIGN KEY (customer_id) REFERENCES users(id) ON DELETE CASCADE
);