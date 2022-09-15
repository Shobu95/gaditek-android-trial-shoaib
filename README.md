# Gaditek Trial Task

This test project contains all functionality that was requested in the document, along with some unit tests and UI tests for the activity that the project contains. More details are mentioned below.

### Developed Using
- Kotlin
- Jetpack Compose
- Hilt
- ViewModel
- Coroutines
- Room
- Retrofit
- Coil (Image Loading)
- Accompanist (for tabs)
- Proguard for obfuscation and resource shrinking

### Tests written for
- Data layer
  - Local Database
  - Retrofit Service
- ViewModel
- Ui Tests for SocialChannelActivity

## Architecture
Application is built using Clean-MVVM and Modern Android Architecture, consisting of Repository layer, which uses local (Room DB) and remote (Retrofit) data sources, UseCase Layer containing business logic, ViewModel and finally a Composable UI. The ViewModel and UI communicate through state and events. UI send events to ViewModel and UI observes the state from the ViewModel.
Separate Data classes have been made for each layer and data source.
- Entity for Room DB (can be mapped to Domain Model)
- DTO for Retrofit (can be mapped to Entity/Database Model)
- Domain Model (normal data class used for displaying data)
![system_design (1)](https://user-images.githubusercontent.com/20271259/190341138-1e2117a8-a8a1-4af2-b64a-0b480665c468.jpg)

## Obfuscation
![Screenshot (56)](https://user-images.githubusercontent.com/20271259/190340450-d4318bed-895f-4381-8187-6101acdd5640.png)


## References:
**Modern Android Architecture**: https://developer.android.com/topic/architecture

**Repository Pattern:** https://developer.android.com/codelabs/basic-android-kotlin-training-repository-pattern#0

**Clean-MVVM:** https://www.youtube.com/watch?v=8YPXv7xKh2w&t=1322s **by Philipp Lackner**

**Testing:**

https://developer.android.com/training/data-storage/room/testing-db

https://developer.android.com/jetpack/compose/testing

https://developer.android.com/codelabs/jetpack-compose-testing

