# Real-Time Room-Based Messaging Web Application

A real-time web-based messaging application that allows users to create or join chat rooms and communicate with other users through real-time messaging.

The system is designed around **room-based communication**. A user can create a room by providing a room name and room ID, while other users can join an existing room by providing their name and the corresponding room ID.

---

## 1. Project Overview

This project is a real-time messaging web application developed using a modern client-server architecture.

The application allows users to:

- Create a new chat room.
- Enter a room using a room ID.
- Join a room by providing their name.
- Send and receive messages in real time.
- Communicate with other users within the same room.
- Manage room-based communication without requiring a traditional login or registration system.

The application uses **WebSocket communication with STOMP and SockJS** to provide real-time messaging between users.

### Basic User Flow

```text
                    Start
                      |
                      v
              Open Web Application
                      |
             +--------+--------+
             |                 |
             v                 v
       Create a Room      Join a Room
             |                 |
             v                 v
       Room Name + ID      Name + Room ID
             |                 |
             v                 v
        Enter Room        Verify Room
             |                 |
             +--------+--------+
                      |
                      v
                 Chat Room
                      |
                      v
             Real-Time Messaging
```

---

# 2. Main Technologies

## Frontend

- **React**
- **Vite**
- **React Router**
- **Axios**
- **STOMP**
- **SockJS**
- **React Icons**

The frontend provides the user interface and communicates with the Spring Boot backend through REST APIs and WebSocket connections.

## Backend

- **Java**
- **Spring Boot**
- **Spring Web**
- **Spring WebSocket**
- **STOMP**
- **SockJS**

The backend handles room management, messaging, API requests, and WebSocket communication.

## Database

- **MongoDB**

MongoDB is used to store application data such as rooms, messages, and other required information.

## Development Tools

- IntelliJ IDEA
- Visual Studio Code
- Git
- GitHub
- Node.js
- npm
- Maven

---

# 3. System Architecture

The application follows a client-server architecture.

```text
                +----------------------+
                |      React + Vite    |
                |       Frontend       |
                +----------+-----------+
                           |
                REST / Axios / WebSocket
                           |
                           v
                +----------------------+
                |     Spring Boot      |
                |       Backend        |
                +----------+-----------+
                           |
                           v
                +----------------------+
                |       MongoDB        |
                |       Database       |
                +----------------------+
```

### Communication

The frontend communicates with the backend in two main ways:

### REST API

Used for operations such as:

- Creating rooms
- Retrieving room information
- Joining rooms
- Other standard HTTP-based operations

### WebSocket

Used for:

- Real-time message delivery
- Sending messages
- Receiving messages without refreshing the page
- Real-time communication between users

STOMP is used as the messaging protocol, while SockJS provides WebSocket fallback support.

---

# 4. Project Structure

The project is divided into two major parts:

```text
Project/
│
├── backend/
│   └── Spring Boot Application
│
├── frontend/
│   └── React + Vite Application
│
└── README.md
```

The exact folder names may differ depending on the local project structure.

---

# 5. Backend Structure

The backend is a Spring Boot application.

A typical structure is:

```text
backend/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── [package]
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── model/
│   │   │       ├── config/
│   │   │       └── ...
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── ...
```

### Important Backend Components

#### Controller

Handles HTTP requests received from the frontend.

For example:

```text
Frontend
   |
   | HTTP Request
   v
Controller
```

#### Service

Contains the main application/business logic.

```text
Controller
    |
    v
Service
    |
    v
Repository
```

#### Repository

Responsible for communicating with MongoDB.

#### Model

Contains the application's data models, such as rooms and messages.

#### Configuration

Contains application configuration, including WebSocket/STOMP configuration where applicable.

---

# 6. Frontend Structure

The frontend is developed using React and Vite.

A typical structure is:

```text
frontend/
│
├── src/
│   ├── components/
│   ├── pages/
│   ├── context/
│   ├── services/
│   ├── hooks/
│   ├── App.jsx
│   ├── main.jsx
│   └── ...
│
├── public/
├── package.json
├── vite.config.js
└── ...
```

The exact folders may vary depending on the implementation.

### Components

Reusable React UI components.

### Pages

Application pages such as room creation, room joining, and the chat interface.

### Context

Used for sharing application state between components where required.

### Services

Contains frontend communication logic such as Axios API requests or other service-related functionality.

---

# 7. Room Creation

A user can create a new room by providing:

- Room name
- Room ID

After successful creation, the user enters the room and becomes the initial user associated with that room.

Example:

```text
Room Name: Software Development
Room ID: SD2026
```

The room ID is used by other users to identify the room they want to join.

---

# 8. Joining a Room

A user who wants to join an existing room provides:

- Their name
- The room ID

The backend checks whether the requested room exists.

If the room exists, the user can enter the room according to the application's room-access rules.

There is currently **no traditional login or registration page**. Users do not need to create an account with a username and password before using the application.

---

# 9. Real-Time Messaging

Once users are inside the same room, they can communicate using real-time messaging.

The communication flow is:

```text
User A
   |
   | Send Message
   v
React Frontend
   |
   | WebSocket / STOMP
   v
Spring Boot Backend
   |
   | Broadcast
   v
Other Users in Room
```

