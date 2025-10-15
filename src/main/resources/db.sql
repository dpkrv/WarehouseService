CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    contact_info VARCHAR(255)
);
CREATE INDEX idx_client_name ON clients(name);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    category VARCHAR(255),
    quantity INT
);
CREATE INDEX idx_product_category ON products(category);

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

CREATE TABLE warehouses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(255)
);
CREATE INDEX idx_warehouse_location ON warehouses(location);

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
CREATE INDEX idx_movement_product ON product_movement(product_id);