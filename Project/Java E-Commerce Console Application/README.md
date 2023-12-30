# Project Documentation for Java E-Commerce Console Application

## Introduction

This documentation provides an overview of the Java E-Commerce Console Application, a Java-based application designed to manage product inventories, handle orders, and maintain user profiles. 

The system utilizes Object-Oriented Programming (OOP) principles to create a modular, scalable, and maintainable codebase.

### System Overview
The Java E-Commerce Console Application comprises several classes, each serving a distinct role in the application. These classes are:

- **Product**: Represents products in the inventory.
- **Item**: Represents an item in an order, containing a product and its quantity.
- **Order**: Represents a customer's order, including items and total price.
- **OrderHistory**: Manages a history of orders.
- **Person**: An abstract class representing people involved in the system.
- **User**: Extends Person, representing a system user.
- **Admin**: Extends Person, representing an administrator.
- **AppInventory**: Manages the inventory of products.
- **Homepage**: The entry point for interacting with the system.
- **Main**: Contains the main method to start the application.

### Design Decisions

#### OOP Principles
- **Encapsulation**: Each class encapsulates its data and behavior, providing a clear interface for interaction.
- **Inheritance**: The Person class is used as a base for User and Admin, promoting code reuse.
- **Abstraction**: Person and Product are abstract classes, defining templates for specific types of people and products.
- **Polymorphism**: Methods in subclasses (e.g., User, Admin) override or extend the behavior of their superclass methods.

#### User Interaction: 
User interaction is primarily handled through the Homepage class, guiding users through various functionalities of the system.

#### Data Management
Collections like ArrayList are used for managing lists of products, orders, and users, facilitating dynamic data management.


## Features Implemented

#### 1) Inventory Management:

- Add, view, and update products in the inventory.
- Track product quantities and details.

#### 2) Order Processing:

- Create orders with multiple items.
- Calculate total price for orders.
- Maintain an order history.

#### 3) User Management:

- Differentiate between regular users and administrators.
- Store and manage user details.

#### 4) Security Measures:

- Username and password management for users.
- Encapsulation of sensitive data.

#### 5) System Interaction:

- User-friendly interface for navigating the system.
- Error handling for user inputs.

## Getting Started

This section will guide you through the initial setup and execution of the Java E-Commerce Console Application.

### Prerequisites:

- Java (JDK) installed on your machine. Ensure you have the latest version to avoid compatibility issues.

### Clone the Repository:
To get a copy of the project, clone the repository from GitHub using the following command in Bash:

`bash`

```
git clone https://github.com/your-username/inventory-management-system.git
```

### Compile and Run:
Navigate to the project directory and compile the Java files, then run the application:

`Bash`

```
cd java-e-commerce-console-application
javac Main.java
java Main
```

## Usage

Upon launching the application, users will interact with a simple command-line interface.

### For Users:

- **Browse Products**: View available products in the inventory.
- **Place Orders**: Select products and quantities to place an order.
- **View Order History**: Check past orders and their details.

### For Admins:

- **Manage Inventory**: Add, update, or remove products from the inventory.
- **View All Orders**: Access and review all user orders.
- **User Management**: Oversee user accounts, including creation and modification.

### Navigation:

The system provides prompts and menus to guide users through various actions.
Users make selections and input data as required to perform different tasks.

### Exiting:

Users can exit the application or return to the main menu at any point using the provided options.


# Conclusion

The Java E-Commerce Console Application is a comprehensive solution for managing product inventories and processing orders. 

The application's OOP design ensures a structured and scalable approach, suitable for future enhancements and maintenance. 

Users can interact with the system seamlessly, making it a practical tool for inventory and order management.