Messages are delivered without requiring users to manually refresh the page.

The application uses:

```text
STOMP
   +
SockJS
   +
Spring WebSocket
```

for real-time communication.

---

# 10. Database

The application uses MongoDB as its database.

MongoDB stores the persistent information required by the application.

The Spring Boot backend communicates with MongoDB through the application's repository/data-access layer.

The database configuration is maintained in:

```text
backend/src/main/resources/application.properties
```

The actual MongoDB connection configuration should be kept private and should not be committed to a public repository if it contains credentials or other sensitive information.

---

# 11. How to Run the Backend

## Prerequisites

Make sure the following are installed:

- Java
- Maven
- MongoDB

First, make sure MongoDB is running.

Then open a terminal inside the backend directory:

```bash
cd backend
```

Run the Spring Boot application using Maven:

```bash
mvn spring-boot:run
```

Alternatively, if the project uses the Maven wrapper:

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux/macOS

```bash
./mvnw spring-boot:run
```

The backend should start on the configured Spring Boot port, commonly:

```text
http://localhost:8080
```

The actual port depends on the project's configuration.

---

# 12. How to Run the Frontend

Open another terminal and navigate to the frontend directory:

```bash
cd frontend
```

Install the required Node.js dependencies:

```bash
npm install
```

Then start the Vite development server:

```bash
npm run dev
```

Vite will normally display something similar to:

```text
VITE ready

Local: http://localhost:5173/
```

Open the displayed local URL in a web browser.

### Important

The backend and frontend should normally be running at the same time.

For example:

```text
Terminal 1:
Spring Boot Backend
http://localhost:8080

Terminal 2:
Vite Frontend
http://localhost:5173
```

---

# 13. Recommended Startup Order

When running the complete application locally:

### Step 1 — Start MongoDB

Make sure the MongoDB server is running.

### Step 2 — Start the Backend

```bash
cd backend
mvn spring-boot:run
```

### Step 3 — Start the Frontend

Open another terminal:

```bash
cd frontend
npm install
npm run dev
```

### Step 4 — Open the Application

Open the URL provided by Vite, usually:

```text
http://localhost:5173
```

---

# 14. Git and GitHub

The project uses Git for version control.

Basic commands:

```bash
git status
```

To add changes:

```bash
git add .
```

To create a commit:

```bash
git commit -m "Describe your changes"
```

To push changes to GitHub:

```bash
git push
```

Before pushing the project, make sure sensitive information such as passwords, API keys, private credentials, and local configuration files are not committed.

---

# 15. Development Workflow

A typical development workflow is:

```text
1. Start MongoDB
       |
       v
2. Start Spring Boot Backend
       |
       v
3. Start React/Vite Frontend
       |
       v
4. Open Application
       |
       v
5. Create or Join a Room
       |
       v
6. Test Real-Time Messaging
       |
       v
7. Modify Code
       |
       v
8. Test Again
       |
       v
9. Commit Changes with Git
```

---

# 16. Current Access Model

The application does not use a conventional authentication system.

There is:

- No login page
- No registration page
- No password-based authentication

A user identifies themselves by providing their name when joining a room.

Room access is based on the room ID and the application's room-management logic.

---

# 17. Planned Room Access Control

A planned extension of the system is to introduce **room-level membership approval**.

The intended flow is:

```text
User wants to join room
          |
          v
Is user already a member?
       /       \
     Yes        No
      |          |
      v          v
Enter room   Send request
                 |
                 v
            Room Admin
                 |
          +------+------+
          |             |
       Approve        Reject
          |             |
          v             v
     Add member      Deny access
          |
          v
      Enter room
```

The first user who creates and enters a room acts as the administrator of that room.

This feature can be implemented as an extension to the existing room and WebSocket architecture without replacing the current messaging functionality.

---

# 18. Troubleshooting

## Frontend does not start

Try:

```bash
npm install
npm run dev
```

If dependencies are corrupted, remove `node_modules` and reinstall:

```bash
npm install
```

## Backend does not start

Check:

- Java installation
- Maven installation
- MongoDB status
- `application.properties`
- MongoDB connection configuration
- Port conflicts

## Messages are not appearing in real time

Check:

- Backend is running
- Frontend is connected to the correct backend address
- WebSocket/STOMP endpoint configuration
- SockJS configuration
- Browser console for frontend errors
- Spring Boot console for backend errors

## Cannot connect to MongoDB

Check:

- MongoDB service is running
- MongoDB connection URI
- Database configuration
- Username/password, if authentication is enabled
- MongoDB port

---

# 19. Project Goal

The main goal of this project is to provide a simple, real-time, room-based communication platform where users can communicate without requiring a traditional account registration and login system.

The system combines:

```text
React + Vite
      +
Spring Boot
      +
MongoDB
      +
WebSocket
      +
STOMP / SockJS
```

to provide a responsive real-time messaging experience.

---

# 20. Quick Start

For a quick local setup:

### Terminal 1 — Backend

```bash
cd backend
mvn spring-boot:run
```

### Terminal 2 — Frontend

```bash
cd frontend
npm install
npm run dev
```

Then open the Vite URL shown in the terminal, normally:

```text
http://localhost:5173
```

Make sure MongoDB is running before starting the backend.
