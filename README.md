🌐 International NewsApplication
A modern International News App built with Jetpack Compose using MVVM, modular architecture, Retrofit, Coil, Coroutines, Flow, and Hilt. Features vertical pagination, clean UI, and reactive state management to showcase best practices in modern Android development.

This is my first Jetpack Compose-based Android application — an International News App that fetches and displays real-time news articles in a vertically swipable layout. The goal of this project was to test and apply my knowledge of modern Android development best practices, architecture patterns, and UI building with Compose.

📌 **Key Highlights**
✨ **Jetpack Compose:** The entire UI is built using Jetpack Compose for a modern, declarative experience.

📚 **Module Libraries** – The app is structured into feature-based modules like data, domain, and presentation, enabling better code organization and reusability.

🌿 **Clean Architecture:** The project follows a clean architecture structure with proper separation between UI, Domain, and Data layers.

🏗️ **MVVM + Modular Architecture:** Implements Model-View-ViewModel pattern with modularization for scalability and maintainability.

📦 **Centralized Dependency Management:** All dependencies are managed in a single Gradle file for easy updates and consistency.

🌪️ **Coroutines & Kotlin Flow:** Handles asynchronous data streams using Kotlin Coroutines and Flow.

🍂 **State Management:** UI state is managed using Compose's state APIs and Flow from ViewModel.

🍃 **Custom Composables**: Reusable UI components created using custom composable functions.

🧩 **Dagger-HILT:** Dependency injection is implemented using Dagger-HILT for cleaner code and easier testing.

🌐 **Retrofit**: For making REST API calls to fetch international news articles.

🖼️ **Coil**: Efficient image loading in Compose using Coil.

🧱 **Project Structure**
**app**/: Application entry point and setup

**core**/: Common classes and utilities shared across modules

**data**/: API services, DTOs, and repository implementations

**domain**/: Business logic, models, and use cases

**presentation**/: UI components, screens, and ViewModels

**di**/: Dagger-Hilt modules for dependency injection

🚀 **Features**
View international news articles by swiping vertically

One article per page for better focus and readability

Dark mode support

Clean UI with Coil for image loading

Proper loading and error handling states

🛠️ **Technologies Used**
**Jetpack Compose** – UI framework

**MVVM Architecture** – Structure

**Dagger-Hilt** – Dependency Injection

**Kotlin Coroutines** + Flow – Async & reactive programming

**Retrofit** – API communication

**Coil** – Image loading

**Modular Architecture** – Code organization

🎯 **Goal of the Project**
The goal was to:

Practice Jetpack Compose and build a real-world UI

Implement a scalable architecture with modern Android tools

Learn to manage state and side-effects in Compose

Gain experience using dependency injection and modularity

🧠 **What I Learned**
Applying Jetpack Compose to build scalable UIs

Structuring an app using module libraries for each layer

Implementing centralized dependency management via buildSrc

Managing asynchronous data streams with Kotlin Flow and Coroutines

Using Dagger-Hilt for dependency injection across multiple modules

Building custom Composables and handling vertical pagination
