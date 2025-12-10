# Strongs-API

[![GitHub license](https://img.shields.io/badge/License-Unspecified-lightgrey.svg)](LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/TimBent/strongs-api.svg?style=flat)](https://github.com/TimBent/strongs-api/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/TimBent/strongs-api.svg)](https://github.com/TimBent/strongs-api/issues)
[![Language](https://img.shields.io/badge/Language-Java-blue.svg)](https://www.java.com/)
[![Build Tool](https://img.shields.io/badge/Build-Maven-orange.svg)](https://maven.apache.org/)

## 📖 Overview

The **Strongs-API** project provides a robust and scalable RESTful API built in **Java** to access and serve data from **Strong's Exhaustive Concordance of the Bible**. The primary goal is to offer developers a simple and performant way to integrate original language lexical data (Hebrew and Greek Strong's numbers) into applications, websites, and scholarly tools.

## ✨ Features

* **RESTful Endpoints:** Standardized routes for looking up Hebrew (H) and Greek (G) Strong's entries.
* **Fast Lookups:** Designed for high-speed retrieval of definitions, transliterations, and grammatical details.
* **Built with Java/Spring:** Utilizes a modern, enterprise-grade technology stack for stability and performance.
* **Containerized:** Includes a `Dockerfile` for easy deployment via Docker.

## 🚀 Getting Started

These instructions will get a copy of the project running on your local machine for development and testing purposes.

### Prerequisites

* **Java Development Kit (JDK):** Version 17 or higher (based on modern Maven conventions).
* **Apache Maven:** Used for building and dependency management.
* **Git:** For cloning the repository.

### Installation & Build

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/TimBent/strongs-api.git](https://github.com/TimBent/strongs-api.git)
    cd strongs-api
    ```

2.  **Build the project using Maven:**
    The `pom.xml` indicates this is a Maven project. Execute the following command to compile the code and package it into a JAR file:
    ```bash
    mvn clean install
    ```

3.  **Run the application:**
    Once the build is successful, you can run the executable JAR file (the exact name will depend on the final Maven configuration, typically found in the `/target` directory):
    ```bash
    java -jar target/[application-name].jar
    ```

    The API should start and typically be accessible on `http://localhost:8080`.

### Containerized Setup (Docker)

Since a `Dockerfile` is present, you can build and run the application as a Docker container:

1.  **Build the Docker image:**
    ```bash
    docker build -t strongs-api .
    ```

2.  **Run the container:**
    ```bash
    docker run -p 8080:8080 strongs-api
    ```
    The API will be available at `http://localhost:8080`.

## ⚙️ API Endpoints (Conceptual)

Assuming standard naming conventions for a Strong's API, the following endpoints are expected:

| Method | Endpoint | Description | Example Strong's Number |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/strongs/H{number}` | Retrieve an entry by its Hebrew Strong's number. | `H0430` (for Elohim) |
| `GET` | `/api/v1/strongs/G{number}` | Retrieve an entry by its Greek Strong's number. | `G3956` (for Pas) |
| `GET` | `/api/v1/health` | Check the operational status of the service. | - |

## 🤝 Contributing

We welcome contributions! Please feel free to open an issue or submit a pull request for new features, bug fixes, or improvements.

## 📜 License

Please review the `LICENSE` file (once added) in the repository for details on the licensing terms for this project.

***
