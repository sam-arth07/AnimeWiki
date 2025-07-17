# 🌟 AnimeWiki

<div align="center">
  <img src="app/src/main/ic_launcher-playstore.png" alt="AnimeWiki Logo" width="180"/>
  <h3>Your Ultimate Anime Discovery Companion</h3>
</div>

AnimeWiki is an elegant, feature-rich Android application that transforms the anime exploration experience. Achieved an immersive and intuitive interface by implementing modern Android architecture patterns and reactive programming paradigms, resulting in a seamless, responsive, and visually captivating application.

---

## ✨ Key Features

- **Comprehensive Anime Database**: Explore thousands of anime titles with detailed information
- **Dynamic UI**: Experience smooth animations and theme-adaptive interfaces with Material 3 design
- **Smart Search**: Find anime quickly with powerful search functionality
- **Offline Support**: Browse your favorite anime even without an internet connection
- **Dynamic Theming**: Enjoy adaptive color schemes extracted from anime cover images

---

## 🌐 Live Server

The application is powered by a dedicated backend server:
[AnimeWiki Server on Render](https://animeserver-cm3n.onrender.com)

---

## 🏗️ Architecture Overview

AnimeWiki is built with a **Clean Architecture** approach following the **MVVM** pattern:

<div align="center">
  <img src="https://developer.android.com/static/topic/libraries/architecture/images/final-architecture.png" alt="Architecture Diagram" width="600"/>
</div>

### Layer Separation

- **📊 Data Layer**: 
  - Handles remote API communication, local database storage, and data modeling
  - Implements repository pattern for single source of truth
  - Uses Room for persistent storage and Retrofit for network calls

- **💼 Domain Layer**: 
  - Contains business logic and use cases
  - Defines repository interfaces
  - Pure Kotlin with no Android dependencies

- **🖼️ Presentation Layer**: 
  - Contains screens, ViewModels, and UI state management
  - Utilizes Jetpack Compose for declarative UI
  - Implements unidirectional data flow with Kotlin Flows

- **🎨 UI Layer**: 
  - Contains theme definitions and color systems
  - Implements Material 3 design principles

- **💉 DI Layer**: 
  - Provides dependency injection setup with Hilt
  - Ensures proper separation of concerns

---

## 🛠️ Tech Stack

| Category | Technologies | Purpose |
|----------|-------------|---------|
| **Core** | ![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF.svg?style=flat&logo=kotlin&logoColor=white) | Modern, concise language with coroutines for asynchronous programming |
| **UI** | ![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4.svg?style=flat&logo=jetpack-compose&logoColor=white) ![Material 3](https://img.shields.io/badge/Material%203-757575.svg?style=flat&logo=material-design&logoColor=white) | Declarative UI toolkit with modern design principles |
| **Architecture** | ![MVVM](https://img.shields.io/badge/MVVM-0095D5.svg?style=flat) ![Clean Architecture](https://img.shields.io/badge/Clean%20Architecture-0095D5.svg?style=flat) | Separation of concerns and testable code structure |
| **Dependency Injection** | ![Hilt](https://img.shields.io/badge/Hilt-2196F3.svg?style=flat) | Simplified DI implementation built on Dagger |
| **Networking** | ![Retrofit](https://img.shields.io/badge/Retrofit-3E4348.svg?style=flat) ![OkHttp](https://img.shields.io/badge/OkHttp-3E4348.svg?style=flat) ![KotlinX Serialization](https://img.shields.io/badge/KotlinX%20Serialization-7F52FF.svg?style=flat) | Type-safe HTTP client with efficient serialization |
| **Local Storage** | ![Room](https://img.shields.io/badge/Room-3DDC84.svg?style=flat) ![DataStore](https://img.shields.io/badge/DataStore-3DDC84.svg?style=flat) | Database and preferences management |
| **Navigation** | ![Jetpack Navigation](https://img.shields.io/badge/Navigation%20Compose-4285F4.svg?style=flat) | Type-safe navigation between screens |
| **Image Loading** | ![Coil](https://img.shields.io/badge/Coil-E91E63.svg?style=flat) | Kotlin-first image loading library |
| **Pagination** | ![Paging 3](https://img.shields.io/badge/Paging%203-3DDC84.svg?style=flat) | Efficient loading of large data sets |
| **Dynamic Theming** | ![Palette API](https://img.shields.io/badge/Palette%20API-4285F4.svg?style=flat) | Extract vibrant colors from images |
| **Backend** | ![Render](https://img.shields.io/badge/Render-46E3B7.svg?style=flat&logo=render&logoColor=white) | Cloud hosting platform for API |

---

## 📱 Screenshots

### Splash Screen
<div align="center">
  <img src="https://github.com/user-attachments/assets/b94850ab-8e48-416e-bdff-cb68fb398cd1" width="240"/>
  <img src="https://github.com/user-attachments/assets/57bd6999-523c-4163-96d3-8208a58203f7" width="240"/>
</div>

### Welcome Screen
<div align="center">
  <img src="https://github.com/user-attachments/assets/edb59d9f-2c00-4661-8f75-4a6d1b32d751" width="240"/>
  <img src="https://github.com/user-attachments/assets/2e212dd5-2ab9-4e29-b529-7026a071c76f" width="240"/>
  <img src="https://github.com/user-attachments/assets/453613a5-bcef-4d95-b30c-bc1111dcacc4" width="240"/>
  <img src="https://github.com/user-attachments/assets/853032f1-2319-4510-9480-6096ae5b5246" width="240"/>
  <img src="https://github.com/user-attachments/assets/5ca0a78f-530c-4872-b1c3-6f5eab88e8c1" width="240"/>
  <img src="https://github.com/user-attachments/assets/7e7644be-e55c-4ec3-92fc-3c8fa5dfa51c" width="240"/>
</div>

### Home Screen
<div align="center">
  <img src="https://github.com/user-attachments/assets/9cd8fbbb-7d5c-4651-80cf-fdd0c1344b36" width="240"/>
  <img src="https://github.com/user-attachments/assets/9f485fb0-c00e-4bef-a99a-f7d4a8493845" width="240"/>
</div>

### Anime Details
<div align="center">
  <img src="https://github.com/user-attachments/assets/c3500448-a7a1-4f42-b2e2-6f38aff1cb37" width="240"/>
  <img src="https://github.com/user-attachments/assets/4b073726-b5e8-457c-abea-c35002de2872" width="240"/>
  <img src="https://github.com/user-attachments/assets/c1aa0ab4-0bd9-448f-bd3c-06ba96b33887" width="240"/>
  <img src="https://github.com/user-attachments/assets/20e14390-b3ea-4ba8-98f4-0aae05f2abdb" width="240"/>
</div>

### Search
<div align="center">
  <img src="https://github.com/user-attachments/assets/37b5888c-c89d-4a6d-8e10-433beac0c094" width="240"/>
  <img src="https://github.com/user-attachments/assets/2e825ec4-ebdf-4292-92b0-e52412082a7b" width="240"/>
  <img src="https://github.com/user-attachments/assets/d9dc53f1-5e92-4067-9fbf-9fa5d5034a14" width="240"/>
</div>

*Note: Create a `screenshots` directory and add your actual app screenshots.*

---

## 📂 Project Structure

```
app/src/main/java/com/example/animewiki/
├── data/                # Data sources, repositories, models
│   ├── local/           # Room database, entities, DAOs
│   ├── remote/          # Retrofit services, DTOs, API responses
│   └── repositories/    # Repository implementations
├── di/                  # Dependency injection modules
├── domain/              # Business logic, use cases, domain models
│   ├── models/          # Domain entities
│   ├── repositories/    # Repository interfaces
│   └── usecases/        # Application use cases
├── navigation/          # Navigation graphs and route definitions
├── presentation/        # Screens, ViewModels
│   ├── common/          # Shared UI components
│   ├── details/         # Anime details screen and ViewModel
│   ├── home/            # Home screen and ViewModel
│   └── search/          # Search screen and ViewModel
├── ui/                  # Theme and color definitions
│   ├── theme/           # Material theme setup
│   └── color/           # Color palettes
├── util/                # Extension functions and helper classes
├── MainActivity.kt      # Main activity hosting the Compose UI
└── MyApplication.kt     # Application class for Hilt setup
```

---

## 🚀 Implementation Highlights

Achieved an exceptional anime discovery experience by implementing:

- **Reactive Data Flow**: Utilized Kotlin Flows throughout the app for reactive UI updates and seamless user experience
- **Efficient Pagination**: Implemented Paging 3 library to handle large datasets with minimal memory footprint
- **Dynamic Theming**: Applied Palette API to extract colors from anime images for immersive, content-aware UI
- **Clean Architecture**: Structured the app with proper separation of concerns for maintainability and testability
- **Offline-First Approach**: Designed with Room database as single source of truth, enabling offline browsing
- **Elegant UI**: Created fluid animations and transitions with Jetpack Compose for a delightful user experience

---

## 📋 Requirements

- Android Studio Iguana or newer
- Minimum SDK: 24 (Android 7.0 Nougat)
- Target SDK: 35 (Android 15)
- Kotlin 2.0

---

## 🚀 Getting Started

1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/AnimeWiki.git
   ```

2. Open the project in Android Studio

3. Sync Gradle and build the project

4. Run on your device or emulator

---

## 📊 Future Enhancements

- User authentication and personalized recommendations
- Offline-first approach with improved caching
- Advanced filtering and sorting options
- Social features for sharing and discussing anime
- Integration with external tracking services

---
<div align="center">
  <p>Built with ❤️ using modern Android development practices</p>
</div>
