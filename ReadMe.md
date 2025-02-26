# 🛒Smart Cart Online Store System

🚀 SmartCart Online Store System is implemented using the **Java** language with **Object-Oriented Programming** concepts. This system is designed for customers to browse and purchase items, and for admins to manage the items available in the store. 

The provided skeleton code is for implementing functionality of the system. The class diagram shows the relationship between the classes, their attributes and methods, and the domain model diagram shows the connections and interactions between the entities in the system. It is easier to build upon the skeleton code to create a functional online store management system with a proper understanding of the structure of the diagrams and the relationships between them.

---

## 📜 Introduction
The **Smart Cart Online Store System** is developed using **Java** with **Object-Oriented Programming (OOP)** principles. This system allows:
- 🛒 **Customers** to browse, add, remove, update, and purchase items.
- 🛠️ **Admins** to manage store items, including adding, updating, and removing products.

It follows various **design patterns** such as **Factory, Command, Template, and MVC** and uses **Java RMI** for server-client communication.

---

## 📂 Project Structure
```
📦 OnlineStoreManagementSystem
 ├── 📁 src
 │   ├── 📄 **OnlineStoreInt.java**  # Interface for remote methods
 │   ├── 📄 **OnlineStore.java**     # Business logic implementation
 │   ├── 📄 **Item.java**            # Represents an item in store
 │   ├── 📄 **CartItem.java**        # Represents an item in shopping cart
 │   ├── 📄 **ShopCart.java**        # Shopping cart operations
 │   ├── 📄 **Command.java**         # Command interface
 │   ├── 📄 **CommandAddItem.java**  # Command to add item
 │   ├── 📄 **CommandUpdateItem.java** # Command to update item
 │   ├── 📄 **CommandRemoveItem.java** # Command to remove item
 │   ├── 📄 **OnlineStoreFactoryInt.java** # Factory interface
 │   ├── 📄 **OnlineStoreFactoryDefault.java** # Factory class implementation
 │   ├── 📄 **OnlineStoreClient.java** # Client-side interaction
 │   ├── 📄 **OnlineStoreServer.java** # Server-side operations
```

---

## 🎯 Features
### 👥 **User Functionalities**
- 🛍️ **Browse** available items.
- ➕ **Add** items to the shopping cart.
- ✏️ **Update** item quantity.
- ❌ **Remove** items from the cart.
- 💰 **Checkout** and purchase items.

### 🏪 **Admin Functionalities**
- 🏗️ **Add** new items to the store.
- 🔄 **Update** existing products.
- ❌ **Remove** items from the store.
- 📜 **View** all store products.

---

## 🎨 **Architectural Design Patterns Used**
- **🛑 MVC (Model-View-Controller):** Separates concerns of UI, data, and control flow.
- **🗝️ Authorization Pattern:** Controls access based on roles (Admin/User).
- **🏭 Factory & Abstract Factory Pattern:** Creates object instances without specifying concrete classes.
- **📜 Template Pattern:** Defines a blueprint for subclasses.
- **🔀 Command Pattern:** Encapsulates requests into objects for flexibility.

---

## 🚀 **How to Run**

1. **Start `rmiregistry`** on port `2002` (or any other, but use the one specified in the code) on the server machine. 🔌
   
2. Run `make clean` to remove all files apart from the original source files. 🧹
   
3. Compile all the Java files using the `make` command. ⚙️
   
4. Execute `make server` to start the server program and run the `OnlineStoreServer` class. 🖥️
   
5. Execute `make client` to start the client program and run the `OnlineStoreClient` class. 📱
   
6. Choose the appropriate role in the terminal:
   - Enter `1` for **Admin login** 🛠️.
   - Enter `2` for **User login** 👤.

### **If Admin Role is Selected:** 👩‍💼👨‍💼

1. If you're an **existing Admin** account holder, enter `1`.  
   For creating a new **Admin** account, enter `2` and provide the desired username and password. 📝

2. To login to an existing Admin account:
   - Enter admin username: `adminname1`
   - Enter admin password: `adminpass1`
   
   (**Note:** The credentials are predefined in the program for verification purposes.) ✅

3. For Admin, the following functionalities are available. Please select the appropriate option based on your needs:

   - **1. Browse Item** 👀  
     "Browse Item" allows admins to browse all the items available in the store for purchase and view their detailed information.
   
   - **2. Update Item** ✏️  
     "Update Item" allows admins to edit the product description and prices.
   
   - **3. Remove Item** ❌  
     "Remove Item" allows admins to remove an item from the store based on the item ID.
   
   - **4. Add Item** ➕  
     "Add Item" allows admins to add a new item to the store.
   
   - **5. Exit** 🚪  
     "Exit" logs the admin out of the account.

---

### **If User Role is Selected:** 👩‍💻👨‍💻

1. If you're an **existing User** account holder, enter `1`.  
   For creating a new **User** account, enter `2` and provide the desired username and password. 📝

2. To login to an existing User account:
   - Provide username: `username1`
   - Provide password: `pass1`
   
   (**Note:** The credentials are predefined in the program for verification purposes.) ✅

3. For the User, the following functionalities are available. Please select the appropriate option based on your needs:

   - **i. Browse Items** 🔍  
     "Browse Items" allows users to browse all items available in the store for purchase and view their detailed information.
   
   - **ii. Add Item to Cart** 🛒  
     "Add Item to Cart" allows the user to add an item to the cart. This can be done by providing input to the prompt:  
       - Provide **Item Id**  
       - Provide **Item Quantity**
   
   - **iii. Remove Item from Cart** 🗑️  
     "Remove Item from Cart" allows users to remove an item already added to the cart. This can be done by providing input to the prompt:  
       - Enter the **Item ID**
   
   - **iv. Update Item Quantity** 🔄  
     "Update Item Quantity" allows users to update the quantity of an item already added to the cart. This can be done by providing input to the prompt:  
       - Provide **Item ID**  
       - Provide **Item Quantity**
   
   - **v. Display Cart Items** 📦  
     "Display Cart Items" allows users to check the items added to the cart.
   
   - **vi. Display Total Bill from Cart** 💰  
     "Display Total Bill from Cart" allows users to display the total bill for all items added to the cart.

---

## **Important Notes:**

- **Predefined Credentials**: The program has predefined credentials for both the admin and user roles for easy login and testing. 🔑
  
- Ensure that you follow the steps in order, as skipping any part may cause issues with system execution. ⚠️

---


## 📜 **License**
This project is licensed under the **MIT License**.
