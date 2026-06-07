# OPP PROJECT

<div align="center">

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Java%20Swing-Desktop%20GUI-5382A1?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Apache Ant](https://img.shields.io/badge/Apache%20Ant-Build-A81C7D?style=for-the-badge&logo=apacheant&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-Project-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white)

![Repository](https://img.shields.io/badge/repository-GitHub-181717?style=flat-square&logo=github)
![Status](https://img.shields.io/badge/status-active-success?style=flat-square)
![Project Type](https://img.shields.io/badge/type-desktop%20application-blue?style=flat-square)

A Java Swing student information and portal management system built with NetBeans, Apache Ant, MySQL, JDBC, JCalendar, and JavaMail.

</div>

## Overview

OPP PROJECT is a desktop application for managing student portal access and student profile information. It separates administrator and student workflows through different login screens and dashboard modules.

The admin module focuses on account management: creating student users, searching records, updating user data, deleting users, and monitoring the number of registered users. The student module focuses on personal profile maintenance, password changes, calendar viewing, and email messaging with optional image attachments.

## Features

- Admin and student login flows
- Admin dashboard for student user management
- Student profile page with photo upload
- Password change workflow with validation rules
- Calendar tab powered by JCalendar
- Email messaging through JavaMail
- MySQL-backed persistence through JDBC
- NetBeans GUI Designer `.form` files for Swing layouts

## Tech Stack

| Layer | Technology |
| --- | --- |
| Language | Java 17 |
| UI | Java Swing, NetBeans GUI Builder, Absolute Layout |
| Build Tool | Apache Ant |
| IDE Project | Apache NetBeans |
| Database | MySQL |
| Database Driver | MySQL Connector/J 8.0.30 |
| Calendar UI | JCalendar 1.4 |
| Email | JavaMail, Jakarta Activation |

## Architecture

```text
User
 |
 v
Java Swing Frames
 |-- ALogin.java        -> admin authentication
 |-- SLogin.java        -> student authentication
 |-- MainFrame.java     -> admin dashboard and user CRUD
 |-- StudentFrame.java  -> student profile, password, calendar, messaging
 |
 v
ConnectionDataBase.java
 |
 v
MySQL database: projectoopdb
```

The application uses a simple desktop architecture:

- `Main.java` starts the application and opens the admin login screen.
- `ALogin.java` authenticates admin users from `login_table`.
- `SLogin.java` authenticates student users from `user_table`.
- `MainFrame.java` provides admin CRUD operations for records in `user_table`.
- `StudentFrame.java` loads and updates student profile records in `personalinfo_table`, handles password changes, calendar display, and email sending.
- `ConnectionDataBase.java` creates the shared MySQL connection.

## Project Structure

```text
.
|-- build.xml                  # NetBeans/Ant build file
|-- manifest.mf                # JAR manifest
|-- nbproject/                 # NetBeans project metadata
|-- icon/                      # root-level image assets
|-- src/
|   `-- project/
|       |-- Main.java
|       |-- ConnectionDataBase.java
|       |-- ALogin.java
|       |-- ALogin.form
|       |-- SLogin.java
|       |-- SLogin.form
|       |-- MainFrame.java
|       |-- MainFrame.form
|       |-- StudentFrame.java
|       |-- StudentFrame.form
|       `-- icon/              # packaged Swing image assets
|-- test/                      # test source directory
`-- build/                     # generated NetBeans build output
```

## Getting Started

### Prerequisites

- JDK 17 or newer
- Apache NetBeans, recommended for opening the `.form` GUI files
- MySQL Server
- Required Java libraries:
  - MySQL Connector/J 8.0.30
  - JCalendar 1.4
  - JavaMail
  - Jakarta Activation
  - NetBeans Absolute Layout library

### Database Configuration

The current database connection is configured in:

```java
src/project/ConnectionDataBase.java
```

Default connection values:

```text
Database: projectoopdb
Host: localhost
Port: 3306
User: root
Password: 12345
```

Create a MySQL database named `projectoopdb`, then add the tables expected by the source code:

- `login_table` for admin accounts
- `user_table` for student login accounts
- `personalinfo_table` for student profile records

The SQL schema is not included in this repository, so table columns should match the fields referenced in the Java source.

### Run With NetBeans

1. Open the project folder in NetBeans.
2. Check `nbproject/project.properties` and update the dependency paths for your machine.
3. Make sure MySQL is running and the `projectoopdb` database exists.
4. Run the project from NetBeans.

### Run With Ant

```bash
ant run
```

If dependency paths are not configured on your machine, Ant compilation will fail until the library paths in `nbproject/project.properties` are updated.

## Star History

[View this repository on Star History](https://www.star-history.com/#markjasonesguerra/Java-OOP-&Date).

GitHub-powered badges and the Star History chart require the repository to be publicly accessible. If the repository is private or not visible to the GitHub API, these services may display `not found`.

## Commit Guidance

Commit source and project files:

- `README.md`
- `.gitignore`
- `src/**/*.java`
- `src/**/*.form`
- `src/project/icon/**`
- `icon/**`
- `build.xml`
- `manifest.mf`
- `nbproject/project.xml`
- `nbproject/project.properties` only if the dependency paths are intentionally shared

Avoid committing generated or local files:

- `build/`
- `dist/`
- `*.class`
- `nbproject/private/`
- local database dumps containing real data
- files containing passwords, API keys, app passwords, or private email credentials

> Note: this repository currently tracks generated `build/classes` files and `nbproject/private` files. The new `.gitignore` prevents future generated files from being added, but already tracked files remain tracked until they are intentionally removed from Git.

## Security Notes

The current code contains hard-coded database credentials and email credentials. Before using this project outside a local class/demo environment, move secrets to environment variables or a local configuration file that is ignored by Git.

## Author

Mark Jason Esguerra
