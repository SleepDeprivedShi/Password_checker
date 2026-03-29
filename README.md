# Password Strength Checker with Smart Suggestions

Java-based GUI application for validating password strength and generating improved versions of user-provided passwords.

## Overview

This application allows users to enter a username and password through a simple Swing-based interface.

The system evaluates the password against common strength rules and provides detailed feedback on missing criteria.

If the password is weak, it generates upgraded versions of the same password rather than random replacements, preserving user familiarity while improving security.

## Features

- GUI-based input using Java Swing
- Password validation rules:
  - Minimum length of 8 characters
  - At least one uppercase letter
  - At least one lowercase letter
  - At least one number
  - At least one special character
  - Password must not contain the username
- Detailed feedback explaining exactly what is missing
- Generates three improved versions of the entered password
- Suggestions retain the structure of the original password instead of generating random values

## Tech Stack

- Language: Java
- GUI: Swing (JOptionPane, JPanel, JTextField, JPasswordField)
- Logic: Custom validation and transformation functions

## Project Structure

```
password_checker/
├── main.java          # GUI and application flow
├── logic.java         # Password validation rules
├── Suggest.java       # Password upgrade generator
├── README.md
└── .gitignore
```

## How to Run

Compile the file:

```
javac main.java 
```

Run the application:

```
java main
```

## Application Behavior

- User enters username and password
- Password is evaluated for required criteria
- If weak:
  - Displays missing requirements
  - Generates and shows improved password suggestions
- If strong:
  - Confirms successful validation

## Design Notes

- The system focuses on improving user-entered passwords rather than rejecting them outright
- Suggestions are derived from the original input to maintain usability
- Validation and suggestion logic are separated for modularity
