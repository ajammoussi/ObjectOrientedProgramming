# Online Library Management System

## Overview

This Java console application implements an Online Library Management System, providing a seamless experience for both users and administrators. 

The system incorporates Object-Oriented Programming (OOP) principles to ensure modularity, scalability, and maintainability.


## Table of Contents


- Design Decisions
- Features
- Usage
- Conclusion


## Design Decisions


The design of the Online Library is centered around two main entities: Users and Admins. Each entity has distinct functionalities and permissions, creating a clear separation of concerns.

### Object-Oriented Implementation

#### 1) Person Class:

- Serves as the base class for both User and Admin, encapsulating common attributes such as ID, first name, last name, username, and password.
- Methods for setting and retrieving user-specific information.

#### 2) User Class:

- Inherits from the Person class, adding functionalities specific to library users.
- Implements a subscription system with Free and Premium tiers, allowing users to borrow books, change subscriptions, participate in events (Premium), and more.

#### 3) Admin Class:

- Also inherits from the Person class, providing administrative capabilities.
- Enables admins to manage library events, users, view lending history, and perform other administrative tasks.

#### 4) Book Class:

- Represents a book with attributes like book ID, title, author, category, and available copies.
- Supports methods for displaying book information to users and administrators.

#### 5) Book Class:

- Models library events, including event ID, name, date, type, and a list of participants (users).
- Allows admins to create and remove events, while users can participate in Premium events.

#### 5) Lending and LendingHistory Classes:

- Track user book borrowings and maintain a lending history.
- Facilitate book borrowing, returning, and provide lending information.

#### 6) Supplier Class:

- Simulates a book supplier, providing available books to load into the library inventory.

#### 7) Homepage and Main Classes:

- Acts as a central repository for books, users, admins, events, and lending history.
- Supports functionalities like searching for users, displaying library inventory, and more.


## Features


### User Features

- **Borrow and Return Books**: Users can borrow and return books from the library inventory.
- **Change Subscription**: Users can switch between Free and Premium subscription tiers.
- **Participate in Events (Premium)**: Premium users can participate in library events.

### Admin Features

- **Create and Remove Events**: Admins can manage library events, creating and removing them.
- **Manage Users**: Admins can remove users from the system.
View Lending History: Admins can view the lending history of the library.
- **Load Books from Supplier**: Admins can add books to the library inventory from the supplier.
- **View Library Inventory**: Admins can view the current inventory of books in the library.


## Usage

Select your role upon launch (User or Admin)

### Navigation:

The system provides prompts and menus to guide users through various actions.
Users make selections and input data as required to perform different tasks.

### Exiting:

Users can exit the application or return to the main menu at any point using the provided options.

## Contributing

Open to contributions! Report issues or suggest improvements via issues or pull requests.
