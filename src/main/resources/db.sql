CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    contact_info VARCHAR(255)
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    category VARCHAR(255),
    quantity INT
);

CREATE TABLE logistics (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(255),
    transport_type VARCHAR(255)
);

CREATE TABLE contractors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    contact_info VARCHAR(255)
);

CREATE TABLE product_movement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    logistics_id INT,
    client_id INT,
    movement_date DATE,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (logistics_id) REFERENCES logistics(id),
    FOREIGN KEY (client_id) REFERENCES clients(id)
);