-- Create Customer Table
CREATE TABLE customers (
                           customer_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(255) NOT NULL,
                           email VARCHAR(255) UNIQUE NOT NULL,
                           mobile_number VARCHAR(15) UNIQUE NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create Accounts Table
CREATE TABLE accounts (
                          account_number BIGINT PRIMARY KEY,
                          customer_id BIGINT NOT NULL,
                          account_type VARCHAR(50) NOT NULL,
                          branch_address VARCHAR(255) NOT NULL,
                          balance DECIMAL(15,2) DEFAULT 0.00,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
);

-- Create Payees Table
CREATE TABLE payees (
                        payee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        customer_id BIGINT NOT NULL,
                        payee_name VARCHAR(255) NOT NULL,
                        payee_account_number BIGINT NOT NULL,
                        bank_name VARCHAR(255) NOT NULL,
                        ifsc_code VARCHAR(20) NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
);

-- Create Fund Transfers Table
CREATE TABLE fund_transfers (
                                transfer_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                from_account_number BIGINT NOT NULL,
                                to_account_number BIGINT NOT NULL,
                                amount DECIMAL(15,2) NOT NULL,
                                transaction_description VARCHAR(255),
                                transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                FOREIGN KEY (from_account_number) REFERENCES accounts(account_number) ON DELETE CASCADE,
                                FOREIGN KEY (to_account_number) REFERENCES accounts(account_number) ON DELETE CASCADE
);

-- Create Transactions Table
CREATE TABLE transactions (
                              transaction_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              account_number BIGINT NOT NULL,
                              transaction_type ENUM('DEBIT', 'CREDIT') NOT NULL,
                              amount DECIMAL(15,2) NOT NULL,
                              transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              description VARCHAR(255),
                              FOREIGN KEY (account_number) REFERENCES accounts(account_number) ON DELETE CASCADE
);

-- Create Bill Payments Table
CREATE TABLE bill_payments (
                               bill_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               customer_id BIGINT NOT NULL,
                               account_number BIGINT NOT NULL,
                               bill_type ENUM('ELECTRICITY', 'WATER', 'PHONE', 'INTERNET', 'OTHER') NOT NULL,
                               amount DECIMAL(15,2) NOT NULL,
                               bill_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE,
                               FOREIGN KEY (account_number) REFERENCES accounts(account_number) ON DELETE CASCADE
);

-- Create Recharge Table
CREATE TABLE recharges (
                           recharge_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           customer_id BIGINT NOT NULL,
                           account_number BIGINT NOT NULL,
                           mobile_number VARCHAR(15) NOT NULL,
                           amount DECIMAL(10,2) NOT NULL,
                           recharge_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE,
                           FOREIGN KEY (account_number) REFERENCES accounts(account_number) ON DELETE CASCADE
);

-- Create Cheque Requests Table
CREATE TABLE cheque_requests (
                                 cheque_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 account_number BIGINT NOT NULL,
                                 number_of_leaves INT NOT NULL,
                                 request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
                                 FOREIGN KEY (account_number) REFERENCES accounts(account_number) ON DELETE CASCADE
);

-- Create Stop Cheque Table
CREATE TABLE stop_cheques (
                              stop_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              account_number BIGINT NOT NULL,
                              cheque_number BIGINT NOT NULL,
                              reason VARCHAR(255),
                              stop_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (account_number) REFERENCES accounts(account_number) ON DELETE CASCADE
);
