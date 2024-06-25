# Ricky-Morty-App

## Features
Browse a list of characters with details such as name, species, gender, and origin.
View episode details including title, air date, and episode code.
Explore various locations featured in the show.
Search functionality to quickly find specific characters, episodes, or locations.
Installation
To run this app on your local machine, follow these steps:

## Main Screen:

The main screen displays a list of characters from the show.
Scroll through the list to browse characters.
Tap on a character to view detailed information.

### Character Details:
Character details will be shown(such as name, species, gender, and origin.) and button will be provided to add and remove of favorites
## Technologies Used
Kotlin: The primary programming language used for app development.
Android SDK: Tools and APIs for building Android applications.
Retrofit: For making API calls to the Rick and Morty API.
Glide: For image loading and caching.
ViewModel and LiveData: For managing UI-related data in a lifecycle-conscious way.
RecyclerView: For displaying lists of data.
## API Reference
This app uses the Rick and Morty API to fetch data about characters, episodes, and locations.

Base URL: https://rickandmortyapi.com/api
Endpoints:
/character/: Fetch a list of characters.
/character/{id}: Fetch details of a specific character.
/episode/: Fetch a list of episodes.
/episode/{id}: Fetch details of a specific episode.
/location/: Fetch a list of locations.
/location/{id}: Fetch details of a specific location.
