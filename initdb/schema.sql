-- Create User table
CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL
);

-- Create Operation table
CREATE TABLE IF NOT EXISTS operation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cost DOUBLE NOT NULL,
    type_operation VARCHAR(20) NOT NULL
);

-- Create Record table
CREATE TABLE IF NOT EXISTS record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_user BIGINT NOT NULL,
    id_operation BIGINT NOT NULL,
    amount DOUBLE NOT NULL,
    user_balance DOUBLE NOT NULL,
    operation_response VARCHAR(500),
    operation_timestamp TIMESTAMP,
    FOREIGN KEY (id_user) REFERENCES user(id),
    FOREIGN KEY (id_operation) REFERENCES operation(id)
);

-- Insert initial data into User table
INSERT INTO user (username, password, status) VALUES
('user1', 'password1', 'active'),
('user2', 'password2', 'active'),
('user3', 'password3', 'inactive'),
('user4', 'password4', 'active');

INSERT INTO operation (cost, type_operation) VALUES
(10.0, 'addition'),
(20.0, 'subtraction'),
(5.0, 'multiplication'),
(30.0, 'division'),
(25.0, 'sqrt'),
(50.0, 'randomString');

INSERT INTO record (id_user, id_operation, amount, user_balance, operation_response, operation_timestamp) VALUES
(1, 1, 0.0, 100.0, 'Balance inicial', CURRENT_TIMESTAMP ),
(2, 1, 0.0, 50.0, 'Balance inicial', CURRENT_TIMESTAMP ),
(3, 1, 0.0, 200.0, 'Balance inicial', CURRENT_TIMESTAMP ),
(4, 1, 0.0, 0.0, 'Balance inicial', CURRENT_TIMESTAMP)
;