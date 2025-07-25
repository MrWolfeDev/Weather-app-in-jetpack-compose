# WeatherApp (Jetpack Compose)

**WeatherApp** is a modern Android weather application built with **Jetpack Compose**. It lets users search for any city’s weather and view current & forecast conditions in a clean, Material-themed UI. Users can also save favorite cities; saved data is cached locally (with Room) and auto-updates when online:contentReference[oaicite:18]{index=18}.

## Features

- Search weather by city name or use current GPS location.  
- Display current weather and 5-day forecast (3-hour intervals).  
- Save cities to “My Cities” list and quickly toggle between them.  
- Offline support: last-fetched weather is cached in local database.  
- Modern UI using Jetpack Compose, Material 3 theming, and animation placeholders.  
- Good error handling for no-network and invalid city inputs.

## Screenshots  

*(Placeholder for actual screenshots)*

## Setup Instructions

1. **OpenWeatherMap API Key:** Sign up at [openweathermap.org](https://openweathermap.org/) to get a free API key.  

2. **Configure API Key:** In the project, open `Constants.kt` (in the `core/util` or `utils` folder). Set the `API_KEY` constant to your own key (see example below).  
   :contentReference[oaicite:19]{index=19} *Figure: In `Constants.kt`, update the `API_KEY` and base URL for your OpenWeatherMap API key.*  

3. **Build the Project:** Open the project in Android Studio. Let it sync to download all dependencies (Compose, Retrofit, Hilt, Room, etc.).  

4. **Run the App:** Connect an Android device or emulator and run the app. Grant location permissions if prompted. You should see the weather home screen.

## Libraries & Architecture

- **Jetpack Compose** for UI and theming (Material 3).  
- **Hilt (Dagger)** for dependency injection.  
- **Ktor** for network requests to OpenWeatherMap API.  
- **ViewModel & LiveData/StateFlow** for MVVM state management.  
- The app follows Clean Architecture principles, separating data, domain, and presentation layers:contentReference[oaicite:20]{index=20}.

## Building from Source

To build from source:

```bash
git clone https://github.com/MrWolfeDev/Weather-app-in-jetpack-compose.git
cd Weather-app-in-jetpack-compose
# (Insert API key in Constants.kt as above)
./gradlew build
