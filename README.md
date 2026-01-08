# Ancient Wisdom Archive / RoyalCompliments

> "History is a set of lies agreed upon." — Napoleon Bonaparte

A full-stack Spring Boot application that curates, displays, and archives historical quotes. This project serves as a digital library for wisdom from history's greatest minds.

## Features

* **Consult the Archives:** Instantly summon random quotes from a persistent database.
* **Add to Archives:** Add new quotes and authors to the database via the UI.
* **Automatic Seeding:** Automatically populates the database with 50+ historically accurate quotes from `quotes.json` if the archives are empty.
* **Data Export:** Securely export the entire database to a JSON backup file via an admin endpoint.

## Tech Stack

* **Backend:** Java, Spring Boot
* **Database:** MongoDB (Running locally)
* **Frontend:** HTML5, Bootstrap 5, Vanilla JavaScript
* **Build Tool:** Gradle
* **Utilities:** Jackson (JSON processing)

## API Reference

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/compliment` | Fetch a random quote (JSON). |
| **POST** | `/api/compliment` | Add a new quote. Requires JSON body: `{ "text": "...", "author": "..." }`. |
| **DELETE** | `/api/compliment/{id}` | Delete a specific quote by its MongoDB ID. |
| **GET** | `/api/admin/export` | **Admin:** Download `backup.json` containing all stored quotes. |

## Project Structure

```text
backend
 ├── src/main/java/com/example/backend
 │   ├── Compliment.java            # The Entity (Data Model)
 │   ├── ComplimentController.java  # API Endpoints
 │   ├── ComplimentRepository.java  # MongoDB Interface
 │   └── DatabaseSeeder.java        # Loads quotes.json on startup
 └── src/main/resources
     ├── static                     # Frontend Files
     │   ├── index.html
     │   ├── css/style.css
     │   └── js/app.js
     └── quotes.json                # Initial data source
