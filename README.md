# Bank Interface JavaFX

Welcome to the **Bank Interface JavaFX** project! 🏦💻

This project is a desktop banking application developed using **JavaFX** and managed with **Gradle**. It provides a simple and intuitive interface for managing bank accounts, performing PIX transactions, and viewing transaction history. 📊💳

## Imagens:

<img width="1366" height="704" alt="Captura de tela de 2025-08-26 19-20-24" src="https://github.com/user-attachments/assets/1f599b43-9e3f-4622-bbce-81d03688c74d" />

<img width="1366" height="704" alt="Captura de tela de 2025-08-26 19-21-21" src="https://github.com/user-attachments/assets/cce3a761-7510-4b83-ab72-eed0dc4106e9" />

<img width="1366" height="704" alt="Captura de tela de 2025-08-26 19-21-38" src="https://github.com/user-attachments/assets/1c46a5e4-34b3-4ab7-9162-aac163bf9d65" />


## 📦 Project Structure

- The project is organized as follows:

```
Bank_Interface_JavaFX_Gradle/
├── app/                   # Application source code
│   ├── components/        # Custom UI components
│   ├── dto/               # Data Transfer Objects (DTOs)
│   ├── operations/        # Banking operation logic
│   └── App.java           # Main class that launches the application
├── gradle/                 # Gradle scripts and configurations
├── .gitignore              # Files and folders to be ignored by Git
├── gradle.properties       # Gradle properties
├── gradlew                 # Script to run Gradle on Linux/Mac
├── gradlew.bat             # Script to run Gradle on Windows
└── settings.gradle         # Project settings for Gradle
```

## Features ✨

- User-friendly JavaFX interface 🖥️
- PIX operations (sending and receiving payments) 💸
- Transaction history display 📜
- TableView for account and transaction data 📊
- AvatarPane for user and card information 🖼️
- Gradle-based project structure 🏗️

## Technologies Used 🛠️

- Java 23 🟦
- JavaFX 24.0.2 🖥️
- Gradle 9.0.0 ⚙️
- ZXing library for QR Code generation 📱
- BigDecimal for currency precision 💰

## Installation & Setup 🏗️

1. Clone the repository:
   ```bash
   git clone https://github.com/MKawan/Bank_Interface_JavaFX_Gradle.git
   ```

2. Open the project in **Eclipse** or your preferred IDE.

3. Ensure JavaFX is correctly configured in your IDE.

4. Run the application via Gradle:
   ```bash
   ./gradlew run
   ```

## Usage 💡

- Open the app, and you will see a dashboard with user information.
- Use the PIX panel to send payments by entering the recipient's name, PIX key, and amount. 💸
- A QR code is generated for receiving payments when a value is entered.
- Transaction history is displayed in tables with columns for Name, PIX Key, Amount, and Date. 📜
- Past invoices can be viewed in order from oldest to newest. 🧾

## Project Structure 📂

- `src/main/java/br/com/mk/components/` - Contains all JavaFX components, panels, and operations.
- `src/main/java/br/com/mk/dto/` - Contains Data Transfer Objects for transaction history and invoices.
- `src/main/java/br/com/mk/utils/` - Utility classes such as QR Code generator.
- `build.gradle` - Gradle configuration file.

## Notes 📝

- Make sure JavaFX is installed on your system or configured in your IDE.
- The app uses **BigDecimal** for all currency-related operations to maintain precision.
- The QR code generation requires ZXing library support. 📱

## License 📄

This project is open-source and available under the MIT License. 🟢

---

Enjoy using the **Bank Interface JavaFX**! 🚀
