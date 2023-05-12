# news-app

This project is an Android application that utilizes the NewsAPI to provide a news browsing and bookmarking service. The application presents two primary screens: Home and Bookmark.

## Features
### Home Screen
The Home screen is the landing page of the application where all news articles are displayed. The articles are fetched from the NewsAPI, and are categorized for easier browsing. Users have the option to search news based on these categories. The application implements paging, displaying 20 articles per page.

### Bookmark Screen
The Bookmark screen is a personalized space for users to save news articles of interest. To bookmark an article, users need to click on a news article on the Home screen. This will open up a WebView of the article based on the URL provided by NewsAPI. A bookmark option is available on this WebView page.

## Design Pattern
The application employs the Model-View-ViewModel (MVVM) design pattern.

## Dependencies
1. **Navigation:** Used for navigating across different screens within the application.
2. **Lifecycle:** Used to handle the lifecycle of the application and its components, ensuring that data is preserved and UI state is managed correctly.
3. **Coroutines:** Used to handle asynchronous tasks, such as network requests and database operations.
4. **Retrofit:** A type-safe HTTP client for Android and Java, Retrofit makes it easy to connect to a REST web service by translating the API into Java interfaces.
5. **Interceptor:** Interceptors are used to intercept and manipulate HTTP requests and responses. They can be used for a variety of tasks, such as adding headers or logging requests.
6. **Room:** A persistence library providing an abstraction layer over SQLite, Room allows for more robust database access while harnessing the full power of SQLite.
7. **Koin:** A lightweight dependency injection framework, Koin helps to manage dependencies in a clean and simple way.
8. **Glide:** An efficient open source media management and image loading framework for Android, Glide provides flexible options for displaying and caching images.

## API
The application uses the [NewsAPI](https://newsapi.org/), a JSON-based API that provides articles from worldwide news sources and blogs.

## Getting Started
Please refer to the subsequent sections on how to set up and run the application.

### Prerequisites
* Android Studio
* Android SDK

### Installing
* Clone the repository
* Open the project with Android Studio
* Build and run the application on an emulator or physical device

## Contributing
Please read [CONTRIBUTING.md](link-to-your-contributing.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments
* NewsAPI.org for providing the API used in this project.

## Screenshots

### Home Screen
![home](https://github.com/adammilando/news-app/assets/79127421/997f6f62-71e2-4593-9d0e-f82e3ea05791)

### Bookmark Screen
![bookmark](https://github.com/adammilando/news-app/assets/79127421/470a1a4e-3dc7-4d77-a0b4-72852908d4ff)

### WebView
![webview](https://github.com/adammilando/news-app/assets/79127421/9662941e-1fdb-44cf-a980-97313823c2d6)
