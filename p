1.create the customers table and populate it with some sample data.
2. -- Create the 'customers' table
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

-- Insert sample data into the 'customers' table
INSERT INTO customers (name, email, phone) VALUES
('Alice Smith', 'alice.smith@example.com', '555-1234'),
('Bob Johnson', 'bob.johnson@example.com', '555-5678'),
('Charlie Brown', 'charlie.brown@example.com', '555-8765'),
('Diana Prince', 'diana.prince@example.com', '555-4321'),
('Edward Norton', 'edward.norton@example.com', '555-9876'),
('Fiona Gallagher', 'fiona.gallagher@example.com', '555-1111'),
('George Michael', 'george.michael@example.com', '555-2222'),
('Hannah Baker', 'hannah.baker@example.com', '555-3333'),
('Isaac Newton', 'isaac.newton@example.com', '555-4444'),
('Jessica Jones', 'jessica.jones@example.com', '555-5555'),
('Kevin Bacon', 'kevin.bacon@example.com', '555-6666'),
('Lara Croft', 'lara.croft@example.com', '555-7777'),
('Michael Scott', 'michael.scott@example.com', '555-8888'),
('Nancy Drew', 'nancy.drew@example.com', '555-9999'),
('Oscar Wilde', 'oscar.wilde@example.com', '555-0000'),
('Pam Beesly', 'pam.beesly@example.com', '555-1010'),
('Quentin Tarantino', 'quentin.tarantino@example.com', '555-2020'),
('Rachel Green', 'rachel.green@example.com', '555-3030'),
('Steve Rogers', 'steve.rogers@example.com', '555-4040'),
('Tony Stark', 'tony.stark@example.com', '555-5050');
You are tasked with developing a Customer Records Management System for a company. The system should allow customer service representatives to view and navigate through customer records stored in a MySQL database. The system must provide functionality to:
1.	Display the first customer record when the application starts.
2.	Allow navigation to the next, previous, first, or last customer record.
3.	Display appropriate messages when trying to navigate beyond the available records.
4.	Allow the user to exit the application.
Requirements
1.	Display Customer Details: When navigating through the records, display the customer's ID, name, email, and phone number.
2.	Navigation Commands:
o	[N]ext: Move to the next record.
o	[P]revious: Move to the previous record.
o	[F]irst: Move to the first record.
o	[L]ast: Move to the last record.
o	[E]xit: Exit the application.
o	[I]nsert: Insert a new record
o	[D]elete: Delete the record
3.	Error Handling: Display appropriate messages when attempting to navigate past the first or last record.