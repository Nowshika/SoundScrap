# SoundScrap 🎵

> A full-stack music web application built with Spring Boot and React, designed with a Pinterest-inspired pastel aesthetic.

<img width="1439" height="898" alt="Screenshot 2026-04-07 at 10 06 00 AM" src="https://github.com/user-attachments/assets/f60e986d-c310-4443-8cea-441fe98ac2d1" />
<img width="818" height="898" alt="Screenshot 2026-04-07 at 10 07 40 AM" src="https://github.com/user-attachments/assets/0e8e2a45-ec5e-4b76-9ee5-7b42642a595b" />
<img width="1439" height="898" alt="Screenshot 2026-04-07 at 10 07 05 AM" src="https://github.com/user-attachments/assets/f027014f-cbe6-4df7-b35d-85ab0d461102" />
<img width="1439" height="788" alt="Screenshot 2026-04-07 at 10 08 10 AM" src="https://github.com/user-attachments/assets/07cca686-5c16-4e4c-a4df-165bd576f278" />
<img width="1439" height="788" alt="Screenshot 2026-04-07 at 10 09 03 AM" src="https://github.com/user-attachments/assets/a182ff07-9d7e-4837-8f14-26d076b62164" />

---

## About This Project

SoundScrap is a full-stack web application that allows users to build a personal music board — pin songs, filter them by mood, and manage a collection through a live REST API. The project was built as a hands-on learning exercise to understand how a backend API and a frontend UI communicate in a real-world application.

The name *SoundScrap* is inspired by the idea of a scrapbook — collecting and pinning things you love, but for music.

---

## What I Built

- A **RESTful API** using Spring Boot that handles all song data
- A **PostgreSQL database** that persists songs with full CRUD operations
- A **React frontend** that fetches data from the API and renders it as an interactive UI
- A **mood-based filtering system** that queries the backend dynamically
- A clean **component-based frontend architecture** following React best practices
- **Axios integration** to connect the frontend and backend seamlessly

---

## Concepts I Learned and Applied

### Backend — Spring Boot

| Concept | How It Was Used |
|---|---|
| `@RestController` | Marks the controller class to handle HTTP requests and return JSON |
| `@RequestMapping` | Maps all song-related routes under `/api/songs` |
| `@GetMapping` / `@PostMapping` / `@PutMapping` / `@DeleteMapping` | Handles each HTTP method for CRUD operations |
| `@PathVariable` | Extracts values from the URL (e.g. `/api/songs/{id}`) |
| `@RequestBody` | Deserializes incoming JSON into a Java object |
| `@CrossOrigin` | Allows the React frontend on a different port to call the API |
| `@Entity` | Maps the `Song` class to a PostgreSQL database table |
| `@Id` + `@GeneratedValue` | Auto-generates a unique primary key for each song |
| `JpaRepository` | Provides built-in database methods like `findAll()`, `save()`, `deleteById()` |
| Derived Query Methods | Custom queries like `findByMoodIgnoreCase()` written as method names |
| `@Service` | Separates business logic from the controller layer |
| `@RequiredArgsConstructor` (Lombok) | Auto-generates constructor-based dependency injection |
| `spring.jpa.hibernate.ddl-auto=update` | Auto-creates and updates database tables from entity classes |

### Frontend — React

| Concept | How It Was Used |
|---|---|
| Functional Components | All UI built as reusable functional components |
| `useState` | Manages songs list, filter state, modal visibility, and loading state |
| `useEffect` | Fetches songs from the API when the component first mounts |
| Props | Passes song data and event handlers between parent and child components |
| Conditional Rendering | Shows loading state, empty board state, and modal based on conditions |
| Array `.map()` | Renders a `SongCard` for each song returned by the API |
| Array `.filter()` | Filters songs by mood on the frontend |
| Axios | Makes HTTP GET, POST, PUT, DELETE requests to the Spring Boot API |
| Component Composition | `App` → `Board` → `SongCard` hierarchy for clean separation |
| CSS Transitions | Hover effects, card tilt animations, and smooth UI interactions |
| Google Fonts | Custom typography using Cormorant Garamond and Montserrat |
| Responsive Grid | `auto-fill` CSS grid that adapts to screen size including mobile |

### Database — PostgreSQL

| Concept | How It Was Used |
|---|---|
| Relational Database | Stores all song records in a `songs` table |
| Primary Key | Auto-incremented `id` field uniquely identifies each song |
| TRUNCATE + RESTART IDENTITY | Resets the table and id counter cleanly during development |
| JPA / Hibernate ORM | Maps Java objects directly to database rows without writing raw SQL |

### Software Architecture

| Pattern | How It Was Applied |
|---|---|
| Layered Architecture | Separated into Controller → Service → Repository → Database layers |
| REST Architecture | Stateless API with standard HTTP methods and JSON responses |
| Separation of Concerns | Frontend only handles UI; backend handles all data and business logic |
| Component-Based UI | React UI broken into small, reusable, single-responsibility components |

