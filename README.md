# A'maal Android App

This is a simple Android application for managing daily deeds (A'maal), with a focus engine that prioritizes prayers and other religious obligations.

## Features

-   **Focus Engine**: Prioritizes deeds based on fiqh hierarchy and jamāʿah (congregational prayer) timings.
-   **Deed Management**: Add, complete, and reorder non-prayer deeds.
-   **Jamāʿah Timing**: Configure specific timings and priority windows for congregational prayers.
-   **Offline-first**: Uses Room Persistence Library for local data storage.
-   **Clean Architecture**: Minimal and expandable structure.

## Project Structure

The project follows a standard Android application structure:

```
Amaal/
└─ app/src/main/
   ├─ AndroidManifest.xml
   ├─ java/com/amaal/app/
   │  ├─ ui/
   │  │  ├─ MainActivity.java
   │  │  ├─ DeedAdapter.java
   │  │  └─ PrayerConfigDialog.java
   │  ├─ data/
   │  │  ├─ Deed.java
   │  │  ├─ DeedDao.java
   │  │  └─ AppDatabase.java
   │  └─ logic/
   │     └─ FocusEngine.java
   └─ res/
      ├─ layout/
      │  ├─ activity_main.xml
      │  ├─ item_deed.xml
      │  └─ dialog_prayer_config.xml
      └─ values/
         ├─ colors.xml
         └─ themes.xml
```

## Technologies Used

-   **Java**: Primary programming language.
-   **Android SDK**: For building the Android application.
-   **Room Persistence Library**: For local database storage.
-   **Material Design 3**: For UI theming.

## Setup and Run

1.  **Clone the repository**:
    ```bash
    git clone <repository-url>
    cd Amaal
    ```
2.  **Open in Android Studio**:
    Import the `Amaal` project into Android Studio.
3.  **Build and Run**:
    Sync Gradle files and run the application on an emulator or a physical device.

## Contributing

Feel free to fork the repository and submit pull requests.