---

## Project Structure

```
SoundScrap/
│
├── soundscrap/                          ← Spring Boot Backend
│   └── src/main/java/com/soundscrap/soundscrap/
│       ├── model/
│       │   └── Song.java                ← Entity / DB table
│       ├── repository/
│       │   └── SongRepository.java      ← Database queries
│       ├── service/
│       │   └── SongService.java         ← Business logic
│       ├── controller/
│       │   └── SongController.java      ← REST API endpoints
│       └── SoundscrapApplication.java   ← App entry point
│   └── src/main/resources/
│       └── application.properties       ← DB config
│
└── soundscrap-front/                    ← React Frontend
    └── src/
        ├── components/
        │   ├── SongCard.jsx             ← Individual song card
        │   ├── Board.jsx                ← Song grid layout
        │   └── AddSongModal.jsx         ← Add song form
        ├── services/
        │   └── api.js                   ← Axios API calls
        ├── App.jsx                      ← Root component
        └── App.css                      ← All styles
```

---

## API Reference

Base URL: `http://localhost:8080/api`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/songs` | Returns all songs |
| `GET` | `/songs/{id}` | Returns a single song by ID |
| `GET` | `/songs/mood/{mood}` | Returns songs filtered by mood |
| `POST` | `/songs` | Creates and saves a new song |
| `PUT` | `/songs/{id}` | Updates an existing song by ID |
| `DELETE` | `/songs/{id}` | Deletes a song by ID |

### Request Body Example

```json
{
  "title": "Wild Flower",
  "artist": "RM",
  "album": "Indigo",
  "genre": "indie",
  "mood": "dreamy",
  "coverColor": "#ddf2ea",
  "durationSeconds": 234,
  "imageUrl": "https://your-image-url.jpg",
  "audioUrl": "/assets/audio/wild_flower.mp3"
}
```

---

## Tech Stack

| Layer | Technology | Purpose |
|-------|-----------|---------|
| Language | Java 17 | Backend logic |
| Framework | Spring Boot 3.2 | REST API and auto-configuration |
| ORM | Spring Data JPA + Hibernate | Database communication |
| Database | PostgreSQL | Persistent data storage |
| Build Tool | Maven | Dependency management |
| Boilerplate | Lombok | Reduces repetitive Java code |
| Frontend | React 18 | Component-based UI |
| HTTP Client | Axios | API requests from the frontend |
| Styling | Custom CSS | Pastel Pinterest aesthetic |
| IDE (Backend) | IntelliJ IDEA | Java development |
| IDE (Frontend) | VS Code | React development |
| API Testing | Postman | Testing and debugging REST endpoints |
| Version Control | Git + GitHub | Source code management |

---

## How to Run Locally

### Prerequisites
- Java 17+
- Node.js 18+
- PostgreSQL
- Maven

### Step 1 — Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/SoundScrap.git
cd SoundScrap
```

### Step 2 — Set up PostgreSQL

```bash
psql -U postgres
CREATE DATABASE soundscrap;
\q
```

### Step 3 — Configure the backend

Edit `soundscrap/src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/soundscrap
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.port=8080
```

### Step 4 — Run the backend

```bash
cd soundscrap
./mvnw spring-boot:run
```

API is live at → `http://localhost:8080`

### Step 5 — Run the frontend

```bash
cd soundscrap-front
npm install
npm start
```

App is live at → `http://localhost:3000`

---

## Key Learning Outcomes

1. Understood how a **client-server architecture** works in practice — the React frontend and Spring Boot backend are completely separate applications that communicate over HTTP.

2. Learned how **JPA and Hibernate** abstract away SQL — defining a Java class with `@Entity` is enough to create and manage a real database table automatically.

3. Applied the **layered architecture pattern** (Controller → Service → Repository) and understood why separating these concerns makes code easier to maintain and scale.

4. Used **derived query methods** in Spring Data JPA and understood how method names like `findByMoodIgnoreCase()` are automatically converted into SQL queries by the framework.

5. Understood **CORS** and why a frontend on port 3000 cannot call a backend on port 8080 without explicitly allowing it with `@CrossOrigin`.

6. Built a working mental model of **React's data flow** — how state lives in the parent component and gets passed down to children through props, and how events bubble back up through callback functions.

7. Learned that **`useEffect` with an empty dependency array `[]`** runs exactly once when the component mounts — the correct place to fetch initial data from an API.

8. Understood the importance of **separating the frontend from the backend** — the image URLs and audio paths are stored in the database and served through the API, so the frontend contains zero hardcoded data.

---

## Author

**Nowshika Mirza**
Full Stack Developer (Learning)

Built from scratch as a guided full-stack learning project — covering backend API design, database modeling, frontend development, and connecting them together into a single working application.

---

## License

MIT License — free to use, fork, and build upon.
